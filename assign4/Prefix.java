/**
Name: Lu Li
login ID: lli619
*/
import java.util.ArrayList;


public class Prefix 
{
 
   public Prefix()
   {
      preArray = new ArrayList<String>();
   }

   public Prefix(ArrayList<String> list)
   {		
      preArray = list;
   }
   
   public void getPrefix(ArrayList<String> text, int firstWordIndex, int preLength)
   {
      for(int i=firstWordIndex; i<firstWordIndex+preLength;i++)
      {
	     preArray.add(text.get(i));
      }
      
   }
   
   public void shiftOut()
   {
	   preArray.remove(0);
   }
   
   public void shiftIn(String word)
   {
	   preArray.add(word);
   }
   public String get(int i)
   {
	   return preArray.get(i);
   }
   public int size()
   {
	   return preArray.size();
   }
   
   public void prePrint()
   {
	   for(int i=0; i<preArray.size(); i++)
	   {
		   System.out.print(" " + preArray.get(i));
	   }
   }
   
   
   public boolean equals(Object otherObject)
   {
	   if (otherObject == null) return false;
	   if (getClass() != otherObject.getClass()) return false;
       Prefix preobj = (Prefix) otherObject;
       
       return preArray.equals(preobj.preArray);
   }
   
   public int hashCode()
   {
      final int HASH_MULTIPLIER = 29;
      int h = 0;
      int i=0;
      while (i<preArray.size())
      {
	   h = h*HASH_MULTIPLIER + preArray.get(i).hashCode();
	   i++;
      }
      return h;
   }
   
// **************************************************************
   //  PRIVATE INSTANCE VARIABLE(S)
   private ArrayList<String> preArray;
}

