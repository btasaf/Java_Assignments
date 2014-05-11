import java.util.Iterator;




public class Ex4_A { 
 public static void checkList(){ 
 System.out.println("******* Check Linked List **********"); 
 GDLinkedList<Integer> list = new GDLinkedList<Integer>(); 
 System.out.println(list); 
 for (int i=1; i<=5; i++){ 
 list.add(i); 
 System.out.println(list); 
 } 
 list.remove(list.size()); 
 System.out.println(list); 
 list.remove(1); 
 System.out.println(list); 
 list.remove(3); 
 System.out.println(list); 
 list.remove(2); 
 System.out.println(list); 
 list.remove(4); 
 System.out.println(list); 
 } 
 public static void checkIterator(){ 
 System.out.println("******* Check Linked List Iterator **********"); 
 GDLinkedList<Integer> list = new GDLinkedList<Integer>(); 
 for (int i=1; i<=5; i++){ 
 list.add(i); 
 } 
 Iterator<Integer> iter = list.getIterator(); 
 while(iter.hasNext()){ 
 System.out.print(iter.next()+" "); 
 } 
 System.out.println(); 
 } 
 public static void checkReverseIterator(){ 
 System.out.println("*******Check Linked List Reverse Iterator**********"); 
 GDLinkedList<Integer> list = new GDLinkedList<Integer>(); 
 for (int i=1; i<=5; i++){ 
 list.add(i); 
 } 
 Iterator<Integer> iter = list.getreIterator(); 
 while(iter.hasNext()){ 
 System.out.print(iter.next()+" "); 
 } 
 System.out.println(); 
 } 
 public static void main(String[] args) { 
 checkList(); 
 checkIterator(); 
 checkReverseIterator(); 
 } 
}