import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class test1 {
    public static void main(String[] args){
	Calendar calendar=Calendar.getInstance();
        calendar.set(1995,0,20);
	int month= 1+ calendar.get(Calendar.MONTH);
System.out.println(month+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR));
 
       calendar.add(Calendar.DATE,20);
       int month2= 1+ calendar.get(Calendar.MONTH);
 
	System.out.println(month2+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR));
	Calendar cal= new Calendar(2000,2,2);
 
    }
}
