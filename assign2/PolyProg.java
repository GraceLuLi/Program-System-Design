/* 
 * Name: Lu Li
 * loginid: lli619
 */

import java.util.Scanner;
import java.util.ArrayList;

public class PolyProg {
	
	public static void main(String[] args){
		newpolylist();
	    Scanner in = new Scanner(System.in);
		String s = in.next();
		while(s!="quit"){
		if(s.compareToIgnoreCase("create")==0){
			int k=in.nextInt();
		    create(k);	
		    s = in.next();
		}
		else if(s.compareToIgnoreCase("print")==0){
			int k=in.nextInt();
			print(k);
			s = in.next();
			
		}
		else if(s.compareToIgnoreCase("add")==0){	
	        int a=in.nextInt();
	        int b=in.nextInt();
	        int c=in.nextInt();
			add(a,b,c);
		    s = in.next();
		}
		else if(s.compareToIgnoreCase("eval")==0){
            int k=in.nextInt();
            eval(k);
		    s = in.next();
		}
		else if(s.compareToIgnoreCase("help")==0){
			help();
		    s = in.next();
		}
		else if(s.compareToIgnoreCase("quit")==0){
			break;
		}
		else {
			others();
		    s = in.next();
		}
		}
		}
	
	public static void newpolylist(){
		polyList = new ArrayList<Poly>(10);
	    for(int i=0;i<10;i++){
	    	polyList.add(new Poly());
	    }

		System.out.println("cmd>");
      }
	
	public static void create(int k){
		System.out.println("Enter a space-seperated sequence of coeff-power pairs terminated by <n1>");
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		Scanner input = new Scanner(line);	
		polyList.set(k,new Poly());
		while(input.hasNext()){
			double coeff = input.nextDouble();
			
			if(!input.hasNext()){
				System.out.println("Warn: the number typed in should be even, system automatically throw the last number");
				System.out.println("cmd>");
			   return;
			}
			int expon = input.nextInt();
			if(expon<0){
				expon=-expon;
				System.out.println("Warn: the exponent should be nonegative, system automatically change it to positive");
			}
			polyList.set(k,polyList.get(k).add(new Poly(new Term(coeff,expon))));
			
		}
		System.out.println("cmd>");
	}
	
	
	public static void print(int k){
		System.out.println(polyList.get(k).toFormattedString());
		System.out.println("cmd>");
		}
	
	public static void add(int a, int b,int c){

	    polyList.set(a, polyList.get(b).add(polyList.get(c)));
	    System.out.println("cmd>");
	}
	
	public static void eval(int k){
		Scanner in = new Scanner(System.in);
		if(k>9){
			  System.out.println("ERROR: illegal index for a poly. must between 0 and 9, inclusive");
			  }
		else{
			System.out.println("Enter a floating value for x:");
			System.out.println(polyList.get(k).eval(in.nextDouble()));
		}
		System.out.println("cmd>");
	}
	
	
    public static void help(){
    	System.out.println("create i:");
		System.out.println("create a new poly i");
		System.out.println("print i:");
		System.out.println("print out the poly i");
		System.out.println("eval a :");
		System.out.println("calculate the value of poly with x equal a, a is a double number");
		System.out.println("quit:");
		System.out.println("quit this program");
		System.out.println("help:");
		System.out.println("show command options");	
		System.out.println("cmd>");
	}
    
    public static void others(){
		System.out.println("ERROR: Illegal command. Type 'help' for command options");
		System.out.println("cmd>");
    }
    public static ArrayList<Poly> polyList;
	
}
