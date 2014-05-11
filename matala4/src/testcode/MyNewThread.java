package testcode;

public class MyNewThread extends Thread {

	String name;
	MyNewThread(String name){
		super(name);
		this.name = name;
	}
	public void run(){
		for (int i=0; i<10; i++) {
			System.out.println(i+" "+this.getName());
			try{
				sleep((int)(Math.random()*1000));
			}catch(InterruptedException ex){}
		}
		System.out.println(name +"  Done");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyNewThread t1 = new MyNewThread("T1");
		MyNewThread t2 = new MyNewThread("T2");
		
		t2.start();
		try {
			
			
			t2.join();
			t1.start();
		} catch (InterruptedException e) {}
		System.out.println("main exit");
	}

	}


