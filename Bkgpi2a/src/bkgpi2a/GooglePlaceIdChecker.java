package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe décrivant l'objet GooglePlaceIdChecker
 *
 * @author Thierry Baribaud
 * @version 1.11
 * @see http://performanceimmo.github.io/API/#addresschecker
 */
@JsonIgnoreProperties({"addressCheckerType"})
public class GooglePlaceIdChecker extends AddressChecker {

//    private String googlePlaceId;

    /**
     * Constructeur principal
     */
    public GooglePlaceIdChecker() {
    }

    /**
     * @return l'identifiant du lieu par Google
     */
    public String getGooglePlaceId() {
//        return googlePlaceId;
        return getAddressCheckerType();
    }

    /**
     * @param googlePlaceId définit l'identifiant du lieu par Google
     */
    public void setGooglePlaceId(String googlePlaceId) {
//        this.googlePlaceId = googlePlaceId;
        setAddressCheckerType(googlePlaceId);
    }

    /**
     * @return l'objet Checker sous forme textuelle.
     */
    @Override
    public String toString() {
        return "GooglePlaceIdChecker:{"
                + "googlePlaceId:" + getGooglePlaceId()
                + "}";
    }
}
