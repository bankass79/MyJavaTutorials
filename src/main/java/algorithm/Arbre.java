package algorithm;



// Construction d'un arbre 4 noeuds avec deux branches EDB, EF
public class Arbre {
	String value;

	Arbre left,right;

	public Arbre(String value, Arbre left, Arbre right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}



	public static void inorderArbre ( Arbre t) {

		if( t==null) {

			return;
		}else {

			inorderArbre(t.left);
			System.out.println(t.value);
			inorderArbre(t.right);

		}

	}
	public static int size(Arbre t) {


		if( t== null) {

			return 0;
		}else {

			int tailleArbre = size(t.left)+ size(t.right);

			return tailleArbre;
		}


	}

  public static boolean containsValue( Arbre t,  int x) {
	  
	 while( t!= null) {
		 
		 if( x== Integer.parseInt(t.value)) {
			 
			 return true;
			 
			
		 }else {
			 
			 t= (x < Integer.parseInt(t.value)? t.left: t.right);
		 }
		 
	 }
	return false;
  }

	@Override
	public String toString() {
		return "Arbre [value=" + value + ", left=" + left + ", right=" + right + "]";
	}

	public static void main(String[] args) {

		Arbre abrB = new Arbre("6", null, null);

		Arbre abrD= new Arbre("8", abrB, null);

		Arbre arbE=  new Arbre("1", abrD, new Arbre("3", null, null));

		Arbre.inorderArbre(arbE);
		
		System.out.println(Arbre.containsValue(arbE, Integer.parseInt("5")));
		System.out.println(Arbre.containsValue(arbE, Integer.parseInt("1")));
	}
}
