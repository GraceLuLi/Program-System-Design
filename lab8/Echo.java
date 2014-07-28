import java.lang.String;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Echo{

    public static void main(String[] args)                                        {
       
      if(args.length>=1)
	  {
String filename = args[0];
       File inFile = new File(filename);
    try{
       
       Scanner in = new Scanner(inFile);
       while(in.hasNextLine())
	   {
	       System.out.println(in.nextLine());
	   }
       }
    catch (FileNotFoundException exception){
	System.out.println("The file: " + filename + " not found!");
    }
	  }
      else if(args.length==0){
          System.out.println("ERROR:Expected a file name on the java command line");
      }
    
  }


}
