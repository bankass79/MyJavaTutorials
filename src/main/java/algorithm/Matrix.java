package algorithm;

import java.util.Scanner;

public class Matrix { 

	// sommet du graphe = noeud
	
	// la distance entre 2 noeud = edge
	private  final int sommet;

	private int [][] matrix_adjacent;

	public Matrix (int v) {

		sommet=v;
		matrix_adjacent= new int [sommet +1][sommet+1];
	}


	public void calculerDistanceEntreNoeuds(int depart, int arriver, int distance) {

		try {
			matrix_adjacent [depart][arriver]=distance;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("le sommet n\'existe pas");
		}
	}
	public int donnerDistance(int depart, int arriver) {

		try {
			return matrix_adjacent[arriver][depart];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("le sommet n\'existe pas");
		}
		return -1;
	}
	public static void main(String[] args) {

		int s, d, count =1, arriver=0, depart=0;
		Scanner sc = new Scanner(System.in);
		Matrix graph;

		try {

			System.out.println("Entrez le nombre de sommet: ");
			s= sc.nextInt();
			System.out.println("Entrez le nombre de lien:");
			d=sc.nextInt();
			// construction de nouvelle matrix
			graph= new Matrix(s);

			System.out.println("Entrez les noeuds voisins");

			while (count <=d) {
				depart=sc.nextInt();
				arriver=sc.nextInt();
				graph.calculerDistanceEntreNoeuds(depart, arriver, 1);
				count++;

			}
			System.out.println("la matrix adjacent pour le graph donné est:");
			System.out.println(" ");
			for(int i=1; i<=s; i++) {

				System.out.print(i + " ");
				System.out.println();


			}

			for(int i =1; i<=s; i++) {
				System.out.println(i + " ");
				for(int j=1; j<=s; j++) {
					System.out.println(graph.donnerDistance(i, j) + " ");
					System.out.println();
				}

			}

		} catch (Exception e2) {
			System.out.println("something went wrog");

		}
		sc.close();

	}

}
