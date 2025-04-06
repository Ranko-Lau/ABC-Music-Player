package main;

import parser.ABCmusicBaseListener;
import parser.ABCmusicParser;
import interfaces.MusicSymbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import lyrics.LyricsLexer;
import lyrics.LyricsParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import utils.Fraction;
import utils.Scales;
import adts.Chord;
import adts.Lyric;
import adts.Measure;
import adts.MusicPiece;
import adts.Pitch;
import adts.Rest;
import adts.Signature;
import adts.Voice;

/**
 * Walks the tree, creates a MusicPiece object with Notes and Syllables
 * 
 * getMusic() return the final MusicPiece
 * 
 */
public class Listener extends ABCmusicBaseListener {
    /**
     * Contains Signature and MusicPiece
     */
    private Stack<Object> finalStack = new Stack<Object>();

    /**
     * Stacks to combine smaller objects into larger ones
     */
    private Stack<MusicSymbol> musicSymbolStack = new Stack<MusicSymbol>();
    private Stack<List<MusicSymbol>> musicSymbolPerMeasure = new Stack<List<MusicSymbol>>();
    private List<ArrayList<String>> lyricStack = new ArrayList<ArrayList<String>>();

    /**
     * A way to locate each Voice stack from its name, and a variable to keep
     * track of which voice we're in
     */
    private Map<String, Stack<Measure>> voices = new HashMap<String, Stack<Measure>>();
    private String currentVoice = "defaultVoice";

    /**
     * Notes need to know what key they're in. The dictionary keeps track of
     * what notes have sharps or flats in each measure. Scale has a dictionary
     * of key signatures.
     */
    private String key = "";
    private Map<String, Integer> accidentals = new HashMap<String, Integer>();
    Scales scale;

    /**
     * Keep a list of measures that could possibly be repeated from the
     * beginning or from after a repeat, or from after an end notes symbol
     * (these can either be copied over when needed, or cleared). Keep a list of
     * pairs to find the which measures in the line need repeated lyrics (ie.
     * measure 0 to 5, measure 7 to 8).
     * 
     * If we find 1], hold off on adding to the range until we find a :|, but
     * keep track of the number of measures we skip over
     */
    private Map<String, List<Measure>> repeatedMeasures = new HashMap<String, List<Measure>>();
    private List<Pair<Integer, Integer>> rangeRepeatedMeasures = new ArrayList<Pair<Integer, Integer>>();
    private List<Pair<Integer, Integer>> rangeOneRepeatedMeasures = new ArrayList<Pair<Integer, Integer>>();
    private int insideOneRepeat = 0;

    /**
     * do nothing, because the top of the stack should have the node already in
     * it
     */
    @Override
    public void exitAbc_tune(ABCmusicParser.Abc_tuneContext ctx) {
        assert finalStack.size() == 1;
    }

    /**
     * Start a new repeated measure pair
     */
    @Override
    public void enterLine(ABCmusicParser.LineContext ctx) {
        // the repeated lyrics should start from here
        rangeRepeatedMeasures.add(new Pair<Integer, Integer>(0, 0));
    }

    /**
     * Clear repeatedMeasures and restart the more recent range pair if there is
     * a left repeat
     */
    @Override
    public void enterMeasure(ABCmusicParser.MeasureContext ctx) {
        // clear and restart repeatedMeasures
        if (ctx.LREPEAT() != null) {
            // get the last Pair, equate starting and ending, so that it starts
            // from here
        	Pair<Integer, Integer> oldPair = rangeRepeatedMeasures.get(rangeRepeatedMeasures.size() - 1);  
        	Pair<Integer, Integer> newPair = new Pair<Integer, Integer>(oldPair.b, oldPair.b);  

        	rangeRepeatedMeasures.set(rangeRepeatedMeasures.size() - 1, newPair);
            repeatedMeasures.get(currentVoice).clear();
        }
    }

    /**
     * Check for repeats and adjust the repeated ranges and repeated measures
     * accordingly.
     */
    @Override
    public void exitMeasure(ABCmusicParser.MeasureContext ctx) {
        // Obtain the musicSymbols for this measure
        List<MusicSymbol> musicSymbols = new ArrayList<MusicSymbol>(musicSymbolStack);
        musicSymbolStack.clear();
        accidentals.clear(); // clear the accidentals for this measure

        // if there's a [1 or we're inside that [1, don't add to the range
        if (ctx.ONE_REPEAT() != null) {
            insideOneRepeat = 1;
            Integer currentMeasureNum = rangeRepeatedMeasures.get(rangeRepeatedMeasures.size() - 1).b;
            rangeOneRepeatedMeasures.add(new Pair<Integer, Integer>(currentMeasureNum, currentMeasureNum));
        } else if (insideOneRepeat > 0) {
            insideOneRepeat += 1;
            if (!rangeOneRepeatedMeasures.isEmpty()) {  
                Pair<Integer, Integer> oldPair = rangeOneRepeatedMeasures.get(rangeOneRepeatedMeasures.size() - 1);  
                Pair<Integer, Integer> newPair = new Pair<>(oldPair.a, oldPair.b + 1);  
                rangeOneRepeatedMeasures.set(rangeOneRepeatedMeasures.size() - 1, newPair);  
            }  
        } else {  
            if (!rangeRepeatedMeasures.isEmpty()) {  
                Pair<Integer, Integer> oldPair = rangeRepeatedMeasures.get(rangeRepeatedMeasures.size() - 1);  
                Pair<Integer, Integer> newPair = new Pair<>(oldPair.a, oldPair.b + 1);  
                rangeRepeatedMeasures.set(rangeRepeatedMeasures.size() - 1, newPair);  
            }  
        }

        // copy the lyrics and symbols later, start a new range of repeated
        // measures
        if (ctx.RREPEAT() != null) {
            Integer currentMeasureNum = rangeRepeatedMeasures.get(rangeRepeatedMeasures.size() - 1).b + insideOneRepeat;
            rangeRepeatedMeasures.add(new Pair<Integer, Integer>(currentMeasureNum, currentMeasureNum));
            // we can start finding repeated measures again
            insideOneRepeat = 0;
        }

        // clear most recent pair and ongoing repeated measures, make new range
        // pair
        if (ctx.END_NOTES() != null) {
            Integer currentMeasureNum = rangeRepeatedMeasures.get(rangeRepeatedMeasures.size() - 1).b;
            rangeRepeatedMeasures.remove(rangeRepeatedMeasures.size() - 1);
            rangeRepeatedMeasures.add(new Pair<Integer, Integer>(currentMeasureNum, currentMeasureNum));
            repeatedMeasures.get(currentVoice).clear();
        }

        musicSymbolPerMeasure.add(musicSymbols);
    }

    /**
     * Make actual MusicPiece object
     */
    @Override
    public void exitAbc_music(ABCmusicParser.Abc_musicContext ctx) {

        // We can finally make all the Voices, since we are done
        // entering/exiting them
        List<Voice> voicesList = new ArrayList<Voice>();
        for (String voiceName : voices.keySet()) {
            List<Measure> measures = new ArrayList<Measure>(voices.get(voiceName));
            voicesList.add(new Voice(voiceName, measures));
        }

        // Find the Signature and make a MusicPiece
        Signature signature = (Signature) finalStack.pop();
        MusicPiece musicPiece = new MusicPiece(signature, voicesList);

        finalStack.push(musicPiece);
    }

    /**
     * Now that we have all the measures and the corresponding lyrics, we can
     * make the Measure objects
     */
    @Override
    public void exitLine(ABCmusicParser.LineContext ctx) {
        // loop through each measure's worth of MusicSymbols
        for (int i = 0; i < musicSymbolPerMeasure.size(); ++i) {

            // find the number of notes that aren't Rests to align syllables to
            int numNotes = 0;
            for (MusicSymbol note : musicSymbolPerMeasure.get(i)) {
                if (!(note instanceof Rest)) {
                    numNotes++;
                }
            }

            // get the Lyric!
            Lyric lyrics = makeLyric(numNotes);
            // make the actual measure and push to the stack
            Measure measure = new Measure(musicSymbolPerMeasure.get(i), lyrics);
            Stack<Measure> currentStack = voices.get(currentVoice);
            currentStack.push(measure);

            // if the range of the first pair starts with the number of the
            // measure we're looking at, add the measure to repeated and
            // increment a
            if (rangeRepeatedMeasures.size() > 0) {
                Pair<Integer, Integer> oldPair = rangeRepeatedMeasures.get(0);  

                if (oldPair.a.equals(i) && oldPair.a < oldPair.b) {  
                    repeatedMeasures.get(currentVoice).add(measure);   
                    Pair<Integer, Integer> newPair = new Pair<>(oldPair.a + 1, oldPair.b);  
                    rangeRepeatedMeasures.set(0, newPair);  
                } 
                // if we're in the 1] area, don't add the repeated measure yet
                if (rangeOneRepeatedMeasures.size() > 0) {  
                    Pair<Integer, Integer> oldPairOne = rangeOneRepeatedMeasures.get(0);  
                    if (oldPairOne.a.equals(i + 1) && oldPairOne.a <= oldPairOne.b) {  
                        Pair<Integer, Integer> newPairOne = new Pair<>(oldPairOne.a + 1, oldPairOne.b);  
                        rangeOneRepeatedMeasures.set(0, newPairOne);  
                    }  
                }  else if (rangeRepeatedMeasures.get(0).a >= rangeRepeatedMeasures.get(0).b) {
                    rangeRepeatedMeasures.remove(0);

                    // add the range to the stack unless it's the last pair
                    // (which is ongoing)
                    if (rangeRepeatedMeasures.size() > 0) {
                        currentStack.addAll(repeatedMeasures.get(currentVoice));
                        repeatedMeasures.get(currentVoice).clear();
                    }
                }
            }
        }
        musicSymbolPerMeasure.clear();
        // this is held only for a single line
        rangeRepeatedMeasures.clear();
        rangeOneRepeatedMeasures.clear();
    }

    /**
     * Make a new Voice to add Lyrics and Notes to. Set currentVoice to it.
     */
    @Override
    public void enterField_voice(ABCmusicParser.Field_voiceContext ctx) {
        // we could either be in the header or in the body. We only care for the
        // body. If we are not in the header, the stack should have something in
        // it already.
        if (finalStack.size() > 0) {
            // get voice name sans the "V:" and set it to currentVoice
            String voiceName = ctx.getText().substring(2).trim();
            currentVoice = voiceName;

            // add a new Voice stack and repeatMeasure list if needed
            Stack<Measure> voiceExists = voices.get(currentVoice);
            if (voiceExists == null) { // add new Voice stack
                Stack<Measure> stack = new Stack<Measure>();
                List<Measure> list = new ArrayList<Measure>();
                voices.put(voiceName, stack);
                repeatedMeasures.put(voiceName, list);
            }
        }
    }

    /**
     * Store header info in Signature object
     */
    @Override
    public void exitAbc_header(ABCmusicParser.Abc_headerContext ctx) {
        // initialize scale
        scale = new Scales();

        String[] lines = ctx.getText().split(System.lineSeparator());
        String t = "";
        String c = "Unknown";
        Fraction m = new Fraction(4, 4);
        // can't leave this null, so initialize to something silly
        Fraction l = new Fraction(0, 1);
        Fraction q = new Fraction(0, 1);
        List<String> v = new ArrayList<String>();
        // if we just get a number after Q:, we need to multiply it by length
        // later
        boolean reCalculateTempo = false;

        // populate fields, we don't care about X: whatever
        for (String s : lines) {
            if (s.startsWith("T:")) { // title, mandatory
                t = s.substring(2).trim();
            }
            else if (s.startsWith("C:")) { // composer
                c = s.substring(2).trim();
            }
            else if (s.startsWith("M:")) { // meter
                String meter = s.substring(2).trim();
                if (meter.equals("C")) { // C = 4/4
                    m = new Fraction(4, 4);
                } else {
                    // make a Fraction object by splitting around the /
                    m = new Fraction(meter);
                }
            }
            else if (s.startsWith("L:")) { // length
                // make a Fraction object by splitting around the /
                l = new Fraction(s.substring(2).trim());
            }
            else if (s.startsWith("Q:")) { // tempo
                // gives "length=number" or "number", need length*number
                if (s.contains("=")) {
                    String[] extracted = s.substring(2).trim().split("=");
                    Fraction length = new Fraction(extracted[0]);
                    int number = new Integer(extracted[1]);
                    q = length.multiply(number);
                } else {
                    // if we just get a number after Q:, we need to multiply it
                    // by length later
                    reCalculateTempo = true;
                    q = new Fraction(s.substring(2).trim());
                }
            }
            else if (s.startsWith("K:")) { // key, mandatory
                key = s.substring(2).trim();
            }
            else if (s.startsWith("V:")) { // voices
                v.add(s.substring(2).trim());
            }
        }

        // Default length is 1/16 if meter < 3/4 and 1/8 if meter>= 3/4
        if (l.evaluate() == 0f) { // has not been re-initialized
            if (m.evaluate() < .75) {
                l = new Fraction(1, 16);
            } else {
                l = new Fraction(1, 8);
            }
        }

        // Default tempo is length notes = 100
        if (q.evaluate() == 0f) {
            q = l.multiply(100);
        }

        // we grabbed the tempo, but need to multiply by default length
        if (reCalculateTempo) {
            q = q.multiply(l);
        }

        // create a default Voice stack if no Voices are added
        if (v.isEmpty()) {
            Stack<Measure> stack = new Stack<Measure>();
            v.add("defaultVoice");
            voices.put("defaultVoice", stack);
            List<Measure> list = new ArrayList<Measure>();
            repeatedMeasures.put(currentVoice, list);
        }

        Signature signature = new Signature(t, c, l, m, q, key, v);
        finalStack.push(signature);
    }

    /**
     * Pop notes, add them to Chord, add Chord to current Voice stack. This way
     * all the notes in the Chord will be played at the same time.
     */
    @Override
    public void exitChord(ABCmusicParser.ChordContext ctx) {
        // [ notes ]
        String chordText = ctx.getText();

        // I need the number of pitches/rests, so I split around them, and the
        // number of notes will be 1 less than the number of chunks
        String[] chordsSplit = chordText.split("[A-Ga-gzZ]");
        int numNotes = chordsSplit.length - 1;

        List<MusicSymbol> notes = new ArrayList<MusicSymbol>(numNotes);

        // pop notes and add them to a list
        for (int i = 0; i < numNotes; ++i) {
            notes.add(musicSymbolStack.pop());
        }

        Chord chord = new Chord(notes);
        musicSymbolStack.push(chord);
    }

    /**
     * Pop notes, modify their length, add new notes back. This way, they will
     * be played as a Duplet.
     */
    @Override
    public void exitDuplet(ABCmusicParser.DupletContext ctx) {
        addTuplet(2);
    }

    /**
     * Pop notes, modify their length, add new notes back. This way, they will
     * be played as a Triplet.
     */
    @Override
    public void exitTriplet(ABCmusicParser.TripletContext ctx) {
        addTuplet(3);
    }

    /**
     * Pop notes, modify their length, add new notes back. This way, they will
     * be played as a Quadruplet.
     */
    @Override
    public void exitQuadruplet(ABCmusicParser.QuadrupletContext ctx) {
        addTuplet(4);
    }

    /**
     * Add Rest
     */
    @Override
    public void exitRest(ABCmusicParser.RestContext ctx) {
        // duration is right after the 'z'
        String durationString = ctx.getText().substring(1);
        Fraction duration;
        // duration may be empty if none specified
        if (!durationString.isEmpty()) {
            duration = new Fraction(durationString);
        } else {
            duration = new Fraction(1, 1);
        }
        Rest rest = new Rest(duration);
        musicSymbolStack.push(rest);
    }

    /**
     * Add Pitch
     */
    @Override
    public void exitNote(ABCmusicParser.NoteContext ctx) {
        String text = ctx.getText();
        char value = 'A';
        Fraction length = new Fraction(1, 1);
        // to calculate real length later, since we split all characters
        String lengthString = "";
        int octave = 0;
        int accidental = 0;
        // this is for storing accidentals for the measure
        String noteOctave = "";

        // split everything so we can deal with modifiers
        String[] splitNote = text.trim().split("");

        for (String s : splitNote) {
            if (s.matches("[A-G]")) { // this is the actual note
                value = s.charAt(0);
                noteOctave += s;
            }
            else if (s.matches("[a-g]")) { // note one octave up
                value = s.toUpperCase().charAt(0);
                noteOctave += s;
                octave++;
            }
            else if (s.equals("'")) { // higher octave
                noteOctave += "'";
                octave++;

            } else if (s.equals(",")) { // lower octave
                noteOctave += ",";
                octave--;

            } else if (s.equals("=")) { // natural
                accidental = 5; // let 5 represent natural

            } else if (s.equals("^")) { // sharp
                accidental++;

            } else if (s.equals("_")) { // flat
                accidental -= 2;
            } else if (s.matches("[1-9/]")) {
                // note length
                lengthString += s;
            }
        }

        // if we found length, set it
        if (!lengthString.isEmpty()) {
            length = new Fraction(lengthString);
        }

        // if the note doesn't set its own accidental and is not natural, try
        // taking the measure's accidental, and then the key's accidental
        if (accidental == 0) {
            if (accidentals.containsKey(noteOctave)) {
                accidental += accidentals.get(noteOctave);
            } else {
                accidental += Scales.adjustKey(String.valueOf(value), key);
            }
        } else {
            accidentals.put(noteOctave, accidental);
        }

        // now, fix the accidental
        // for every two sharps, move up a pitch
        if (accidental == 2) {
            List<String> adjust = Scales.movePitch(value, 1);
            value = adjust.get(0).charAt(0);
            octave += new Integer(adjust.get(1));
            accidental = 0;

            // for every two flats, move down a pitch
        } else if (accidental == -4) {
            List<String> adjust = Scales.movePitch(value, -1);
            value = adjust.get(0).charAt(0);
            octave += new Integer(adjust.get(1));
            accidental = 0;
        } else if (accidental == 5) {
            // this is a natural, but we had to represent it somehow
            accidental = 0;
        }

        Pitch note = new Pitch(length, value, octave, accidental);
        musicSymbolStack.push(note);
    }

    /**
     * Add syllables to current Voice's stack by passing the lyric text to
     * another parser
     */
    @Override
    public void exitLyric(ABCmusicParser.LyricContext ctx) {
        String lyricText = ctx.getText();
        // remove the w:
        lyricText = lyricText.substring(2).trim();

        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(lyricText);
        LyricsLexer lexer = new LyricsLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        // List<? extends Token> actualTokens = lexer.getAllTokens();

        // Feed the tokens into the parser.
        LyricsParser parser = new LyricsParser(tokens);
        parser.reportErrorsAsExceptions();

        // Generate the parse tree using the starter rule.
        ParseTree tree = parser.lyric(); // "lyric" is the starter rule.
        // ((RuleContext) tree).inspect(parser);

        // Walk the tree with the listener.
        ParseTreeWalker walker = new ParseTreeWalker();
        LyricsListener listener = new LyricsListener();
        walker.walk(listener, tree);
        ArrayList<ArrayList<String>> lyric = listener.getLyric();

        lyricStack.addAll(lyric);
    }

    /**
     * Makes a Lyric object based on the content of lyricStack
     * 
     * We take the first list of syllables off the lyricStack, and take as many
     * syllables as we need to fill up the measure (up to numNotes). Then we pad
     * the measure with spaces if necessary. We delete the list if it is empty
     * (this mutates the stack!) If there are no syllables, we make an empty
     * Lyric.
     * 
     * @param numNotes
     *            number of notes in the measure that aren't Rests
     * @return the new Lyric object with the right number of syllables
     */
    private Lyric makeLyric(int numNotes) {
        if (lyricStack.size() == 0) {
            // lyricStack may be empty if the piece doesn't have words
            return new Lyric(new ArrayList<String>());
        }
        // if no bars, we get a single ArrayList with all the syllables
        ArrayList<String> lyricList = new ArrayList<String>();
        ArrayList<String> lyricListFromStack = lyricStack.get(0);

        // get the syllables we need and delete them from the stack
        for (int i = 0; i < numNotes && !lyricListFromStack.isEmpty(); ++i) {
            lyricList.add(lyricListFromStack.get(0));
            lyricListFromStack.remove(0);
        }

        // pad the measure with spaces to fill up to numNotes
        while (lyricList.size() < numNotes) {
            lyricList.add("");
        }

        // remove the list from the stack if we've gathered all its syllables
        if (lyricListFromStack.isEmpty()) {
            lyricStack.remove(0);
        }

        return new Lyric(lyricList);

    }

    /**
     * Pops notes in the tuplet out of the stack, multiplied their duration, and
     * adds the new notes back to the stack. Only Pitches and Chords allowed in
     * a tuplet.
     * 
     * Duration of each note is multiplied by 3/2 if duplet, 2/3 if triplet, 3/4
     * if quadruplet
     * 
     * @param tupletNumber
     *            2 for duplet, 3 for triplet, 4 for quadruplet
     */
    private void addTuplet(int tupletNumber) {
        // stack to store changed notes
        Stack<MusicSymbol> currentStack = new Stack<MusicSymbol>();

        // multiply duration of each note by 3/2 if duplet, 2/3 if triplet, 3/4
        // if quadruplet
        Fraction multiplicationFactor = new Fraction(3, 2);
        if (tupletNumber == 3) {
            multiplicationFactor = new Fraction(2, 3);
        }
        else if (tupletNumber == 4) {
            multiplicationFactor = new Fraction(3, 4);
        }

        for (int i = 0; i < tupletNumber; ++i) {
            // add to the stack the same note with its length multiplied by the
            // multiplicationFactor

            // Can be Pitch or Chord (not Rest)
            MusicSymbol musicSymbol = musicSymbolStack.pop();
            if (musicSymbol instanceof Pitch) {
                Pitch newMusicSymbol = ((Pitch) musicSymbol).multiplyLength(multiplicationFactor);
                currentStack.push(newMusicSymbol);

            } else if (musicSymbol instanceof Chord) {
                Chord newMusicSymbol = ((Chord) musicSymbol).multiplyLength(multiplicationFactor);
                currentStack.push(newMusicSymbol);
            }
        }
        // put new notes back in the stack
        for (int i = 0; i < tupletNumber; ++i) {
            musicSymbolStack.push(currentStack.pop());
        }
    }

    /**
     * Gives the final MusicPiece object made from the file inputted
     * 
     * @return MusicPiece
     */
    protected MusicPiece getMusic() {
        return (MusicPiece) finalStack.get(0);
    }

}