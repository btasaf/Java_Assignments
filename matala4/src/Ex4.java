

public class Ex4 {
	
	public boolean isPrime(long n, double maxTime) throws RuntimeException {
		threadisprime tip=new threadisprime("threadisprime", n);
		try{
			tip.start();
			tip.join((long) (1000*(maxTime%1)));	
			if(tip.hasfinish)return tip.isprime;

		}
		catch(Throwable e){System.out.println(e);}
		throw new RuntimeException("time is up!");
	}
	
	
	private class threadisprime extends Thread{
		long num;
		boolean hasfinish=false,isprime;
		public threadisprime(String name,long num){
			super(name);
			this.num=num;
		}
		public void run(){
			isprime=Ex4_tester.isPrime(num);
			hasfinish=true;

		}
	}
}
/**
 * ������ ������ �������:
 * java stop function after time
 * java Stop thread after time
 * ��� ������:
 * ����� ����� ��� �� ���� ���� �� ����� �������� ������ �� ���� ��� ������
 * ������ ��� ����� �� ��� �������� ����� �� ������
 * ����� ��� ����� �������� JOIN 
 * ����� ����� ���� ��� ������� �������
 * ����� ���� ��� ������ �� ��� ����� �� ��
 */
