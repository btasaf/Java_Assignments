package testcode;

public class FirstThread extends Thread{
	public FirstThread(String name){
		super(name);
	}
	private boolean keepGoing = true;
	public void setKeepGoing(boolean keepGoing){
		this.keepGoing = keepGoing;
	}
	@Override
	public void run(){
		int i=0;
		while (keepGoing){
			try{
				System.out.println(Thread.currentThread().getClass()+" i="+i++);
				Thread.sleep(300);
			}catch(Throwable ex){}
		}

	}
}

