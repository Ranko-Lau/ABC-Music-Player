package main;

import java.util.ArrayList;
import java.util.List;

import lyrics.LyricsBaseListener;
import lyrics.LyricsParser;

/**
 * Walks the tree, creates a Lyric object
 * 
 * Lyric() return the final Lyric
 * 
 */
public class LyricsListener extends LyricsBaseListener {
	private List<ArrayList<String>> arrayOfArrays = new ArrayList<ArrayList<String>>();
	
	@Override
	public void enterMeasure(LyricsParser.MeasureContext ctx) {
		arrayOfArrays.add(new ArrayList<String>());
	}

	@Override
	public void exitSyllable(LyricsParser.SyllableContext ctx) {

		int skip = 1;
		// get the working measure list, there must be a measure so it's safe to
		// ask for the last index by calling the size of the stack
		ArrayList<String> workingList = ((ArrayList<String>) arrayOfArrays
				.get(arrayOfArrays.size() - 1));

		String syllable = ctx.getText();

		if (workingList.size() > 0) {
			// bring up the last syllable in the working measure
			String lastElem = workingList.get(workingList.size() - 1);
			if (!lastElem.equals("")
					&& (lastElem.charAt(lastElem.length() - 1)) == ' '
					|| lastElem.contains("\\-")) {
				// remove the last syllable and add a new one composed of
				// two words with a space or dash in between (these are to
				// be played under the same note)
				workingList.remove(workingList.size() - 1);
				if (syllable.contains("~")) {
					String newSyllable = syllable.replace("~", " ");
					if (lastElem.contains("\\-")) {
						String newLastElem = lastElem.replace("\\-", "-");
						workingList.add(newLastElem + newSyllable);
					} else {
						workingList.add(lastElem + newSyllable);
					}
				}
				
				else {
					String newLastElem = lastElem.replace("\\-", "-");
					workingList.add(newLastElem + syllable);
				}
				skip = 0;
			}
		}

		if (syllable.contains(" -")) {

			String toAdd = syllable.replace(" -", "");
			workingList.add(toAdd);
			workingList.add("");
		}

		// case of word and tilde
		else if (syllable.contains("~") && skip == 1) {

			String syllableSpace = syllable.replace("~", " ");
			workingList.add(syllableSpace);
		}

		// case of word and hyphen returns the word plus the dash and will
		// have a word after this dash added in the next iteration of
		// syllable
		else if (syllable.contains("\\-") && skip == 1) {
			// String syllableDash = syllable.replace("\\-", "-");
			workingList.add(syllable);
		}

		// case of star just returns an empty string
		else if (syllable.contains("*")) {
			workingList.add("");
		}

		else if (syllable.contains("_")) {
			// count how many underscores appear
			int count = syllable.length() - syllable.replace("_", "").length();
			// now see if there are dashes
			if (syllable.contains("-")) {
				workingList.add(syllable.split("-")[0]);
			}
			else{
				workingList.add(syllable.replace("_", ""));
			}
			for (int i = 0; i < count; i++) {
					// an extension of a syllable will be shown by empty
					// strings
					workingList.add("");
				}
		}

		// double dash case returns the word before the dashes and an empty
		// string
		else if (syllable.contains("--")) {
			// remove the last dash
			String noDash = syllable.substring(0,syllable.length() - 1);
			workingList.add(noDash);
			workingList.add("");
		}

		else if (skip == 1) {
			workingList.add(syllable);
		}
	}

	/**
	 * Gives the final MusicPiece object made from the file inputed
	 * 
	 * @return Lyric as measure lyric objects
	 */
	public ArrayList<ArrayList<String>> getLyric() {
		return (ArrayList<ArrayList<String>>) arrayOfArrays;
	}

}