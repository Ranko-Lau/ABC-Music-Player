package adts;

import interfaces.MusicPart;
import interfaces.MusicSymbol;

import java.util.ArrayList;
import java.util.List;

import sound.MusicPlayer;
import utils.NumberTheory;

/**
 * ADT that represents a measure. It has a list of MusicSymbols and a lyric.
 */
public class Measure implements MusicPart {
	private final List<MusicSymbol> notes;
	private final Lyric lyrics;

	/**
	 * Creates a Measure object with notes and lyrics
	 * 
	 * @param notes
	 *            a list of MusicSymbols in the measure
	 * @param lyrics
	 *            a Lyric object with syllables that are in this measure
	 */
	public Measure(List<MusicSymbol> notes, Lyric lyrics) {
		this.notes = new ArrayList<MusicSymbol>(notes);
		this.lyrics = lyrics;
	}

	@Override
	public void addNotes(MusicPlayer player) {
		String syllable = new String();
		// lyrics counter
		int j = 0, nonEmpty = 0;
		for (int i = 0; i < notes.size(); i++) {
			// if note is a rest, skip adding the lyric
			if (!(notes.get(i) instanceof Rest)) {
				if (!lyrics.isEmpty()) {
					syllable = lyrics.getSyllable(j);
					if (!syllable.isEmpty()) {
						// add space if lyric is nonempty
						if (syllable.charAt(syllable.length() - 1) != '-') {
							syllable += " ";
						}
						// new line each 12 syllables
						if (nonEmpty % 12 == 11) {
							syllable += "\n";
						}
						nonEmpty++;
					}
					// new line after lyrics are gone
					if (j == lyrics.getSize() - 1 && nonEmpty > 0) {
						syllable += "\n";
					}
				}
				j++;
			} else {
				// no syllable for rest
				syllable = "";
			}

			notes.get(i).addNote(player, syllable);
		}
	}

	@Override
	public int calculateTicksPerBeat() {
		int LCM = 1;
		for (MusicSymbol symbol : notes) {
			LCM = NumberTheory.lcm(LCM, symbol.calculateTicksPerBeat());
		}
		return LCM;
	}

	@Override
	public boolean equals(Object _that) {
		// two objects can only be equal if they are of the same type
		if (!(_that instanceof Measure)) {
			return false;
		}
		Measure that = (Measure) _that;
		return this.notes.equals(that.notes) && this.lyrics.equals(that.lyrics);
	}

	/**
	 * Returns the notes, with spaces, followed by a pipe. Lyrics are not
	 * printed.
	 * 
	 * @return the string representation of a Measure
	 */
	@Override
	public String toString() {
		String measureString = new String(" ");
		for (MusicSymbol s : notes) {
			measureString += s.toString();
			measureString += " ";
		}
		return measureString + "|";
	}

	@Override
	public int hashCode() {
		return notes.hashCode() + lyrics.hashCode();
	}

}
