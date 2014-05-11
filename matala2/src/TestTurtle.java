import java.util.Scanner;

import Turtle.*;
class TestTurtle{

	public static void main (String [] args){
			SimpleTurtle bob = new SimpleTurtle();

			bob.tailDown();
			bob.moveForward(100);
			bob.turnRight(60);
			bob.moveForward(40);
		Army();
	}

	public static void	Army(){
		Scanner s=new Scanner(System.in);
		int ch;
		SimpleTurtle tarmy[]=new SimpleTurtle[5];
		System.out.println("choose your turtles:");
		System.out.println(" 1.simple \n 2.smart \n 3.drunk \n 4.jumpy");
		for (int i = 0; i < 5; i++) {
			System.out.println("turtle number #"+(i+1)+": ");
			ch=s.nextInt();
			if(ch==1)
				tarmy[i]=new SimpleTurtle();
			if(ch==2)
				tarmy[i]=new SmartTurtle();
			if(ch==3)
				tarmy[i]=new DrunkTurtle();
			if(ch==4)
				tarmy[i]=new JumpyTurtle();
		}
		s.close();
		for (int i = 0; i < tarmy.length; i++) {
			tarmy[i].tailDown();
		}
		for (int i = 0; i < tarmy.length; i++) {
			tarmy[i].moveForward(100);
		}
		for (int i = 0; i < tarmy.length; i++) {
			tarmy[i].turnRight(90);
		}
		for (int i = 0; i < tarmy.length; i++) {
			tarmy[i].moveForward(60);
		}
		for (int i = 0; i < tarmy.length; i++) {
			if( tarmy[i] instanceof JumpyTurtle)
				((JumpyTurtle) tarmy[i]).drawPolygon(6,70);
			else if(tarmy[i] instanceof SmartTurtle)
				((SmartTurtle) tarmy[i]).drawPolygon(6,70);
		}

		for (int i = 0; i < tarmy.length; i++) {
			tarmy[i].hide();
		}
	}

}