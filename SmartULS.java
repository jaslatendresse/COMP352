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
	
	public static boolean isNum(String str){
		try{
			int i = Integer.parseInt(str);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}
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
	
	public void setSmartThresholdULS(int size){
		if(size >= THRESHOLD){
			isBST = true;
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
		if(isBST){
			DS.sort();
		}
		return DS.nextKey(key);
	}
	
	public String prevKey(String key){
		if(isBST){
			DS.sort();
		}
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