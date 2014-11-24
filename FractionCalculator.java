/*
Ehshan Veerabangsa, eveera01;
CW2, Programming in Java;
MSc Computer Science
 */

public class FractionCalculator {

	private Fraction storedFraction;
	private Fraction totalFraction;
	private Fraction reset;
	private int operator;
	private boolean exit;
	private String errorString;
	private String userCommand [][];

	
	public FractionCalculator(){
		storedFraction = new Fraction(0,1);
		totalFraction = new Fraction(0,1);
		reset = new Fraction(0,1);
		operator = 0;
		exit = false;
		errorString = "";
		userCommand = new String[][]{
				{"a", "A", "abs",},
				{"n", "N", "neg",},
				{"c",  "C", "clear",},
				{"q", "Q", "quit",}
		};
	}

	// main method to check input, develop fraction and assigns operators or user commands
	public Fraction evaluate(Fraction fraction, String inputString){

		String[] inputArray = inputString.split("\\s");
		for (int i = 0; i < inputArray .length; i++) {
			if (checkOperator(inputArray[i])){
				getOperator(inputArray[i]);
			}else if (checkNumber(inputArray[i])){
				if(operator == 0) {
					totalFraction= fractionBuilder(inputArray [i]);
				}else{
					storedFraction= fractionBuilder(inputArray [i]);
					totalFraction = sum(totalFraction, storedFraction, operator);
				}
			}else if (checkCommand(inputArray [i],userCommand )) {
				totalFraction = getCommand(inputArray[i], userCommand, totalFraction);
			}else{
				clear();
				errorCollect(inputArray[i], errorString);
			}
		}
		if(!errorString.isEmpty()){
			errorMsg(errorString);
			clearError(errorString);
		}
		return totalFraction;
	}

	//sub-methods

	//checks for operator characters
	public boolean checkOperator(String input) {
		if (input.length() == 1) {
			if (input.equals("*") || input.equals("/") || input.equals("+") || input.equals("-")) {
				return true;
			}
		}
		return false;
	}

	//assigns operator value
	public int getOperator(String input) {
		if (operator !=0) {
			System.out.println("Error! Too many operators have spoiled the broth");
			clear();
			opReset();
			return operator;
		}
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

	// simple method to check if first character in string is number or minus sign
	public boolean checkNumber(String input) {
		if ((Character.isDigit(input.charAt(0)) || input.charAt(0) == '-')){
			return true;
		}
		return false;
	}

	// constructs fraction using user input and fraction class
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

	//calculates the sum two fraction (can be use several times for one input)
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
				sumFraction = fraction1;
		}
		opReset();
		return sumFraction;
	}

	// checks for user command characters
	public boolean checkCommand(String input,String command [][]) {
		boolean match = false;
			for (int i = 0; i < command.length; i++) {
				for (int j = 0; j < command[i].length; j++) {
					if (input.equals(command[i][j])) {
						match = true;
					}
				}
			}
		return match;
	}

	// assigns method bases on user commands
	public Fraction getCommand(String input,String userCommand [][],Fraction fraction) {
		Fraction sumFraction = new Fraction(0,1);
		for (int i = 0; i < userCommand .length; i++) {
			for (int j = 0; j < userCommand[i].length; j++) {
				if (input.equals(userCommand[0][j])) {
					sumFraction = fraction.absValue();
					return sumFraction;
				}else if (input.equals(userCommand[1][j])){
					sumFraction = fraction.negate();
					return sumFraction ;
				}else if (input.equals(userCommand[2][j])){
					sumFraction = reset;
					return sumFraction;
				}else if (input.equals(userCommand[3][j])){
					exit = true;
					break;
				}
			}
		}
		return sumFraction;
	}

	// checks for exit characters(no longer needed)
	/*
	public boolean checkExit(String input) {
		if (input.length() == 1) {
			if (input.equals("q") || input.equals("Q") || input.equals("quit")) {
				return true;
			}
		}
		return false;
	}
	*/

	//checks for EOL characters // to be developed
	public boolean checkError(String input) {
		return false;
	}

	// resets fraction values
	public void clear() {
		totalFraction = reset;
	}

	// re-initialises operator
	public void opReset(){
		operator = 0;
	}

	// builds an error message
	public void errorCollect (String input, String errorString){
		this.errorString = errorString +" "+input;
	}

	// clear error message
	public void clearError(String errorString){
		this.errorString = "";
	}

	// takes user input as string and runs main program
	public void calculate(){
		intro();
		while(!exit) {
			Fraction fraction = new Fraction(0, 1);
			String userInput = System.console().readLine();
			fraction = evaluate(fraction, userInput);
			System.out.println("Sum = "+fraction);
			System.out.println("");
		}
		System.out.println("Thank you for using my Fraction Calculator");
	}


	// Welcome message
	public void intro(){
		System.out.println("Welcome to Coursework Two: A Fraction Calculator");
		System.out.println("");
		System.out.println("A program by Ehshan Veerabangsa");
		System.out.println("");
		System.out.println("Fractions can be entered as 2 numbers separated by a /(slash)");
		System.out.println("Operators take conventional form: +(add), -(minus), *(multiply) and /(divide)");
		System.out.println("Operators take conventional form: +(add), -(minus), *(multiply) and /(divide)");
		System.out.println("Enter A, a or abs for the fraction's absolute value");
		System.out.println("Enter N, n, or neg to negate the fraction");
		System.out.println ("Enter C, c or clear to reset the calculator");
		System.out.println("");
		System.out.println("If you've had enough, enter Q, q or quit to exit the program");
		System.out.println("");
		System.out.println("Let's Begin! Enter your calculation:");
	}

	public void errorMsg (String errorString){
		System.out.println("");
		System.out.println("Error! '"+errorString+"' is not a valid input");
		System.out.println("");
	}

	//consider
	public static void main(String[] args) {
		FractionCalculator firstCalculator = new FractionCalculator();
		firstCalculator.calculate();
	}

}

