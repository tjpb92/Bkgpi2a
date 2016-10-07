package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant l'objet Checker
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class Checker {

    private String googlePlaceId;

    /**
     * Constructeur principal
     * @param googlePlaceId
     */
    public Checker(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }
    /**
     * @return the googlePlaceId
     */
    @JsonGetter("googlePlaceId")
    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    /**
     * @param GooglePlaceId the googlePlaceId to set
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
