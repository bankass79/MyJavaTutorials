package lesTris;

public class TriParSelection {

	public static void main(String[] args) {

		double [] tab= {6.4, 10, -19.7, 4.9, -32.1, 5, 18.6 };
		int longueur = tab.length;
		String msg= " Le tableau contient " + longueur + " " + "élements";
		System.out.println(msg);
		double valMinTab = tab[0];

		for(int i=1; i<longueur; i++) {

			if( tab[i]<valMinTab) {
				valMinTab=tab[i]; 
			}

		}
		System.out.print("La valeur minimale de ce tableau est :"+ valMinTab);
		System.out.println();

		//le rang du minimum est 

		int posMin = 0;
		for( int j=0; j<longueur; j++) {

			if( tab[j]< tab[posMin]) {

				posMin=j;

			}
		}

		System.out.println("la position de la valeur minimale est: "+ " "+  posMin);

		// affichage des éléments du tableau

		for(int k=0; k<longueur; k++) {

			System.out.print(k+ ":" + " " + tab[k] + " ");
			System.out.println();
		}
		//System.out.println();

		//permuter la valeur du premier élement du tableau par la valeur du minimum

		double tmp = tab[0];
		tab[0]=valMinTab;
		valMinTab=tmp;
		tmp=tab[0];


		// réaffichage des élements du tableau

		for(int k=0; k<longueur; k++) {

			System.out.print(k+ ":" + " " + tab[k] + " ");
			//System.out.println();
		}
	}	
}
