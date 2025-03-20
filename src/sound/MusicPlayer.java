package sound;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import utils.Fraction;

/**
 * The mutable class MusicPlayer is our main data type for the ABC main. It
 * can dynamically add notes and lyrics to itself by using a counter
 * currentTicks which represent the current position inside the song.
 */
public class MusicPlayer {
	private SequencePlayer player;
	private int currentTick;
	private final int ticksPerBeat;

	/**
	 * Creates a new instance of Music main with given tempo (beats per
	 * minute) and ticks per beat. These values remain unchanged.
	 * 
	 * @param tempo
	 *            an integer representing the number of beats per minute for a
	 *            song
	 * @param ticksPerBeat
	 *            an integer representing the number of ticks per beat
	 */
	public MusicPlayer(int tempo, int ticksPerBeat,int currentTick) {
		LyricListener listener = new LyricListener() {
			public void processLyricEvent(String text) {
				System.out.print(text);
			}
		};
		try {
			this.player = new SequencePlayer(tempo, ticksPerBeat, listener);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		this.currentTick = currentTick;
		this.ticksPerBeat = ticksPerBeat;
	}

	/**
	 * Creates an Instance of Music Player using an existing SequencePlayer;
	 * 
	 * @param main
	 *            is a valid SequencePlayer
	 */
	public MusicPlayer(SequencePlayer player, int ticks) {
		this.player = player;
		this.currentTick = ticks;
		this.ticksPerBeat = player.getTicksPerBeat();
	}

	/**
	 * Adds the given MIDI note of given length to the main
	 * 
	 * @param note
	 *            an integer representing the MIDI note.
	 * @param noteLength
	 *            represents the note length as a fraction of default node
	 *            length
	 */
	public void addNote(int note, Fraction noteLength) {
		player.addNote(note, currentTick,
				noteLength.multiply(ticksPerBeat).getNumerator());
	}

	/**
	 * Increments the currentTicks counter with the given note length
	 * 
	 * @param length
	 *            represents the length as a fraction of default node length
	 */
	public void addTime(Fraction length) {
		currentTick += length.multiply(ticksPerBeat).getNumerator();
	}

	/**
	 * Add the given lyric to the main
	 * 
	 * @param lyric
	 *            a string that represents the lyric to be added
	 */
	public void addLyric(String lyric) {
		player.addLyricEvent(lyric, currentTick);
	}

	/**
	 * resets the value of the counter to 0
	 */
	public void resetTime() {
		currentTick = 0;
	}

	/**
	 * Check whether an object is equal to this instance of Music Player.
	 * Players are considered equal if they have the same values of
	 * currentTicks, ticksPerBeat and equal main attributes.
	 */
	public boolean equals(Object that) {
		if (!(that instanceof MusicPlayer)) {
			return false;
		}
		MusicPlayer thatPlayer = (MusicPlayer) that;
		return (this.player.equals(thatPlayer.player) && currentTick == thatPlayer.currentTick);
	}

	/**
	 * play the song with the lyrics
	 */
	public void play() {
		try {
			player.play();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}

}