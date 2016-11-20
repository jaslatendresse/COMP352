import java.util.Arrays;

public class Q1 {
	
	public static int[] swap(int[] toReverse){
		int arraySize = toReverse.length;
		int temp = 0;
		if(arraySize%2 == 0){
			for(int i = 0; i < (arraySize/2 + 1); i++){
				temp = toReverse[i+1];
				toReverse[i+1] = toReverse[i];
				toReverse[i] = temp; 
			}
		}
		else{
			for(int i = 0; i < (arraySize/2); i++){
				temp = toReverse[i+1];
				toReverse[i+1] = toReverse[i];
				toReverse[i] = temp;
			}
		}
		return toReverse;
	}

	public static void main(String[] args) {
		
		int[] a1 = {1,2,3,4,5};
		System.out.println(Arrays.toString(swap(a1)));
		
	}

}
