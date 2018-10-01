package algorithm;

public class TriFusionClass<T extends Comparable<T>> implements triFusionInterface<T> {

	@Override
	public void sort(T[] elements) {

		T[] arr= (T[]) new Comparable [elements.length];

		sort( elements, arr, 0, elements.length-1);
	}

	// constructeur
	public TriFusionClass() {
		
	}
	
	
	private void sort(T[] elements, T[] arr, int low, int high) {
		// low = high le tableau est trié, on ne fait rien
		if( low>=high) {

			return;
		}
		// sinon  on choisi m dans [low..high]	
		int mid= low + (high-low)/2; // high borne supérieur du tableau.

		// trier arr[low,...,m]
		sort(elements, arr, low, mid);
		//trier  arr[m+1, high]
		sort(elements,arr, mid+1, high);
		// fusionner dans elements [low, high], arr[1,...m] et arr[m+1, high]
		merge(elements, arr, low, mid, high);
	}

	//fonction de  fusion dans elements [low, high], arr[1,...m] et arr[m+1, high]
	private void merge(T[] a, T[] b, int low, int mid, int high) {

		int i= low;  // borne inférieur
		int j = mid+1; // milieu + 1

		for(int k=low; k<high; k++) {

			// comparaison de i  à mid et de j à high
			if( i < mid && j <high) {

				// comparaison de l'élément à la position i avec l'élément à la position j  
				if( a[i].compareTo(a[j])>=0) {

					b[k]=a [i++];
				}else {
					b[k]= a[j++];
				}

			}else if (j>high && i<=mid) {


				b[k]= a[i++];


			}else if ( j<=high && i>mid) {

				b[k]= a[j++];

			}
		}
		for (int j2 = low; j2 < high; j2++) {

			a[j2]= b[j2];
		}
	}

	private static void print(Comparable[] array){
		StringBuffer buffer = new StringBuffer();
			for (Comparable value : array) {
				buffer.append(value);
				buffer.append(' ');
			}
	System.out.println(buffer);
	}
	
	public static void main(String[] args) {
	 Integer[] array = { 4, 3, 1, 8, 9, 15, 20, 2, 5, 6, 30, 70,
				60,80,0,9,67,54,51,52,24,54,7 };
	 print(array);

	}

}
