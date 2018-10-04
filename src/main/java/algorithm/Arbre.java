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



	@Override
	public String toString() {
		return "Arbre [value=" + value + ", left=" + left + ", right=" + right + "]";
	}

	public static void main(String[] args) {

		Arbre abrB = new Arbre("B", null, null);

		Arbre abrD= new Arbre("D", abrB, null);

		Arbre arbE=  new Arbre("E", abrD, new Arbre("F", null, null));

		Arbre.inorderArbre(arbE);

	}
}
