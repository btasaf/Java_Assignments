package testcode;
public class TestThreadCalcPI {
	public static void main(String[] args) {
		ThreadCalcPI mt = new ThreadCalcPI ();
		mt.start ();
		int i = 0;
		while (mt.isAlive ()){
		try{
		Thread.sleep (200); // Sleep for 200 milliseconds
		System.out.println("Thread is alive "+(i++));
		   }
		catch (InterruptedException e){}
		}
		System.out.println ("pi = " + mt.pi);
	
	}
}