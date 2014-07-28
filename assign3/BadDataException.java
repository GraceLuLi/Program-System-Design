/** 
 Name: Lu Li
 login ID: lli619
 */

import java.io.IOException;

public class BadDataException extends IOException
{
   public BadDataException() {}
   public BadDataException(String message)
   {
	   super(message);
   }
}
