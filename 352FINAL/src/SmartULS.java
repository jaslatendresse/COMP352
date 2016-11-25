import java.util.Arrays;
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
		 * 
		 * What is left to do: 
		 * nextKey (BinarySearchTree)
		 * prevKey (BinarySearchTree)
		 * rangeKeys (SmartULS)
		 * Test
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
	
	public void add(String key, int value){
		DS.put(key, value);
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
