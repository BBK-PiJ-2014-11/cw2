/*
Ehshan Veerabangsa, eveera01;
CW2, Programming in Java;
MSc Computer Science
 */

//import java.util.Scanner;
public class FractionCalculatorTest {
	//private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//FractionCalculator firstCalculator = new FractionCalculator();
		//firstCalculator.calculate();


		//test with set input
		FractionCalculator testCalculator = new FractionCalculator();

		test(testCalculator, "3/4 + 1/-3 * 7 / 5", new Fraction(0, 1), 0);

	}

	public static void test(FractionCalculator calculator, String inputString, Fraction storedFraction, int storedOperator) {
		System.out.println("Test");
		System.out.println(calculator.toString());
	}

}