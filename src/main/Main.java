package main;

import parser.ABCmusicLexer;
import parser.ABCmusicParser;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.AskDialog.AskDialogInterface;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import adts.MusicPiece;
import sound.MusicPlayer;

/**
 * Main entry point of our application. READ THE FOLLOWING FOR UI DIRECTIONS.
 */
public class Main {

	/**
	 * Plays the input file using Java MIDI API and displays header information
	 * to the standard output stream.
	 * 
	 * This main file implements a simple JFrame UI which makes it easier for
	 * the user to play any valid .abc file. The instructions are simple:
	 * 
	 * 1) Copy the .abc file into any of the three *_abc folders (otherSongs,
	 * sample, or songs).
	 * 
	 * 2) Run and click on your song
	 * 
	 * @param file
	 *            the name/location of input abc file relative to abcplayer/src
	 */
	public static void play(String file) {
		// get the MusicPiece object
		MusicPiece music = Main.stringToMusicPiece(Main.readFileToString(file));

		// Find the ticks and tempo to give to the midi main
		int ticksPerBeat = music.calculateTicksPerBeat();
		int tempo = music.getPlayerTempo(ticksPerBeat);

		// Try to play this, it may throw if it can't read the MIDI
		MusicPlayer player = new MusicPlayer(tempo, ticksPerBeat, 0);
		music.addNotes(player);
		player.play();

	}

	protected static String readFileToString(String file) {
		StringBuilder output = new StringBuilder();

		// try with resources, resources always closed after
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(
				file))) {
			String line;

			// Read file line by line and save to output
			while ((line = bufferReader.readLine()) != null) {
				output.append(line);
				output.append(System.getProperty("line.separator"));
			}
			bufferReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();
	}

	public static MusicPiece stringToMusicPiece(String input) {
		// Create a stream of tokens using the lexer.
		CharStream stream = new ANTLRInputStream(input);
		ABCmusicLexer lexer = new ABCmusicLexer(stream);
		lexer.reportErrorsAsExceptions();
		TokenStream tokens = new CommonTokenStream(lexer);
		// List<? extends Token> actualTokens = lexer.getAllTokens();

		// Feed the tokens into the parser.
		ABCmusicParser parser = new ABCmusicParser(tokens);
		parser.reportErrorsAsExceptions();

		// Generate the parse tree using the starter rule.
		ParseTree tree;
		tree = parser.abc_tune(); // "abc_tune" is the starter rule.
		// ((RuleContext) tree).inspect(parser);

		// Walk the tree with the listener.
		ParseTreeWalker walker = new ParseTreeWalker();
		Listener listener = new Listener();
		walker.walk(listener, tree);
		return listener.getMusic();
	}

	public static void main(String[] args) {
		// bring up the pop-up window. This window will have a dropdown menu of
		// all the songs available for the user to play
		new AskDialog("ABC Songs provided to us", "Sample Songs",
				"Our Awesome Additions", "songs_abc", "sample_abc",
				"otherSongs_abc", getFiles("songs_abc"),
				getFiles("sample_abc"), getFiles("otherSongs_abc"),
				new AskDialogInterface() {
					@Override
					public void clickedOnSong(String song, String folder,
							AskDialog d) {
						d.dispose();
						doStuff(song, folder);
					}
				});
	}

	private static void doStuff(String choice, String folder) {
		// if cancelled wasn't clicked print the chosen song and play it
		if (choice != null) {
			System.out.println("Now playing: " + choice);

			String choiceParsed = choice.replace(" ", "_") + ".abc";

			play(folder + "/" + choiceParsed);
		}
		// else return a message indicating to the user that he/she cancelled
		else {
			int ran = (int) (Math.random() * 10);
			String randMessage;
			if (ran < 3) {
				randMessage = "Cancelled command: null song choice. Bad choice.";
			} else if (ran < 7) {
				randMessage = "No music? OK. Maybe later.";
			} else {
				randMessage = "You clicked Cancel by mistake. Go back and pick a song.";
			}
			System.out.println(randMessage);
		}
	}

	private static String[] getFiles(String folderName) {
		File[] list = new File(folderName).listFiles();
		ArrayList<String> choiceList = new ArrayList<String>();
		for (int i = 0; i < list.length; i++) {
			if (list[i].getName().endsWith(".abc")) {
				choiceList.add(list[i].getName().replace(".abc", "")
						.replace("_", " "));
			}
		}
		String[] array = new String[choiceList.size()];
		array = choiceList.toArray(array);
		return array;
	}

	/**
	 * Pop up drop-down menu function used to display the available songs to
	 * play
	 * 
	 * @param values
	 *            string representation of songs in songs_abc
	 * @return pop-up box
	 */
	public static String ask(final String... values) {

		String result = null;

		if (EventQueue.isDispatchThread()) {

			JPanel panel = new JPanel();
			panel.add(new JLabel("Pick the song to play:"));
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
			for (String value : values) {
				model.addElement(value);
			}
			JComboBox<String> comboBox = new JComboBox<String>(model);
			panel.add(comboBox);

			int iResult = JOptionPane.showConfirmDialog(null, panel,
					"ABC song main", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			switch (iResult) {
			case JOptionPane.OK_OPTION:
				result = (String) comboBox.getSelectedItem();
				break;
			}

		} else {

			Response response = new Response(values);
			try {
				SwingUtilities.invokeAndWait(response);
				result = response.getResponse();
			} catch (InterruptedException | InvocationTargetException ex) {
				ex.printStackTrace();
			}

		}

		return result;

	}

	// simple UI interface
	public static class Response implements Runnable {

		private String[] values;
		private String response;

		public Response(String... values) {
			this.values = values;
		}

		@Override
		public void run() {
			response = ask(values);
		}

		public String getResponse() {
			return response;
		}
	}
}