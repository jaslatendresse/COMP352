
public class SmartULS {
	private final static int THRESHOLD = 1000;
	boolean isHashTable = false;
	boolean isSequence = false;
	HashTable HT;
	Sequence SQ;
	
	public SmartULS(int smartSize){
		if(isHashTable){
			HT = new HashTable();
			SQ = null;
		}
		else if(isSequence){
			SQ = new Sequence();
			HT = null;
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
		if(isHashTable){
			s.HT.put(key,value);
		}
		if(isSequence){
			s.SQ.put(key, value);
		}
	}
	
	public void remove(SmartULS s, int key){
		if(isHashTable){
			s.HT.remove(key);
		}
		if(isSequence){
			s.SQ.remove(key);
		}
	}
	
	public int getValues(SmartULS s, int key){
		if(isHashTable){
			return s.HT.get(key);
		}
		if(isSequence){
			return s.SQ.get(key);
		}
		return -1;
	}
	
	public int nextKey(SmartULS s, int key){
		int theNextKey = -1;
		if(isHashTable){
			theNextKey = s.HT.nextKey(key);
			if(theNextKey < 0){
			}
		}
		if(isSequence){
			theNextKey = s.SQ.nextKey(key);
		}
		if(theNextKey < 0){
			System.out.println("The next key could not be found");
		}
		return theNextKey;
	}
	
	public int prevKey(SmartULS s, int key){
		int thePrevKey = -1;
		if(isHashTable){
			thePrevKey = s.HT.prevKey(key);
		}
		if(isSequence){
			thePrevKey = s.SQ.prevKey(key);
		}
		if(thePrevKey<0){
			System.out.println("The previous key could not be found.");
		}
		return thePrevKey;
	}
}
