
public class Sequence implements DataStructure {

	public Entry first; 
	public Entry last;
	public int size; 
	
	public boolean isEmpty(){
		return size == 0; 
	}
	
	public Sequence(){
		this.first = null;
		this.last = null; 
		this.size = 0; 
	}
	
	@Override
	public void put(int key, int value) {
		Entry e = new Entry(); 
		
		if(isEmpty()){
			first = e; 
			last = e;
		}
		else{
			e.next = null; 
			e.prev = last; 
			last.next = e;
			last = e; 
		}
		e.key = key;
		e.value = value; 
		e.index = size; 
		size++;
	}
	

	@Override
	public void remove(int key) {
		
		
	}

	@Override
	public int get(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Entry{
	protected Integer key;
	protected Integer value;
	protected Integer index; 
	protected Entry next;
	protected Entry prev;
	
	public Entry(){
		this.key = null;
		this.value = null;
	}
	
	public Entry(int key, int value){
		this.key = key;
		this.value = value; 
	}
	
	public Integer getKey(){
		return key; 
	}
	
	public Integer getValue(){
		return value; 
	}
	
	public Entry getNext(){
		return next; 
	}
	
	public Entry getPrev(){
		return prev; 
	}
}
