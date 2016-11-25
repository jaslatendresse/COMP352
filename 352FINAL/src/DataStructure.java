
public interface DataStructure {
  
	public void put(int key, int value);
	public void remove(int key);
	public int get(int key);
	public int nextKey(int key);
	public int prevKey(int key);
	public int[] sort();

}
 