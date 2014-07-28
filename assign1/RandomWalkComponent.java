import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Point;


public class RandomWalkComponent extends JComponent{

    public void paintComponent(Graphics g){
       
        Graphics2D g2= (Graphics2D) g;
        Point initial= new Point(200,200);
    	Drunkard person= new Drunkard(initial,5);
	 for(int i=0;i<1000;i++){
	 Point P1 = new Point(0,0);
         Point P2 = new Point(0,0);
         P1 = person.getCurrentLoc();
	 person.takeStep();
	 P2 = person.getCurrentLoc();
	 //Line2D.Double line=new Line2D.Double(P1.x,P1.y,P2.x,P2.y);
         Line2D.Double line=new Line2D.Double(P1.x,P1.y,P2.x,P2.y);
           g2.draw(line);
	   	}

         
  }
}

        
