   
public class DataStructureGame {
	public static final int DEFAULT_VALUE = 0;
	public static DoublyLinkedList<Integer> gameToPlay = new DoublyLinkedList<Integer>();
	public static Node<Integer> head;
	 
	public static void main(String[] args){
		int[] play1 = {5, 8, 2, 3, 1, 5, 0};//false
		int[] play2 = {4, 8, 5, 2, 4, 5, 1, 6, 3, 0};//false
		int[] play3 = {3, 3, 3 ,3 ,3, 3, 3, 0};//false
		int[] play4 = {2, 3, 4, 5, 2, 7, 4, 8, 2, 9, 1, 4, 9, 0};//false
		int[] play5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6 ,5 ,4, 6, 0}; //true
		int[] play6 = {3, 3, 3, 5, 2, 4, 6, 3, 2, 1, 4, 6, 9, 3, 4, 2, 1, 0};//false
		int[] play7 = {3,3,3,3,3,3,3,2,2,2,0};//false
		int[] play8 = {4,6,4,7,8,3,4,3,0};//false
		int[] play9 = {5,7,8,3,5,6,7,2,3,1,1,4,5,6,4,3,5,6,7,0};//false
		int[] play10 = {4,5,2,1,1,3,4,5,9,8,3,0};//false
		int[] play11 = {7,1,3,2,6,5,7,8,0};//false
		int[] play12 = {6,9,8,2,3,1,4,5,7,6,0};//true
		int[] play13 = {5,4,6,4,5,4,3,2,2,1,1,3,3,3,1,1,4,5,6,2,2,0};//false
		int[] play14 = {2,4,6,4,3,4,4,4,5,6,7,8,0}; //false
		int[] play15 = {4,4,4,5,7,8,5,3,5,2,1,4,6,3,4,5,2,0};//false
		int[] play16 = {6,7,4,3,5,2,6,5,4,7,5,0};//false
		int[] play17 = {3,4,2,2,2,3,3,1,3,1,4,5,6,0};//false
		int[] play18 = {2,4,5,6,7,6,5,4,6,8,6,5,0};//false
		int[] play19 = {6,6,7,5,3,3,4,5,3,3,2,2,2,1,8,6,4,0};//false
		int[] play20 = {3,2,5,1,5,3,4,0};//false

		
		
		createGame(play2);
		head = gameToPlay.first;
		
		System.out.println(gameToPlay);
		System.out.println(solveGame(DEFAULT_VALUE));
	}
	
	/*
	 * Adds the integers of the array in doubly linked list
	 * 
	 * @param game 
	 * @return void
	 */
	
	public static void createGame(int [] game){
		for (int number : game){
			gameToPlay.add(number);
		}
	}
	

	/*
	 * Moves left or right in a doubly linked list until the node value is 0 or there is no space to move
	 * 
	 * @param start index
	 * @return true if node value is 0, false if node is visited twice or there is no possible move. 
	 */
		 
	public static boolean solveGame(int start){
		Node<Integer> curr = gameToPlay.moveForward(head, start);
		boolean end = false; 
		
		do{
			if(curr.isVisited){ //Node is already visited, game ends
				end = true; 
			}
			else if(curr.data == 0){ //Node value is 0, game ends because win
				return true; 
			}
			else if(curr.data < gameToPlay.size - curr.index){ //Can move right
				System.out.println("Moving forward " + curr.data + " spaces.");
				curr.isVisited = true; //Current node is visited
				curr = gameToPlay.moveForward(curr, curr.index + curr.data); //Moving to the next node on the right
				
			}
			else if(curr.data < curr.index){ //Can move left
				System.out.println("Moving backward " + curr.data + " spaces.");
				curr.isVisited = true; //Current node is visited
				curr = gameToPlay.moveBackward(curr, curr.index - curr.data); //Moving to the previous node on the left
			}
			else{ //No possible move, game ends
				end = true;
			}
		}while(!end); //loop while the game isn't over
		return false; 
	}
	
}
