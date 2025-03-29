package interfaces;

import adts.Music;
import sound.MusicPlayer;

/**
 * Interface that represents any music part. This could be a MusicPiece, a
 * Measure, or a Voice. The objects are immutable. The equals, toString, and
 * hashCode methods work recursively and individually different from each class
 * extending Music. Read their documentation for full specs.
 */

/*
 * Representation MusicPart = MusicPiece(signature: Signature, voices:
 * List<Voice>) + Measure(notes: List<MusicSymbol>, lyrics: Lyric) + Voice(name:
 * String, measures: List<Measure>)
 */
public interface MusicPart extends Music {
    
	/**
     * Adds the containing notes to the music main
     * 
     * @param player
     *             is a valid MusicPlayer
     */
	public void addNotes(MusicPlayer player);
	
    /**
     * Calculates the required number of ticks per beat, so that each note can
     * be represented as an integer number of ticks.
     * 
     * @return integer representing number of ticks per beat.
     */
    @Override
    public int calculateTicksPerBeat();
	
	/**
	 * Tests the equality of one MusicPart to another, such that two 
	 * expressions with equal attributes (observationally indistinguishable) 
	 * are considered equal
	 * 
	 * @param _that
	 *             MusicPart to compare to
	 * @return whether or not the two MusicParts are equal
	 */
	@Override
	public boolean equals(Object _that);
	
	/**
	 * @return the MusicPart as a string
	 */
	@Override
	public String toString();
	
	/**
	 * Calculates the hashcode for this MusicPart. HashCode for two equal musics
	 * will be identical.
	 * 
	 * @return the hashcode for the MusicPart
	 */
	@Override
	public int hashCode();
}
