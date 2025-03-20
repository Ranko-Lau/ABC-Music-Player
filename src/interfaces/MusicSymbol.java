package interfaces;

import adts.Music;
import sound.MusicPlayer;
import utils.Fraction;

/*
 * Interface that represents a music symbol, which can be either a pitch, a rest
 * or a chord. The objects are immutable. The equals, toString, and hashCode
 * methods work recursively and individually different from each class extending
 * Music. Read their documentation for full specs.
 * 
 */

/*
 * Representation MusicSymbol = Chord(notes: List<Pitch>) + Pitch(value: string,
 * octave: int, length: int) + Rest(length: int)
 */

public interface MusicSymbol extends Music {
	/**
	 * Adds the note and the associated given lyric to the music main given
	 * the number of ticks per beat
	 * 
	 * @param main
	 *            is a valid MusicPlayer
	 * 
	 */
	public void addNote(MusicPlayer player, String syllable);

	/**
	 * Calculates the required number of ticks per beat, so that each note can
	 * be represented as an integer number of ticks.
	 * 
	 * @return integer representing number of ticks per beat.
	 */
	@Override
	public int calculateTicksPerBeat();

	/**
	 * Tests the equality of one MusicSymbol to to another, such that two
	 * MusicSymbols with equal attributes (observationally indistinguishable)
	 * are considered equal
	 * 
	 * @param _that
	 *            MusicSymbols to compare to
	 * @return whether or not the two MusicSymbols are equal
	 */
	@Override
	public boolean equals(Object _that);

	/**
	 * Returns the string representation of the MusicSymbol
	 * 
	 * @returns the MusicSymbol as a string
	 */
	@Override
	public String toString();

	/**
	 * Calculates the hashcode for this MusicSymbol. HashCode for two equal
	 * MusicSymbols will be identical.
	 * 
	 * @return the hashcode for the MusicSymbol
	 */
	@Override
	public int hashCode();

	/**
	 * Returns the lentgh of the music symbol
	 * 
	 * @returns symbol's length as a Fraction of default note length
	 */
	public Fraction getLength();
	
	/**
     * Creates a copy of the MusicSymbol with lengths of notes multiplied by factor
     * 
     * @param factor
     *            is a valid Fraction
     * @return MusicSymbol with the new length
     */
    public MusicSymbol multiplyLength(Fraction factor);

}