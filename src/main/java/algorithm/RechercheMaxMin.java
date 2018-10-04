package algorithm;

public class RechercheMaxMin {
	
	// Sortie retourne un couple t= (x, y)
	//x= min(a,b)  y=max(a,b)
	public static int []  comparerDeuxEntiers( int a, int b) {
		
		int [] t = new int [2];
		
		if (a<b) {
			
			t[0]=a;
			t[1]= b;
		}else {
			
			t[0]=b;
			t[1]=a;
		}
		return t;
		
	}
	// on cherche recursivement les couples min-max des deux moitiés, puis on les compare entre elles
	
	public static int [] minMaxAUX(int [] t, int g, int d) {
		
		int diff= g-d;
		
		if(diff==1) {
	
			int [] u= new int [2];
			
			u[0]= u[1]= t[g];
			
			return u;
			
		}else if( diff==2) {
			
			return comparerDeuxEntiers(t[g], t[g+1]);
		}else {
			
			// diff>2
			int m= (g+ d)/2;
			
			int [] tg = minMaxAUX(t, g, m);
			
			int []td =minMaxAUX(t, m, d);
			
			int [] u =  new int [2];
			
			if(tg[0]< td[0]) {
				u[0]= tg[0];
			}else {
				
				u[0]= td[0];
			}
			
			if( tg[1] >td[1]) {
				
				u[1]= tg[1];
			}else {
				
				u[1]= td[1];
			}
			return u;
		}
		
	}
	
	public static int [] minMax (int [] t) {
		
		return minMaxAUX(t, 0, t.length);
	}
  
	
	public static void main(String[] args) {
	   int[] t = {1, 4, 6, 8, 2, 3, 6, 0};
	   
	   System.out.println(minMax(t));
}
}
