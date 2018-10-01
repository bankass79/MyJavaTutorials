package algorithm;

import grapheX.Identifiable;

import java.awt.Graphics;

public class Ville extends Identifiable {

	String nom;

    // -180 < long < 180
    // -90 < lat < 90
    double latitude, longitude;

    Ville(String s,double id, double lat,double longi) {
    	super(""+id);
    	nom = s;
    	latitude = lat;
    	longitude = longi; 
    }

    public String toString() {
    	return nom+"\tLatitude: "+latitude+"\t"+"Longitude: "+longitude;
    }

    double getLatitude() {
	return latitude;
    }

    double getLongitude() {
	return longitude;
    }

    double getLatitudeRadians() {
	return latitude/180*Math.PI;
    }

    double getLongitudeRadians() {
	return longitude/180.0*Math.PI;
    }

    private int tLat(double latitude, double latmin, double latmax, int h) {
	return h-(int) ((latitude-latmin)/(latmax-latmin)*h);
    }
    private int tLong(double longitude, double lonmin, double lonmax, int w) {
	return (int) ((longitude-lonmin)/(lonmax-lonmin)*w);
    }
    
    public void dessineArete(Graphics g, double latmin,double lonmin, double latmax, double lonmax, int w, int h,Ville d) {
	int lat1 = tLat(latitude,latmin,latmax,h);
	int lat2 = tLat(d.getLatitude(),latmin,latmax,h);
	int lon1 = tLong(longitude,lonmin,lonmax,w);
	int lon2 = tLong(d.getLongitude(),lonmin,lonmax,w);
	g.drawLine(lon1,lat1,lon2,lat2);
    }

	private double sqr(double a) {
	    return a*a;
		}

/*    public static Ville getVille(String id) {
	return listeVilles[Integer.parseInt(id)];
    }	

    public static Ville getVille(int i) {
	return listeVilles[i];
    }

	
    public static int nombreVilles() {
	if (listeVilles != null) return listeVilles.length;
	else return 0;
    }
*/
	
    public double distance(Ville dest) {
	// utilise la distance ellipsoidale de vincenty
	double R = 6371000; // rayon de la terre
	return R*Math.sqrt(sqr((getLatitude()-dest.getLatitude()))+sqr((getLongitude()-dest.getLongitude())))/180.0*Math.PI; 
	    //	return Math.acos(Math.sin(getLatitudeRadians())*Math.sin(dest.getLatitudeRadians())+Math.cos(getLatitudeRadians())*Math.cos(dest.getLatitudeRadians())*Math.cos(dest.getLongitudeRadians()-getLongitudeRadians()))*R;
    }

    public void dessine(Graphics g, double latmin,double lonmin, double latmax, double lonmax, int w, int h, boolean noms) {
	g.fillOval(tLong(longitude,lonmin,lonmax,w),tLat(latitude,latmin,latmax,h),4,4);
	if (noms) 
	    g.drawString(nom,tLong(longitude,lonmin,lonmax,w)-5*nom.length(),tLat(latitude,latmin,latmax,h)-10);
    } 



}
