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

	@Override
	public int calculateTicksPerBeat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fraction getLength() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MusicSymbol multiplyLength(Fraction factor) {
		// TODO Auto-generated method stub
		return null;
	}

}
