package algorithm;

public class ArrayStructures {

	private int [] theArray = new int [50];
	private int arraySize = 10;

	// génere des valeurs dans le tableau
	private void generatRandomArray () {
		for( int i=0; i<arraySize; i++) {

			theArray [i]= (int)(Math.random()*10 +10);
		}
	}
	// afficher les valeurs aléatoire dans le tableau
	private void printArray () {

		System.out.println("-------");
		for (int i = 0; i < arraySize; i++) {

			System.out.print("|" + i + "|");
			System.out.println(theArray[i] + "|" );
			System.out.println("-------");
		}
	}
	// retourne la valeur correspondand à un index
	private int getValueAtIndex( int index) {

		if( index < arraySize) {

			return theArray[index];
		}

		return 0;
	}
	
	// recherche une valeur dans le tableau
	
	private  boolean  arrayContainValue (int search) {
		 boolean searchValue= false;
		
		 for (int i=0; i<arraySize; i++) {
			
			if( theArray [i]==search) {
				
				searchValue= true;
			}
		}
		 return searchValue;
	}
	
	// supprime in index dans le tableau
	private void deleteIndexAtArray(int index) {
		
		if( index <arraySize) {
			
			for (int i=index; i<arraySize-1; i++) {
				
				theArray[i]= theArray[i+1];
			}
		}
		
	}
	
	// insère une valeur dans le tableau
	
	private void insertValue(int value) {
		
		if( arraySize<50) {
			theArray[arraySize]=value;
			arraySize++;
		}
	}
  // recherche lineaire de valeur
	
	private String linearSearchValue( int value) {
	
		boolean valueInArray= false;
		
		String indexWithValue= "";
		System.out.println("The value was found at index:");
		for (int i = 0; i < arraySize; i++) {
			
			if( theArray[i]==value) {
				
				valueInArray= true;
				//System.out.println(i + " ");
				indexWithValue += i + " ";
			}
			
			
	
		}
		if(!valueInArray) {
			
			indexWithValue= "aucune";
			//System.out.println(indexWithValue);
			//System.out.println();
		}
		
		return indexWithValue;
		
		
	}
	public static void main(String[] args) {

		ArrayStructures newArray = new ArrayStructures();
		newArray.generatRandomArray();
		newArray.printArray();
		System.out.println(newArray.getValueAtIndex(3));
		System.out.println(newArray.arrayContainValue(16));
		newArray.deleteIndexAtArray(3);
		newArray.printArray();
		newArray.insertValue(192);
		newArray.printArray();
		System.out.println(newArray.linearSearchValue(17));

	}

}
