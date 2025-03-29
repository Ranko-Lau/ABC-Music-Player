package sound;

import java.text.MessageFormat;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * Schedules and plays a sequence of notes at given time steps (or "ticks").
 */
public class SequencePlayer {

	private Sequencer sequencer;
	private Track track;
	private int beatsPerMinute;
	private int ticksPerBeat;

	// midi channel - for our purpose always 0
	private static int DEFAULT_CHANNEL = 0;
	// the volume
	private static int DEFAULT_VELOCITY = 100;
	// the meta-message type for lyrics
	// (The Standard MIDI Files 1.0 specification says it should be 5.)
	private static int LYRIC_EVENT_TYPE = 5;

	/*
	 * Rep invariant: sequencer is non-null, track is non-null, beatsPerMinute
	 * is positive
	 */

	/**
	 * @param beatsPerMinute
	 *            the number of beats per minute
	 * @param ticksPerBeat
	 *            the number of ticks per beat
	 * @param listener
	 *            the listener that responds to lyric events
	 * @throws MidiUnavailableException
	 * @throws InvalidMidiDataException
	 */
	public SequencePlayer(int beatsPerMinute, int ticksPerBeat,
			final LyricListener listener) throws MidiUnavailableException,
			InvalidMidiDataException {
		this.sequencer = MidiSystem.getSequencer();
		MetaEventListener metaListener = new MetaEventListener() {
			@Override
			public void meta(MetaMessage msg) {
				listener.processLyricEvent(new String(msg.getData()));
			}
		};
		sequencer.addMetaEventListener(metaListener);

		// Create a sequence object with with tempo-based timing, where
		// the resolution of the time step is based on ticks per beat.
		Sequence sequence = new Sequence(Sequence.PPQ, ticksPerBeat);
		this.beatsPerMinute = beatsPerMinute;

		// Create an empty track. Notes will be added to this track.
		this.track = sequence.createTrack();
		sequencer.setSequence(sequence);

		this.ticksPerBeat = ticksPerBeat;
		checkRep();

	}

	/**
	 * @param eventType
	 *            the MIDI status byte; must be a valid MidiMessage type in
	 *            ShortMessage
	 * @param note
	 *            a MIDI data byte; must be a valid pitch value
	 * @param tick
	 *            the tick of the event; must be >= 0
	 */
	private void addMidiEvent(int eventType, int note, int tick)
			throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(eventType, DEFAULT_CHANNEL, note, DEFAULT_VELOCITY);
		MidiEvent event = new MidiEvent(msg, tick);
		this.track.add(event);
	}

	/**
	 * Schedules a lyric event to be triggered at tick. When the lyric event is
	 * triggered, the SequencePlayer's MetaEventListener is alerted.
	 * 
	 * @param text
	 *            a string containing the lyric text
	 * @param tick
	 *            the starting tick; must be >= 0
	 */
	public void addLyricEvent(String text, int tick) {
		byte[] byteData = text.getBytes();
		try {
			MetaMessage msg = new MetaMessage(); // Other constructor fails on
													// Java 6.
			msg.setMessage(LYRIC_EVENT_TYPE, byteData, byteData.length);
			MidiEvent event = new MidiEvent(msg, tick);
			this.track.add(event);
		} catch (InvalidMidiDataException e) {
			String msg = "Cannot add lyric at tick " + tick;
			throw new RuntimeException(msg, e);
		}

	}

	public int getTicksPerBeat() {
		return ticksPerBeat;
	}

	/**
	 * Schedules the note to be played starting at startTick for the duration of
	 * numTicks.
	 * 
	 * @param note
	 *            the pitch value for the note to be played; must be a valid
	 *            note
	 * @param startTick
	 *            the starting tick; must be >= 0
	 * @param numTicks
	 *            the number of ticks for which this note should be played; must
	 *            be >= 0
	 */
	public void addNote(int note, int startTick, int numTicks) {
		try {
			// schedule two events in the track, one for starting a note and
			// the other for ending the note.
			addMidiEvent(ShortMessage.NOTE_ON, note, startTick);
			addMidiEvent(ShortMessage.NOTE_OFF, note, startTick + numTicks);
		} catch (InvalidMidiDataException e) {
			String msg = MessageFormat.format(
					"Cannot add note with the pitch {0} at tick {1} "
							+ "for duration of {2}", note, startTick, numTicks);
			throw new RuntimeException(msg, e);
		}
	}

	/**
	 * The sequencer is opened to begin playing its track.
	 */
	public void play() throws MidiUnavailableException {
		sequencer.open();
		sequencer.setTempoInBPM(this.beatsPerMinute);

		// start playing!
		sequencer.start();

		// busy-wait until the sequencer stops playing.
		while (sequencer.isRunning()) {
			Thread.yield();
		}

		// when done playing, close the sequencer
		sequencer.close();
	}

	/**
	 * @return string that displays the entire track information as a sequence
	 *         of MIDI events, where each event is either turning on or off a
	 *         note at a certain tick
	 */
	@Override
	public String toString() {
		String trackInfo = "";

		for (int i = 0; i < track.size(); i++) {
			MidiEvent e = track.get(i);
			MidiMessage msg = e.getMessage();
			String msgString = "";

			if (msg instanceof javax.sound.midi.ShortMessage) {
				ShortMessage smg = ((ShortMessage) msg);
				int command = smg.getCommand();
				String commandType = "UnknownCommand";

				// determine the type of the command in this message
				if (command == ShortMessage.NOTE_OFF) {
					commandType = "NOTE_OFF";
				} else if (command == ShortMessage.NOTE_ON) {
					commandType = "NOTE_ON ";
				}

				msgString = "Event: " + commandType + " Pitch: "
						+ smg.getData1() + " ";
			} else {
				msgString = "***** End of track *****  ";
			}

			trackInfo = trackInfo + msgString + " Tick: " + e.getTick() + "\n";
		}

		return trackInfo;
	}

	@Override
	/**
	 * Check whether an object is equal to current instance of SequencePlayer.
	 * @return true if objects are equal. Two sequence players are considered equal if they have
	 * the same midi and lyric events. 
	 */
	public boolean equals(Object p) {
		if (!(p instanceof SequencePlayer)) {
			return false;
		}
		SequencePlayer player = (SequencePlayer) p;
		return (this.toString().equals(player.toString()));
	}

	private void checkRep() {
		assert sequencer != null : "sequencer should be non-null";
		assert track != null : "track should be non-null";
		assert beatsPerMinute >= 0 : "should be positive number of beats per minute";
	}

	/**
	 * Play an octave up and back down starting from middle C. addNote(base,
	 * tick, duration) schedules a note with pitch value 'base' starting at
	 * 'tick' to be played for 'duration' number of ticks. For example,
	 * addNote(new Pitch('C').toMidiNote(), 10, 1) plays the middle C at time
	 * step 10 for half the duration of a beat.
	 */
	public static void main(String[] args) {
		SequencePlayer player;
		try {

			// Create a new main, with 120 beats per minute, 2 ticks per beat
			// and a LyricListener that prints each lyric that it sees.
			LyricListener listener = new LyricListener() {
				public void processLyricEvent(String text) {
					System.out.println(text);
				}
			};
			player = new SequencePlayer(200, 2, listener);

			player.addLyricEvent("Up!", 0);
			player.addNote(new PlayerPitch('C').toMidiNote(), 0, 1);
			player.addNote(new PlayerPitch('D').toMidiNote(), 1, 1);
			player.addNote(new PlayerPitch('E').toMidiNote(), 2, 1);
			player.addNote(new PlayerPitch('F').toMidiNote(), 3, 1);
			player.addNote(new PlayerPitch('G').toMidiNote(), 4, 1);
			player.addNote(new PlayerPitch('A').toMidiNote(), 5, 1);
			player.addNote(new PlayerPitch('B').toMidiNote(), 6, 1);
			player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE).toMidiNote(),
					7, 1);
			player.addLyricEvent("Down!", 8);
			player.addNote(new PlayerPitch('B').toMidiNote(), 8, 1);
			player.addNote(new PlayerPitch('A').toMidiNote(), 9, 1);
			player.addNote(new PlayerPitch('G').toMidiNote(), 10, 1);
			player.addNote(new PlayerPitch('F').toMidiNote(), 11, 1);
			player.addNote(new PlayerPitch('E').toMidiNote(), 12, 1);
			player.addNote(new PlayerPitch('D').toMidiNote(), 13, 1);
			player.addNote(new PlayerPitch('C').toMidiNote(), 14, 1);

			System.out.println(player);

			// play!
			player.play();

			/*
			 * Note: A possible weird behavior of the Java sequencer: Even if
			 * the sequencer has finished playing all of the scheduled notes and
			 * is manually closed, the program may not terminate. This is likely
			 * due to daemon threads that are spawned when the sequencer is
			 * opened but keep on running even after the sequencer is killed. In
			 * this case, you need to explicitly exit the program with
			 * System.exit(0).
			 */
			// System.exit(0);

		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}