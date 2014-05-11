
public class FractionSet {
	Fraction[] fs;
	int size;

	FractionSet(){
		fs=new Fraction[10];
		size=0;
	}
	FractionSet(FractionSet other){
		fs=other.fs;
		size=other.size;
	}
	FractionSet(int size){
		fs=new Fraction[size];
		this.size=0;
	}
	void add(Fraction elem){
		if(size==fs.length)
			resize();
		fs[size++]=elem;
	}
	private void resize() {
		Fraction[] temp=new Fraction[fs.length+10];
		for (int i = 0; i < fs.length; i++) {
			temp[i]=fs[i];
		}
		fs=temp;
	}
	boolean containAll(FractionSet other){
		boolean back=true;
		for (int i = 0; i < other.size; i++) {
			if(-1==contains(other.fs[i]))
				back=false;
		}
		return back;
	}
	int	contains(Fraction f){
		for (int i = 0; i < size; i++) {
			if(fs[i].equals(f))
				return 1;
		}
		return -1;
	}
	void difference(FractionSet other){
		int q=0;
		Fraction[] nf=new Fraction[size];
		for (int i = 0; i < size; i++) {
			if(other.contains(this.fs[i])==-1)
			nf[q++]=fs[i];
		}
		fs=nf;
		size=q;
		
	}
	boolean equals(FractionSet other){
		boolean back=true;
		if(this.size!=other.size)back=false;
		
		for (int i = 0; i < this.size; i++) {
			if(!this.fs[i].equals(other.fs[i]))
				back=false;
		}
		return back;
	}
	void intersection(FractionSet other){
		int q=0;
		Fraction[] nf=new Fraction[size];
		for (int i = 0; i < size; i++) {
			if(other.contains(this.fs[i])==1)
			nf[q++]=fs[i];
		}
		fs=nf;
		size=q;
	}
	void remove(Fraction elem){
		Fraction[] back=new Fraction[fs.length];
		int q=0;
		for (int i = 0; i < fs.length; i++) {
			if(!fs[i].equals(elem))
				back[q++]=fs[i];
		}
		size--;
	}
	int size(){
		return size;
	}
	public java.lang.String toString(){
		String back="[ ";
		for (int i = 0; i < size; i++) {
			back=back+", "+fs[i].toString();
		}
		back=back+" ]";
		return back;
	}
	void union(FractionSet other){
		int q=0;
		Fraction[] nf=new Fraction[size+other.size];
		for (int i = 0; i < this.size; i++) {
			nf[q++]=this.fs[i];
		}
		for (int i = 0; i < other.size; i++) {
			if(this.contains(other.fs[i])==-1)
			nf[q++]=other.fs[i];
		}
		this.fs=nf;
		size=q;
	}
	void xor(FractionSet other){
		FractionSet t1=new FractionSet(this);
		FractionSet t2=new FractionSet(this);
		FractionSet o1=new FractionSet(other);
		FractionSet o2=new FractionSet(other);
		o1.difference(t1);
		t2.difference(o2);
		t2.union(o1);
		this.fs=t2.fs;
		this.size=t2.size;
	}
}
