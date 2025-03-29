package adts;

import interfaces.MusicPart;

import java.util.ArrayList;
import java.util.List;

import sound.MusicPlayer;
import utils.NumberTheory;

/**
 * ADT that represents a voice. It has a name, and a list of Measures.
 * 
 * By default, there is one voice, but there can be multiple. This is used to
 * have several melodies play at once.
 * 
 */
public class Voice implements MusicPart {
    private final String name;
    private final List<Measure> measures;

    /**
     * Creates a new Voice object with a name and its measures
     * 
     * @param name
     *            name of the Voice
     * @param measures
     *            list of Measures in the Voice
     */
    public Voice(String name, List<Measure> measures) {
        this.name = name;
        this.measures = new ArrayList<Measure>(measures);
    }

    @Override
    public void addNotes(MusicPlayer player) {
        for (Measure measure : measures) {
            measure.addNotes(player);
        }
    }

    @Override
    public int calculateTicksPerBeat() {
        int LCM = 1;
        for (Measure measure : measures) {
            LCM = NumberTheory.lcm(LCM, measure.calculateTicksPerBeat());
        }
        return LCM;
    }

    @Override
    public boolean equals(Object _that) {
        // two objects can only be equal if they are of the same type
        if (!(_that instanceof Voice)) {
            return false;
        }
        Voice that = (Voice) _that;
        return this.measures.equals(that.measures) && this.name.equals(that.name);
    }

    /**
     * Represents the Voice as the voice name followed by measures with an end
     * of notes |] symbol at the end. Lyrics are not printed.
     * 
     * @return the string representation of the Voice
     */
    @Override
    public String toString() {
        StringBuilder voiceString = new StringBuilder(name + ":");
        for (Measure m : measures) {
            voiceString.append(m.toString());
        }

        return voiceString + "]";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + measures.hashCode();
    }

}