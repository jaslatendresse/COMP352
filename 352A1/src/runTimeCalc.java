import java.math.BigInteger;
import java.io.*;

public class runTimeCalc {
	
	public static void main(String[] args) throws FileNotFoundException{
		 
		PrintWriter output = new PrintWriter("src/output.txt");

		
		for(int k = 5; k<=40; k+=5){
			long startTimeBinary = System.nanoTime();
			binaryOddo(k);
			long endTimeBinary = System.nanoTime();
			output.println("BINARY: " + k + "nth term of the Oddonacci number: " + binaryOddo(k) + ", with a runtime of " + (endTimeBinary - startTimeBinary) + " nanoseconds");
			
		}
		
		for(int k = 5; k<=40; k+=5){
			long startTimeLinear = System.nanoTime();
			linOddo(k, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE);
			long endTimeLinear = System.nanoTime();
			output.println("LINEAR: " + k + "nth term of the Oddonacci number: " + linOddo(k, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE) +  ", with a runtime of " + (endTimeLinear - startTimeLinear) + " nanoseconds");
		}
		
		output.close();
		
	}

	 public static BigInteger linOddo(int k, BigInteger num1, BigInteger num2, BigInteger num3){
		 if(k == 1){
			 return num3;
		 }
		
		 else{
			 return(linOddo(k-1,num1.add(num2.add(num3)),num1,num2));
		 }
	 }

	  
	  public static BigInteger binaryOddo(int k) {
			if (k==1 || k==2 || k==3)
				return BigInteger.ONE;
			else if (k==4)
				return BigInteger.valueOf(3);
			else
				return (BigInteger.valueOf(2).multiply(binaryOddo(k-1)).subtract(binaryOddo(k-4)));
		}
}
