import java.math.BigInteger;

public class ProgQ
{
  public static void main(String[] args)
  {
	  
		  System.out.println(linOddo(41,BigInteger.ONE,BigInteger.ONE,BigInteger.ONE));
		  System.out.println(binaryOddo(41));
		  

  }
  
  public static int Oddo(int i){
    if(i == 1 || i == 2 || i == 3){
      return 1; 
    }
    else{
      return Oddo(i - 1) + Oddo(i - 2) + Oddo(i - 3);
    }
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
