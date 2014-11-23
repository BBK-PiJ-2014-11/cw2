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
	String errorString;
	
	public FractionCalculator(){
		storedFraction = new Fraction(0,1);
		reset = new Fraction(0,1);
		operator = 0;
		exit = false;
		errorString = "";
		userCommand = new String[][]{
				{"a", "A", "abs"},
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
			if (checkOperator(inputArray[i])){
				getOperator(inputArray[i]);
				if (operator == 0){
					totalFraction = reset;
					clear(totalFraction);
					System.out.println("After clear tf -- "+ totalFraction);
					return totalFraction;
				}
			}else if (checkNumber(inputArray[i])){
				if(operator == 0) {
					fraction = fractionBuilder(inputArray [i]);
					System.out.println("first assignment: "+ fraction);
				}else{
					storedFraction = fractionBuilder(inputArray [i]);
					System.out.println("first assignment: "+ storedFraction);
				}
				totalFraction = sum(fraction, storedFraction, operator);
			}else if (checkCommand(inputArray [i],userCommand )) {
				System.out.println("command entered");
				totalFraction = getCommand(inputArray[i], userCommand, totalFraction);
			}else if(checkExit(inputArray[i])){
					exit = true;
			}else{
				clear(fraction);
				errorCollect(inputArray[i], errorString);
			}

		}
		if(!errorString.isEmpty()){
			errorMsg(errorString);
			clearError(errorString);
		}
		storedFraction = totalFraction;
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
			opReset(operator);
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

	public boolean checkNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			char number = input.charAt(i);
			if (!Character.isDigit(number)&& (!Character.isSpaceChar(number ))){
				return false;
			}
		}
		return true;
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
		opReset(this.operator);
		return sumFraction;
	}

	// checks for user command characters
	public boolean checkCommand(String input,String command [][]) {
		if (input.length() == 1) {
			for (int i = 0; i < command.length; i++) {
				System.out.println((command.length));
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

	// assigns method bases on user commands
	public Fraction getCommand(String input,String userCommand [][],Fraction fraction) {
		System.out.println("passed fraction");
		System.out.println((fraction));
		for (int i = 0; i < userCommand .length; i++) {
			if (input.equals(userCommand[0])){
				System.out.println("ABS CAUGHT");
				System.out.println("FRACTION passed to method: = "+fraction);
				fraction.absValue();
				System.out.println("FRACTION after method: = " + fraction);
				return fraction;
			}else if (input.equals(userCommand[1])) {
				System.out.println("NEG CAUGHT");
				fraction.negate();
				return fraction;
			}else if (input.equals(userCommand[2])){
				System.out.println("CLEAR CAUGHT");
				fraction = reset;
				return fraction;
			}else //if(input.equals(userCommand[3])) {
			{
				System.out.println("QUIT CAUGHT");
				exit = true;
				break;
			}

			/*
			System.out.println((userCommand[i]));
			for (int j = 1; j < userCommand[i].length; j++) {
				System.out.println((userCommand[i][j]));
				if (input.equals(userCommand[0][j])) {
					System.out.println("ABS CAUGHT");
					System.out.println("FRACTION passed to method: = "+fraction);
					fraction.absValue();
					System.out.println("FRACTION after method: = " + fraction);
					return fraction;
				}else if (input.equals(userCommand[1][j])){
					System.out.println("NEG CAUGHT");
					fraction.negate();
					return fraction;
				}else if (input.equals(userCommand[2][j])){
					System.out.println("CLEAR CAUGHT");
					fraction = reset;
					return fraction;
				}else{
					System.out.println("QUIT CAUGHT");
					exit = true;
					break;
				}
			}*/
		}
		System.out.println("fraction below");
		System.out.println((fraction));
		return fraction;
	}

	// checks for exit characters
	public boolean checkExit(String input) {
		if (input.length() == 1) {
			if (input.equals("q") || input.equals("Q") || input.equals("quit")) {
				return true;
			}
		}
		return false;
	}

	//checks for EOL characters // to be developed
	public boolean checkError(String input) {
		return false;
	}

	// resets fraction values
	public Fraction clear(Fraction fraction) {
		fraction = this.reset;
		return fraction;
	}

	// re-initialises operator
	public void opReset(int operator){
		this.operator = 0;
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
			System.out.println("operator: "+operator);
		}
		System.out.println("Thank you for using my Fraction Calculator");
	}


	// Welcome message
	public void intro(){
		System.out.println("Welcome to Coursework Two: A Fraction Calculator");
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

	public void errorMsg (String errorString){
		System.out.println("");
		System.out.println("Error!"+errorString+" is not a valid input");
		System.out.println("");
	}

}