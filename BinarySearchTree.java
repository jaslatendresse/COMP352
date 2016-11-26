public class BinarySearchTree implements DataStructure {

	public NodeEntry root;
	
	public BinarySearchTree(){
		this.root = null;
	}

	@Override
	public void put(String key, int value) {
		NodeEntry entry = new NodeEntry(key, value);
		
		if(root == null){
			root = entry;
			return;
		}
		NodeEntry curr = root; 
		NodeEntry parent = null;
		
		while(true){
			parent = curr; 
			if(Integer.parseInt(key) < Integer.parseInt(curr.key)){
				curr = curr.left;
				if(curr == null){
					parent.left = entry;
					return; 
				}
			}
			else{
				curr = curr.right;
				if(curr == null){
					parent.right = entry;
					return;
				}
			}
		}
		
	}

	@Override
	public void remove(String key) {
		NodeEntry parent = root;
		NodeEntry current = root;
		boolean isLeftChild = false;
		while(!current.key.equals(key)){
			parent = current; 
			if(Integer.parseInt(current.key)>Integer.parseInt(key)){
				isLeftChild = true; 
				current = current.left;
			}
			else{
				isLeftChild = false;
				current = current.right;
			}
			if(current == null){
				return; 
			}
		}
		if(current.left == null && current.right == null){
			if(current == root){
				root = null;
			}
			if(isLeftChild){
				parent.left = null;
			}
			else{
				parent.right = null;
			}
		}
		
		else if(current.right == null){
			if(current == root){
				root = current.left;
			}
			else if(isLeftChild){
				parent.left = current.left;
			}
			else{
				parent.right = current.left;
			}
		}
		else if(current.left == null){
			if(current == root){
				root = current.right;
			}
			else if(isLeftChild){
				parent.left = current.right;
			}
			else{
				parent.right = current.right;
			}
		}
		else if(current.left != null && current.right != null){
			NodeEntry next = getNext(current);
			if(current == root){
				root = next;
			}
			else if(isLeftChild){
				parent.left = next;
			}
			else{
				parent.right = next;
			}
			next.left = current.left;
		}
	}
	
	public NodeEntry getNext(NodeEntry entry){
		NodeEntry successor = null;
		NodeEntry successorParent = null;
		NodeEntry current = entry.right;
		
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		if(successor != entry.right){
			successorParent.left = successor.right;
			successor.right = entry.right;
		}
		return successor;
	}

	@Override
	public int get(String key) {
		NodeEntry current = root; 
		while(current != null){
			if(current.key.equals(key)){
				return current.value;
			}
			else if(Integer.parseInt(current.key) > Integer.parseInt(key)){
				current = current.left;
			}
			else{
				current = current.right;
			}
		}
		return -1;
	}

	@Override
	public String nextKey(String key) {
		return null;
	}

	@Override
	public String prevKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] sort() {
		//Tree is already sorted so sorting method is useless in this case. 
		return null;
	}
	
}

class NodeEntry{
	protected NodeEntry left;
	protected NodeEntry right;
	String key;
	int value; 
	
	public NodeEntry(String key, int value){
		this.key = key;
		this.value = value; 
		this.left = null;
		this.right = null;
	}
}
