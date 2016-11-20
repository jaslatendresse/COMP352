/*
 * Authors : Jasmine Latendresse ID 40011419
 * 			 Fabian Vergara 40006707
 * 			 Elise Comeau ID 27038054
 * Date    : Wednesday, October 19, 2016
 *     
 */
public class DoublyLinkedList<T>{
	
	public Node<T> first;
	public Node<T> last;
	public int size; 

	public DoublyLinkedList(){
		this.first = null;
		this.last = null;
		this.size = 0; 
	}
	
	public void add(T data){
		Node<T> n = new Node<T>(); 
		
		if(isEmpty()){
			first = n;
			last = n; 
		}
		else{
			n.next = null;
			n.prev = last;
			last.next = n; 
			last = n; 
		}
		
		n.data = data;
		n.index = size; 
		size++;
	}
	
	public Node<T> moveForward(Node<T> n, int index){
		Node<T> curr = first;
		while(curr.index != index){
			curr = curr.next;
		}
		return curr;
	}
	
	public Node<T> moveBackward(Node<T> n, int index){
		Node<T> curr = last; 
		while(curr.index != index){
			curr = curr.prev;
		}
		return curr;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public String toString(){
		if (isEmpty()){
			return "It is empty";
		}
		Node<T> current = first;
		String toReturn = "";
		while (current != null){
			toReturn += current.data + ", ";
			current = current.next;
		}
		return toReturn;
	}
}

class Node<T>{
	protected T    data;
	protected Node<T> next;
	protected Node<T> prev;
	protected boolean isVisited;
	protected int index;
	
	public Node(){
		this.data = null;
		this.next = null;
		this.prev = null;
		this.isVisited = false;
		this.index = 0; 
	}
	
	public String toString(){
		return "Number : " + this.data;
	}
}