/*
Ehshan Veerabangsa, eveera01;
CW2, Programming in Java;
MSc Computer Science
 */

public class FractionCalculatorTest {

	public static void main(String[] args) {

		//test with set input
		FractionCalculator testCalculator = new FractionCalculator();

		//will test one after other, fraction value and operator will be passed to next test

		test(testCalculator, "3/4 + 1/-3 * 7 / 5", new Fraction(0, 1), 0);
		// calculator should reset
		test(testCalculator, "what the fudge!", new Fraction(0, 1), 0);
		// calculate sum
		test(testCalculator, "1/2 / 3/4 - 8/16", new Fraction(0, 1), 3);
		// negate sum
		test(testCalculator, "neg", new Fraction(0, 1), 0);
		//  reset
		test(testCalculator, "C", new Fraction(0, 1), 2);
		// calculate sum to negative fraction
		test(testCalculator, "1/2 - 3/4", new Fraction(0, 1), 0);
		// get absolute value
		test(testCalculator, "a", new Fraction(0, 1), 0);
		// calculate
		test(testCalculator, "* 3/5", new Fraction(0, 1), 0);
		//  reset
		test(testCalculator, "clear", new Fraction(0, 1), 0);
		//store fraction
		test(testCalculator, "3/5", new Fraction(0, 1), 0);
		//store operator
		test(testCalculator, "-", new Fraction(0, 1), 0);
		//result of stored operator and fraction
		test(testCalculator, "2/5", new Fraction(0, 1), 0);


	}

	public static void test(FractionCalculator calculator, String inputString, Fraction fraction, int storedOperator) {
		System.out.println("Test");
		System.out.println(calculator.evaluate(fraction ,inputString).toString());
		System.out.println("");
	}

}