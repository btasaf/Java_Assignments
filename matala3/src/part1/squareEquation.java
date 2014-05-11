package part1;

public class squareEquation {
	public static void main(String[] args) {
		int y=1;
		for (int x=0;x<y;x++){
			y++;

			System.out.println("כדי לצאת נא להכניס 0");
			System.out.println("1 כדי לפטור משוואה נא להכניס" );
			System.out.println("נא להכניס פקודה");
			int f=MyConsole.readInt("");
			switch (f){

			case 1:
				double a=MyConsole.readDouble("enter num a");
				double b=MyConsole.readDouble("enter num b");
				double c=MyConsole.readDouble("enter num c");
				System.out.println(a+"x^2+"+b+"x+"+c+"=0");
				try{
					squareEquationfun(a,b,c);
				}
				catch(Exception ex){
					System.out.println(ex);
				}
				break ;
			default :
				y--;
			}
		}
	}
	public static  void squareEquationfun(double a, double b, double c) throws Exception{
		double d=Math.sqrt(Math.pow(b, 2) - 4*a*c);
		if (d==0){
			System.out.print("x1=x2= ");
			System.out.println(-b/(2*a));
		}
		else if(d>0){
			double root1;
			double root2;
			root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
			root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
			System.out.print("x1= ");
			System.out.println(root1);
			System.out.print("x2= ");
			System.out.println(root2);
		}
		else{
			throw new Exception("no real root");
		}
	}

}