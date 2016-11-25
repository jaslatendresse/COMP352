import java.util.Random;

public class SmartULS {
	private final static int THRESHOLD = 1000;
	boolean isHashTable = false;
	boolean isSequence = false;
	DataStructure DS;
	
	public static void main(String[] args){
	
		/*
		 * If using prevKey or nextKey, we have to make sure to add
		 * if(nextKey < 0) System.out.println("next key could not be found);
		 * 
		 * Generate
		 * allKeys
		 * rangeKeys
		 * 
		 */
	}
	
	public SmartULS(int size){
		setSmartThresholdULS(size);
		if(isHashTable){
			DS = new HashTable();
			System.out.println("The data structure used is Hashtable");
		}
		else if(isSequence){
			DS = new Sequence();
			System.out.println("The data structure used is Sequence");
		}
	}
	
	public void setSmartThresholdULS(int size){
		if(size >= THRESHOLD){
			isHashTable = true;
		}
		else{
			isSequence = true; 
		}
	}
	
	public void add(int key, int value){
		DS.put(key, value);
	}
	
	public void remove(int key){
		DS.remove(key);
	}
	
	public int getValues(int key){
		return DS.get(key);
	}
	
	public int nextKey(int key){
		return DS.nextKey(key);
	}
	
	public int prevKey(int key){
		
		return DS.prevKey(key);
	}
	
	public int generate(){
		Random r = new Random();
		int randomKey;
		do{
			randomKey = 1000000 + r.nextInt(90000000);
		}while(DS.get(randomKey) != -1);
		
		return randomKey;
	}
	
	public void allKeys(){
		int[] sortedKeys = DS.sort();
	}
	
}
