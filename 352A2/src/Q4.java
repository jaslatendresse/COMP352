import java.util.Arrays;

public class Q4 {

	public static void main(String[] args){
		
		int[] a = {60,35,81,98,14,47};
		
		System.out.println(Arrays.toString(MySolution(a,a.length)));
		
		System.out.println(Arrays.toString(sort(a,a.length)));
		
	}
	public static int[] MySolution(int[] A, int n){
		int[] var = new int[n];
		int[] S = new int[n]; 
		for(int i = 0; i < n - 1; i++){
			var[i] = 0;
		}
		
		for(int i = 0; i < n - 2; i++){
			for(int j = i + 1; j < n - 1; j++){
				if(A[i] <= A[j]){
					var[j]++;
				}
				else{
					var[i]++;
				}
			}
		}
		for(int i = 0; i < n - 1; i++){
			S[var[i]] = A[i];
		}
		return S; 
	}
	
	
	public static int[] sort(int[] array, int n) {
   
	    int[] aux = new int[array.length];
	    
	    int min = array[0];
	    int max = array[0];
	    
	    for (int i = 1; i < n-1; i++) {
	      if (array[i] < min) {
	        min = array[i];
	      } else if (array[i] > max) {
	        max = array[i];
	      }
	    }
	 
	    int[] counts = new int[max - min + 1];
	 
	    for (int i = 0;  i < n-1; i++) {
	      counts[array[i] - min]++;
	    }
	 
	    counts[0]--;
	    for (int i = 1; i < counts.length; i++) {
	      counts[i] = counts[i] + counts[i-1];
	    }
	 
	   
	    for (int i = array.length - 2; i >= 0; i--) {
	        aux[counts[array[i] - min]--] = array[i];
	    }
	 
	    return aux;
	  }
	 
}
