
public class Complex {
	double a,b;

	public Complex(double a,double b) {
		this.a=a;
		this.b=b;
	}
	
	public double module(){
		return Math.sqrt(a*a+b*b);
	}
	public void add (Complex z){ 
		a=+z.a;
		b=b+z.b;
	}
	public void mul (Complex z){ 
		a=a*z.a-b*z.b;
		b=a*z.b+b*z.a;		
	}
    public int compare(Complex z){ 
    	double z1=module();
    	double z2=z.module();
    	if(z1==z2)
    		return 0;
    	if(z1>z2)
    		return 1;
    	else
    		return-1;
    }
}
