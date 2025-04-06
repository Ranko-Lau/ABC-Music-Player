package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Static class used for identification of accidental affected notes related to
 * the key signature. Also contains methods to modify pitch notes in cases of
 * double accidentals.
 * 
 */
public class Scales {

	private static Map<String, Map<String, String>> SCALES = new HashMap<String, Map<String, String>>();

	private final Map<String, String> C = new HashMap<String, String>();
	private final Map<String, String> AM = new HashMap<String, String>();
	private final Map<String, String> G = new HashMap<String, String>();
	private final Map<String, String> EM = new HashMap<String, String>();
	private final Map<String, String> D = new HashMap<String, String>();
	private final Map<String, String> BM = new HashMap<String, String>();
	private final Map<String, String> A = new HashMap<String, String>();
	private final Map<String, String> FSM = new HashMap<String, String>();
	private final Map<String, String> E = new HashMap<String, String>();
	private final Map<String, String> CSM = new HashMap<String, String>();
	private final Map<String, String> B = new HashMap<String, String>();
	private final Map<String, String> GSM = new HashMap<String, String>();
	private final Map<String, String> FS = new HashMap<String, String>();
	private final Map<String, String> DSM = new HashMap<String, String>();
	private final Map<String, String> D_ = new HashMap<String, String>();
	private final Map<String, String> B_M = new HashMap<String, String>();
	private final Map<String, String> A_ = new HashMap<String, String>();
	private final Map<String, String> FM = new HashMap<String, String>();
	private final Map<String, String> E_ = new HashMap<String, String>();
	private final Map<String, String> CM = new HashMap<String, String>();
	private final Map<String, String> B_ = new HashMap<String, String>();
	private final Map<String, String> GM = new HashMap<String, String>();
	private final Map<String, String> F = new HashMap<String, String>();
	private final Map<String, String> DM = new HashMap<String, String>();

	/**
	 * This constructor creates the dictionary of every possible Key and maps it
	 * to dictionaries of the affected notes and the accidentals pertaining to
	 * each note.
	 */
	public Scales() {

		SCALES.put("C", C);
		SCALES.put("Am", AM);

		G.put("F", "sharp");
		SCALES.put("G", G);
		EM.put("F", "sharp");
		SCALES.put("Em", EM);

		D.put("C", "sharp");
		D.put("F", "sharp");
		SCALES.put("D", D);
		BM.put("C", "sharp");
		BM.put("F", "sharp");
		SCALES.put("Bm", BM);

		A.put("C", "sharp");
		A.put("F", "sharp");
		A.put("G", "sharp");
		SCALES.put("A", A);
		FSM.put("C", "sharp");
		FSM.put("F", "sharp");
		FSM.put("G", "sharp");
		SCALES.put("F#m", FSM);

		E.put("C", "sharp");
		E.put("D", "sharp");
		E.put("F", "sharp");
		E.put("G", "sharp");
		SCALES.put("E", E);
		CSM.put("C", "sharp");
		CSM.put("D", "sharp");
		CSM.put("F", "sharp");
		CSM.put("G", "sharp");
		SCALES.put("C#m", CSM);

		B.put("A", "sharp");
		B.put("C", "sharp");
		B.put("D", "sharp");
		B.put("F", "sharp");
		B.put("G", "sharp");
		SCALES.put("B", B);
		GSM.put("A", "sharp");
		GSM.put("C", "sharp");
		GSM.put("D", "sharp");
		GSM.put("F", "sharp");
		GSM.put("G", "sharp");
		SCALES.put("G#m", GSM);

		B.put("A", "sharp");
		B.put("C", "sharp");
		B.put("D", "sharp");
		B.put("F", "sharp");
		B.put("G", "sharp");
		SCALES.put("B", B);
		GSM.put("A", "sharp");
		GSM.put("C", "sharp");
		GSM.put("D", "sharp");
		GSM.put("F", "sharp");
		GSM.put("G", "sharp");
		SCALES.put("G#m", GSM);

		FS.put("A", "sharp");
		FS.put("C", "sharp");
		FS.put("D", "sharp");
		FS.put("E", "sharp");
		FS.put("F", "sharp");
		FS.put("G", "sharp");
		SCALES.put("F#", FS);
		DSM.put("A", "sharp");
		DSM.put("C", "sharp");
		DSM.put("D", "sharp");
		DSM.put("E", "sharp");
		DSM.put("F", "sharp");
		DSM.put("G", "sharp");
		SCALES.put("D#m", DSM);

		D_.put("G", "flat");
		D_.put("A", "flat");
		D_.put("B", "flat");
		D_.put("D", "flat");
		D_.put("E", "flat");
		SCALES.put("Db", D_);
		B_M.put("G", "flat");
		B_M.put("A", "flat");
		B_M.put("B", "flat");
		B_M.put("D", "flat");
		B_M.put("E", "flat");
		SCALES.put("Bbm", B_M);

		A_.put("A", "flat");
		A_.put("B", "flat");
		A_.put("D", "flat");
		A_.put("E", "flat");
		SCALES.put("Ab", A_);
		FM.put("A", "flat");
		FM.put("B", "flat");
		FM.put("D", "flat");
		FM.put("E", "flat");
		SCALES.put("Fm", FM);

		E_.put("A", "flat");
		E_.put("B", "flat");
		E_.put("E", "flat");
		SCALES.put("Eb", E_);
		CM.put("A", "flat");
		CM.put("B", "flat");
		CM.put("E", "flat");
		SCALES.put("Cm", CM);

		B_.put("B", "flat");
		B_.put("E", "flat");
		SCALES.put("Bb", B_);
		GM.put("B", "flat");
		GM.put("E", "flat");
		SCALES.put("Gm", GM);

		F.put("B", "flat");
		SCALES.put("F", F);
		DM.put("B", "flat");
		SCALES.put("Dm", DM);
	}

	/**
	 * This method can be used to check for key signature modifications
	 * throughout the music file
	 * 
	 * @param value
	 *            the uppercase basenote A-G
	 * @param key
	 *            the signature key (K in the header)
	 * @return 1 if it is to be modified as a sharp, -1 for a flat, and 0 for no
	 *         change
	 */
	public static int adjustKey(String value, String key) {
		if (!SCALES.containsKey(key)) {
			throw new IllegalArgumentException("Signature key " + key
					+ " not found");
		}
		Map<String, String> keyMap = SCALES.get(key);
		if (keyMap.containsKey(value)) {
			if (keyMap.get(value).equals("sharp")) {
				return 1;
			} else if (keyMap.get(value).equals("flat")) {
				return -1;
			}
		}
		return 0;
	}

	/**
	 * Function used to change the value of a note when double accidentals are
	 * used.
	 * 
	 * @param value
	 *            the basenote of the note to modify. Must be uppercase char
	 *            A-G.
	 * @return a list of two strings. The first is the new note and the second
	 *         is an indication of octave change. This second value will be -1
	 *         only when going down a pitch from C and going up a pitch from B
	 */
	public static List<String> movePitch(char value, int deltaPitch) {
		List<String> result = new ArrayList<String>();
		List<Character> pitches = Arrays.asList('C', 'D', 'E', 'F', 'G', 'A', 'B');
		int pitchPosition = pitches.indexOf(value);

		if (pitchPosition == 6 && deltaPitch == 1) {
			result.add(""+pitches.get(0));
			result.add("1");
			return result;
		}

		if (pitchPosition == 0 && deltaPitch == -1) {
			result.add(""+pitches.get(6));
			result.add("-1");
			return result;
		}
		
		char pitch=pitches.get(pitchPosition + deltaPitch);
		result.add(""+pitch);
		result.add("0");
		return result;
	}
}