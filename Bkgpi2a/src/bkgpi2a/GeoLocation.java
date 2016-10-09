package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant l'objet GeoLocation donnant les coordonnées d'une adresse.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class GeoLocation {

    /**
     * Latitude du lieu en degrés décimaux
     */
    @JsonProperty("lat")
    private double lat;

    /**
     * Longitude du lieu en degrés décimaux
     */
    @JsonProperty("lng")
    private double lng;

    /**
     * Constructeur principal
     *
     * @param lat Latitude du lieu en degrés décimaux
     * @param lng Longitude du lieu en degrés décimaux
     */
    @JsonCreator
    public GeoLocation(
            @JsonProperty("lat") double lat,
            @JsonProperty("lng") double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * @return la latitude du lieu en degrés décimaux
     */
    @JsonGetter("lat")
    public double getLat() {
        return lat;
    }

    /**
     * @param lat définit la latitude du lieu en degrés décimaux
     */
    @JsonSetter("lat")
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return la longitude du lieu en degrés décimaux
     */
    @JsonGetter("lng")
    public double getLng() {
        return lng;
    }

    /**
     * @param lng définit la longitude du lieu en degrés décimaux
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
