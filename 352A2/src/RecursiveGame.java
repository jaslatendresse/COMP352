import java.util.Arrays;    

public class RecursiveGame {
	public static final int DEFAULT_VALUE = 0;

	public static void main(String[] args){
		int[] play1 = {5, 8, 2, 3, 1, 5, 0};//false
		int[] play2 = {4, 8, 5, 2, 4, 5, 1, 6, 3, 0};//true
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

		
		
		System.out.println(Arrays.toString(play1));
		System.out.println(solveGameRecursively(DEFAULT_VALUE, play1));
	}
	
	
	/*
	 * Moves left or right in an array of integers the value of the element is 0 or until there is no space to move
	 * 
	 * @param index - index of the integer values in the list
	 * @param game - contains the integer values in the list
	 */
	public static boolean solveGameRecursively(int index, int[] game){
	
		final int VISITED = 15; //Value to set a square to visited
		
		if(game[index] == VISITED){
			return false;
		}
		
		int i = game[index]; //Storing game index 
		
		if(game[index] == 0){ //If square value is 0, win = end of game
			return true;
		}
		
		else if(game[index] < game.length - index && game[index] != game[index + game[index]]){ //Can move to the right
			game[index] = VISITED; //Sets the current square to visited
			return solveGameRecursively(index + i, game);
		}
		else if(game[index] < index){ //Can move backward
			game[index] = VISITED; //Sets the current square to visited
			return solveGameRecursively(index - i, game);
		}
		else
			return false; //Can't move
	}
}
