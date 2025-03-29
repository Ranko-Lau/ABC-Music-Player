package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import adts.Lyric;

/**
 * This is the test suite for Lyric's equals(), toString(), hashCode(), and
 * getSyllable().
 * 
 * Testing strategy: test each method and make sure it is true to its spec for
 * every valid type of input. equals() must return true on equal objects, and
 * false on unequal objects. toString() must provide the appropriate string
 * representation of the object. hashCode() must return a hashcode that is the
 * same for equal objects.
 * 
 * Partition on the number of syllables the Lyric has (0 or more) and make sure
 * symbols and whitespace function normally. For getSyllable(), partition on
 * where the syllable is (beginning, middle, end), and size of the array (0 and
 * more elements).
 * 
 */
public class LyricTest {
    /**
     * Test equals(), must return true on equal objects, and false on unequal
     * objects
     */
    @Test
    public void equalsTest() {
        // tests equality, as well as Lyrics with 0 and more syllables
        Lyric lyric1 = new Lyric(Arrays.asList(new String[] { "A", "B123", " " }));
        Lyric lyric2 = new Lyric(Arrays.asList(new String[] { "A", "B123", " " }));
        Lyric lyric3 = new Lyric(new ArrayList<String>());

        assertEquals(lyric1, lyric1); // reflexive
        assertEquals(lyric1, lyric2);
        assertNotEquals(lyric1, lyric3);
    }

    /**
     * Test hashCode()
     */
    @Test
    public void hashCodeTest() {
        // make sure hashcode for equal objects is the same
        Lyric lyric1 = new Lyric(Arrays.asList(new String[] { "A", "B123", " " }));
        Lyric lyric2 = new Lyric(Arrays.asList(new String[] { "A", "B123", " " }));

        assertEquals(lyric1.hashCode(), lyric1.hashCode()); // reflexive
        assertEquals(lyric1.hashCode(), lyric2.hashCode());
    }

    /**
     * Test toString()
     */
    @Test
    public void toStringTest() {
        // Make sure all kinds of syllables print, as well as empty arrays
        // (prints nothing). Whitespace should also be printed if the array has
        // it.
        Lyric lyric1 = new Lyric(Arrays.asList(new String[] { "Psy", "chic", "spies", "from", "China", "Try", "to",
                "steal", "your", "mind's", "elation.", "Lit", "tle", "girls", "from", "Swe", "den", "Dream", "of",
                "sil", "ver", "screen", "quo", "ta", "tions" })); // Californication
        Lyric lyric2 = new Lyric(Arrays.asList(new String[] { "A-", " ", "B123", "Woo-oop", " ", " ", "eeee" }));
        Lyric lyric3 = new Lyric(new ArrayList<String>());

        assertEquals("Psy chic spies from China Try to steal your mind's elation. "
                + "Lit tle girls from Swe den Dream of sil ver screen quo ta tions", lyric1.toString());
        assertEquals("A-   B123 Woo-oop     eeee", lyric2.toString());
        assertEquals("", lyric3.toString());
    }

    /**
     * Test isEmpty(), must return whether or not the Lyric has any syllables
     */
    @Test
    public void isEmptyTest() {
        Lyric lyric1 = new Lyric(Arrays.asList(new String[] { "Psy", "chic", "spies", "from", "China", "Try", "to",
                "steal", "your", "mind's", "elation.", "Lit", "tle", "girls", "from", "Swe", "den", "Dream", "of",
                "sil", "ver", "screen", "quo", "ta", "tions" }));
        Lyric lyric2 = new Lyric(Arrays.asList(new String[] { " " }));
        Lyric lyric3 = new Lyric(new ArrayList<String>());

        assertFalse(lyric1.isEmpty());
        assertFalse(lyric2.isEmpty()); // has a whitespace
        assertTrue(lyric3.isEmpty()); // is actually empty
    }

    /**
     * Test getSyllable(), must return the syllable at the index requested
     */
    @Test
    public void getSyllableTest() {
        // make sure things at beginning, middle, and end work. Also test arrays
        // with only one element.
        Lyric lyric1 = new Lyric(Arrays.asList(new String[] { "Psy", "chic", "spies", "from", "China", "Try", "to",
                "steal", "your", "mind's", "elation." }));
        Lyric lyric2 = new Lyric(Arrays.asList(new String[] { " " }));

        assertEquals("Psy", lyric1.getSyllable(0));
        assertEquals("elation.", lyric1.getSyllable(10));
        assertEquals("Try", lyric1.getSyllable(5));
        assertEquals(" ", lyric2.getSyllable(0));
    }
}