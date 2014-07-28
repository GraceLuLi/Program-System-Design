

import java.util.ArrayList;


public class Nums {

    public Nums() {
	numsArr = new ArrayList<Integer>();

    }

    public int numSize(){
        return numsArr.size();
    }

    public void add(int value) {
	numsArr.add(value);

    }


 
    public int minVal(){
        if(numsArr.size()==0){
	    return 0;}
	else{
           int minVal=numsArr.get(0);
           for (int i=0; i< numsArr.size(); i++){
            if(numsArr.get(i)< minVal){
		minVal=numsArr.get(i);
	    }
        }
	   return minVal;}

    }

  
    public void printVals() {
	System.out.print("(");
        for (int i=0; i < numsArr.size(); i++){
	    System.out.print(numsArr.get(i)+" ");}
        System.out.print(")");
    }

  
    public Nums valuesGT(int threshold) {
       Nums numsArrGT = new Nums();
         
        for (int i=0; i < numsArr.size(); i++){
            if(numsArr.get(i) > threshold){
                numsArrGT.add( numsArr.get(i));
             }
         }     

	return numsArrGT;  

    }


     private ArrayList<Integer> numsArr=new ArrayList<Integer>();
     
    
}
