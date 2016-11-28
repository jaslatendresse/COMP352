public class Sequence implements DataStructure {

/* ============================================================ Instance Variables ============================================================ */
	public Entry first; 
	public Entry last;
	public int size;
	public int[] keysToSort; // used for the merge sort
	public int[] temp; // used for the merge sort
	
/* ================================================================== Methods ================================================================= */	
	/**
	 * Verifies if the sequence is empty.
	 * @return true if the sequence contains at least one entry,
	 * 		   false if it contains no entry.
	 */
	public boolean isEmpty(){
		return size == 0; 
	}
	
	/**
	 * Default constructor.
	 */
	public Sequence(){
		this.first = null;
		this.last = null; 
		this.size = 0; 
	}
	
	@Override
	public void put(String key, int value) {
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
		size++;
	}
	

	@Override
	public void remove(String key) {
		Entry entry = first; 
		Entry temp = null; 
		
		for(int i = 0; i < size; i++){ // loops through the sequence 
			if(entry.key.equals(key)){
				temp = entry; 
				entry.prev.next = temp.next;
				entry.next.prev = temp.prev; 		
			}
			else{
				entry = entry.next;
			}
		}
		size--; 
	}

	@Override
	public int get(String key) {
		Entry entry = this.first; 
		for(int i = 0; i < size; i++){
			if(entry.key.equals(key)){
				return entry.value; 
			}
			entry = entry.next;
		}
		System.out.println("Key was not found");
		return -1;
	}
	
	@Override
	public String getFirstKey() {
		if (this.first == null)
			return null;
		else
			return this.first.getKey();
	}
	
	@Override
	public String nextKey(String key){
		Entry entry = this.first;
		
		while(entry.getNext() != null) {		
			if (entry.getKey().equals(key))
				return entry.getNext().getKey();		
			entry = entry.getNext();
		}
		System.out.println("Next key was not found");
		return null;
	}
	
	@Override
	public String prevKey(String key){
		Entry entry = this.last;	
		
		while(entry.getPrev() != null) {		
			if (entry.getKey().equals(key))
				return entry.getPrev().getKey();		
			entry = entry.getPrev();
		}
		return null; 
	}
		
	
	@Override
	public int[] sort(){
		Entry entry = first;
		keysToSort = new int[size];
	
	// filling keysToSort with the unordered keys
		for(int i = 0; i<size; i++){
			if(entry.getKey() != null){
				keysToSort[i] = Integer.parseInt(entry.getKey());
				entry = entry.next;
			}
		}
		this.temp = new int[size];
		
	// ordering the keys
		mergesort(0, size - 1);
		return keysToSort; 
	}

	/**
	 * Merge sorts a sequence according to the keys of its entries.
	 * @param low the lowest key in the range
	 * @param high the highest key in the range
	 */
	private void mergesort(int low, int high){
		if(low < high){
			int mid = low + (high - low)/2; // average of the low and high
			mergesort(low, mid); 			// merge sort the lower-half
			mergesort(mid + 1, high); 		// merge sort the upper-half
			merge(low, mid, high); 			// merge the combined two halves
		}
	}
	
	/**
	 * Merges the merge sorted halves of a sequence
	 * @param low lowest key in the sequence
	 * @param mid mid value key in the sequence
	 * @param high highest key in the sequence
	 */
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
/* ============================================================ Instance Variables ============================================================ */
	protected String key; // used as an identifier
	protected Integer value;
	protected Entry next;
	protected Entry prev;
	
/* ================================================================== Methods ================================================================= */
	/**
	 * Default constructor
	 */
	public Entry(){
		this.key = null;
		this.value = null;
	}
	
	public Entry(String key, int value){
		this.key = key;
		this.value = value; 
	}

	public String getKey(){
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