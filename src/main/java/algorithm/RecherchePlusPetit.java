package algorithm;

import java.util.Scanner;

public class RecherchePlusPetit {

	public  int plusPetitElement(int [] n) {

	
	  System.out.println(" Saisissez la taille du tableau :");		  
	  Scanner sc = new Scanner (System.in);		
	  
		  // n tableau d'entier, s la taille du tableau
		   int s= sc.nextInt();
		 		   n = new int [s];
		 		   
		 		   int taille= n.length;
	  		  
		 		   
		 		   for (int i = 0; i < taille; i++) {
			  System.out.println(" saisisse : " + " " + i + " ème Valeur  du tableau");
			  
		   n [i] = sc.nextInt();
		  
	}
		 sc.close();
		// k est l'indice du premier élement
		int k =0 ;

		for (int i= 0; i<n.length; i++) {

			if( n[i] < n [k ]) {
				k=i;
			}

		}
		
		System.out.println("l'indice de la plus petite valeur du tableau est: ");
		return k;


	}

	public static void main(String[] args) {


		RecherchePlusPetit rech= new RecherchePlusPetit();
		int [] n =  {33, 89, 12, 98, 6};
		System.out.println(rech.plusPetitElement(n));  


	}

}
