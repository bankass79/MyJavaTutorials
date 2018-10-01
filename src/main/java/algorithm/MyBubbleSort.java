package algorithm;

import java.util.Scanner;

public class MyBubbleSort {
	
	public static void bubble_sort(int [] array) {
		
		int k;
		int len= array.length;
		
		for( int m=len; m>=0; m--) {
			for(int i =0; i< len-1; i++) {
			k= i + 1;
			if(array[i]> array[k]) {
				
				swapNumber( i, k, array);
			}
			}
		}
		
		printNumber(array);
		
	}

	// Cette méthode permet d'afficher les valeurs d'un tableau
	private static void printNumber(int[] array) {
		for (int i=0; i <array.length; i++) {
			
			System.out.print(array [i] + ", ");
		}
		System.out.println("\n");
	
	}
	// cette méthode permet d'échanger l'emplacement des nombres dans le tableau, 
	// prend commparamètre un tableau et et deux entiers (i, k)
	private static void swapNumber(int i, int k, int[] array) {
			// 1- créer une variable de temp de même type de ceux du paramètre de la méthode
			// 2- affecter la valeur du tableau à la position i à temp
		    // 3- la valeur du tableua à la position k à array[i]
		    // 4- affecter la valeur de temp à array [k] 
			int temp;
			temp= array [i];
			array[i]= array[k];
			array[k]=temp;
	}

	 public static void main(String[] args) {
		
		 MyBubbleSort sort= new MyBubbleSort();
		 System.out.println("Entrez la taille de votre tableau" );
		 Scanner sc = new Scanner(System.in);
		 
		 int n= sc.nextInt();
		 
		 int [] array= new int [n];
		 
		 System.out.println("Entrez les valeurs du tableau");
		 for ( int i=0; i< array.length; i++) {
			 
		 int val= sc.nextInt();
			 
			 array[i]=val;
		 }
		 
		MyBubbleSort.bubble_sort(array);	 
	}
	
}
     