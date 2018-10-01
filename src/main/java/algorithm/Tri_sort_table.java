package algorithm;

public class Tri_sort_table {

	private static void  tri_sort( int [] array) {
		
		int n= array.length;
		int k;
		for( int m =n; m>=0; m--) {
			
			for(int i=0; i<array.length-1; i++) {
				
				k=i+1;
				if (array[i]> array[k]) {
					swapNumber(i, k, array);
				}
				
			}
		}
		
		printArray( array);
		
	}
	
	private static void printArray(int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + ",");
		}
		System.out.println("\n");
	}

	private static void swapNumber(int i, int k, int[] array) {
	int temp;
	temp= array[i];
	array[i]= array[k];
	array[k]= temp;		
	}

	public static void main(String[] args) {
		
		int [] input = {63, 78, 23, 12, 89, 45, 76, 11, 55, 56,13 };
		tri_sort(input);

	}

}
