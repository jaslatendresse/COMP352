import java.util.*;

public class Q2 {

	public static void main(String[] args){
		int[] array = {123,73,39,12,14,9,113,93,203,22,25,10};
		int x = 3;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i : array){
			q.add(i);
		}
		
		findPairs(q,x);

		
		
	}
	
	public static void findPairs(Queue<Integer> queue, int k){
		Integer num1;
		
		while(!queue.isEmpty()){
			num1 = queue.poll();
			
			for(Integer i : queue){
				if(num1.intValue() % i.intValue() == k){
					System.out.printf("Values %d and %d %n", num1.intValue(), i.intValue());
				}
			}
		}
		
	}
}
