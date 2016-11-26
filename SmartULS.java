import java.util.Arrays;
import java.util.Random;

public class SmartULS {
	private final static int THRESHOLD = 8; // CHANGE IT BACK TO 1000!!!!!!
	boolean isHashTable = false;
	boolean isSequence = false;
	DataStructure DS;
	
	public static void main(String[] args){
	// TEST: CONSTRUCTORS
		SmartULS small = new SmartULS(5); // should be a sequence
	
	// TEST: SmartULS.add() (sequence)
		SmartULS.add(small, "-43", 45); // adding a negative key
		SmartULS.add(small, "0", 23);   // adding key of 0
		SmartULS.add(small, "2", 21);
	 // SmartULS.add(small, "2", 4);	 // adding same key twice: causes infinite loop when print keys out
		SmartULS.add(small, "3", 7);
		SmartULS.add(small, "4", 46);
		SmartULS.add(small, "5", 423);
		SmartULS.add(small, "6", 3);
		SmartULS.add(small, "7", 54); // adding an extra value
		
	// TEST: SmartULS.nextKey() (sequence)
		System.out.println("TEST: SmartULS.nextKey() (sequence)");
		String smallKey = "-43"; // first key
		do {
			System.out.println("key: "+ smallKey + "  value: " + small.DS.get(smallKey));
			smallKey = small.nextKey(smallKey);
		}
		while(smallKey != null);
		System.out.println();
		
		
	// TEST: SmartULS.prevKey() (sequence)
		System.out.println("TEST: SmartULS.prevKey() (sequence)");
		smallKey = "7"; // last key
		do {
			System.out.println("key: "+ smallKey + "  value: " + small.DS.get(smallKey));
				smallKey = small.prevKey(smallKey);
			}
		while(smallKey != null);
		System.out.println();
		
	
		
		
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
	
	public static void add(SmartULS s, String key, int value){
		s.DS.put(key, value);
	}
	
	public void remove(String key){
		DS.remove(key);
	}
	
	public int getValues(String key){
		return DS.get(key);
	}
	
	public String nextKey(String key){
		return DS.nextKey(key);
	}
	
	public String prevKey(String key){
		
		return DS.prevKey(key);
	}
	
	public int generate(){
		Random r = new Random();
		int randomKey;
		String strVal;
		do{
			randomKey = 1000000 + r.nextInt(90000000);
			strVal = Integer.toString(randomKey);
			
		}while(DS.get(strVal) != -1);
		
		return randomKey;
	}
	
	public void allKeys(){
		int[] sortedKeys = DS.sort();
		System.out.println(Arrays.toString(sortedKeys));
	}
	
}