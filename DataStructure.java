public interface DataStructure {
  
	public void put(String key, int value);
	public void remove(String key);
	public int get(String key);
	public String nextKey(String key);
	public String prevKey(String key);
	public int[] sort();

}
