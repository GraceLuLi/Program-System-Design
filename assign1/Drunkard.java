// Name:
// USC loginid:
// CS 455 PA1

// Drunkard.java

import java.awt.Point;
import java.util.Random;


/**
   Represents a "drunkard" doing a random walk on a grid.
*/
public class Drunkard {

    /**
       Creates drunkard with given starting location and distance
       it will move in a single step.
       @param startLoc starting location of drunkard
       @param theStepSize size of one step in the random walk
    */
    

    public Drunkard(Point startLoc, int theStepSize) {
    
        location = startLoc;
        StepSize = theStepSize;
        boundary =200/ StepSize;
     }


    /**
       Takes a step of length step-size (see constructor) in one of
       the four compass directions.  Changes the current location of the
       drunkard.
    */
    public void takeStep() {

        rnd=Math.round(Math.random()*4);
        if(rnd==0 && counts[0]<boundary){ 
	     location.translate(StepSize,0);
             counts[0]++; counts[2]--;
             }
	else if(rnd==1 && counts[1]<boundary){ 
	     location.translate(0,StepSize);
             counts[1]++;counts[3]--; 
             }
	else if(rnd==2 && counts[2]<boundary){ 
	     location.translate((0-StepSize),0);
	     counts[2]++;counts[0]--;
             }
	else if(rnd==3 && counts[3]<boundary){ 
	    location.translate(0,(0-StepSize));
	    counts[3]++; counts[1]--;
             }
         
          }


    /**
       gets the current location of the drunkard.
       @return a point object representing drunkard's current location
    */
    public Point getCurrentLoc() {

        Point loca1 = location.getLocation();
        return loca1;  // REMOVE this line -- dummy code to get it to compile
    }

     
    
    private Point location;
    private int StepSize;
    private int boundary;
    private double rnd;
    private int[] counts=new int[4];
}
