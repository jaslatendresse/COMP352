import java.util.*;
import java.io.File;
import java.io.IOException;
public class SmartULS {
	private final static int THRESHOLD = 1000; 
	
	private final static int SIZE1 = 5;
	private final static int SIZE2 = 600;
	private final static int SIZE3 = 820;
	private final static int SIZE4 = 1020;
	private final static int SIZE5 = 2300;
	private final static int [] allSizes = {SIZE1, SIZE2, SIZE3, SIZE4, SIZE5};
	
	boolean isBST = false;
	boolean isSequence = false;
	DataStructure DS;
	
	public static void main(String[] args) throws IOException{
	// Welcome message
		System.out.println("Demo for SmartULS class");
		System.out.println();
		
	// Creating the SmartULS'
		SmartULS uls1 = new SmartULS(SIZE1);
		SmartULS uls2 = new SmartULS(SIZE2);
		SmartULS uls3 = new SmartULS(SIZE3);
		SmartULS uls4 = new SmartULS(SIZE4);
		SmartULS uls5 = new SmartULS(SIZE5);
		SmartULS uls6 = new SmartULS(999);
		SmartULS uls7 = new SmartULS(999);
		SmartULS uls8 = new SmartULS(999);
		
		SmartULS [] allSULS = {uls1, uls2, uls3, uls4, uls5, uls6, uls7, uls8}; 				// to use in the for loops
		String [] allNames = {"uls1", "uls2", "uls3", "uls4", "uls5", "uls6", "uls7", "uls8"};  // to use in the for loops
		
		System.out.println();
		System.out.println();
		
		
	// Filling SmartULS with keys and values
		
		String key; // used to test keys
		int value = 0; // used to test and generate values
		
		for (int i = 0; i < 5 ; i++) { // the last three SmartULS' will get their keys from files
			for(int j = 0; j < allSizes[i] ; j++) {
				allSULS[i].add(SmartULS.generate(), value);
				value++;
			}
			System.out.println("Entries added to SmartULS " + allNames[i] );
		}
		
		
		try{
			Scanner in = new Scanner(new File("src/file1.txt"));			 
			
			while(in.hasNextInt()){
				try{
					key = String.format("%08d", in.nextInt());
					uls6.add(key, value);
					value++;
				}
				catch(InputMismatchException e){
					System.out.println("Key format is wrong");
				}
			}
			
			System.out.println("Entries added to SmartULS uls6");	
			in.close();
		
		}catch(IOException e){
			System.out.println("File not found");
		}
		
		
		try{
			Scanner in = new Scanner(new File("src/file2.txt"));
			
			while(in.hasNextInt()){
				try{
					key = String.format("%08d", in.nextInt());
					uls7.add(key,value);
					value++;
				}
				catch(InputMismatchException e){
					System.out.println("Key format is wrong");
				}
			}
			System.out.println("Entries added to SmartULS uls7");
			in.close();
			
		}catch(IOException e){
			System.out.println("File not found");
		}
		
		
		try{
			Scanner in = new Scanner(new File("src/file3.txt"));
			
			while(in.hasNextInt()){
				try{
					key = String.format("%08d", in.nextInt());
					uls8.add(key, value);
					value++;
				}
				catch(InputMismatchException e){
					System.out.println("Key format is wrong");
				}
			}
			
			System.out.println("Entries added to SmartULS uls8");
			in.close();
			
		}catch(IOException e){
			System.out.println("File not found");
		}
		System.out.println();
		System.out.println();
		
		
	// Obtaining the next and previous keys
		for (int i = 0 ; i < allSULS.length ; i++) {
			System.out.println(allNames[i] + " first entry: ");
				key = allSULS[i].DS.getFirstKey();
				value = allSULS[i].getValues(allSULS[i].DS.getFirstKey());
			System.out.println("   key: " + key + "  value: " + value);
			
			System.out.println(allNames[i] + " next entry: ");
				key =  allSULS[i].nextKey(key);
				value = allSULS[i].getValues(key);
			System.out.println("   key: " + key + "  value: " + value);
			
			System.out.println(allNames[i] + " previous entry: ");
				if (i == 3 || i == 4)
					System.out.println("Entry not available.");
				else {
					key =  allSULS[i].prevKey(key);
					value = allSULS[i].getValues(key);
					System.out.println("   key: " + key + "  value: " + value);
				}
			
			System.out.println();
		}
		System.out.println();
		
		
	// Producing all keys : Infinite loop
	/*
		for (int i = 0 ; i < allSULS.length ; i++) {
			System.out.println("Printing all the keys of " + allNames[i] + " in sorted order: ");
			allSULS[i].allKeys();
			System.out.println();
		}
		System.out.println();
	*/
	System.out.println("allKeys method cannot be tested");	
	
	// Producing a range of keys
	
		for (int i = 0 ; i < allSULS.length ; i++) {
			System.out.println("Printing all the keys of " + allNames[i] + " between 20000000 and 30000000: ");
			if (i > 2) {
				System.out.println("Keys not available.");
				System.out.println();
			}
			else {
				allSULS[i].rangeKey("20000000", "30000000");
				System.out.println();
			}
		}
		System.out.println();
	
		
	// Removing SmartULS entries
		for (int i = 0 ; i < allSULS.length ; i++) {
			System.out.println("The keys of the first three entries of " + allNames[i] + ":");
			if (i == 3 || i == 4) {
				System.out.println("Keys not available.");
				System.out.println();
			}
			else {
					key = allSULS[i].DS.getFirstKey();
				System.out.print("first key: " + key);
					key =  allSULS[i].nextKey(key);
				System.out.print(" second key: " + key);
					key =  allSULS[i].nextKey(key);
				System.out.println(" third key: " + key);
				
				System.out.println("Removing the second entry");
					allSULS[i].remove(allSULS[i].nextKey(allSULS[i].DS.getFirstKey()));
				
				System.out.println("The first key and its following key: ");
					key = allSULS[i].DS.getFirstKey();
				System.out.print("first key: " + key);
					key =  allSULS[i].nextKey(key);
				System.out.println(" following key: " + key);
				
				System.out.println();	
			}
		}
		
	// Conclusion
		System.out.println("End of demo.");
	}
		
	
	
	/**
	 * Verifies if a string contains only numbers.
	 * @param str string to be verified
	 * @return true if all the characters are numbers,
	 * 		   false otherwise
	 */
	public static boolean isNum(String str){
		try{
			int i = Integer.parseInt(str);

		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	/**
	 * Constructor for SmartULS
	 * @param size number of expected entries of the SmartULS
	 */
	public SmartULS(int size){
		setSmartThresholdULS(size);
		if(isBST){
			DS = new BinarySearchTree();
			System.out.println("The data structure used is Binary Search Tree");
		}
		else if(isSequence){
			DS = new Sequence();
			System.out.println("The data structure used is Sequence");
		}
	}	
	
	/**
	 * Sets the type of data structure that will be used by the SmartULS
	 * @param size number of expected entries of the SmartULS
	 */
	public void setSmartThresholdULS(int size){
		if(size >= THRESHOLD){
			isBST = true;
		}
		else{
			isSequence = true; 
		}
	}	
	
	/**
	 * Adds an entry to the SmartULS
	 * @param key Key of the new entry
	 * @param value Value of the new entry
	 */
	public void add(String key, int value){
		DS.put(key, value);
	}
	
	/**
	 * Removes an entry in the SmartULS object.
	 * @param key key of the entry to be removed
	 */
	public void remove(String key){
		DS.remove(key);
	}
	
	/**
	 * Finds the value of a given entry in the SmartULS object.
	 * @param key key of the given entry
	 * @return value of the given entry
	 */
	public int getValues(String key){
		return DS.get(key);
	}
	
	/**
	 * Finds the key succeeding a given entry in the SmartULS object.
	 * @param key key of the given entry
	 * @return key of the entry succeeding the given entry
	 */
	public String nextKey(String key){
		if(isBST){
			DS.sort();
		}
		return DS.nextKey(key);
	}
	
	/**
	 * Finds the key preceding a given entry in the SmartULS object.
	 * @param key  key of the given entry
	 * @return key of the entry preceding the given entry
	 */
	public String prevKey(String key){
		if(isBST){
			DS.sort();
		}
		return DS.prevKey(key);
	}
	
	/**
	 * Generates a random key for a given entry in the SmartULS object.
	 * @return random key
	 */
	public static String generate(){	
		double randomKey;
		int tempKey;
		do {
			randomKey = Math.random() * 100000000;
			tempKey = (int) randomKey;
		} while (tempKey > 99999999 || tempKey < 10000000);
		
			String realKey = Integer.toString(tempKey);
		return realKey;
	}
	
	/**
	 * Prints the sorted keys if the entries in the SmartULS object.
	 */
	public void allKeys(){
		int[] sortedKeys = DS.sort();
		System.out.println(Arrays.toString(sortedKeys));
	}
	
	/**
	 * Finds the number of keys in the SmartULS object that are within a given range.
	 * @param key1 lower bound of the range
	 * @param key2 upper bound of the range
	 * @return number of keys inside the range
	 */
	public int rangeKey(String key1, String key2) {
		int numbOfKeys = 0;
		String key = this.DS.getFirstKey();
		
		while (key != null) {
			if( key.compareTo(key1) > 0 && key.compareTo(key2) < 0)
				numbOfKeys++;
			key = this.DS.nextKey(key);
		}
		
		return numbOfKeys;
	}
	
	
	
}