package tests;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import sound.LyricListener;
import sound.PlayerPitch;
import sound.SequencePlayer;
import static org.junit.Assert.*;
/**
 * Tests for warm-up questions
 * @category no_didit
 *
 */
public class SequencePlayerTest {
	
	@Test
	public void Test_piece1(){
		boolean error=false;
		SequencePlayer player;		
		try {        
	        LyricListener listener = new LyricListener() {
	            public void processLyricEvent(String text) {
	                System.out.println(text);
	            }
	        };
	
	        player = new SequencePlayer(140, 12, listener);	
	
	        player.addNote(new PlayerPitch('C').toMidiNote(), 0, 12);
	        player.addNote(new PlayerPitch('C').toMidiNote(), 12, 24);
	        player.addNote(new PlayerPitch('C').toMidiNote(), 24, 33);
	        player.addNote(new PlayerPitch('D').toMidiNote(), 33, 36);
	        player.addNote(new PlayerPitch('E').toMidiNote(), 36, 48);
	        
	        player.addNote(new PlayerPitch('E').toMidiNote(), 48, 57);
	        player.addNote(new PlayerPitch('D').toMidiNote(), 57, 60);
	        player.addNote(new PlayerPitch('E').toMidiNote(), 60, 69);
	        player.addNote(new PlayerPitch('F').toMidiNote(), 69, 72);
	        player.addNote(new PlayerPitch('G').toMidiNote(), 72, 96);
	        
	        
	        player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE).toMidiNote(), 96, 100);
	        player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE).toMidiNote(), 100, 104);
	        player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE).toMidiNote(), 104, 108);
	       
	        player.addNote(new PlayerPitch('G').toMidiNote(), 108, 112);
	        player.addNote(new PlayerPitch('G').toMidiNote(), 112, 116);
	        player.addNote(new PlayerPitch('G').toMidiNote(), 116, 120);
	        
	        player.addNote(new PlayerPitch('E').toMidiNote(), 120, 124);
	        player.addNote(new PlayerPitch('E').toMidiNote(), 124, 128);
	        player.addNote(new PlayerPitch('E').toMidiNote(), 128, 132);
	        
	        player.addNote(new PlayerPitch('C').toMidiNote(), 132, 136);
	        player.addNote(new PlayerPitch('C').toMidiNote(), 136, 140);
	        player.addNote(new PlayerPitch('C').toMidiNote(), 140, 144);
	        
	        player.addNote(new PlayerPitch('G').toMidiNote(), 144, 153);
	        player.addNote(new PlayerPitch('F').toMidiNote(), 153, 156);
	        player.addNote(new PlayerPitch('E').toMidiNote(), 156, 165);
	        player.addNote(new PlayerPitch('D').toMidiNote(), 165, 168);
	        player.addNote(new PlayerPitch('C').toMidiNote(), 168, 192);
	
	        System.out.println(player);        
	        player.play();    
	
	    } catch (MidiUnavailableException e) {
	        error=true;
	    } catch (InvalidMidiDataException e) {
	    	error=true;
	    }
		assertFalse(error);
	}
	
	@Test
	public void Test_piece2(){
		boolean error=false;
		SequencePlayer player;		
		try {        
	        LyricListener listener = new LyricListener() {
	            public void processLyricEvent(String text) {
	                System.out.println(text);
	            }
	        };
	
	        player = new SequencePlayer(200, 12, listener);	
	
	        player.addNote(new PlayerPitch('E').transpose(PlayerPitch.OCTAVE).toMidiNote(), 0, 6);
	        player.addNote(new PlayerPitch('F').transpose(1).toMidiNote(), 0, 6);
	        player.addNote(new PlayerPitch('E').transpose(PlayerPitch.OCTAVE).toMidiNote(), 6, 12);
	        player.addNote(new PlayerPitch('F').transpose(1).toMidiNote(), 6, 12);
	        player.addNote(new PlayerPitch('E').transpose(PlayerPitch.OCTAVE).toMidiNote(), 18, 24);
	        player.addNote(new PlayerPitch('F').transpose(1).toMidiNote(), 18, 24);
	        player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE).toMidiNote(), 30, 36);
	        player.addNote(new PlayerPitch('F').transpose(1).toMidiNote(), 30, 36);
	        player.addNote(new PlayerPitch('E').transpose(PlayerPitch.OCTAVE).toMidiNote(), 36, 48);
	        player.addNote(new PlayerPitch('F').transpose(1).toMidiNote(), 36, 48);
	       
	        
	        player.addNote(new PlayerPitch('G').transpose(PlayerPitch.OCTAVE).toMidiNote(), 48, 60);
	        player.addNote(new PlayerPitch('B').toMidiNote(), 48, 60);
	        player.addNote(new PlayerPitch('G').toMidiNote(), 48, 60);
	        player.addNote(new PlayerPitch('G').toMidiNote(), 72, 84);
	     
	        player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE).toMidiNote(), 96, 114);
	        player.addNote(new PlayerPitch('G').toMidiNote(), 114, 120);
	        player.addNote(new PlayerPitch('E').toMidiNote(), 132, 144);
	        
	        player.addNote(new PlayerPitch('E').toMidiNote(), 144, 150);
	        player.addNote(new PlayerPitch('A').toMidiNote(), 150, 162);
	        player.addNote(new PlayerPitch('B').toMidiNote(), 162, 174);
	        player.addNote(new PlayerPitch('B').transpose(-2).toMidiNote(), 174, 180);
	        player.addNote(new PlayerPitch('A').toMidiNote(), 180, 192);
	        
	        player.addNote(new PlayerPitch('G').toMidiNote(), 192, 200);
	        player.addNote(new PlayerPitch('E').transpose(PlayerPitch.OCTAVE).toMidiNote(), 200, 208);
	        player.addNote(new PlayerPitch('G').transpose(PlayerPitch.OCTAVE).toMidiNote(), 208, 216);
	        player.addNote(new PlayerPitch('A').transpose(PlayerPitch.OCTAVE).toMidiNote(), 216, 228);
	        player.addNote(new PlayerPitch('F').transpose(PlayerPitch.OCTAVE).toMidiNote(), 228, 234);
	        player.addNote(new PlayerPitch('G').transpose(PlayerPitch.OCTAVE).toMidiNote(), 234, 240);
	      
	        player.addNote(new PlayerPitch('E').transpose(PlayerPitch.OCTAVE).toMidiNote(), 246, 258);
	        player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE).toMidiNote(), 258, 264);
	        player.addNote(new PlayerPitch('D').transpose(PlayerPitch.OCTAVE).toMidiNote(), 264, 270);
	        player.addNote(new PlayerPitch('C').transpose(PlayerPitch.OCTAVE).toMidiNote(), 270, 279);
	
	        System.out.println(player);        
	        player.play();    
	
	    } catch (MidiUnavailableException e) {
	        error=true;
	    } catch (InvalidMidiDataException e) {
	    	error=true;
	    }
		assertFalse(error);
	}
	
	@Test
	public void Test_piece3(){
		boolean error=false;
		SequencePlayer player;		
		try {        
	        LyricListener listener = new LyricListener() {
	            public void processLyricEvent(String text) {
	                System.out.println(text);
	            }
	        };
	
	        player = new SequencePlayer(100, 1, listener);	
	
	        player.addNote(new PlayerPitch('D').toMidiNote(), 4, 6);
	        
	        player.addNote(new PlayerPitch('G').toMidiNote(), 6, 10);
	        player.addNote(new PlayerPitch('B').toMidiNote(), 10, 11);
	        player.addNote(new PlayerPitch('G').toMidiNote(), 11, 12);
	        
	        player.addNote(new PlayerPitch('B').toMidiNote(), 12, 16);
	        player.addNote(new PlayerPitch('A').toMidiNote(), 16, 18);
	        
	        player.addNote(new PlayerPitch('G').toMidiNote(), 18, 22);
	        player.addNote(new PlayerPitch('E').toMidiNote(), 22, 24);

	        player.addNote(new PlayerPitch('D').toMidiNote(), 24, 28);
	        player.addNote(new PlayerPitch('D').toMidiNote(), 28, 30);
	        
	        player.addNote(new PlayerPitch('G').toMidiNote(), 30, 34);
	        player.addNote(new PlayerPitch('B').toMidiNote(), 34, 35);
	        player.addNote(new PlayerPitch('G').toMidiNote(), 35, 36);
	        
	        player.addNote(new PlayerPitch('B').toMidiNote(), 36, 40);
	        player.addNote(new PlayerPitch('A').toMidiNote(), 40, 42);
	        
	        player.addNote(new PlayerPitch('D').transpose(PlayerPitch.OCTAVE).toMidiNote(), 42, 48);
	        
	        player.addNote(new PlayerPitch('D').transpose(PlayerPitch.OCTAVE).toMidiNote(), 48, 50);
	        
	        player.addLyricEvent("A", 4);
	        player.addLyricEvent("ma", 6);
	        player.addLyricEvent("zing", 10);	     
	        player.addLyricEvent("grace!", 12);
	        player.addLyricEvent("How", 16);
	        player.addLyricEvent("sweet", 18);
	        player.addLyricEvent("the", 22);
	        player.addLyricEvent("sound", 24);
	        player.addLyricEvent("That", 28);
	        player.addLyricEvent("saved", 30);
	        player.addLyricEvent("a", 34);
	        player.addLyricEvent("wretch", 36);
	        player.addLyricEvent("like", 40);
	        player.addLyricEvent("me", 42);	      
	        
	        System.out.println(player);        
	        player.play();    
	
	    } catch (MidiUnavailableException e) {
	        error=true;
	    } catch (InvalidMidiDataException e) {
	    	error=true;
	    }
		assertFalse(error);
	}
	
}