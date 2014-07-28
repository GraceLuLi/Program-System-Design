/**
  Name: Lu Li
  login ID: lli619
*/
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;


public class RandomTextGenerator 
{
   public RandomTextGenerator(Map<Prefix, ArrayList<String>> mapTable, boolean debug, Random random)
   {  
     this.mapTable = mapTable;
     this.debug = debug;
     this.random = random;
     outTextArr = new ArrayList<String>();
   }
      
   public Prefix prefixGenerate()
   {
	   
	   Set<Prefix> prefixSet = mapTable.keySet();
	   Iterator<Prefix> iter = prefixSet.iterator();
	   int firstPrefixIndex = random.nextInt(prefixSet.size());
	   // get first prefix
	   Prefix firstPrefix = new Prefix(); 
	   int i = 0;
	   while (iter.hasNext() & i<=firstPrefixIndex)
	      {
		    firstPrefix = iter.next();
		    i++;
	      } 
	   return firstPrefix;
   }
   
   
   public ArrayList<String> textGenerate(int numWords)
   {
	   
	  Prefix firstPrefix = this.prefixGenerate();

	  if(numWords != 0)
	  { 

	  ArrayList<String> successors = mapTable.get(firstPrefix);
	  int successorIndex = random.nextInt(successors.size());
	  String successor = successors.get(successorIndex);
	  for(int h=0; h<firstPrefix.size(); h++)
	  {
		  outTextArr.add(firstPrefix.get(h));
	  }
	  outTextArr.add(successor);
	  
	  if(debug == true)
	  {
		  System.out.print("DEBUG: chose a new initial prefix:");
		  firstPrefix.prePrint();
		  System.out.println("");
		  System.out.print("DEBUG: successors: ");
		  for(int k=0; k<successors.size(); k++)
		  {
			  System.out.print(successors.get(k) + " ");
		  }
		  System.out.println("");
		  System.out.print("DEBUG: word generated: ");
		  System.out.print(successor);
		  System.out.println("");
	  }
	  

		   Prefix prefix = firstPrefix;
		   
		  for(int j=0; j<numWords-1;j++)
		  {
			  prefix.shiftOut();
			  prefix.shiftIn(successor);
		      while(!mapTable.containsKey(prefix))
		      {

		    	   prefix = this.prefixGenerate();
		      }
		      
			   if(debug == true )
				  {
					  System.out.println("DEBUG: successors: <END OF FILE>"); 
					  System.out.print("DEBUG: chose a new initial prefix:");
					  prefix.prePrint();
					  System.out.println("");
				  }
		    successors = mapTable.get(prefix);
		    successorIndex = random.nextInt(successors.size());
		    successor = successors.get(successorIndex);
		    outTextArr.add(successor); 

		    
			  if(debug == true )
			  {
				  System.out.print("DEBUG: prefix:");
				  prefix.prePrint();
				  System.out.println("");
				  System.out.print("DEBUG: successors: ");
				  for(int k=0; k<successors.size(); k++)
				  {
					  System.out.print(successors.get(k) + " ");
				  }
				  System.out.println("");
				  System.out.print("DEBUG: word generated: ");
				  System.out.print(successor);
				  System.out.println("");
			  }

		    
		  }
	  
	 
	  }
	  return outTextArr;
     
   }
   
   
   
   
// **************************************************************
    //  PRIVATE INSTANCE VARIABLE(S)
   private Map<Prefix, ArrayList<String>> mapTable;
   private boolean debug; 
   private Random random;
   private ArrayList<String> outTextArr;
 
     
}


