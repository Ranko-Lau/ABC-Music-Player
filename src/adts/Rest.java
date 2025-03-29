package adts;

import interfaces.MusicSymbol;
import sound.MusicPlayer;
import utils.Fraction;

/**
 * Basic ADT that represents a single rest. It has a length - the fraction of
 * default note
 * 
 */
public class Rest implements MusicSymbol {
    private final Fraction length;

    /**
     * Creates a Rest object with a duration
     * 
     * @param length
     *            a Fraction of the duration of the rest
     */
    public Rest(Fraction length) {
        this.length = length;

    }

    @Override
    public void addNote(MusicPlayer player, String syllable) {
    	if (!syllable.isEmpty()) {
            player.addLyric(syllable);
        }
    	
    	player.addTime(length);
        
    }

    @Override
    public int calculateTicksPerBeat() {
        return length.getDenominator();
    }
    
    public Fraction getLength() {
        return length;
    }

    public Rest multiplyLength(Fraction factor) {
        Fraction newLength = length.multiply(factor);
        return new Rest(newLength);
    }
    
    @Override
    public boolean equals(Object _that) {
        // two objects can only be equal if they are of the same type
        if (!(_that instanceof Rest)) {
            return false;
        }
        // if they are, cast the Object into a Rest object and check for
        // equality recursively on Fraction length
        Rest that = (Rest) _that;
        return this.length.equals(that.length);
    }

    /**
     * Returns a string for a rest which is a "z" followed by its length
     * 
     * @return the string representation of a rest
     */
    @Override
    public String toString() {
        return "z" + this.length.toString();
    }

    @Override
    public int hashCode() {
        return this.length.hashCode();
    }

}
