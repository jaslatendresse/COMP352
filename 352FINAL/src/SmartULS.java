import java.util.*;
import java.io.File;
import java.io.IOException;
public class SmartULS {
	private final static int THRESHOLD = 1000; 
	boolean isBST = false;
	boolean isSequence = false;
	DataStructure DS;
	
	public static void main(String[] args) throws IOException{
	
		String stringSize;
		Scanner userInput = new Scanner(System.in);
		boolean inputIsInt = false;
		
	// Testing with test files
		try{
			Scanner in = new Scanner(new File("src/file1.txt"));
			SmartULS uls = new SmartULS(999);
			System.out.println("SmartULS created");
			
			int randomVal = 0; 
			
			System.out.println("Inserting entries to the SmartULS");
			String newKey;
			while(in.hasNextInt()){
				try{
					newKey = String.format("%08d", in.nextInt());
					uls.add(newKey, randomVal);
					randomVal++;
				}
				catch(InputMismatchException e){
					System.out.println("Key format is wrong");
				}
			}
			System.out.println("Entries added to SmartULS");
			System.out.println();	
			in.close();
		}catch(IOException e){
			System.out.println("File not found");
		}
		
		try{
			Scanner in = new Scanner(new File("src/file2.txt"));
			SmartULS uls = new SmartULS(999);
			System.out.println("SmartULS created");
			
			int randomVal = 0; 
			
			System.out.println("Inserting entries to the SmartULS");
			String newKey;
			while(in.hasNextInt()){
				try{
					newKey = String.format("%08d", in.nextInt());
					uls.add(newKey, randomVal);
					randomVal++;
				}
				catch(InputMismatchException e){
					System.out.println("Key format is wrong");
				}
			}
			System.out.println("Entries added to SmartULS");
			System.out.println();
			in.close();
		}catch(IOException e){
			System.out.println("File not found");
		}
		
		try{
			Scanner in = new Scanner(new File("src/file3.txt"));
			SmartULS uls = new SmartULS(999);
			System.out.println("SmartULS created");
			
			int randomVal = 0; 
			
			System.out.println("Inserting entries to the SmartULS");
			String newKey;
			while(in.hasNextInt()){
				try{
					newKey = String.format("%08d", in.nextInt());
					uls.add(newKey, randomVal);
					randomVal++;
				}
				catch(InputMismatchException e){
					System.out.println("Key format is wrong");
				}
			}
			System.out.println("Entries added to SmartULS");
			System.out.println();
			in.close();
		}catch(IOException e){
			System.out.println("File not found");
		}
		
	//Testing with user input
		do{
			System.out.println("Enter the deisred size of the SmartULS");
			stringSize = userInput.next();
			if(isNum(stringSize)){
				inputIsInt = true; 
			}
		}while(inputIsInt == false);
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