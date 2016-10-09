package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant l'objet GeoLocation donnant les coordonn�es d'une adresse.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class GeoLocation {

    /**
     * Latitude du lieu en degr�s d�cimaux
     */
    @JsonProperty("lat")
    private double lat;

    /**
     * Longitude du lieu en degr�s d�cimaux
     */
    @JsonProperty("lng")
    private double lng;

    /**
     * Constructeur principal
     *
     * @param lat Latitude du lieu en degr�s d�cimaux
     * @param lng Longitude du lieu en degr�s d�cimaux
     */
    @JsonCreator
    public GeoLocation(
            @JsonProperty("lat") double lat,
            @JsonProperty("lng") double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * @return la latitude du lieu en degr�s d�cimaux
     */
    @JsonGetter("lat")
    public double getLat() {
        return lat;
    }

    /**
     * @param lat d�finit la latitude du lieu en degr�s d�cimaux
     */
    @JsonSetter("lat")
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return la longitude du lieu en degr�s d�cimaux
     */
    @JsonGetter("lng")
    public double getLng() {
        return lng;
    }

    /**
     * @param lng d�finit la longitude du lieu en degr�s d�cimaux
     */
    @JsonSetter("lng")
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{latitude:" + getLat()
                + ", longitude:" + getLng()
                + "}");
    }
}
