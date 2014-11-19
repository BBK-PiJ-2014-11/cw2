//Created by Ehshan Veerabangsa; eveera01;

public class FractionCalculator {

	private Fraction inputFraction;
	private Fraction reset;
	private int operator;
	private boolean exit;
	
	public FractionCalculator(){
		inputFraction = new Fraction(0,1);
		reset = new Fraction(0,1);
		operator = 0;
		boolean exit = false;
	}
	
	
	public Fraction evaluate(Fraction fraction, String inputString){ 
	
	//to be written
	
	}
	
	public void intro(){
		System.out.println("Welcome to Coursework Two: A Fraction calculator");
		System.out.println("");
		System.out.println("A program by Ehshan Veerabangsa");
		System.out.println("");
		System.out.println("Fractions can be entered as 2 numbers seperated by a /");
		System.out.println("Opperators take conventional form: +(add), -(minus), *(multiply) and /(divide)");
		System.out.println("Enter A, a or abs or the fraction's absolute value");
		System.out.println("Enter N, n, or neg to negate the fraction");
		System.out.println ("Enter C, c or clear to reset the calculator");
		System.out.println("");
		System.out.println("If you've had enough, enter Q, q or quit to exits the programe");
		System.out.println("");
		System.out.println("Let's Begin!");
	}
	
	public void clear(Fraction fraction) {
		fraction = reset;
	}

}