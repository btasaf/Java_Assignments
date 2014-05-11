

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
 * מקורות לחיפוש הפיתרון:
 * java stop function after time
 * java Stop thread after time
 * דרך פיתרון:
 * יצירת תהליך שכל מה שהיא עושה זה לקרוא לפונקציה שבודקת אם מספר הוא ראשוני
 * ובנוסף היא רושמת אם היא הפונקציה סיימה את הפעולה
 * בראשי אני משתמש בפונקציה JOIN 
 * כשאני מוסיף תנאי זמן שקיבלתי מהמשתמש
 * ובסוף בודק דרך התהליך אם היא סיימה או לא
 */
