import java.util.Arrays;

public class Q1 {

	public static void main(String[] args){
		int[] array = {123,73,39,12,14,9,113,93,203,22,25,10};
		int x = 3; 
		
		printResult(array,x);

	}
	
	
	public static void findPairs(int[] array, int k){
		for(int i = 0; i <array.length; i++){
			int first = array[i];
			for(int j = i + 1; j<array.length; j++){
				int second = array[j];
				
				if((first%second) == k){
					System.out.printf("Indices %d and %d ", i, j);
					 System.out.printf("with values %d and %d %n", first, second);
				}
			}
		}
	}
	public static void printResult(int[] array, int x){
		System.out.println("All pairs of elements of the array that modulo up to " + x + " are: ");
		findPairs(array, x);
	}
}
