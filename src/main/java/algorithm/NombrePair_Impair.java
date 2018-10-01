package algorithm;

public class NombrePair_Impair  {
	
	// n est pair ssi (n-1) est impair
	public static  boolean  nombreEstPair(int n) {
		
		if( n==0) {
			
			return true;
		
		}else {
			
			nombreEstImpair(n-1);
			
			System.out.println(" le nombre est pair" + " " + n);
	
		}
			return false;
	}

	// n est impair ssi (n-1) est pair
	private static  boolean nombreEstImpair(int n) {
		
		if(n ==0) {
			
			return false;
		}else {
			
			System.out.println("le nombrte est impair:" + " " +n );
			return nombreEstPair(n-1);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(nombreEstImpair(7));
		
	}

}
