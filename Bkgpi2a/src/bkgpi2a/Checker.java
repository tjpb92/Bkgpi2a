package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant l'objet Checker
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class Checker {

    @JsonProperty("googlePlaceId")
    private String googlePlaceId;

    /**
     * Constructeur principal
     *
     * @param googlePlaceId identifiant du lieu par Google
     */
    public Checker(
            @JsonProperty("googlePlaceId") String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    /**
     * @return l'identifiant du lieu par Google
     */
    @JsonGetter("googlePlaceId")
    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    /**
     * @param GooglePlaceId d�finit l'identifiant du lieu par Google
     */
    @JsonSetter("googlePlaceId")
    public void setGooglePlaceId(String GooglePlaceId) {
        this.googlePlaceId = GooglePlaceId;
    }

    /**
     * @return l'objet Checker sous forme textuelle.
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{GooglePlaceId:" + getGooglePlaceId()
                + "}");
    }
}
