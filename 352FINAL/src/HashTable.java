import java.math.BigInteger;

public class HashTable implements DataStructure {
	 
	private static int size;
	public HashEntry[] table;
	
	
	public HashTable(){
		table = new HashEntry[size];
		for(int i = 0; i < size; i++){
			table[i] = null;
		}
	}
	public HashTable(int tableSize){
		if(!checkPrime(tableSize)){
			size = nextPrime(tableSize);
		}
		table = new HashEntry[size];
		for(int i = 0; i<size; i++){
			table[i] = new HashEntry();

		}
	}
	
	
	public boolean checkPrime(int n){
		BigInteger b = new BigInteger(String.valueOf(n));
		
		return b.isProbablePrime(1);
	}
	
	public int nextPrime(int n){
		BigInteger b = new BigInteger(String.valueOf(n));
		return Integer.parseInt(b.nextProbablePrime().toString());
	}

	@Override
	public void put(int key, int value) {
		size++;
		int hash = hashFunction(key);
		
		HashEntry entry = new HashEntry(key, value);
		
		while(table[hash].key != null && table[hash].getKey() != key){
			hash = (hash + 1) % size;
		}
		table[hash] = entry;
		if(hash == (size - 1)){
			entry.next = null;
			entry.prev = table[hash - 1];
		}
		else if(hash == 0){
			entry.next = table[hash + 1];
			entry.prev = null;
		}
		else{
			entry.next = table[hash + 1];
			entry.prev = table[hash - 1];
		}
	}

	@Override
	public void remove(int key) {
		int hash = (key % size);
		
		while(table[hash].key != null && table[hash].getKey() != key){
			hash = (hash - 1) % size;
		}
		table[hash] = null;
		
	}
		

	@Override
	public int get(int key) {
		int hash = (key%size);
		
		while(table[hash].key != null && table[hash].getKey() != key){
			hash = (hash + 1) % size;
		}
		if(table[hash] == null){
			return -1;
		}
		else{
			return table[hash].getValue();
		}
		
	}
	
	private int hashFunction(Integer i){
		int hash = i.hashCode();
		hash %= table.length;
		if(hash < 0){
			hash += table.length;
		}
		return hash;
	}
	
	@Override
	public int nextKey(int key){
		int hash = (key%size);
		HashEntry temp;
		if(table[hash].getNext() != null){
			temp = table[hash].getNext();
			return temp.key;
		}
		return -1;
	}
	@Override
	public int prevKey(int key){
		int hash = (key%size);
		HashEntry temp;
		if(table[hash].getPrev() != null){
			temp = table[hash].getPrev();
			return temp.key;
		}
		return -1;
	}
}

class HashEntry {

	protected Integer key;
	protected Integer value; 
	protected HashEntry next;
	protected HashEntry prev;
	
	
	HashEntry(){
		this.key = null;
		this.value = null;
	}
	HashEntry(int key, int value){
		this.key = key;
		this.value = value; 
		this.next = null;
		this.prev = null; 
	}
	
	public Integer getKey(){
		return key;
	}
	
	public Integer getValue(){
		return value;
	}
	
	public HashEntry getNext(){
		return next;
	}
	
	public HashEntry getPrev(){
		return prev; 
	}
}