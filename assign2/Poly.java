/* 
 * Name: Lu Li
 * loginid: lli619
 */

import java.util.ArrayList;
import java.lang.Math;
/**
   A polynomial. Polynomials can be added together, evaluated, and
   converted to a string form for printing.
*/
public class Poly {
 
    public Poly() {
    	polyArr = new ArrayList<Term>();
    }

     public Poly(Term term) {
       polyArr = new ArrayList<Term>();
       polyArr.add(term);
     }
     
    public int polysize(){
	return polyArr.size();
    }
    
    public Term polyget(int i){
        return polyArr.get(i);
    }
    public void polyadd(Term term){
    	polyArr.add(term);
    }
    /**
       Returns the Poly that is the sum of this polynomial and b
       (neither poly is modified)
     */

    public Poly add(Poly b) {
    	Poly result = new Poly();
    	int i = 0;int j = 0;
    	while(i<polyArr.size()&&j<b.polysize()){
    		if(polyArr.get(i).getExpon()>b.polyget(j).getExpon()){
    			result.polyadd(new Term(polyArr.get(i).getCoeff(),polyArr.get(i).getExpon()));
    			i++;
    		}
    		else if(polyArr.get(i).getExpon()<b.polyget(j).getExpon()){
    			result.polyadd(new Term(b.polyget(j).getCoeff(),b.polyget(j).getExpon()));
    			j++;
    		}
    		else if(polyArr.get(i).getExpon()==b.polyget(j).getExpon()){
    			double newcoeff=polyArr.get(i).getCoeff()+b.polyget(j).getCoeff();
    			if(newcoeff!=0){
    			result.polyadd(new Term(newcoeff,polyArr.get(i).getExpon()));
    			}
    			i++;j++;
    		}
    	}
    	if(i==polyArr.size()){
    		while(j<b.polysize()){
    		result.polyadd(b.polyget(j));
    		j++;}
    	}
        	if(j==b.polysize()){
        		while(i<polyArr.size()){
        		result.polyadd(polyArr.get(i));
        		i++;}
        	}
        	return result;
    	}

    /**
       Returns the value of the poly at a given value of x.
     */
    public double eval(double x) {
    	double sum = 0;
    	for(int i=0; i< polyArr.size(); i++){
    	 sum += Math.pow(x,polyArr.get(i).getExpon()) * polyArr.get(i).getCoeff();
    	}
    assert isValidPoly();
	return sum;         
    }
    
    public String toFormattedString() {
        //print it out with format
   	 String formate ="";
   	 if(polyArr.size()==0){
   		return formate="0.0";//when there is no term, print 0.0
   	 }
   	for(int i=0;i<polyArr.size()-1;i++){//when #of terms bigger than 1
   		if(polyArr.get(i).getCoeff()!=0){
   		if(polyArr.get(i).getCoeff()!=1||polyArr.get(i).getExpon()==0){
   			formate += polyArr.get(i).getCoeff();	
   		}
   	   	if(polyArr.get(i).getExpon()!=0){
   			formate +="x";
   	   	}
   		if(polyArr.get(i).getExpon()>1){
   		 formate += "^"+polyArr.get(i).getExpon();
   		}
   		if(polyArr.get(i+1).getCoeff()>0){
	    	  formate += "+";
	      }
   	}
   	}
    //when #of terms bigger than or equal 1
  	int i = polyArr.size()-1;
   	if(polyArr.get(i).getCoeff()!=0){
   	if(polyArr.get(i).getCoeff()!=1||polyArr.get(i).getExpon()==0){
			formate += polyArr.get(i).getCoeff();	
		}
   	if(polyArr.get(i).getExpon()!=0){
		formate +="x";
   	}
		if(polyArr.get(i).getExpon()>1){
		 formate += "^"+polyArr.get(i).getExpon();
		}
   	}
 	assert isValidPoly();
 	return formate;   
    }
   	 
/*
     public String toFormattedString() {
     //print it out with format
	 String formate ="";
	 if(polyArr.size()==0){
		return formate="0.0";//when there is no term, print 0.0
	 }
	  for(int i=0;i<polyArr.size()-1;i++){//when #of terms bigger than 1
		
			if(polyArr.get(i).getExpon()>1){
		      formate += polyArr.get(i).getCoeff()+"x^"+polyArr.get(i).getExpon();
		      if(polyArr.get(i+1).getCoeff()>0){
		    	  formate += "+";
		      }
		      }	
			if(polyArr.get(i).getExpon()==1){
				formate += polyArr.get(i).getCoeff()+"x";
				if(polyArr.get(i+1).getCoeff()>0){
			    	  formate += "+";
			      }
			}
	  }
	  //when #of terms bigger than or equal 1
	  if(polyArr.get(polyArr.size()-1).getExpon() > 1){
	   formate += polyArr.get(polyArr.size()-1).getCoeff()+"x^"+polyArr.get(polyArr.size()-1).getExpon();
	  }
	  if(polyArr.get(polyArr.size()-1).getExpon()==1){
		   formate += polyArr.get(polyArr.size()-1).getCoeff()+"x";
		  }
	  if(polyArr.get(polyArr.size()-1).getExpon()==0){
			formate += polyArr.get(polyArr.size()-1).getCoeff();
		}
	assert isValidPoly();
	return formate;    
    }*/

    /**
       Returns true iff the poly data is in a valid state. */
   
	private boolean isValidPoly() {
		boolean bl=true;
		for(int i=0; i< polyArr.size();i++){
			if(polyArr.get(i).getExpon()<0){
				bl=false;
			}
		}
		return bl;
	}
    private ArrayList<Term> polyArr;


}
