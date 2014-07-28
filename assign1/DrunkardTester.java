import java.util.Scanner;
import java.awt.Point;


public class DrunkardTester {
    public static void main(String[] args){

    System.out.println("Please type in step size:");
    Scanner in = new Scanner(System.in);
    int k= in.nextInt();

    System.out.println("How many steps do you want to take?");
    
    int steps= in.nextInt();

    Point initial=new Point(200,200);
    Drunkard person1=new Drunkard(initial,k);
         Point P1 = new Point(0,0);
         Point P2 = new Point(0,0);
         
         for (int i=0;i<steps;i++){
         P1 = person1.getCurrentLoc();
	 person1.takeStep();
         P2 = person1.getCurrentLoc();
         System.out.println("The step size between "+P1+" and "+P2+" is "+k);
       }
 }
}
