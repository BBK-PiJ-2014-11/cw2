/*
Ehshan Veerabangsa, eveera01;
CW2, Programming in Java;
MSc Computer Science
 */

/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

    // test divide by zero - should print an error and exit
    new Fraction(1, 0);

     // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");


    // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");


	//-------------------------------------Extended--------------------------------------------


	// test add
	Fraction a = new Fraction(13,15);
	Fraction b = new Fraction(2,3);
	Fraction c = new Fraction(1,5);
	if (!a.equals(b.add(c))) System.out.println("Add failed");

	// test subtract
	Fraction d = new Fraction(7,12);
	Fraction e = new Fraction(5,6);
	Fraction i = new Fraction(1,4);
	if (!d.equals(e.subtract(i))) System.out.println("Subtract failed");

	//test divide
	Fraction j = new Fraction(4,7);
	Fraction k = new Fraction(1,2);
	Fraction l = new Fraction(7,8);
	if (!j.equals(k.divide(l))) System.out.println("Divide failed");

	// test toString
	Fraction wholeNumber = new Fraction(4,1);
	System.out.println(wholeNumber.toString());

	// test absValue
	Fraction negative = new Fraction(-1,2);
	System.out.println(negative.absValue().toString());
	Fraction negate = new Fraction(-5,8);
	System.out.println(negate.absValue().toString());
	Fraction neg = new Fraction(-3,4);
	System.out.println(neg.absValue().toString());

	//test negate
	Fraction positiveNumber = new Fraction(1,2);
	System.out.println(positiveNumber.negate().toString());
	Fraction pos = new Fraction(5,8);
	System.out.println(pos.negate().toString());
	Fraction plus = new Fraction(3,4);
	System.out.println(plus.negate().toString());
	}

	//-----------------------------------------------------------------------------

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
