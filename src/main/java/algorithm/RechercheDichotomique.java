package algorithm;

public class RechercheDichotomique {

	public static int rechercheDicho( int []t, int x, int g, int d) {
		
		int indice=-1;
		
		while (g < d) {
			
			int m= (g+ d)/2;
			
					if( t[m] == x) {
						indice= m;	
						break;
					
					}else if( t[m] > x ) {
						
						d=m;
						
					}else {
						
						g= m+1;
						
					}
		}
		
		return indice;
	}

   public static int rechecheDichotomique( int [] t, int x) {
	   
	   return rechercheDicho(t, x,0, t.length);
	  
   }

   public static void main(String[] args) {
	
	   int [] tab= {22, 34, 45,76,78,98};
	   
	   System.out.println(rechecheDichotomique(tab, 76));
	   
}
   
}
