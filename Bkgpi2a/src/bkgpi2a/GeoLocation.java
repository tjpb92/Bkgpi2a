package bkgpi2a;

/**
 * Classe d�crivant l'objet GeoLocation donnant les coordonn�es d'une adresse.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class GeoLocation {
    
    /**
     * Latitude of a location in decimal degrees.
     */
    private double lat;

    /**
     * Longitude of a location in decimal degrees.
     */
    private double lng;

    /**
     * Constructeur principal
     */
    public GeoLocation(double myLat, double myLng) {
        this.lat = myLat;
        this.lng = myLng;
    }
    /**
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(double lng) {
        this.lng = lng;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return(this.getClass().getName() + 
                ":{latitude:" + getLat() + 
                ", longitude:" + getLng() + 
                "}");        
    }
}
