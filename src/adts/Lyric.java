package adts;

import java.util.ArrayList;
import java.util.List;

/**
 * ADT that represents complete lyrics. It has a list of syllables. 
 */
public class Lyric {
	private final List<String> syllables;

	/**
	 * Creates a Lyric object with syllables
	 * 
	 * @param syllables
	 *            list of strings representative of syllables per measure
	 */
	public Lyric(List<String> syllables) {
		this.syllables = new ArrayList<String>(syllables);
	}

	/**
	 * Checks whether the lyrics are empty
	 * 
	 * @return true if is empty, false otherwise
	 */
	public boolean isEmpty() {
		return syllables.isEmpty();
	}

	/**
	 * Simply returns the syllable at the index requested. Requires that the
	 * index requested is less than the size of the syllables list.
	 * 
	 * @param i
	 *            index of syllable to return
	 * @return the syllable String
	 */
	public String getSyllable(int i) {
		return syllables.get(i);
	}

	/**
	 * Calculates the number of lyrics
	 * 
	 * @return integer representing number of syllables
	 */

	public int getSize() {
		return syllables.size();
	}

	@Override
	public boolean equals(Object _that) {
		// two objects can only be equal if they are of the same type
		if (!(_that instanceof Lyric)) {
			return false;
		}
		// if they are, cast the Object into a Lyric object and check for
		// equality recursively
		Lyric that = (Lyric) _that;
		return this.syllables.equals(that.syllables);
	}

	/**
	 * Returns the syllables separated by spaces
	 * 
	 * @return the string representation of the Lyric
	 */
	@Override
	public String toString() {
		StringBuilder lyricString = new StringBuilder();
		for (String s : syllables) {
			lyricString.append(s + " ");
		}
		return lyricString.toString().trim();
	}

	@Override
	public int hashCode() {
		return this.syllables.hashCode();
	}

}