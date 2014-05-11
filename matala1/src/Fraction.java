
public class Fraction {
	int _n;
	int _d;

	Fraction(){
		_n=0;
		_d=1;
	}
	Fraction(Fraction f){
		_n=f._n;
		_d=f._d;
	}
	Fraction(int n, int d){
		_n=n;
		_d=d;
	}
	void add(Fraction f){
		_n=(_n*f._d)+(f._n*_d);
		_d=_d*f._d;
	}
	void sub (Fraction f){
		_n=(_n*f._d)-(f._n*_d);
		_d=_d*f._d;
	}
	void mul(Fraction f){
		_n=_n*f._n;
		_d=_d*f._d;
	}
	void dev(Fraction f){
		_n=_n*f._d;
		_d=_d*f._n;
	}
	int compare(Fraction f){
		if(this.equals(f))
			return  0;
		Fraction c=this;
		c.mul(f);
		if(c._n>c._d)
			return 1;
		else
			return -1;
	}
	boolean equals(Fraction f){
		if(_n-f._n==0&_d-f._d==0)
			return true;
		return false;
	}
	public String toString(){
		return "("+_n+"/"+_d+")";
	}
}
