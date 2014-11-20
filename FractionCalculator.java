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
		exit = false;
	}

	public Fraction evaluate(Fraction fraction, String inputString){

		//needs development

		Fraction storedFraction = new Fraction(0,1);
		String[] inputArray = inputString.split("\\s");
		for (int i = 0; i < inputArray .length; i++) {
			if (checkOperator(inputArray [i])){
				getOperator(inputArray [i]);
			}else if (Character.isDigit(inputArray [i].charAt(0))){
				if(operator == 0) {
					inputFraction = fractionBuilder(inputArray [i]);
				}else{
					storedFraction = fractionBuilder(inputArray [i]);
				}
				sum(inputFraction, storedFraction, operator);
				operator = 0;
			}

		}

	}

	//sub-methods

	public boolean checkOperator(String input) {
		if (input.length() == 1) {
			if (input.equals("*") || input.equals("/") || input.equals("+") || input.equals("-")) {
				return true;
			}
		}
		return false;
	}

	public int getOperator(String input) {
		switch (input) {
			case "+":
				operator = 1;
				break;
			case "-":
				operator = 2;
				break;
			case "*":
				operator = 3;
				break;
			case "/":
				operator = 4;
				break;
			default:
				System.out.println("Error with operator");
				break;
		}
		return operator;
	}

	public Fraction fractionBuilder (String input){
		String[] builderString = input.split("\\/");
		if (builderString.length == 1) {
			int num = Integer.parseInt(builderString[0]);
			int denom = 1;
			return new Fraction(num,denom);
		} else {
			int num = Integer.parseInt(builderString[0]);
			int denom = Integer.parseInt(builderString[1]);
			return new Fraction(num,denom);
		}
	}

	public Fraction sum (Fraction fraction1, Fraction fraction2, int operator) {
		switch (operator) {
			case 1:
				return fraction1.add(fraction2);
				break;
			case 2:
				return fraction1.subtract(fraction2);
				break;
			case 3:
				return fraction1.multiply(fraction2);
				break;
			case 4:
				return fraction1.divide(fraction2);
				break;
			default:
				return reset;
				break;
		}
	}


	public Fraction clear(Fraction fraction) {
		fraction = reset;
		return fraction;
	}

	public void intro(){
		System.out.println("Welcome to Coursework Two: A Fraction calculator");
		System.out.println("");
		System.out.println("A program by Ehshan Veerabangsa");
		System.out.println("");
		System.out.println("Fractions can be entered as 2 numbers seperated by a /");
		System.out.println("Operators take conventional form: +(add), -(minus), *(multiply) and /(divide)");
		System.out.println("Enter A, a or abs or the fraction's absolute value");
		System.out.println("Enter N, n, or neg to negate the fraction");
		System.out.println ("Enter C, c or clear to reset the calculator");
		System.out.println("");
		System.out.println("If you've had enough, enter Q, q or quit to exit the program");
		System.out.println("");
		System.out.println("Let's Begin!");
	}

}