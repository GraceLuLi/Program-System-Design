import java.util.Calendar;

public class LuCalendar {
    public static void main(String[] args) {
   
	Calendar calendar=Calendar.getInstance();	
        calendar.set(1995,1,20);  
        
System.out.println(calendar.get(Calendar.MONTH)+"/"
                   +calendar.get(Calendar.DATE)+"/"
                   +calendar.get(Calendar.YEAR));
	  calendar.set(Calendar.DATE,Calendar.DATE+20);
System.out.println(calendar.get(Calendar.MONTH)+"/"
                   +calendar.get(Calendar.DATE)+"/"
                   +calendar.get(Calendar.YEAR));

    }
}
