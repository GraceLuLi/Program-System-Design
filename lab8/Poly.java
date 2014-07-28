/**
   A polynomial. Polynomials can be copied, added together, multiplied, 
   evaluated, and converted to a string form for printing.

   Version for PA3
*/
public class Poly {

    /**
       Creates the 0 polynomial
    */
    public Poly() {

    }


    /**
       Creates polynomial with single term given
     */
    public Poly(Term term) {

    }


    /**
       Creates poly that is a copy of original
       (Copy constructor)
    */
    public Poly(Poly original) {

    }


    /**
       Returns the Poly that is the sum of this polynomial and b
       (neither poly is modified)
     */
    public Poly add(Poly b) {
	return new Poly();  // dummy code.  just to get stub to compile
    }


    /**
       Returns the value of the poly at a given value of x.
     */
    public double eval(double x) {
	return 0;         // dummy code.  just to get stub to compile
    }


    /**
       Return a String version of the polynomial with the 
       following format, shown by exmaple:
       zero poly:   "0.0"
       1-term poly: "3.0x^2"
       4-term poly: "3.0x^5 + x^2 + 2.0x + 7.0"

       Poly is in a simplified form (only one term for any exponent),
       with no zero-coefficient terms, and terms are shown in
       decreasing order by exponent.
    */
    public String toFormattedString() {
	return "";        // dummy code.  just to get stub to compile
    }


    /**
       Returns the Poly that is the product of this polynomial and b
       (neither poly is modified)
     */
    public Poly mult(Poly b) {
	return new Poly();  // dummy code.  just to get stub to compile
    }


    /**
       Adds b to this poly.  (mutator)
       (b is unchanged)
    */
    public void addIn(Poly b) {

    }



    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
       Returns true iff the poly data is in a valid state.
    */
    private boolean isValidPoly() {
	return false;     // dummy code.  just to get stub to compile
    }



    // **************************************************************
    //  PRIVATE INSTANCE VARIABLE(S)


}
