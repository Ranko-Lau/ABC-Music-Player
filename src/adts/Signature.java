package adts;

import java.util.ArrayList;
import java.util.List;

import utils.Fraction;

/**
 * ADT that represents a signature. It has a title, composer, length, meter,
 * tempo, key, and voices.
 * 
 * Default composer is "Unknown". Default meter is 4/4. Default length is 1/16
 * if meter < 3/4 and 1/8 if meter>= 3/4. Default tempo is length notes = 100.
 * If no voice is provided, a default voice is added.
 * 
 */
public class Signature {
    private final String title;
    private final String composer;
    private final Fraction length;
    private final Fraction meter;
    private final Fraction tempo;
    private final String key;
    private final List<String> voices;

    /**
     * Creates a Signature object with music information
     * 
     * @param title
     *            title of the MusicPiece (mandatory)
     * @param composer
     *            composer of MusicPiece (default: "Unknown")
     * @param length
     *            default length of a note (default: 1/16 if meter < 3/4, 1/8 if
     *            meter>= 3/4)
     * @param meter
     *            sum of lengths of all notes in a measure (default: 4/4)
     * @param tempo
     *            number of given length notes to play in a minute (default:
     *            length note * 100)
     * @param key
     *            key signature (mandatory)
     * @param voices
     *            list of voices in the MusicPiece (default: "defaultVoice")
     */
    public Signature(String title, String composer, Fraction length,
            Fraction meter, Fraction tempo, String key, List<String> voices) {
        this.title = title;
        this.composer = composer;
        this.length = length;
        this.meter = meter;
        this.tempo = tempo;
        this.key = key;
        this.voices = new ArrayList<String>(voices);
    }

    public int getPlayerTempo(int ticksPerBeat) {
        return tempo.multiply(length.getDenominator()).getNumerator();
    }

    /**
     * Tests the equality of one Signature to to another, such that two
     * Signatures with equal attributes (observationally indistinguishable) are
     * considered equal
     * 
     * @param _that
     *            Signature to compare to
     * @return whether or not the two Signatures are equal
     */
    @Override
    public boolean equals(Object _that) {
        // two objects can only be equal if they are of the same type
        if (!(_that instanceof Signature)) {
            return false;
        }
        // if they are, cast the Object into a Signature object and check for
        // equality recursively on all attributes
        Signature that = (Signature) _that;
        return (this.title.equals(that.title)
                && this.composer.equals(that.composer)
                && this.length.equals(that.length)
                && this.meter.equals(that.meter)
                && this.tempo.equals(that.tempo) && this.key.equals(that.key) && this.voices
                    .equals(that.voices));
    }

    /**
     * Returns the string representation of the Signature in this format:
     * 
     * T: title \n C: composer \n M: meter \n L: length \n Q: tempo \n V:
     * [voices] \n K: key
     * 
     * @return the string representation of a Signature
     */
    @Override
    public String toString() {
        // make sure meter, length, and tempo aren't blank if they're 1
        String meterString = meter.toString().isEmpty() ? "4/4" : meter.toString();
        String lengthString = length.toString().isEmpty() ? "1" : length.toString();
        String tempoString = tempo.toString().isEmpty() ? "1" : tempo.toString();

        // convert /2 to 1/2 (and the like)
        if (meterString.startsWith("/")) {
            meterString = "1" + meterString;
        }
        if (lengthString.startsWith("/")) {
            lengthString = "1" + lengthString;
        }
        if (tempoString.startsWith("/")) {
            tempoString = "1" + tempoString;
        }

        return "T: " + title.toString() + " \n C: " + composer.toString() + " \n M: "
                + meterString + " \n L: " + lengthString + " \n Q: " + tempoString +
                " \n V: " + voices.toString() + " \n K: " + key.toString();
    }

    /**
     * Calculates the hashcode for this Signature. HashCode for two equal
     * Signatures will be identical.
     * 
     * @return the hashcode for the Signature
     */
    @Override
    public int hashCode() {
        return this.title.hashCode() + this.composer.hashCode()
                + this.length.hashCode() + this.meter.hashCode()
                + this.tempo.hashCode() + this.key.hashCode()
                + this.voices.hashCode();
    }

}