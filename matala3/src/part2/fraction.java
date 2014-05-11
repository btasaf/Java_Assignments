package part2;

import java.rmi.server.Operation;
import java.util.regex.Pattern;

public class fraction {
	int n,d;

	public fraction(){
		n=0;
		d=1;
	}
	public fraction(int nom,int den)throws fractionException{
		if(den==0){
			throw new fractionException("the denominator is 0");
		}
		else{
			n=nom;
			d=den;
			reduc();
		}
	}
	public fraction(String fra) throws fractionException {
		String[] f=fra.split("/");
		if(f.length!=2||!f[0].matches("[0-9]+")||!f[1].matches("[1-9]+")){
			throw new fractionException("this fraction is illegal");
		}
		else{
			n=Integer.parseInt(f[0]);
			d=Integer.parseInt(f[1]);
			
			reduc();
		}
	}
	public  String ToString(){
		return n+" / "+d;
	}
	public fraction plus(fraction a){
		n=n*a.d+a.n*d;
		d=d*a.d;
		reduc();
		return this ;
	}
	public fraction minus(fraction a){
		n=n*a.d-a.n*d;
		d=d*a.d;
		reduc();
		return this ;
	}
	public fraction mul(fraction a){
		n=n*a.n;
		d=d*a.d;
		reduc();
		return this;
	}
	public fraction div(fraction a){
		n=n*a.d;
		d=d*a.n;
		reduc();
		return this;
	}
	private void reduc(){
		int i=2;
		while(i<=n&&i<=d){
			if(n%i==0&&d%i==0){
				n=n/i;
				d=d/i;
				reduc();
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		fraction b=null;
		try{
			b=new fraction("7/6");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println(b.ToString());
	}
}
