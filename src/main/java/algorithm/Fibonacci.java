package algorithm;

public class Fibonacci {
	
	public static int fibonacci(int n) {
		
		//System.out.println(" nombre : " + n );
		if( n<=1) {
			
			
			return n;
		}else {
		
		return fibonacci(n-2) + fibonacci(n-1);
		
		}
		
	}
	
	public static void main(String[] args) {
		
		
		 System.out.println(fibonacci(10));
		
		
	}

}
