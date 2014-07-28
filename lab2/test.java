import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;


public class test {
    public static void main(String[] args) {
	Calendar today=Calendar.getInstance();

     Scanner in = new Scanner(System.in);
     int  year = today.get(Calendar.YEAR);
     

     	System.out.print("Please enter your birthmonth: ");
	int  birmonth = in.nextInt();
        birmonth=birmonth-1;

	System.out.print("Please enter your birthday: ");
	int  birday = in.nextInt();
	Calendar birthday = new GregorianCalendar();
   
        birthday.set(Calendar.YEAR,year);
        birthday.set(Calendar.MONTH,birmonth);
        birthday.set(Calendar.DATE,birday);


        long  t=today.getTimeInMillis();
        long  b=birthday.getTimeInMillis();
	if(b<t){
              birthday.set(Calendar.YEAR,year+1);
              b=birthday.getTimeInMillis();}
        
   
        long  k1=b-t;
        long  k2=k1/(1000*60*60*24);
        if(k2==0){
	    System.out.println("Happy Birthday!");}
        else {        
        
	System.out.println("Your birthday is only " + k2 + " days away!");}

 
    }
}
