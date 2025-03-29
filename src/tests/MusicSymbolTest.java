package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import interfaces.MusicSymbol;

import java.util.Arrays;

import org.junit.Test;

import utils.Fraction;
import adts.Chord;
import adts.Pitch;
import adts.Rest;

/**
 * This is the test suite for equals(), toString(), and hashCode() for the
 * classes in the MusicSymbol interface. The addNote(main) method is tested in
 * MusicPlayerTest.java as its main role is to modify the main.
 * 
 * Moreover, we test the particular methods of the classes that implement the
 * interface: Pitch: multiplyLength(), getLength(), Chord: multiplyLength().
 * 
 * Testing strategy: test each method and make sure it is true to its spec for
 * every valid type of input. equals() must return true on equal objects, and
 * false on unequal objects. toString() must provide the appropriate string
 * representation of the object. hashCode() must return a hashcode that is the
 * same for equal objects.
 * 
 * For Pitch, make sure everything works correctly regardless of how many
 * modifiers there are (, ,, ^ ^^ _ __ and duration), and same for Rest (it only
 * has duration). For Chord, partition on the number of MusicSymbols it has.
 * Also, make sure duration shows up correctly (ie. 1/1 should be nothing, 1/2
 * should be /2)
 * 
 */

public class MusicSymbolTest {

	/**
	 * Test Pitch equals()
	 */
	@Test
	public void equalsPitchTest() {
        // include the different modifiers!
		Pitch pitch1 = new Pitch(new Fraction(1, 2), 'A', 1, 0);
		Pitch pitch2 = new Pitch(new Fraction(1, 2), 'A', 1, 0);
		Pitch pitch3 = new Pitch(new Fraction(1), 'D', -1, -2);
		Pitch pitch4 = new Pitch(new Fraction(1), 'D', -1, -2);

		assertEquals(pitch1, pitch1); // reflexive
		assertEquals(pitch1, pitch2);
		assertNotEquals(pitch1, pitch3);
		assertEquals(pitch3, pitch4); // make sure things like accidentals work
	}

	/**
	 * Test Rest equals()
	 */
	@Test
	public void equalsRestTest() {
        // include different durations
		Rest rest1 = new Rest(new Fraction(1));
		Rest rest2 = new Rest(new Fraction(1));
		Rest rest3 = new Rest(new Fraction(2, 3));

		assertEquals(rest1, rest1); // reflexive
		assertEquals(rest1, rest2);
		assertNotEquals(rest1, rest3);
	}

	/**
	 * Test Chord equals()
	 */
	@Test
	public void equalsChordTest() {
        // include rests and pitches in chords, as well as testing different
        // sizes of chords
		MusicSymbol pitch1 = new Pitch(new Fraction(1, 2), 'A', 1, 0);
		MusicSymbol pitch2 = new Pitch(new Fraction(1, 2), 'A', 1, 0);
		MusicSymbol pitch3 = new Pitch(new Fraction(1), 'D', 0, -2);
		MusicSymbol pitch4 = new Pitch(new Fraction(1), 'D', 0, -2);
		MusicSymbol rest1 = new Rest(new Fraction(2, 3));

		Chord chord1 = new Chord(Arrays.asList(pitch1, pitch2, pitch3, rest1));
		Chord chord2 = new Chord(Arrays.asList(pitch1, pitch1, pitch4, rest1));
        Chord chord3 = new Chord(Arrays.asList(pitch1));

		assertEquals(chord1, chord1); // reflexive
		assertEquals(chord1, chord2);
		assertNotEquals(chord1, chord3);
	}

	/**
	 * Test Pitch hashCode()
	 */
	@Test
	public void hashCodePitchTest() {
        // make sure equal objects have same hashcode
		Pitch pitch1 = new Pitch(new Fraction(1), 'A', 1, 0);
		Pitch pitch2 = new Pitch(new Fraction(1), 'A', 1, 0);

		assertEquals(pitch1.hashCode(), pitch1.hashCode()); // reflexive
		assertEquals(pitch1.hashCode(), pitch2.hashCode());
	}

	/**
	 * Test Rest hashCode()
	 */
	@Test
	public void hashCodeRestTest() {
        // make sure equal objects have same hashcode
		Rest rest1 = new Rest(new Fraction(1));
		Rest rest2 = new Rest(new Fraction(1));

		assertEquals(rest1.hashCode(), rest1.hashCode()); // reflexive
		assertEquals(rest1.hashCode(), rest2.hashCode());
	}

	/**
	 * Test Chord hashCode()
	 */
	@Test
	public void hashCodeChordTest() {
        // make sure equal objects have same hashcode
		MusicSymbol pitch1 = new Pitch(new Fraction(1), 'A', 1, 0);
		MusicSymbol pitch2 = new Pitch(new Fraction(1), 'A', 1, 0);
		MusicSymbol pitch3 = new Pitch(new Fraction(1), 'D', 0, -2);
		MusicSymbol pitch4 = new Pitch(new Fraction(1), 'D', 0, -2);
		MusicSymbol rest1 = new Rest(new Fraction(2, 3));

		// make sure that even if we use different MusicSymbol object that
		// amount to the same, they evaluate to the same thing
		Chord chord1 = new Chord(Arrays.asList(pitch1, pitch2, pitch3, rest1));
		Chord chord2 = new Chord(Arrays.asList(pitch1, pitch1, pitch4, rest1));

		assertEquals(chord1.hashCode(), chord1.hashCode()); // reflexive
		assertEquals(chord1.hashCode(), chord2.hashCode());
	}

	/**
	 * Test Pitch toString()
	 */
	@Test
	public void toStringPitchTest() {
		// flat is _, sharp is ^, octave up is first lowercase and then with ',
		// octave down has ,
		Pitch pitch1 = new Pitch(new Fraction(2, 3), 'D', 1, -2);
		Pitch pitch2 = new Pitch(new Fraction(1, 2), 'A', 2, 1);
		Pitch pitch3 = new Pitch(new Fraction(1), 'C', -1, 0);

		assertEquals("_d2/3", pitch1.toString());
		assertEquals("^a'/2", pitch2.toString());
		assertEquals("C,", pitch3.toString());
	}

	/**
	 * Test Rest toString()
	 */
	@Test
	public void toStringRestTest() {
        // different durations
		Rest rest1 = new Rest(new Fraction(1));
		Rest rest2 = new Rest(new Fraction(2, 3));

		assertEquals("z", rest1.toString());
		assertEquals("z2/3", rest2.toString());
	}

	/**
	 * Test Chord toString()
	 */
	@Test
	public void toStringChordTest() {
        // different modifiers, and different sizes of chord
		MusicSymbol pitch1 = new Pitch(new Fraction(2, 3), 'D', 1, -2);
		MusicSymbol pitch2 = new Pitch(new Fraction(1, 2), 'A', 2, 1);
		MusicSymbol pitch3 = new Pitch(new Fraction(1), 'C', -1, 0);
		MusicSymbol pitch4 = new Pitch(new Fraction(1, 8), 'E', 0, 0);
		MusicSymbol rest1 = new Rest(new Fraction(2, 3));

		Chord chord1 = new Chord(Arrays.asList(pitch2));
		Chord chord2 = new Chord(Arrays.asList(pitch1, pitch2, pitch3, rest1,
				pitch4));

		assertEquals("[^a'/2]", chord1.toString());
		assertEquals("[_d2/3 ^a'/2 C, z2/3 E/8]", chord2.toString());
	}

	/**
	 * Test Pitch's getLength(), should return the Fraction that represents its
	 * duration
	 */
	@Test
	public void getLengthPitchTest() {
        // test different fractions from the default of 1 to others
		Pitch pitch1 = new Pitch(new Fraction(2, 3), 'D', 1, -2);
		Pitch pitch2 = new Pitch(new Fraction(1, 2), 'A', 2, 1);
		Pitch pitch3 = new Pitch(new Fraction(1), 'C', -1, 0);

		assertEquals(new Fraction(2, 3), pitch1.getLength());
		assertEquals(new Fraction(1, 2), pitch2.getLength());
		assertEquals(new Fraction(1), pitch3.getLength());
	}

	/**
	 * Test Pitch's multiplyLength(), should return a Pitch with the length
	 * multiplied by the desired Fraction (modifiers not modified otherwise)
	 */
	@Test
	public void multiplyLengthPitchTest() {
        // test multiplying by 1 and different fractions
		Pitch pitch1 = new Pitch(new Fraction(2, 3), 'D', 1, -2);
		Pitch pitch2 = new Pitch(new Fraction(1, 2), 'A', 2, 1);
		Pitch pitch3 = new Pitch(new Fraction(1), 'C', -1, 0);

		// we will never multiply by negatives or zero
		assertEquals(new Pitch(new Fraction(2, 3), 'D', 1, -2),
				pitch1.multiplyLength(new Fraction(1)));
		assertEquals(new Pitch(new Fraction(1, 4), 'A', 2, 1),
				pitch2.multiplyLength(new Fraction(1, 2)));
		assertEquals(new Pitch(new Fraction(1), 'C', -1, 0),
				pitch3.multiplyLength(new Fraction(4, 4)));
	}

	/**
	 * Test Chord's multiplyLength(), should return a Chord with its Pitches'
	 * lengths multiplied by the desired Fraction (no modifiers modified
	 * otherwise)
	 */
	@Test
	public void multiplyLengthChordTest() {
        // test multiplying by 1 and different fractions
		MusicSymbol pitch1 = new Pitch(new Fraction(2, 3), 'D', 1, -2);
		MusicSymbol pitch2 = new Pitch(new Fraction(1, 2), 'A', 2, 1);
		MusicSymbol pitch3 = new Pitch(new Fraction(1), 'C', -1, 0);
		MusicSymbol rest1 = new Rest(new Fraction(2, 3));

		Chord chord1 = new Chord(Arrays.asList(pitch2));
		Chord chord2 = new Chord(Arrays.asList(pitch1, pitch2, pitch3, rest1));

		MusicSymbol pitch4 = new Pitch(new Fraction(1, 6), 'D', 1, -2); // pitch1*1/4
		MusicSymbol pitch5 = new Pitch(new Fraction(1, 8), 'A', 2, 1); // pitch2*1/4
		MusicSymbol pitch6 = new Pitch(new Fraction(1, 4), 'C', -1, 0); // pitch3*1/4
		MusicSymbol rest2 = new Rest(new Fraction(1, 6)); // rest1*1/4

		Chord chord3 = new Chord(Arrays.asList(pitch2));
		Chord chord4 = new Chord(Arrays.asList(pitch4, pitch5, pitch6, rest2));

		// we will never multiply by negatives or zero
		assertEquals(chord3, chord1.multiplyLength(new Fraction(1)));
		assertEquals(chord4, chord2.multiplyLength(new Fraction(1, 4)));
	}

}