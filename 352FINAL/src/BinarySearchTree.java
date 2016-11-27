public class BinarySearchTree implements DataStructure {
<<<<<<< HEAD
/* ============================================================ Instance Variable ============================================================ */
	private NodeEntry root;
	
/* ================================================================== Methods ================================================================= */
	@Override
	public void put(String key, int value) {
		if(root == null){ // if there's no root
=======

	private NodeEntry root;
	@Override
	public void put(String key, int value) {
		if(root == null){
>>>>>>> master
			root = new NodeEntry(key, value);
		}
		else{
			root.put(key, value);
		}
		
	}

	@Override
	public void remove(String key) {
		NodeEntry removingEntry = getNodeEntry(key);
<<<<<<< HEAD
		remove(key, removingEntry);	
	}
	
	/**
	 * Removes an entry in the binary search tree.
	 * @param key Key of the entry to be removed
	 * @param entry entry to be removed
	 */
=======
		remove(key, removingEntry);
		
	}
	
>>>>>>> master
	private void remove(String key, NodeEntry entry){
		if(entry == null){
			return;
		}
		if(key.compareTo(entry.key) < 0){
<<<<<<< HEAD
			remove(key, entry.left); // left child
		}
		else if(key.compareTo(entry.key)>0){
			remove(key,entry.right); // right child
		}
		else{
			if(entry.left != null && entry.right != null){ // no child
				NodeEntry leftMax = maxElem(entry.left);
				entry.key = leftMax.key;
				remove(leftMax.key, entry.left); // removes the leftmost entry in the tree
			}
			else if(entry.left != null){
				entry = entry.left;
			}
=======
			remove(key, entry.left);
		}
		else if(key.compareTo(entry.key)>0){
			remove(key,entry.right);
		}
		else{
			if(entry.left != null && entry.right != null){
				NodeEntry leftMax = maxElem(entry.left);
				entry.key = leftMax.key;
				remove(leftMax.key, entry.left);
			}
			else if(entry.left != null){
				entry = entry.left;
			}
>>>>>>> master
			else if(entry.right != null){
				entry = entry.right;
			}
			else{
				entry = null;
			}
		}
	}
<<<<<<< HEAD

	/**
	 * Finds the entry that is the most rightward in the tree.
	 * @param entry starting point in the tree
	 * @return rightmost entry
	 */
=======
	
>>>>>>> master
	private NodeEntry maxElem(NodeEntry entry){
		if(entry.right == null){
			return entry;
		}
		else{
			return maxElem(entry.right);
		}
	}
	
<<<<<<< HEAD
	/**
	 * Finds the node entry with a given key
	 * @param key Key of the desired node entry
	 * @return node with given key
	 */
=======
>>>>>>> master
	private NodeEntry getNodeEntry(String key){
		NodeEntry curr = root; 
		Integer id = Integer.parseInt(key);
		
		while(curr != null){
			if(Integer.parseInt(curr.key) == id){
				return curr;
			}
			else if(Integer.parseInt(curr.key) > id){
				curr = curr.left;
			}
			else{
				curr = curr.right;
			}
		}
		return null;
	}

	@Override
	public int get(String key) {
		return root == null ? null : root.get(key);
	}

	@Override
<<<<<<< HEAD
	public String getFirstKey() {
		if (this.root == null)
			return null;
		else
			return root.key;
	}
	
	@Override
=======
>>>>>>> master
	public String nextKey(String key) {
		NodeEntry curr = getNodeEntry(key);
		if(curr != null){
			NodeEntry next = getNext(curr);
			if(next != null){
				return next.key;
			}
			else{
				return "No next key found";
			}
		}
		else{
			return "Key not found";
<<<<<<< HEAD
		}	
=======
		}
		
>>>>>>> master
	}

	@Override
	public String prevKey(String key) {
		NodeEntry entry = getNodeEntry(key);
		if(entry != null){
			NodeEntry prev = getPrev(root, entry);
			if(prev != null){
				return prev.key;
			}
			else{
				return "No previous key";
			}
		}
		else{
			return "Key not found";
		}
	}
	
<<<<<<< HEAD
	/**
	 * Finds the previous node entry to a given node.
	 * @param root root node of the given node
	 * @param first given node
	 * @return previous node to the given node
	 */
=======
>>>>>>> master
	private NodeEntry getPrev(NodeEntry root, NodeEntry first){
		if(first.left != null){
			return maxElem(first.left);
		}
		NodeEntry prev = null;
		
		while(root != null){
			if(Integer.parseInt(first.key) == Integer.parseInt(root.key)){
				break;
			}
			else if(Integer.parseInt(first.key) < Integer.parseInt(root.key)){
				root = root.left;
			}
			else if(Integer.parseInt(first.key) > Integer.parseInt(root.key)){
				prev = root;
				root = root.right;
			}
		}
		return prev; 
	}
	
<<<<<<< HEAD
	/**
	 * Finds the succeeding node entry to a given node.
	 * @param first given node
	 * @return next node to the given node
	 */
=======
>>>>>>> master
	private NodeEntry getNext(NodeEntry first){
		NodeEntry next = null; 
		NodeEntry parentNext = null; 
		NodeEntry curr = first.right;
		
		while(curr!=null){
			parentNext = next;
			next = curr; 
			curr = curr.left;
		}
		if(next != first.right){
			parentNext.left = next.right;
			next.right = first.right;
		}
		return next;
	}

	@Override
	public int[] sort() {
		//Binary search trees sort the keys when inserting them
		return null;
	}

	
}

class NodeEntry{
<<<<<<< HEAD
/* ============================================================ Instance Variables ============================================================ */
=======
>>>>>>> master
	protected String key;
	protected Integer value; 
	protected NodeEntry left, right; 
	
<<<<<<< HEAD
/* ================================================================== Methods ================================================================= */
	/**
	 * Constructor
	 * @param key
	 * @param value
	 */
=======
>>>>>>> master
	public NodeEntry(String key, Integer value){
		this.key = key; 
		this.value = value; 
	}
	
<<<<<<< HEAD
	/**
	 * See public void put(String key, int value) of the same class
	 */
=======
>>>>>>> master
	public void put(String key, Integer value){
		if(key.compareTo(this.key) < 0){
			if(left!=null){
				left.put(key, value);
			}
			else{
				left = new NodeEntry(key, value);
			}
		}
		else if(key.compareTo(this.key) > 0){
			if(right != null){
				right.put(key, value);
			}
			else{
				right = new NodeEntry(key, value);
			}
		}
		else{
			this.value = value; 
		}
	}
	
	public Integer get(String key){
		if(this.key.equals(key)){
			return value; 
		}
		if(key.compareTo(this.key) < 0){
			return left == null ? null : left.get(key);
		}
		else{
			return right == null ? null : right.get(key);
		}
	}
	
}


