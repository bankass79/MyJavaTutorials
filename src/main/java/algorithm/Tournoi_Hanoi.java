package algorithm;

public class Tournoi_Hanoi {
	
	public static int tournoiHanoi( int n, int disquerDepart, int disqueMilieu, int disqueArriver) {
		
		if (n >0) {
			
			tournoiHanoi(n-1, disquerDepart, disqueArriver, disqueMilieu);
			
			System.out.println("On bouge de " + disquerDepart+  "vers" + disqueArriver);
		tournoiHanoi(n-1, disqueMilieu,disquerDepart,  disqueArriver);
		}
		
		
		return 0;
		
		
	}
	
	public static void main(String[] args) {
		
		
		 tournoiHanoi(6, 1, 2, 3);


	
	}

}
