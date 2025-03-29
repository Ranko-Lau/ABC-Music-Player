package utils;

/**
 * The Fraction class implements non-negative fractions, i.e., rational numbers.
 */
public class Fraction {

	/* private fields within a Fraction. */
	private int numerator;
	private int denominator;

	/**
	 * Constructs a Fraction n/d.
	 * 
	 * @param n
	 *            is the numerator, assumed non-negative.
	 * @param d
	 *            is the denominator, assumed positive.
	 */
	public Fraction(int n, int d) {
		int gcd = NumberTheory.gcd(n, d);
		this.numerator = n / gcd;
		this.denominator = d / gcd;
	}

	/**
	 * Constructs a Fraction n/1.
	 * 
	 * @param n
	 *            is the numerator, assumed non-negative.
	 */
	public Fraction(int n) {
		this(n, 1);
	}

	/**
	 * Constructs a Fraction parsed from a String input.
	 * 
	 * @param frac
	 *            is an int followed by a "/" followed by another int.
	 */
	public Fraction(String frac) {
		int n = 1, d = 1;
		String fraction = frac.trim();
		if (fraction.charAt(0) == '/') {
			fraction = "1" + fraction;
		}
		if (fraction.charAt(fraction.length() - 1) == '/') {
			fraction += "2";
		}
		String[] elementsFrac = fraction.trim().split("/");
		n = Integer.parseInt(elementsFrac[0]);
		if (elementsFrac.length == 2) {
			d = Integer.parseInt(elementsFrac[1]);
		}
		int gcd = NumberTheory.gcd(n, d);
		this.numerator = n / gcd;
		this.denominator = d / gcd;
	}

	/**
	 * Constructs a default Fraction 0/1.
	 */
	public Fraction() {
		this.numerator = 0;
		this.denominator = 1;
	}

	/**
	 * Converts this fraction to a string format: "numerator/denominator."
	 * Fractions are printed in reduced form and are simplified for abc format,
	 * e.g. "1/1"=""; "1/2"="/", "2/1"="2", "1/3"="/3"
	 * 
	 * @return a String representation of this Fraction.
	 */

	public String toString() {
		String numeratorString, denominatorString, barString;
		numeratorString = "" + numerator;
		denominatorString = "" + denominator;
		barString = "/";
		if (denominator == 1) {
			denominatorString = "";
			barString = "";
		}
		if (numerator == 1) {
			numeratorString = "";
		}
		return numeratorString + barString + denominatorString;
	}

	/**
	 * Tells whether the current fraction is smaller than the given one
	 * 
	 * @return a boolean
	 */
	public boolean less(Fraction f2) {

		return (this.evaluate() < f2.evaluate());
	}

	/**
	 * Calculates and returns the double floating point value of a fraction.
	 * 
	 * @return a double floating point value for this Fraction.
	 */
	public double evaluate() {
		double n = numerator; // convert to double
		double d = denominator;
		return (n / d);
	}

	/**
	 * Add f2 to this fraction and return the result.
	 * 
	 * @param f2
	 *            is the fraction to be added.
	 * @return the result of adding f2 to this Fraction.
	 */
	public Fraction add(Fraction f2) {
		Fraction r = new Fraction((numerator * f2.denominator)
				+ (f2.numerator * denominator), (denominator * f2.denominator));
		return r;
	}

	/**
	 * Multiply f to this fraction and return the result.
	 * 
	 * @param f
	 *            is the Fraction to be multiplied.
	 * @return the result of multiplying Fraction f to this Fraction.
	 */
	public Fraction multiply(Fraction f) {

		int num = this.numerator * f.getNumerator();
		int den = this.denominator * f.getDenominator();

		return new Fraction(num, den);
	}

	/**
	 * Multiply int f to this fraction and return the result.
	 * 
	 * @param f
	 *            is the int to be multiplied.
	 * @return the result of multiplying int f to this Fraction.
	 */
	public Fraction multiply(int f) {

		int num = this.numerator * f;
		int den = this.denominator;

		return new Fraction(num, den);
	}

	/**
	 * Getters. Return the values of denominator and numerator
	 */
	public int getNumerator() {
		return this.numerator;
	}

	public int getDenominator() {
		return this.denominator;
	}

	/**
	 * Check two Fraction objects for equality. Fractions are considered equal
	 * if they are evaluated to the same float number
	 * 
	 * @param f
	 *            fraction object to compare
	 * @return true is objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object f) {
		if (!(f instanceof Fraction)) {
			return false;
		}
		Fraction frac = (Fraction) f;
		return (this.evaluate() == frac.evaluate());

	}

	@Override
	public int hashCode() {
		return (int) evaluate();
	}
}