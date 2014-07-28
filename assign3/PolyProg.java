/* 
 * Name: Lu Li
 * loginid: lli619
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class PolyProg {
	
	public static void main(String[] args){
		PolyProg polyProg = new PolyProg();
	    dataList = new ArrayList<Poly>(10);
	    for(int i=0;i<10;i++){
	    	dataList.add(new Poly());
	    }
		System.out.print("cmd> ");
		Scanner in = new Scanner(System.in);
	   while(in.hasNext()){
		String line = in.nextLine();
		Scanner cmdLine = new Scanner(line);
		if (cmdLine.hasNext()){
			String cmdChar = cmdLine.next();
			
			try{
			 if(cmdChar.equalsIgnoreCase("quit")){
				break;
			   }
			 if(cmdChar.equalsIgnoreCase("help")){
				 polyProg.help();
			   }
			else if(cmdChar.equalsIgnoreCase("create")){
				
			    int[] index = getCommandArgs(cmdLine, 1);
				try{
					polyProg.create(index);
				}
				catch(BadDataException exception){
					 System.out.println(exception.getMessage());
					 polyProg.create(index);
				 }	
			}
            else if(cmdChar.equalsIgnoreCase("add")){
            	int[] index = getCommandArgs(cmdLine, 3);
            	polyProg.add(index);
			}
            else if (cmdChar.equalsIgnoreCase("addin")){
			    int[] index = getCommandArgs(cmdLine, 2);
			    polyProg.addin(index);
			 }
			
			else if (cmdChar.equalsIgnoreCase("mult")){
			    int[] index = getCommandArgs(cmdLine, 3);
			    polyProg.mult(index);
			 }
			 else if (cmdChar.equalsIgnoreCase("copy")){
			    int[] index = getCommandArgs(cmdLine, 2);
			    polyProg.copy(index);
			 }
			 else if (cmdChar.equalsIgnoreCase("print")){
			    int[] index = getCommandArgs(cmdLine, 1);
			    polyProg.print(index);
			 }
			 else if (cmdChar.equalsIgnoreCase("eval")){
				int[] index = getCommandArgs(cmdLine, 1);
				polyProg.eval(index);
				 }
			 else{
				System.out.println("ERROR: Illegal command. Type 'help' for command options");
				System.out.println("cmd>");
			 }
			}
		 catch (BadDataException exception){
			 System.out.println(exception.getMessage());
			 System.out.print("cmd> ");
		 }	
		}
	   }

}
 
	private static int[] getCommandArgs(Scanner cmdLine, int numArgs) throws BadDataException
	           {
		if(!cmdLine.hasNext()){
		 throw new BadDataException("ERROR: too few arguments.  Expecting " + numArgs + ".");
		}
		String cmdIndexLine = cmdLine.nextLine();
		Scanner IndexinChar = new Scanner(cmdIndexLine);
		Scanner IndexinInt = new Scanner(cmdIndexLine);
		int[] cmdIndex = new int[numArgs];
		int i = 0;
		int j = 0;
		while(IndexinInt.hasNext()){
			if(i>numArgs-1){
				throw new BadDataException("ERROR: too many arguments.  Expecting " + numArgs + ".");
			}
			int a = IndexinInt.nextInt();
	         if (a>9 || a<0){
	            throw new BadDataException("ERROR: illegal poly index.  must be between 0 and 9, inclusive");
	    	 }
			cmdIndex[i] = a;
			i++;
		}
		while(IndexinChar.hasNext()){
			j++;
			IndexinChar.next();
		}
        if(i<j){
			throw new BadDataException("ERROR: wrong type of input.  Expecting Integer");
		}
        else if(i<numArgs){
			throw new BadDataException("ERROR: too few arguments.  Expecting " + numArgs + ".");
		}
        return cmdIndex;
	           }
		

	public void create(int[] index) throws BadDataException{
		dataList.set(index[0],new Poly());
		System.out.println("Enter a space-seperated sequence of coeff-power pairs terminated by <n1>");
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		Scanner input = new Scanner(line);	
		while(input.hasNext()){
			double coeff = input.nextDouble();
			
			if(!input.hasNext()){
				System.out.println("WARN: the number typed in should be even, system automatically throw the last number");
				System.out.println("cmd>");
			   return;
			}
			if(!input.hasNextInt()){
				throw new BadDataException("ERROR: wrong input type. A term is a coefficient(double) followed by an exponent(int)");
			}
			int expon = input.nextInt();
			if(expon<0){
				throw new BadDataException("ERROR: the exponent should be nonegative");
			}
			dataList.set(index[0],dataList.get(index[0]).add(new Poly(new Term(coeff,expon))));
			
		}
		System.out.println("cmd>");
	}
	
	
	public void print(int[] index){
		System.out.println(dataList.get(index[0]).toFormattedString());
		System.out.println("cmd>");
		}
	
	
	public void add(int[] index){
	    dataList.set(index[0], dataList.get(index[1]).add(dataList.get(index[2])));
	    System.out.println("cmd>");
	}
	
	public void addin(int[] index)
	  {
	     dataList.set(index[0], dataList.get(index[0]).add(dataList.get(index[1])));
	      System.out.print("cmd>");
	  }
	  
	public void mult(int[] index)
	  {
	     dataList.set(index[0], dataList.get(index[1]).mult(dataList.get(index[2])));
	     System.out.print("cmd>");
	  }
	
	public void eval(int[] index){
		Scanner in = new Scanner(System.in);
			System.out.println("Enter a floating value for x:");
			System.out.println(dataList.get(index[0]).eval(in.nextDouble()));
		    System.out.println("cmd>");
	}	
   public void copy(int[] index)
	  {
	     Poly a = (Poly)dataList.get(index[1]);
	     dataList.set(index[0], a);
	     System.out.print("cmd>");
	  }
	
    public void help(){
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
   private static ArrayList<Poly> dataList;
}