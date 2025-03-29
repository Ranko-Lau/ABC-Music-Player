package adts;

import interfaces.MusicPart;

import java.util.ArrayList;
import java.util.List;

import sound.MusicPlayer;
import utils.NumberTheory;

/**
 * ADT that represents the complete music piece. It has a Signature and a list 
 * of Voices. The Voices then have the notes and lyrics.
 */
public class MusicPiece implements MusicPart {
    private final Signature signature;
    private final List<Voice> voices;

    /**
     * Creates a MusicPiece object that represents a complete piece of music
     * with a Signature and a list of Voices (or one by default)
     * 
     * @param signature
     *            the signature of the MusicPiece
     * @param voices
     *            list of Voices in the piece
     */
    public MusicPiece(Signature signature, List<Voice> voices) {
        this.signature = signature;
        this.voices = new ArrayList<Voice>(voices);
    }

    @Override
    public void addNotes(MusicPlayer player) {
        for (Voice voice : voices) {
            voice.addNotes(player);
            player.resetTime();
        }
    }

    @Override
    public int calculateTicksPerBeat() {
        int LCM = 1;
        for (Voice voice : voices) {
            LCM = NumberTheory.lcm(LCM, voice.calculateTicksPerBeat());
        }
        return LCM;
    }

    public int getPlayerTempo(int ticksPerBeat) {
        return signature.getPlayerTempo(ticksPerBeat);
    }

    @Override
    public boolean equals(Object _that) {
        // two objects can only be equal if they are of the same type
        if (!(_that instanceof MusicPiece)) {
            return false;
        }
        // if they are, cast the Object into a MusicPiece object and check for
        // equality recursively
        MusicPiece that = (MusicPiece) _that;
        return this.signature.equals(that.signature)
                && this.voices.equals(that.voices);
    }

    /**
     * Returns the signature followed by the voices' measures
     * 
     * @return the string representation of a MusicPiece
     */
    @Override
    public String toString() {
        String voicesString = voices.toString();
        // remove the [ and ] from the voices string
        voicesString = voicesString.substring(1, voicesString.length() - 1);

        return signature.toString() + " \n" + voicesString;
    }

    @Override
    public int hashCode() {
        return this.signature.hashCode() + this.voices.hashCode();
    }

}
