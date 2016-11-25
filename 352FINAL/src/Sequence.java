
public class Sequence implements DataStructure {

	public Entry first; 
	public Entry last;
	public int size; 
	public int[] keysToSort;
	public int[] temp;
	
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
		Entry entry = new Entry(); 
		Entry temp = null; 
		
		for(int i = 0; i < size; i++){
			if(entry.key == key){
				temp = entry; 
				entry.prev.next = temp.next; 
				entry.next.prev = temp.prev; 
				
				for(int j = entry.index; j < size; j++){
					temp.index--; 
					temp = temp.next;
				}
				size--; 
				return; 
			}
			else{
				entry = entry.next;
			}
		}
		
		System.out.println("Entry with key " + key + " was not found.");
	}

	@Override
	public int get(int key) {
		Entry entry = new Entry(); 
		for(int i = 0; i < size; i++){
			if(entry.key == key){
				return entry.value; 
			}
			entry = entry.next;
		}
		return -1;
	}
	
	@Override
	public int nextKey(int key){
		Entry entry = new Entry();
		for(int i = 0; i < size; i++){
			if(entry.getKey() == key && entry.getNext().getKey() != null){
				return entry.getNext().getKey();
			}
		}
		return -1;
	}
	
	@Override
	public int prevKey(int key){
		Entry entry = new Entry();
		for(int i = 0; i < size; i++){
			if(entry.getKey() == key && entry.getPrev().getKey() != null){
				return entry.getPrev().getKey();
			}
		}
		return -1; 
	}
	
	@Override
	public int[] sort(){
		Entry entry = first;
		keysToSort = new int[size];
		for(int i = 0; i<size; i++){
			if(entry.getKey() != null){
				keysToSort[i] = entry.getKey();
				entry = entry.next;
			}
		}
		this.temp = new int[size];
		mergesort(0, size - 1);
		return keysToSort; 
	}
	
	private void mergesort(int low, int high){
		if(low < high){
			int mid = low + (high - low)/2;
			mergesort(low, mid);
			mergesort(mid + 1, high);
			merge(low, mid, high);
		}
	}
	
	private void merge(int low, int mid, int high){
		for(int i = low; i <=high; i++){
			temp[i] = keysToSort[i];
		}
		int i = low; 
		int j = mid + 1;
		int k = low; 
		
		while(i <= mid && j <= high){
			if(temp[i] <= temp[j]){
				keysToSort[k] = temp[i];
				i++;
			}
			else{
				keysToSort[k] = temp[j];
				j++;
			}
			k++;
		}
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
