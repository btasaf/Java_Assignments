package testcode;

public class FansSmain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		{
			FirstThread t1 = new FirstThread("FirstThread");
			SecondThread t2 = new SecondThread("SecondThread", t1);
			        t2.start();
			        t1.start();
			while (t1.isAlive()){
			try{
			System.out.println(Thread.currentThread().getName()+" alive");
			Thread.sleep(500);
			            }catch(Throwable ex){}
			        }
			System.out.println(Thread.currentThread().getName()+":"+t2.getName() + " is alive?: "+t2.isAlive());
			    }


	}

}
