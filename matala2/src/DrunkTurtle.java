import java.util.Random;

import Turtle.*;
public class DrunkTurtle extends SimpleTurtle {

	public void moveForward (double distance){
		double newdistance=Math.random()*(distance*2);
		super.moveForward(newdistance);
		turnLeft((int) (Math.random()*60-30));
	}
}
