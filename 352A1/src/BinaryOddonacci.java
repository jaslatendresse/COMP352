
/*
 * Authors: Elise Comeau ID 27038054, Jasmine Latendresse ID 40011419, Fabian Vergara 40006707
 * Date: September 30th, 2016
 * 
 * This program calculates the time required to execute an exponential recursive method
 * called binaryOddo (defined below). The Oddonacci series is defnied as:
 * 		Oddonacci(1) = Oddonacci(2) = Oddonacci(3) = 1, and
 * 		Oddonacci(k) = Oddonacci(k-1) + Oddonacci(k-2) + Oddonacci(k-3) for k >= to 4.		
 */
import java.io.BufferedWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
//Oddonacci numbers rapidly get large: int and long variables don't have the capacity to hold such values
import java.math.BigInteger; 

public class BinaryOddonacci {
	//The largest Oddonacci number will have index 40
	public static final int MAX_NUMBER_TO_FIND = 40; 
	public static void main(String[] args) {

		// 1. The string that the program will print in the file is initialized empty, for now.
		String stringToPrint = "";

		// 2. Printing out the index, Oddonacci numbers and time needed to execute the algorithm.
		//    The for loop is going to print every 5th Oddonacci number
		for (int k = 5; k <= MAX_NUMBER_TO_FIND; k += 5) { 
			// Execution start time
			long startTimeBinary = System.nanoTime(); 
			binaryOddo(k);
			// Execution end time. 
			long endTimeBinary = System.nanoTime();
			
			//Total time taken to execute: end time - start time

			//Concatenation of strings holding each iteration of the loop
			stringToPrint = stringToPrint + "BINARY: " + k + "-nth term of the Oddonacci number: " + binaryOddo(k)
					+ ", with a runtime of " + (endTimeBinary - startTimeBinary) + " nanoseconds" + "\n";
		}
		//Printing the output string to a file
		printOutput("output-binary.txt", stringToPrint);
	}

	/*
	 * This method calculates the Oddonacci number defined above using binary
	 * recursion.
	 * 
	 * @param k: Index of the desired Oddonacci number
	 * 
	 * @return kth Oddonacci number
	 * 
	 */
	public static BigInteger binaryOddo(int k) {
		//First base case: Oddonacci numbers with index less than 4
		if ( k < 4){
			//The Oddonacci is equal to 1, not a sum
			return BigInteger.ONE; 
		}
		//Second base case: Oddonacci numbers with index of 4
		else if (k == 4) {
			//The Oddonacci number is equal to 3, the sum of the first three numbers
			return BigInteger.valueOf(3);
		}
		//The recursive case: for k index greater than 4
		else{
			//We use the mathematical expression 2 * binaryOdd(k-1) - binaryOddo(k-4)
			return (BigInteger.valueOf(2).multiply(binaryOddo(k - 1)).subtract(binaryOddo(k - 4)));
		}
	}

	/*
	 * Helper method that will take a file name and string as parameters, and will print that string to
	 * a given file. The method handles exceptions and crash cases. If the file exists, it'll override it.
	 * If the file doesn't exist, it'll create it.
	 * 
	 * @param fileName      : name of the file that you are going to print to 
	 * @param stringToPrint : string that is going to be printed in the file
	 * 
	 */
	public static void printOutput(String fileName, String stringToPrint) {
		//Try and catch statement to avoid crashes
		try (
			//Creating a buffered writer object with fileName as its file name and utf-8 as format
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),
						"utf-8"))) {
			//Writing file using writer object
			writer.write(stringToPrint);
			//Printed Acknowledge
			System.out.println("File printed successfully");

		} catch (IOException e) {
			//Something went wrong, the exception is handled here.
			System.out.println("Something went wrong printing the file");
			//Printing the stack trace to see what went wrong
			e.printStackTrace();
		}	
	}
}
