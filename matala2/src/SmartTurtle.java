import Turtle.*;

public class SmartTurtle extends SimpleTurtle {

	public void drawSquare (double size){
		this.tailDown();
		for (int i = 0; i < 4; i++) {
		this.turnRight(90);
		this.moveForward(size);
		}
	}
	protected void drawPolygon (int sides, double size){
		int deg=360/sides;
		for (int i = 0; i < sides; i++) {
			this.turnRight(deg);
			this.moveForward(size);
		}
	}
	boolean issmart(){
		return true;
	}
}
