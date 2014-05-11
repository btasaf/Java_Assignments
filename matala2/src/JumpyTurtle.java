import Turtle.*;
public class JumpyTurtle extends SmartTurtle {
	
	public void moveForward (double distance){
		double d=distance;
		while(d>0){
			tailDown();
			super.moveForward(5);
			tailUp();
			super.moveForward(5);
			d=d-10;
		}
	}
}
