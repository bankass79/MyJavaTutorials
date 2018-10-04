package algorithm;

public class Liste {
	
	int contenu;
	Liste suivant;

	public Liste( int c, Liste suiv) {
		
		this.contenu=c;
		this.suivant=suiv;
	}
	public static  int longueurRec(Liste l) {
		
		if(l==null) {
			
			return 0;
		}else {
			
			return 1 + longueurRec(l.suivant);
		}
	}
	
	public static  void afficherContenu(Liste l) {
		
		Liste ll=l;
		while(ll !=null) {
			
			System.out.println(l.contenu + "-->");
			
			ll=ll.suivant;
		}
		
		System.out.println("null");
	}
	
	public static void main(String[] args) {
	Liste l;
	l= new Liste(3, null);
	l=new Liste(12, l);
	l= new Liste(4, l);
	
	System.out.println(l.contenu);
      afficherContenu(l);
      
      System.out.println(longueurRec(l));
	}

}
