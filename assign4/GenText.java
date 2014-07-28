/**
Name: Lu Li
login ID: lli619
*/
import java.lang.String;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;

import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
import java.io.PrintWriter;
import java.lang.NumberFormatException;


public class GenText 
{
   public static void main(String[] args)
   {
	   try
	   {
	   if (args.length != 4 && args.length != 5)
	   {
		   System.out.println("Error: Wrong CommandLine");
		   throw new BadDataException("Correct Command : java GenText -d prefixLength numWords sourceFile outFile ");
	   }
	   else
	   {
		 int prefixLength = 1;
		 int numwords = 0;
		 String sourceFile="";
		 String outFile;
		 boolean debug;
		 Random random;
		 if(args.length == 4)
		 {
			 debug = false;
			 try
			 {
			 prefixLength = Integer.parseInt(args[0]);
			 numwords = Integer.parseInt(args[1]);
			 }
			 catch(NumberFormatException exception)
		       {   
                 System.out.println("ERROR: prefixLength or numWords argments must be integers!");
                 throw new BadDataException("Correct Command : java GenText -d prefixLength numWords sourceFile outFile ");
		       }
	       
		     sourceFile = args[2];
		     outFile = args[3];
		     random=new Random();
		 }
		 else //args.length == 5
		 {
			 if(!args[0].equals("-d"))
			 {
				 System.out.println("Error: Wrong CommandLine of Debug");
				 throw new BadDataException("Correct Command : java GenText -d prefixLength numWords sourceFile outFile ");
			 }
			 debug = true;
			 try
			 {
			 prefixLength = Integer.parseInt(args[1]);
			 numwords = Integer.parseInt(args[2]);
			 }
			 catch(NumberFormatException exception)
		       {   
               System.out.println("ERROR: prefixLength or numWords argments must be integers!");
               throw new BadDataException("Correct Command : java GenText -d prefixLength numWords sourceFile outFile ");
		       }
		     sourceFile = args[3];
		     outFile = args[4];
		     random=new Random(1); 
		 }
		 if(numwords < 0)
		 {
			 System.out.println("Error: numWords must be greater than or equal 0!");
			 throw new BadDataException("Correct Command : java GenText -d prefixLength numWords sourceFile outFile ");
		 }
		 if(prefixLength < 1)
		  {
		      System.out.println("ERROR: prefixlength must be bigger than 0!");
		      throw new BadDataException("Correct Command : java GenText -d prefixLength numWords sourceFile outFile ");
		   }
		 File inFile = new File(sourceFile);
		 ArrayList<String> textArr = new ArrayList<String>();
		try {
			Scanner in = new Scanner(inFile);
			while (in.hasNext())
		    {
		       textArr.add(in.next());
		    }
		} catch (FileNotFoundException e) {
			 System.out.println("ERROR: The file: " + sourceFile + " not found!");
		}
		 if(prefixLength >= textArr.size())
		  {
		      System.out.println("ERROR: prefixlength must be smaller than number of words in sourceFile!");
		      throw new BadDataException("Correct Command : java GenText -d prefixLength numWords sourceFile outFile ");
		   }
		   Map<Prefix, ArrayList<String>> mapTable = new HashMap<Prefix, ArrayList<String>>();
			  
		   for(int i=0; i<textArr.size()-prefixLength; i++)
		   {
			   Prefix prefix = new Prefix();
		       prefix.getPrefix(textArr,i,prefixLength);
		       String successor = textArr.get(i+prefixLength);
		       ArrayList<String> successors;
		       if(mapTable.containsKey(prefix))
		       {
		    	   successors = mapTable.get(prefix);
		       }
		       else
		       {
		    	   successors = new ArrayList<String>();
		       }
		       successors.add(successor);
		       mapTable.put(prefix, successors);
		   }
		   // generate random text, put it in outArrText
		   
		    RandomTextGenerator genText = new RandomTextGenerator(mapTable, debug,random);
		    ArrayList<String> outArrText = genText.textGenerate(numwords);
			  for(int b=0; b< outArrText.size();b++){
				  System.out.print(outArrText.get(b));
			  }
		 // write outArrText to outputfile
			try {
				PrintWriter writefile = new PrintWriter(outFile);
			
		       int linechars = 0;
		       for (int i=0; i< outArrText.size()-1; i++)
		       {
		           if(linechars < 80 && (linechars + outArrText.get(i).length())>80) 
		           {
		        	    //writefile.write("\n");
		        	   writefile.println("");
				        linechars = 0;
			       }
		            writefile.print(outArrText.get(i)+" ");
		            linechars += outArrText.get(i).length()+1;     
		      }
		       writefile.print(outArrText.get(outArrText.size()-1));
		       writefile.close();
	         }
		       catch (FileNotFoundException e) {
					System.out.println("ERROR: can't write to output file" + outFile + "!" );
				}
			   catch (SecurityException e){
		       System.out.println("ERROR: can't write to output file" + outFile + "!" );
		      }
		   
	   } // this } is for big else 
	   }
		 catch (BadDataException exception)
		 {
		    System.out.println(exception.getMessage());
		 }
}//this { is for main


// **************************************************************
   //  some fuctions

}//this { is for class
// **************************************************************
   //  PRIVATE INSTANCE VARIABLE(S)

