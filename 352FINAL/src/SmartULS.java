
public class SmartULS {
	private final static int THRESHOLD = 1000;
	boolean isHashTable = false;
	boolean isSequence = false;
	DataStructure DS;
	
	public SmartULS(int size){
		if(isHashTable){
			DS = new HashTable();
		}
		else if(isSequence){
			DS = new Sequence();
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
	
	public void add(SmartULS s, int key, int value){
		DS.put(key, value);
	}
	
	public void remove(SmartULS s, int key){
		DS.remove(key);
	}
	
	public int getValues(SmartULS s, int key){
		return DS.get(key);
	}
	
	public int nextKey(SmartULS s, int key){
		if(DS.nextKey(key) < 1){
			System.out.println("Next key could not be found");
		}
		return DS.nextKey(key);
	}
	
	public int prevKey(SmartULS s, int key){
		if(DS.prevKey(key) < 1){
			System.out.println("Previous key could not be found");
		}
		return DS.prevKey(key);
	}
}
