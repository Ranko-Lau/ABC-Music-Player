package utils;

public class NumberTheory {
	public static int gcd(int a, int b) {
		int t=0; int A=a; int B=b;
		if (A==0){
			return b;
		}
		while (B!=0){
			t=B;
			B=A%B;
			A=t;
		}
		if (A<0){
			A*=-1;
		}
		return A;
	}

	public static int lcm(int a, int b) {
		return ((a * b) / gcd(a, b));
	}
}
