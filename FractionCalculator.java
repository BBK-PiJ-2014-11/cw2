/*
Ehshan Veerabangsa, eveera01;
CW2, Programming in Java;
MSc Computer Science
 */

public class FractionCalculator {

	private Fraction storedFraction;
	private Fraction reset;
	private int operator;
	private boolean exit;
	private String userCommand [][];
	
	public FractionCalculator(){
		storedFraction = new Fraction(0,1);
		reset = new Fraction(0,1);
		operator = 0;
		exit = false;
		userCommand = new String[][]{
				{"a", "a", "abs"},
				{"n", "N", "neg"},
				{"c", "C", "clear"},
				{"q", "Q", "quit"}
		};
	}

	public Fraction evaluate(Fraction fraction, String inputString){

		//needs development

		Fraction totalFraction = new Fraction(0,1);
		String[] inputArray = inputString.split("\\s");
		for (int i = 0; i < inputArray .length; i++) {
			if (checkOperator(inputArray [i])){
				if (operator!= 0){
					clear(fraction);
					System.out.println("operator already entered, calculation reset");
				}
				getOperator(inputArray [i]);
			}else if (Character.isDigit(inputArray [i].charAt(0))){
				if(operator == 0) {
					storedFraction = fractionBuilder(inputArray [i]);
				}else{
					fraction = fractionBuilder(inputArray [i]);
				}
				totalFraction = sum(storedFraction, fraction, operator);
				operator = 0;
			}else if (checkCommand(inputArray [i],userCommand )) {
				System.out.println("command entered");
				getCommand(inputArray[i], userCommand, fraction);
			}else if(checkExit(inputArray[i])){
					exit = true;
			}else{
				clear(storedFraction);
				System.out.println("Input not valid");
			}

		}
		storedFraction = totalFraction;
		return totalFraction;


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
		char inputChar = input.charAt(0);
		switch (inputChar) {
			case '+':
				operator = 1;
				break;
			case '-':
				operator = 2;
				break;
			case '*':
				operator = 3;
				break;
			case '/':
				operator = 4;
				break;
			default:
				operator = 0;
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
		Fraction sumFraction = new Fraction(0,1);
		switch (operator) {
			case 1:
				sumFraction = fraction1.add(fraction2);
				break;
			case 2:
				sumFraction = fraction1.subtract(fraction2);
				break;
			case 3:
				sumFraction = fraction1.multiply(fraction2);
				break;
			case 4:
				sumFraction = fraction1.divide(fraction2);
				break;
			default:
				clear(sumFraction);
		}
		return sumFraction;
	}

	public boolean checkCommand(String input,String command [][]) {
		if (input.length() == 1) {
			for (int i = 0; i < command.length; i++) {
				for (int j = 1; j < command[i].length; j++) {
					//System.out.println((command[i][j]));
					if (input.equals(command[i][j])) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public Fraction getCommand(String input,String command [][],Fraction fraction) {
		System.out.println("passed fraction");
		System.out.println((fraction));
		for (int i = 0; i < command.length; i++) {
			for (int j = 1; j < command[i].length; j++) {
				System.out.println((command[i][2]));
				if (input.equals(command[1][j])) {
					fraction.absValue();
				}else if (input.equals(command[2][j])){
					fraction.negate();
				}else if (input.equals(command[3][j])){
					this.clear(fraction);
				}else{
					this.clear(fraction);
				}
			}
		}
		System.out.println("fraction below");
		System.out.println((fraction));
		return fraction;
	}

	public boolean checkExit(String input) {
		if (input.length() == 1) {
			if (input.equals("q") || input.equals("Q") || input.equals("quit")) {
				return true;
			}
		}
		return false;
	}

	public void clear(Fraction fraction) {
		fraction = reset;
	}

	public void calculate(){
		intro();
		while(!exit) {
			Fraction fraction = new Fraction(0, 1);
			String userInput = System.console().readLine();
			fraction = evaluate(fraction, userInput);
			System.out.println("Sum = "+fraction);
			System.out.println("");
		}
		System.out.println("Goodbye");
	}



	public void intro(){
		System.out.println("Welcome to Coursework Two: A Fraction calculator");
		System.out.println("");
		System.out.println("A program by Ehshan Veerabangsa");
		System.out.println("");
		System.out.println("Fractions can be entered as 2 numbers seperated by a /(slash)");
		System.out.println("Operators take conventional form: +(add), -(minus), *(multiply) and /(divide)");
		System.out.println("Enter A, a or abs or the fraction's absolute value");
		System.out.println("Enter N, n, or neg to negate the fraction");
		System.out.println ("Enter C, c or clear to reset the calculator");
		System.out.println("");
		System.out.println("If you've had enough, enter Q, q or quit to exit the program");
		System.out.println("");
		System.out.println("Let's Begin! Enter your calculation:");
	}

}