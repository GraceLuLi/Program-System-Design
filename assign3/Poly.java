/* 
 * Name: Lu Li
 * loginid: lli619
 */

/**
   A polynomial. Polynomials can be copied, added together, multiplied, 
   evaluated, and converted to a string form for printing.

   Version for PA3
*/
import java.util.LinkedList;
import java.util.ListIterator;

public class Poly {

    public Poly() {
    	
    }

    public Poly(Term term) {
    	 polyList.add(term);
    	 assert isValidPoly();
    }
    /**
       Creates poly that is a copy of original
       (Copy constructor)
    */ 
    public Poly(Poly original) {
    	ListIterator<Term> iter = original.polyIterator();
        while(iter.hasNext()){
        	polyList.add(iter.next());
        }
        assert isValidPoly();
        assert original.isValidPoly();
    }

    
    /**
    New methods add by myself for Poly class
 */ 
    public ListIterator<Term> polyIterator(){
    	return polyList.listIterator();
    }
    public void polyadd(Term term){
    	polyList.add(term);
    	assert isValidPoly();
    }

    /**
       Returns the Poly that is the sum of this polynomial and b
       (neither poly is modified)
     */
    public Poly add(Poly b) {
    	Poly sum = new Poly();
    	ListIterator<Term> itera = polyList.listIterator();
    	ListIterator<Term> iterb = b.polyIterator();
    	while(itera.hasNext()&&iterb.hasNext()){
    	
    	
    	Term termA = itera.next();
    	Term termB = iterb.next();
    
    	if(termA.getExpon()>termB.getExpon()){
    		sum.polyadd(termA);
    		termB=iterb.previous();
    	}
    	else if(termA.getExpon()<termB.getExpon()){
    		sum.polyadd(termB);
    		termA=itera.previous();
    	}
    	else if(termA.getExpon()==termB.getExpon()){
    		double newCoeff = termA.getCoeff()+termB.getCoeff();
    		if(newCoeff!=0){
    			Term newTerm = new Term(newCoeff, termA.getExpon());
    			sum.polyadd(newTerm);
    		}
    	}
    	
    	}
    	while(itera.hasNext()){
    		sum.polyadd(itera.next());
    	}
    	while(iterb.hasNext()){
    		sum.polyadd(iterb.next());
    	}
    	assert isValidPoly();
    	assert b.isValidPoly();
    	return sum;
    }


    /**
       Returns the value of the poly at a given value of x.
     */
    public double eval(double x) {
    	double value = 0;
    	ListIterator<Term> iter = polyList.listIterator();
    	while(iter.hasNext()){
    		Term temp = iter.next();
    		value += Math.pow(x, temp.getExpon())*temp.getCoeff();
    	}
    	assert isValidPoly();
    	return value;
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
     ListIterator<Term> iter = polyList.listIterator();
     String formatted = "";
     if(!iter.hasNext()|| ((int)polyList.get(0).getCoeff() == 0 && polyList.size()==1)){
    	 return formatted = "0.0";
     }
	 while(iter.hasNext()){
		 Term temp = iter.next();
		 if(temp.getCoeff() !=0){
		 if(temp.getCoeff()!=1||temp.getExpon()==0){
			 formatted += temp.getCoeff();
		 }
		 if(temp.getExpon()!=0){
			 formatted += "x";
		 if(temp.getExpon()!=1){
			 formatted += "^"+temp.getExpon();
		 }
		 }
		 if(iter.hasNext()){
			 Term a = iter.next();
			 if (a.getCoeff() != 0) {
			 formatted += "+";
			 }
			iter.previous();
		 }
		 }
	 }
	assert isValidPoly();
    return formatted;	
    }


    /**
       Returns the Poly that is the product of this polynomial and b
       (neither poly is modified)
     */
    public Poly mult(Poly b) {
    	Poly product = new Poly();
    	ListIterator<Term> itera;
    	ListIterator<Term> iterb = b.polyIterator();
    	while(iterb.hasNext()){
    		Term termB = iterb.next();
    		itera = polyList.listIterator();
    		while(itera.hasNext()){
    			Term termA = itera.next();
    			double newCoeff = termA.getCoeff()*termB.getCoeff();
    			int newExpon = termA.getExpon()+termB.getExpon();
    			product.addIn(new Poly(new Term(newCoeff, newExpon)));
    		}
    		
    	}
    	assert isValidPoly();
    	assert b.isValidPoly();
    	return product;
    }


    /**
       Adds b to this poly.  (mutator)
       (b is unchanged)
    */

    public void addIn(Poly b) {
    	ListIterator<Term> itera = polyList.listIterator();
    	ListIterator<Term> iterb = b.polyIterator();
    	while(itera.hasNext()&&iterb.hasNext()){
    	Term termA = itera.next();
    	Term termB = iterb.next();
    	
    		if(termB.getExpon()>termA.getExpon()){
    			itera.previous();
    			itera.add(termB);	
    		}
    		else if(termB.getExpon()==termA.getExpon()){
    			double newCoeff = termA.getCoeff()+termB.getCoeff();
        		if(newCoeff!=0){
        			Term newTerm = new Term(newCoeff, termA.getExpon());
        			itera.set(newTerm);
        		}
        		else{
        			itera.remove();
        			itera.previous();
        		}
    		}
    	   else if(termB.getExpon()<termA.getExpon()){
    		   iterb.previous();
    	   }
    	}
    	
    	while(iterb.hasNext()){
    		itera.add(iterb.next());
    	}
    	assert isValidPoly();
    	assert b.isValidPoly();
    }

    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
       Returns true iff the poly data is in a valid state.
    */
    private boolean isValidPoly() {
		boolean a=true;
		for(int i=0; i< polyList.size();i++){
			if(polyList.get(i).getExpon()<0||((int)polyList.get(i).getCoeff()==0 && polyList.size()>1)){
				a=false;
			}
		}
		for(int i=0; i< polyList.size()-1;i++){
			if(polyList.get(i).getExpon()<=polyList.get(i+1).getExpon()){
				a=false;
			}
		}
		return a;
	}
    // **************************************************************
    //  PRIVATE INSTANCE VARIABLE(S)
    private LinkedList<Term> polyList = new LinkedList<Term>();

}
