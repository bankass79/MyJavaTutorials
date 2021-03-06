package algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tribionacci {

	
	private static Logger LOGGER = LoggerFactory.getLogger(Tribionacci.class);
	
	public static int tribionnaci(int t) {
		
		if (t<=2) {
			
			return 0;
		}else if( t==3) {
			
			return 1;
		}else {
			
			LOGGER.debug(" Tribionnaci ok");
			return tribionnaci(t-1) + tribionnaci(t-2)+ tribionnaci(t-3);
			
		}
		
	}

	private static void printTribionnaciRec(int t) {
		
		
	 for (int i = 0; i < t; i++) {
		System.out.print(tribionnaci(i) + " ");
	}
		
	}

	public static void main(String[] args) {
		int y = 10;
		int k= Tribionacci.tribionnaci(y);
		
		printTribionnaciRec(k);
		
	}
}
