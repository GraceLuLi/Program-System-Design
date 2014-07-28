import java.util.Scanner;


public class PolyTester {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);  
    	System.out.println("cmd>");
    	String s = in.next();
    	if(s.compareToIgnoreCase("create")==0){
			System.out.println("Enter a ");
			}
    	else{
    		System.out.println("aa");
    	}
    	
      /* Poly p1 = new Poly();
       Poly p2 = new Poly(new Term(3,3));
       Poly p3 = p2.add(new Poly(new Term(3,7)));
       Poly p4 = new Poly(new Term(3,2)).add(new Poly(new Term(-3,2)));
       Poly p5 = p4.add(new Poly(new Term(-5,6))).add(p2);
  
       System.out.println(p1.toFormattedString());
       System.out.println(p2.toFormattedString());
       System.out.println(p3.toFormattedString());
       System.out.println(p4.toFormattedString());
       System.out.println(p5.toFormattedString());*/

    }
}
