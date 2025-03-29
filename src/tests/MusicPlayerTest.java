package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import interfaces.MusicSymbol;

import java.util.Arrays;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import sound.LyricListener;
import sound.MusicPlayer;
import sound.PlayerPitch;
import sound.SequencePlayer;
import utils.Fraction;
import adts.Chord;
import adts.Pitch;
import adts.Rest;

/**
 * Testing suite for MusicPlayer class and Music's addNote() and addNotes()
 * methods.
 * 
 * We first check MusicPlayer's equals(), addTime(), addNote(), methods and
 * continue with Music's.
 * 
 * @category no_didit
 */
public class MusicPlayerTest {

	/*
	 * equals() Strategy: check for equality of empty/nonempty equal objects,
	 * check for equality of different music players
	 */
	@Test
	public void equalsMusicPlayerNonEmptyTest() {
		SequencePlayer player;
		try {
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
			player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE)
					.toMidiNote(), 7, 1);
			player.addLyricEvent("Down!", 8);
			player.addNote(new PlayerPitch('C').toMidiNote(), 14, 1);
			MusicPlayer player1 = new MusicPlayer(player, 0);
			MusicPlayer player2 = new MusicPlayer(player, 0);
			assertTrue(player1.equals(player2));
		} catch (MidiUnavailableException e) {
			assertTrue(false);
		} catch (InvalidMidiDataException e) {
			assertTrue(false);
		}

	}

	@Test
	public void equalsMusicPlayerEmptyTest() {
		MusicPlayer player1 = new MusicPlayer(12, 120, 0);
		MusicPlayer player2 = new MusicPlayer(12, 120, 0);
		assertTrue(player1.equals(player2));
	}

	@Test
	public void equalsMusicPlayerNotEqualTest() {
		Pitch pitch1 = new Pitch(new Fraction(1, 2), 'A', 1, 0);
		MusicPlayer player1 = new MusicPlayer(12, 120, 0);
		MusicPlayer player2 = new MusicPlayer(12, 120, 0);
		pitch1.addNote(player1, new String(""));
		assertFalse(player1.equals(player2));
	}

	/*
	 * addTime(). Strategy: currentTick is zero/non-zero note length - smaller
	 * than one/bigger than one / one
	 */

	@Test
	public void addTimeMusicPlayerZeroTest() {
		MusicPlayer player1 = new MusicPlayer(120, 12, 6);
		MusicPlayer player2 = new MusicPlayer(120, 12, 0);
		player2.addTime(new Fraction(1, 2));
		assertTrue(player1.equals(player2));
	}

	@Test
	public void addTimeMusicPlayerNonZeroLengthBiggerThanOneTest() {
		MusicPlayer player1 = new MusicPlayer(120, 4, 16);
		MusicPlayer player2 = new MusicPlayer(120, 4, 8);
		player2.addTime(new Fraction(2, 1));
		assertTrue(player1.equals(player2));
	}

	@Test
	public void addTimeMusicPlayerLengthOneTest() {
		MusicPlayer player1 = new MusicPlayer(120, 6, 11);
		MusicPlayer player2 = new MusicPlayer(120, 6, 5);
		player2.addTime(new Fraction(1, 1));
		assertTrue(player1.equals(player2));
	}

	/*
	 * addNote() Strategy: addNotes of length bigger than one/smaller than
	 * one/one
	 */

	@Test
	public void addNoteMusicPlayerTest() {
		SequencePlayer player;
		try {
			LyricListener listener = new LyricListener() {
				public void processLyricEvent(String text) {
					System.out.println(text);
				}
			};
			player = new SequencePlayer(200, 2, listener);

			player.addNote(new PlayerPitch('C').toMidiNote(), 0, 2);
			player.addNote(new PlayerPitch('A').toMidiNote(), 2, 6);
			player.addNote(new PlayerPitch('F').transpose(PlayerPitch.OCTAVE)
					.toMidiNote(), 4, 1);

			MusicPlayer player1 = new MusicPlayer(player, 4);
			MusicPlayer player2 = new MusicPlayer(200, 2, 0);
			player2.addNote(new PlayerPitch('C').toMidiNote(), new Fraction(1,
					1));
			player2.addTime(new Fraction(1, 1));
			player2.addNote(new PlayerPitch('A').toMidiNote(), new Fraction(3,
					1));
			player2.addTime(new Fraction(1, 1));
			player2.addNote(new PlayerPitch('F').transpose(PlayerPitch.OCTAVE)
					.toMidiNote(), new Fraction(1, 2));
			assertTrue(player1.equals(player2));
		} catch (MidiUnavailableException e) {
			assertTrue(false);
		} catch (InvalidMidiDataException e) {
			assertTrue(false);
		}

	}

	/*
	 * Pitch's addNote() Test different values/octaves/accidentals/length
	 */
	@Test
	public void addNotePitchTest() {
		MusicPlayer player1 = new MusicPlayer(200, 2, 0);
		MusicPlayer player2 = new MusicPlayer(200, 2, 0);
		player2.addNote(new PlayerPitch('C').toMidiNote(), new Fraction(1, 1));
		player2.addTime(new Fraction(1, 1));
		player2.addNote(new PlayerPitch('A').transpose(-2).toMidiNote(),
				new Fraction(3, 1));
		player2.addTime(new Fraction(3, 1));
		player2.addNote(new PlayerPitch('F').octaveTranspose(1).toMidiNote(),
				new Fraction(1, 2));
		player2.addTime(new Fraction(1, 2));
		Pitch pitch1 = new Pitch(new Fraction(1, 1), 'C', 0, 0);
		Pitch pitch2 = new Pitch(new Fraction(3, 1), 'A', 0, -2);
		Pitch pitch3 = new Pitch(new Fraction(1, 2), 'F', 1, 0);
		pitch1.addNote(player1, new String(""));
		pitch2.addNote(player1, new String(""));
		pitch3.addNote(player1, new String(""));
		assertTrue(player1.equals(player2));
	}
	
	/*
	 * Rest() addNote() Test different lengths >1/<1/1
	 */
	
	@Test
	public void addNoteRestTest() {
		MusicPlayer player1 = new MusicPlayer(200, 6, 0);
		MusicPlayer player2 = new MusicPlayer(200, 6, 2);
		MusicPlayer player3 = new MusicPlayer(200, 6, 8);
		MusicPlayer player4 = new MusicPlayer(200, 6, 20);
		Rest rest1 = new Rest(new Fraction(1,3));
		Rest rest2 = new Rest(new Fraction(1,1));
		Rest rest3 = new Rest(new Fraction(2,1));		
		rest1.addNote(player1, new String(""));
		assertTrue(player1.equals(player2));
		rest2.addNote(player1, new String(""));
		assertTrue(player1.equals(player3));
		rest3.addNote(player1, new String(""));
		assertTrue(player1.equals(player4));
	}
	
	/*
	 * Cord() addNote() Test different lengths
	 */
		
	@Test
	public void addNoteChordTest() {
		MusicPlayer player1 = new MusicPlayer(200, 2, 0);
		MusicPlayer player2 = new MusicPlayer(200, 2, 0);
		player2.addNote(new PlayerPitch('C').toMidiNote(), new Fraction(1, 1));
		player2.addNote(new PlayerPitch('A').transpose(-2).toMidiNote(),
				new Fraction(3, 1));
		player2.addNote(new PlayerPitch('F').octaveTranspose(1).toMidiNote(),
				new Fraction(1, 2));
		player2.addTime(new Fraction(1, 2));
		Pitch pitch1 = new Pitch(new Fraction(1, 1), 'C', 0, 0);
		Pitch pitch2 = new Pitch(new Fraction(3, 1), 'A', 0, -2);
		Pitch pitch3 = new Pitch(new Fraction(1, 2), 'F', 1, 0);
		MusicSymbol rest1 = new Rest(new Fraction(2, 3));
		Chord chord1 = new Chord(Arrays.asList(pitch1, pitch2, pitch3, rest1));
		chord1.addNote(player1,new String(""));
		assertTrue(player1.equals(player2));
	}
	
	

}