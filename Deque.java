import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	class Node{
		Item val;
		Node next;
		Node pre;
		public Node(){
			val = null;
		}
		public Node(Item item){
			val = item;
		}
	}
	
	private Node first;
	private Node last;
	private int size;
	public Deque() {
		// construct an empty deque
		first = new Node();
		last = new Node();
		size = 0;
	}
	public boolean isEmpty() {
		// is the deque empty?
		return size == 0;
	}
	public int size() {
		// return the number of items on the deque
		return size;
		
	}
	public void addFirst(Item item) {
	   	// add the item to the front
		if(item == null) throw new java.lang.NullPointerException("item is null");
	   	Node tmp = first;
	   	Node newNode = new Node(item);
	   	first = newNode;
	   	first.next = tmp;
	   	tmp.pre = first;
	   	size++;
   	}
   	public void addLast(Item item) {
	   	// add the item to the end
   		if(item == null) throw new java.lang.NullPointerException("item is null");
	   	Node tmp = last;
	   	Node newNode = new Node(item);
	   	last = newNode;
	   	last.pre = tmp;
	   	tmp.next = last;
	   	size++;
   	}
   	public Item removeFirst() {
	   	// remove and return the item from the front
   		if (size <= 0) 
   			throw new java.util.NoSuchElementException("can not remove from empty queue");
   		size--;
	   	Item item = first.val;
	   	first = first.next;
	   	first.pre =null;
	    return item;
	    
   }
   public Item removeLast() {
	   // remove and return the item from the end
	   if (size <= 0) 
		   throw new java.util.NoSuchElementException("can not remove from empty queue");
	   size--;
	   Item item = last.val;
	   last = last.pre;
	   last.next = null;
	   return item;
   }
   public Iterator<Item> iterator() {
	   // return an iterator over items in order from front to end
	   return new DqIterator();
   }
   private class DqIterator implements Iterator<Item>{
	   private Node curr = first;
	   
	   public boolean hasNext(){
		   if (curr.val == null) return false;
		   return curr.next != null;
	   }
	   public Item next() {
		   if (hasNext() == false)
			   throw new java.util.NoSuchElementException("no more item in queue");
		   curr = curr.next;
		   return curr.val;
	   }
	   public void remove(){
		   throw new java.lang.UnsupportedOperationException("remove operation is not supported");
		   
	   }
   	}
   	public static void main(String[] args) {
   		// unit testing
   	}
}