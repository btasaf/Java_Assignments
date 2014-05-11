package testcode;

public class SecondThread extends Thread{
	FirstThread t;
	public SecondThread(String name, FirstThread t){
		super(name);
		this.t = t;
	}
public void run(){
try{
Thread.sleep(3000);
System.out.println(Thread.currentThread().getClass()+" stop");
        }catch(Throwable ex){}
t.setKeepGoing(false);
    }
}
