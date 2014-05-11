import java.util.Iterator;



public class GDLinkedList<T> {
	NodeGener<T> head;
	NodeGener<T> tail;

	public GDLinkedList(){
		head=tail=null;
	}
	public void add(T data){
		NodeGener<T> n=new NodeGener<T>(data);
		if(head==null){
			head=tail=n;
			return;
		}
		tail.next=n;
		n.pri=tail;
		tail=n;
	}
	public T remove(T data){
		NodeGener<T> i;
		if(head.data==data){
			i=head;
			head=head.next;
			i=null;
			return data;
		}
		if(tail.data==data){
			tail=tail.pri;
			tail.next=null;
			return data;
		}
		for(i=head.next;i!=null;i=i.next){//!!!!!
			if(i.data==data){
				i.pri.next=i.next;
				i.next.pri=i.pri;
			}
		}
		return data;
	}
	public boolean contains(T data){
		boolean back=false;
		NodeGener<T> i;
		for(i=head;i!=null;i=i.next){
			if(i.data==data)back=true;
		}
		return back;
	}
	public int size(){
		int back=0;
		NodeGener<T> i;
		for(i=head;i!=null;i=i.next){
			back++;
		}
		return back;
	}
	
	public String toString(){
		String back="";
		NodeGener<T> i;
		for(i=head;i!=null;i=i.next){
			back=back+i.toString();
			back=back+", ";
		}
		return back;
	}
	public Iterator<T> getreIterator(){
		return 	new Iterator<T>(){
			int count=size();
			NodeGener<T> i=tail;
			@Override
			public boolean hasNext() {
				if(count>0)
					return true;
				else
					return false;
			}

			@Override
			public T next() {

				if(hasNext()){
					count--;
					NodeGener<T> temp=i;
					i=i.pri;
					return temp.data;
				}
				else{
					return null;
				}
			}

			@Override
			public void remove() {
				System.out.println("ther is no \"remove()\" ");

			}

		};
	}
	public Iterator<T> getIterator(){
		return 	new Iterator<T>(){
			int count=0;
			NodeGener<T> i=head;
			@Override
			public boolean hasNext() {
				if(count<size())
					return true;
				else
					return false;
			}

			@Override
			public T next() {

				if(hasNext()){
					count++;
					NodeGener<T> temp=i;
					i=i.next;
					return temp.data;
				}
				else{
					return null;
				}
			}

			@Override
			public void remove() {
				System.out.println("ther is no \"remove()\" ");

			}

		};
	}
	private class NodeGener<T> {
		NodeGener<T> next,pri;
		T data;
		public NodeGener(T item){
			next=null;
			data=item;
		}
		public String toString(){
			return ""+data;

		}
	}

}
