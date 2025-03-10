package tests;

import static org.junit.Assert.*;
import abc.parser.ABCmusicLexer;

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

/*
 * Tests the Lexer, ensures tokens are what they should be. Tests headers,
 * headers and body, comments, and all kinds of notes (chords, repeats, tuplets,
 * octaves, accidentals).
 */

public class LexerTest {

	@Test
	public void basicHeaderTest() {
		// Tests only the basic header
		String input = "X: 1 \n T:Piece \n K:C \n";
		verifyLexer(input, new String[] {"X: 1 \n", "T:Piece \n", "K:C \n"});
	}
		
    @Test
    public void extendedHeaderOnlyTest() {
        // tests the full possible header and alternative way of writing tempo
        String input = "X: 1 \n T:Piece No.1 \n C: Me \n M:4/4 \n L:1/4 \n Q:140 \n K:C \n";
        verifyLexer(input, new String[] { "X: 1 \n", "T:Piece No.1 \n", "C: Me \n", "M:4/4 \n", "L:1/4 \n",
                "Q:140 \n", "K:C \n" });
    }

    @Test
    public void headerAndOneMeasureTest() {
        // Tests a header and a single measure. Notes and their modifiers are
        // lexed as a single token.
        String input = "X: 1 \n T:Piece No.1 \n K:C \n C C C3/4 D/4 E";
        verifyLexer(input,
                new String[] { "X: 1 \n", "T:Piece No.1 \n", "K:C \n", "C", "C", "C3/4", "D/4", "E" });
    }

    @Test
    public void lyricsTest() {
        // Tests lyrics, which are lexed as one chunk.
        String input = "X: 3 \n T:Piece No.3 \n M:3/4 \n L:1/8 \n Q:1/8=100 \n K: C \n "
                + "z4 D2 | G4 BG |] \n w: * A 2 | ma-zing2 | \n ";
        verifyLexer(input,
                new String[] { "X: 3 \n", "T:Piece No.3 \n", "M:3/4 \n", "L:1/8 \n", "Q:1/8=100 \n", "K: C \n", "z4",
                        "D2", "|", "G4", "B", "G", "|]", "\n", "w: * A 2 | ma-zing2 | \n"
                });
    }

    @Test
    public void noteModifiersTest() {
        // Test modifiers of notes, which are combined into one object along
        // with the note. Also test incomplete headers and out of order headers.
        String input = "X: 1 \n T:Bagatelle No.25 in A, WoO.59 \n C:Ludwig van Beethoven "
                + "\n V:1 \n V:2 \n L:1/16 \n M: C \n K:Am \n "
                + "V:1 \n _E,,E,^G, z z2| __A,,E, ^^A, z =a' b | \n ";
        verifyLexer(input,
                new String[] { "X: 1 \n", "T:Bagatelle No.25 in A, WoO.59 \n", "C:Ludwig van Beethoven \n", "V:1 \n",
                        "V:2 \n", "L:1/16 \n", "M: C \n", "K:Am \n", "V:1 \n", "_E,,", "E,", "^G,",
                        "z", "z2", "|", "__A,,", "E,", "^^A,", "z", "=a'", "b", "|", "\n"
                });
    }

    @Test
    public void repeatsTest() {
        // Test repeats, which should come out as their own symbol. Also test
        // different newlines
        String input = "X: 1 \n T:Bagatelle No.25 in A, WoO.59 \n C:Ludwig van Beethoven "
                + "\n V:1 \n V:2 \n M:3/8 \n L:1/16 \n Q:1/8=140 \r\n K:Am \r\n "
                + "V:1 \n |: E,,E,^G, z z2|[1A,,E,A, z :| | \n ";
        verifyLexer(input,
                new String[] { "X: 1 \n", "T:Bagatelle No.25 in A, WoO.59 \n", "C:Ludwig van Beethoven \n", "V:1 \n",
                        "V:2 \n", "M:3/8 \n", "L:1/16 \n", "Q:1/8=140 \r\n", "K:Am \r\n", "V:1 \n", "|:", "E,,", "E,",
                        "^G,",
                        "z", "z2", "|", "[1", "A,,", "E,", "A,", "z", ":|",
                        "|", "\n"
                });
    }

    @Test
    public void chordsTupletsTest() {
        // Test chords and tuplets, where (2, (3, (4, [, and ], are lexed
        // separately from their notes. Also tests chords in tuplets.
        String input = "X:8628 \n T:Prelude BWV 846 no. 1 \n C:Johann Sebastian Bach "
                + "\n M:4/4 \n L:1/16 \n Q:1/4=70 \n V:1 \n K:C \n "
                + "% \n V:1 \n (2AB (3Bdf (4d[BA]A/2g' dBGB DFED|[E16G16z16]|] \n";
        verifyLexer(input,
                new String[] { "X:8628 \n", "T:Prelude BWV 846 no. 1 \n", "C:Johann Sebastian Bach \n", "M:4/4 \n",
                        "L:1/16 \n", "Q:1/4=70 \n", "V:1 \n", "K:C \n", "% \n", "V:1 \n",
                        "(2", "A", "B", "(3", "B", "d", "f", "(4", "d", "[", "B", "A", "]", "A/2", "g'", "d", "B",
                        "G", "B", "D", "F", "E", "D", "|", "[", "E16", "G16", "z16", "]", "|]", "\n"
                });
    }

    @Test
    public void strangeLyricsCharactersTest() {
        // Tests weird characters that have failed the lexer before (ie. - ' *
        // ~ _ \- --)
        String input = "X:2167 \n T:Waxie's Dargle \n M:4/4 \n L:1/8 \n Q:1/4=180 \n K:G \n "
                + "gf|e2dc B2A2|B2G2 E2D2|G2G2 GABc|d4 B2gf| \n"
                + "w: Sa-ys m\\-y aul' w--an_ to your aul' w~an * \n ";
        verifyLexer(input,
                new String[] { "X:2167 \n", "T:Waxie's Dargle \n", "M:4/4 \n", "L:1/8 \n", "Q:1/4=180 \n", "K:G \n",
                        "g", "f", "|", "e2", "d", "c", "B2", "A2", "|", "B2", "G2", "E2", "D2", "|", "G2", "G2",
                        "G", "A", "B", "c", "|", "d4", "B2", "g", "f", "|", "\n",
                        "w: Sa-ys m\\-y aul' w--an_ to your aul' w~an * \n"
                });
	}
	
	
	/*
	 * Helper method to verify tokens are what they should be.
	 * 
	 * @param input input to be lexed
	 * @param expectedTokens list of strings that should match the tokens
	 */
	private void verifyLexer(String input, String[] expectedTokens) {
		CharStream stream = new ANTLRInputStream(input);
		ABCmusicLexer lexer = new ABCmusicLexer(stream);
		lexer.reportErrorsAsExceptions();
		List<? extends Token> actualTokens = lexer.getAllTokens();
		
		assertEquals(expectedTokens.length, actualTokens.size());
		
		for (int i = 0; i < actualTokens.size(); i++) {
			String actualToken = actualTokens.get(i).getText();
			String expectedToken = expectedTokens[i];
			assertEquals(actualToken, expectedToken);
		}
	}

}


