package algorithm;

public class RecherchePlusPetit {

	public  int plusPetitElement(int [] n) {


		// k est l'indice du premier élement
		int k =0 ;

		for (int i= 0; i<n.length; i++) {

			if( n[i] < n [k ]) {
				k=i;
			}

		}
		return k;


	}

	public static void main(String[] args) {


		RecherchePlusPetit rech= new RecherchePlusPetit();
		int [] n =  {33, 89, 12, 98, 6};
		System.out.println(rech.plusPetitElement(n));  


	}

}
