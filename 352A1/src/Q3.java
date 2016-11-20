import java.util.Arrays;

public class Q3 {
	
	public static void main(String[] args){
		int[] array = {6,12,7,3,5};
		int n = array.length;
		
		System.out.println(Arrays.toString(MyAlgorithm(array, n)));
	}

	public static void swap(int i, int j){
		int temp = i;
		i = j;
		j = temp; 
	}
	
	public static int[] MyAlgorithm(int[] A, int n){
		boolean done = true;
		int j = 0; 
		int temp;
		while (j <= n - 2){
			if(A[j] > A[j + 1]){
				temp = A[j];
				A[j] = A[j + 1];
				A[j + 1] = temp;
				done = false;
				
			}
			j++;
		}
		j = n -1;
		while (j >= 1){
			if(A[j] < A[j - 1]){
				temp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = temp;
				done = false;
	
			}
			j--;
		}
		if(done){
			return A;
		}
		else
			return MyAlgorithm(A,n);
	}
}
