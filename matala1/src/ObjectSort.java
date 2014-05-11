
public class ObjectSort {

	public static void sort(Sortable item){
		boolean flag = true;
		for (int i=0; flag && i <item.size(); i++){
			flag = false;
			for (int j=0; j < item.size()-1-i; j++){
				if(item.compare(item.valueAt(j) ,item.valueAt(j+1))>0){
					flag = true;
					Object temp = item.valueAt(j);
					item.setValue(item.valueAt(j+1),j);
					item.setValue(temp,j+1);
				}
			}
		}
	}
	public static boolean checkSort(Sortable item){
		boolean ans = true;
		for (int i=0; ans&&i< item.size()-1; i++){
			if(item.compare(item.valueAt(i) ,item.valueAt(i+1))>0){
				ans = false;
			}
		}
		return ans;

	}
}
