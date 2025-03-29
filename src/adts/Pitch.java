package adts;

import interfaces.MusicSymbol;
import sound.MusicPlayer;
import utils.Fraction;

/**
 * Basic ADT that represents a single pitch.
 * 
 * It has a value -- A,B,C,D,E,F,G
 * 
 * octave -- the offset from the standard octave (e.g. +1 for "a,b,c.." octave);
 * 
 * length -- the fraction of default note
 * 
 * accidental -- 1 for sharp and -2 for flat.
 * 
 */
public class Pitch implements MusicSymbol {
    private final char value;
    private final Fraction length;
    private final int octave;
    private final int accidental;

    /**
     * Creates a Pitch object with attributes
     * 
     * @param length
     *            the fraction of default note
     * @param value
     *            A,B,C,D,E,F,G
     * @param octave
     *            the offset from the standard octave (e.g. +1 for "a,b,c.."
     *            octave)
     * @param accidental
     *            1 for sharp and -2 for flat.
     */
    public Pitch(Fraction length, char value, int octave, int accidental) {
        this.length = length;
        this.value = value;
        this.octave = octave;
        this.accidental = accidental;
    }

   
    public void addNote(MusicPlayer player, String syllable) {
    	 
    	if (!syllable.isEmpty()) {
             player.addLyric(syllable);
         }
    	 
        sound.PlayerPitch pitch = new sound.PlayerPitch(value);
        pitch = pitch.transpose(accidental).octaveTranspose(octave);

        player.addNote(pitch.toMidiNote(), length);
        player.addTime(length);

       
    }

    
    public Pitch multiplyLength(Fraction factor) {
        Fraction newLength = length.multiply(factor);
        return new Pitch(newLength, value, octave, accidental);
    }

   
    public Fraction getLength() {
        return length;
    }

    public int calculateTicksPerBeat() {
        return length.getDenominator();
    }

    @Override
    public boolean equals(Object _that) {
        // two objects can only be equal if they are of the same type
        if (!(_that instanceof Pitch)) {
            return false;
        }
        // if they are, cast the Object into a Pitch object and check for
        // equality recursively on length only, the rest are primitives so use
        // standard equality check
        Pitch that = (Pitch) _that;
        return (this.value == that.value && this.length.equals(that.length)
                && this.octave == that.octave && this.accidental == that.accidental);
    }

    /**
     * Return a string in the following format:
     * 
     * accidentals, if any, followed by the actual note value, followed by
     * octaves, if any, followed by duration
     * 
     * Sharps are ^, flats are _, octave up is ' (the first raised octave is
     * just lower case letters, but the next has apostrophes), octave down is a
     * comma, and duration is a fraction, if it isn't 1.
     * 
     * @return the string representation of a pitch
     */
    @Override
    public String toString() {
        String accidentalString, valueString, lengthString;
        if (accidental == 0) {
            accidentalString = "";
        } else if (accidental == 1) {
            accidentalString = "^";
        } else {
            accidentalString = "_";
        }
        valueString = new String("");
        valueString += value;
        if (octave == 1) {
            valueString = valueString.toLowerCase();
        } else if (octave == 2) {
            valueString = valueString.toLowerCase() + "'";
        } else if (octave == -1) {
            valueString += ",";
        }
        lengthString = length.toString();

        return accidentalString + valueString + lengthString;
    }

    @Override
    public int hashCode() {
        return this.value + this.length.hashCode() + this.octave
                + this.accidental;
    }

}
