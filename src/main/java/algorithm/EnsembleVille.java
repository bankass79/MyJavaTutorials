package algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;


public class EnsembleVille {
	private Vector<Ville> listeVilles = new Vector<Ville>();
	
	
	EnsembleVille(String nom) {
    // lit un fichier et renvoie la liste des villes qu il contient
    	VilleParser vp = new VilleParser(nom);
    	listeVilles =  vp.litFichier();
    }

	public int size() {
		return listeVilles.size();
	}
	
	public Ville getVille(int i) {
		return listeVilles.elementAt(i);
	}
	
    public static void main(String args[]) {
    	// le main prend le fichier mf.txt et affiche les villes
    	EnsembleVille ens = new EnsembleVille("C:/Users/a.guindo/Desktop/mf.txt");
    	
    	for (int i = 0; i < ens.size(); i++)
    		System.out.println(ens.getVille(i));
    	System.out.println(ens.size() + " Villes");
        }

}


class VilleParser {
    private int carLu;
    private final StringBuilder buffer = new StringBuilder(); // si plus, tant pis;
    private final BufferedReader b;
    public VilleParser(String nom) {
        try {
	    if ( nom.startsWith("http://") )
		b = new BufferedReader(new InputStreamReader(new URL(nom).openStream(),"UTF-8"));
	    else
		b = new BufferedReader(new InputStreamReader(new FileInputStream(nom),"UTF-8"));

  //	    b = new BufferedReader(new InputStreamReader(new FileInputStream(nom),"UTF-8"));
        } catch (IOException e) {
	    throw new IllegalArgumentException("fichier illisible",e);
        }
    }
    
    
    private void skipToEOL() throws IOException {
        while (carLu!=-1 && "\r\n".indexOf(carLu)==-1) {
	    carLu = b.read();
        }
        while (carLu!=-1 && "\r\n".indexOf(carLu)!=-1)
	    carLu = b.read();
    }
    
    private void skipNextField() throws IOException {
        while ("\t\f".indexOf(carLu)==-1) {
	    carLu = b.read();
        }
        carLu = b.read();
    }
    
    private double readDouble() throws IOException {
        int d = 0,sign=1;
        if (carLu=='-') {
	    sign=-1;
	    carLu = b.read();
        }
        while(carLu<='9' && carLu>='0') {
	    d=10*d+(carLu-'0');
	    carLu=b.read();
        }
        if (carLu!='.') {
	    carLu = b.read();
	    return sign*d;
        }
        carLu = b.read();
        int dot=1;
        while(carLu<='9' && carLu>='0') {
	    d=10*d+(carLu-'0');
	    dot*=10;
	    carLu=b.read();
        }
        carLu=b.read();
        return sign*d/(double)dot;
    }
    
    private String readString() throws IOException {
        buffer.setLength(0);
        while("\t\f".indexOf(carLu)==-1) {
	    buffer.append((char)carLu);
	    carLu=b.read();
        }
        return buffer.toString();
    }
    
    public Vector<Ville> litFichier() {
        try {
	    Vector<Ville> ensemble = new Vector<Ville>();
	    skipToEOL(); // On saute la ligne d entete
	    do {
		skipNextField(); //RC : Region font code
		skipNextField(); //UFI : Unique feature identifier
		double id = readDouble(); //UNI : Unique name identifier
		double latitude = readDouble();
		double longitude = readDouble();
		skipNextField(); //DMS_LAT
		skipNextField(); //DMS_LONG
		skipNextField(); //UTM : Universal transverse Mercator
		skipNextField(); //JOG : Joint operations Graphic reference
		if (carLu!='P') {
		    skipToEOL();
		    continue;
		}
		skipNextField(); //FC : Feature classification
		skipNextField(); //DSG : Feature designation code
		skipNextField(); //PC : Populated place classification
		skipNextField(); //CC1 : Primary coutry code
		skipNextField(); //DSG : Feature designation code
		skipNextField(); //ADM1 : First order administrative division code
		skipNextField(); //ADM2
		skipNextField(); //DIM : Dimension
		skipNextField(); //CC2
		skipNextField(); //NT : Name type
		skipNextField(); //LC : Language code
		skipNextField(); //SHORT_FORM
		skipNextField(); //GENERIC NAME
		skipNextField(); //SHORT_NAME
		String nom = readString(); //FULL_NAME
		skipToEOL();
		ensemble.add(new Ville(nom,id,latitude,longitude));
	    }
	    while(carLu != -1);
	    b.close();
	    return ensemble;
        }
        catch (IOException e) {
	    try {
		b.close();
	    } catch (IOException e1) {/* nothing */}
	    throw new IllegalArgumentException("invalid file",e);
        }
    }

    
}

