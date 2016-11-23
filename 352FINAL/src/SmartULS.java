
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
		if(isHashTable){
			s.HT.nextKey(key);
		}
		if(isSequence){
			s.SQ.nextKey(key);
		}
		return -1;
	}
	
	public int prevKey(SmartULS s, int key){
		if(isHashTable){
			s.HT.prevKey(key);
		}
		if(isSequence){
			s.SQ.prevKey(key);
		}
		return -1;
	}
}
