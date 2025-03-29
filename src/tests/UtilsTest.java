package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import adts.Pitch;
import utils.Fraction;
import utils.NumberTheory;

/**
 * This is the test suite for the Utils auxiliary functions. It starts by
 * testing to make sure all the equals(), toString(), and hashCode() methods
 * work correctly as they are the foundation for the entire project. It ends by
 * testing the more specific methods for each class. Must supply valid inputs
 * for the tests as defined by the preconditions in each class to pass these
 * tests.
 */

public class UtilsTest {

	/*
	 * Testing strategy
	 * 
	 * Goal: make sure every auxiliary Utils method works correctly
	 * 
	 * Strategy: begin with simple Fraction and Scales objects and increase
	 * complexity until the most complex instance of each is reached. Each test
	 * will include levels of complexity and test all possible combinations at
	 * that level of complexity. For example, "simple" Fraction tests will test
	 * one Fraction alone, while "multiple" Fraction tests will test two or more
	 * Fraction objects.
	 */

	/*
	 * Test Fraction objects for the equals methods by creating two Notes
	 * instances
	 */
	@Test
	public void equalsFractionWithNotesTest() {

		// All equality tests will pass if reflexivity, symmetry, and
		// transitivity hold therefore the test for equality will assert these
		// are always true

		// Begin with a bare note that has length of 1 and is a C in default
		// octave 1 with no accidentals
		Pitch pitch1 = new Pitch(new Fraction(1), 'A', 0, 0);
		Pitch pitch2 = new Pitch(new Fraction(1), 'A', 0, 0);

		// reflexivity
		assertEquals(true, pitch1.equals(pitch1));

		// symmetry
		assertEquals(true, pitch1.equals(pitch2));
		assertEquals(true, pitch2.equals(pitch1));

		// non-equal comparisons
		Pitch pitch3 = new Pitch(new Fraction(1), 'B', 0, 0);
		Pitch pitch4 = new Pitch(new Fraction(1), 'A', 1, 0);
		Pitch pitch5 = new Pitch(new Fraction(1), 'A', 0, 1);

		assertFalse(pitch1.equals(pitch3));
		assertFalse(pitch1.equals(pitch4));
		assertFalse(pitch1.equals(pitch5));
	}
	
	@Test
	public void equalsFractionTest() {
		
		Fraction frac1 = new Fraction(1,2);
		Fraction frac2 = new Fraction(2,4);
		Fraction frac3 = new Fraction(5000000, 10000000);
		
		assertTrue(frac1.equals(frac2));
		assertTrue(frac2.equals(frac3));
		assertTrue(frac3.equals(frac1));
		
	}

	

	/**
	 * Test all Fraction objects for the hashCode methods,  testing that equal Fractions yield the same
	 * hashCode.
	 */
	@Test
	public void hashCodePublicTheSameTest() {
		Fraction frac1 = new Fraction(3,8);
		Fraction frac2 = new Fraction(3,8);
		assertTrue(frac1.hashCode()==frac2.hashCode());
	}
	
	@Test
	public void hashCodePublicEqualTest() {
		Fraction frac1 = new Fraction(4,12);
		Fraction frac2 = new Fraction(1,3);
		assertTrue(frac1.hashCode()==frac2.hashCode());
	}
	
	@Test
	public void hashCodePublicNotEqualTest() {
		Fraction frac1 = new Fraction(14,12);
		Fraction frac2 = new Fraction(11,3);
		assertTrue(frac1.hashCode()!=frac2.hashCode());
	}

	/**
	 * Test Fraction's functionality
	 * 
	 * Strategy: begin by testing the constructors (there are several) and move
	 * on to its methods
	 */
	
		
	@Test
	public void fractionFullStringConstructorTest() {
		Fraction frac1 = new Fraction(3,8);
		Fraction frac2 = new Fraction("3/8");
		assertTrue(frac1.equals(frac2));
	}
	
		
	@Test
	public void fractionOnlyBarStringConstructorTest() {
		Fraction frac1 = new Fraction(1,2);
		Fraction frac2 = new Fraction("/");
		assertTrue(frac1.equals(frac2));
	}
	
	@Test
	public void fractionNoDenominatorConstructorTest() {
		Fraction frac1 = new Fraction(31,2);
		Fraction frac2 = new Fraction("31/");
		assertTrue(frac1.equals(frac2));
	}
	
	@Test
	public void fractionNoNumeratorConstructorTest() {
		Fraction frac1 = new Fraction(1,8);
		Fraction frac2 = new Fraction("/8");
		assertTrue(frac1.equals(frac2));	
	}
	
	/**
	 * Fraction to String tests
	 */
	@Test
	public void fractionToStringStandardTest() {
		Fraction frac1 = new Fraction(4,7);
		String frac2 = "4/7";
		assertTrue(frac1.toString().equals(frac2));
	}
	
	@Test
	public void fractionToStringNonReducedFormTest() {
		Fraction frac1 = new Fraction(12,18);
		String frac2 = "2/3";
		assertTrue(frac1.toString().equals(frac2));
	}
	
	@Test
	public void fractionToStringABCformatOneTest() {
		Fraction frac1 = new Fraction(1,1);
		String frac2 = "";
		assertTrue(frac1.toString().equals(frac2));
	}
	@Test
	public void fractionToStringABCformatNumeratorOneTest() {
		Fraction frac1 = new Fraction(1,8);
		String frac2 = "/8";
		assertTrue(frac1.toString().equals(frac2));
	}
	
	/**
	 * Fraction equals() test
	 */
	@Test
	public void fractionEqualsNotEqualTest() {
		Fraction frac1 = new Fraction(4,7);
		Fraction frac2 = new Fraction(4,8);
		assertFalse(frac1.equals(frac2));
	}
	
	@Test
	public void fractionEqualsSameTest() {
		Fraction frac1 = new Fraction(2,3);
		Fraction frac2 = new Fraction(2,3);
		assertTrue(frac1.equals(frac2));
	}
	

	@Test
	public void fractionEqualsEqualButNotSameTest() {
		Fraction frac1 = new Fraction(5,25);
		Fraction frac2 = new Fraction(6,30);
		assertTrue(frac1.equals(frac2));
	}
	
	
	/**
	 * Test the GCD method from NumberTheory class.
	 * Strategy: test for cases
	 * a>b,a<b
	 * b|a, a|b
	 * a=0
	 * a,b=1
	 * a,b- prime
	 * (a,b)=1
	 * (a,b)/=1
	 */
	
	@Test
	public void gcdEqualNumberTest() {
		assertEquals(6,NumberTheory.gcd(6, 6));	
	}
	
	@Test
	public void gcdA1Test() {
		assertEquals(1,NumberTheory.gcd(1, 16));	
	}
	
	@Test
	public void gcdPrimesNumbersTest() {
		assertEquals(1,NumberTheory.gcd(13, 29));	
	}
	
	@Test
	public void gcdZeroTest() {
		assertEquals(8,NumberTheory.gcd(0, 8));	
	}
	
	@Test
	public void gcdOneDividesTheOtherTest() {
		assertEquals(18,NumberTheory.gcd(54, 18));	
	}
	
	@Test
	public void gcdDivisorNotOneTest() {
		assertEquals(11,NumberTheory.gcd(22, 99));	
	}
	
	@Test
	public void gcdDivisorOneTest() {
		assertEquals(1,NumberTheory.gcd(35, 8));	
	}
	
	/*
	 * Test the LCM method from NumberTheory class.
	 * Strategy: test for cases
	 * a>b,a<b
	 * b|a, a|b
	 * a,b=1
	 * a,b>1
	 * gcd(a,b)=1
	 * gcd(a,b)/=1
	 */
	
	@Test
	public void lcmEqualNumberTest() {
		assertEquals(6,NumberTheory.lcm(6, 6));	
	}
	
	@Test
	public void lcmA1Test() {
		assertEquals(16,NumberTheory.lcm(1, 16));	
	}
	
	@Test
	public void lcmPrimesNumbersTest() {
		assertEquals(377,NumberTheory.lcm(13, 29));	
	}
	
		
	@Test
	public void lcmOneDividesTheOtherTest() {
		assertEquals(54,NumberTheory.lcm(54, 18));	
	}
	
	@Test
	public void lcmDivisorNotOneTest() {
		assertEquals(198,NumberTheory.lcm(22, 99));	
	}
	
	@Test
	public void lcmDivisorOneTest() {
		assertEquals(280,NumberTheory.lcm(35, 8));	
	}
	
}