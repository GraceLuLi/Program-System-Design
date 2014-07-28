import java.lang.String;

public class CommandLine{

    public static void main(String[] args)
  {
      if(args.length>=1)
	  {
       String command = args[0];
       System.out.println(command);
	  }
      else{
          System.out.println("ERROR:user did not supply command-line argument");
      }   
  }


}
