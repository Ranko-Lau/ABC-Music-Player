package adts;

import interfaces.MusicSymbol;

import java.util.ArrayList;
import java.util.List;

import sound.MusicPlayer;
import utils.Fraction;
import utils.NumberTheory;

/**
 * ADT that represents a chord. It contains a list of MusicSymbols, which are
 * all played at the same time. No tuplets are allowd.
 */
public class Chord implements MusicSymbol {
    private final List<MusicSymbol> notes;
    private final Fraction length;

    /**
     * Creates a Chord object with notes
     * 
     * @param notes
     *            list of MusicSymbols in the Chord (no tuplets or other
     *            Chords), should be non-empty
     */
    public Chord(List<MusicSymbol> notes) {
        this.notes = new ArrayList<MusicSymbol>(notes);
        // calculate the length - the smallest length of the components
        Fraction minLength = notes.get(0).getLength();
        for (MusicSymbol m : notes) {
            if (m.getLength().less(minLength)) {
                minLength = m.getLength();
            }
        }
        this.length = minLength;
    }

    @Override
    public void addNote(MusicPlayer player, String syllable) {
        // add the syllable if it exists for this note
        if (!syllable.isEmpty()) {
            player.addLyric(syllable);
        }

        for (MusicSymbol note : notes) {
            // add the note to the main
            note.addNote(player, new String());
            // Subtract the length to go back
            player.addTime(note.getLength().multiply(-1));
        }
        // add the actual length of the cord
        player.addTime(length);

    }

    @Override
    public int calculateTicksPerBeat() {
        int LCM = 1;
        for (MusicSymbol note : notes) {
            LCM = NumberTheory.lcm(LCM, note.calculateTicksPerBeat());
        }
        return LCM;
    }

    public Fraction getLength() {
        return length;
    }

    /**
     * Creates a copy of the Chord with lengths of notes multiplied by factor
     * 
     * @param factor
     *            is a valid Fraction
     * @return Chord with the new length
     */
    public Chord multiplyLength(Fraction factor) {
        List<MusicSymbol> newNotes = new ArrayList<MusicSymbol>(notes.size());
        for (MusicSymbol p : notes) {
            newNotes.add(p.multiplyLength(factor));
        }
        return new Chord(newNotes);
    }

    @Override
    public boolean equals(Object _that) {
        // two objects can only be equal if they are of the same type
        if (!(_that instanceof Chord)) {
            return false;
        }
        // if they are, cast the Object into a Chord object and check for
        // equality recursively
        Chord that = (Chord) _that;
        return this.notes.equals(that.notes);
    }

    /**
     * Returns a string of chords in the format: "[" followed by notes with
     * spaces between them and ending with a "]"
     * 
     * @return the string representation of the Chord
     */
    @Override
    public String toString() {
        StringBuilder readableChords = new StringBuilder();
        readableChords.append("[");
        for (MusicSymbol note : this.notes) {
            readableChords.append(note);
            // if it's the last note, don't add a space
            if (!note.equals(this.notes.get(this.notes.size() - 1))) {
                readableChords.append(" ");
            }
        }
        readableChords.append("]");
        return readableChords.toString();
    }

    @Override
    public int hashCode() {
        return this.notes.hashCode();
    }

}
