package adts;

import interfaces.MusicSymbol;
import sound.MusicPlayer;
import utils.Fraction;

public class Rest implements MusicSymbol {

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
