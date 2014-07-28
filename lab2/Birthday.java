import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class Birthday {
    public static void main(String[] args) {
         
         Scanner in = new Scanner(System.in);
         Calendar cal=Calendar.getInstance();
         int  todaydate=cal.getTime();

    	 System.out.print("Enter your birth month: ");
	 String birthmonth = in.nextInt();

	 System.out.print("Enter your birth day of month: ");
	 int birthday = in.nextInt();

         int year=cal.get(Calendar.YEAR);
	     cal.set(year,birthmonth,birthday);
	   int  birthdate=cal.getTime();
	   int  k=birthdate-todaydate;

 	 System.out.println("Your birthday is only" + k + "days away!");
	 
    }
}
