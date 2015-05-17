"Reasonable set of tests.
//can also works with just the code in else clause if (this.getDenominator() == other.getDenominator()) { int num = this.getNumerator() - other.getNumerator(); int denom = this.getDenominator(); return new Fraction(num, denom);
If the code works without the additional case then consider using just the ""else"" clause to simplify the coding.
Add javadoc even when the code already exists and you are extending it (e.g., Fraction)
An enum would have been preferable
switch (operator) { case 1: sumFraction = fraction1.add(fraction2); break; case 2: sumFraction = fraction1.subtract(fraction2); break; case 3: sumFraction = fraction1.multiply(fraction2); break; case 4: sumFraction = fraction1.divide(fraction2); break; default:
Also, consider using ""sets"" for input validation or testing…
Otherwise - a good attempt."
