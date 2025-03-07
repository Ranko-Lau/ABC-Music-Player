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
	public void test() {
		fail("Not yet implemented");
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


