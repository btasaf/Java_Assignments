
public class SortComplex implements  Sortable {
	private Complex[] cArr;
	
	public int compare(Object left, Object right) {
		return ((Complex) left).compare((Complex)right);
	}

	public Object valueAt(int position) {
		return cArr[position];
	}

	public void setValue(Object value, int position) {
		cArr[position]=(Complex) value;
	}

	public int size() {
		return cArr.length;
	}
	
	public SortComplex(Complex[] c){
		cArr=new Complex[c.length];
		for (int i = 0; i < c.length; i++) {
			cArr[i]=c[i];
		}
	}

}
