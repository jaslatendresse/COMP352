
public interface DataStructure {
  
	/**
	 * Places an entry inside the data structure.
	 * @param key Key of the new entry
	 * @param value value of the new entry
	 */
	public void put(String key, int value);
	
	/**
	 * Removes an entry inside the data structure.
	 * @param key key of the entry to be removed
	 */
	public void remove(String key);
	
	/**
	 * Finds the value of the entry with a specific key.
	 * @param key key of the entry whose value is desired
	 * @return value of the entry
	 */
	public int get(String key);
	
	/**
	 * Finds the key of the first entry stored in the data structure.
	 * @return key of the first entry
	 */
	public String getFirstKey();
	
	/**
	 * Finds the key of the element succeeding a given element in the data structure.
	 * @param key Key of the given element
	 * @return key of the succeeding element
	 */
	public String nextKey(String key);
	
	/**
	 * Finds the key of the element preceding a given element in the data structure.
	 * @param key Key of the given element
	 * @return key of the preceding element
	 */
	public String prevKey(String key);
	
	/**
	 * Sorts the keys of the elements in the data structure.
	 * @return Array with the sorted key
	 */
	public int[] sort();

}