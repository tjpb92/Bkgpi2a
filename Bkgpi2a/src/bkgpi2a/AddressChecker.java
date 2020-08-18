package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe abstraite décrivant un vérificateur d'adresses
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see <A href="http://performanceimmo.github.io/API/#addresschecker">AddressChecker</A>
 */
//@JsonSubTypes({
//    @JsonSubTypes.Type(value = DataGouvAPIIdChecker.class, name = "DataGouvAPIIdChecker"),
//    @JsonSubTypes.Type(value = GooglePlaceIdChecker.class, name = "GooglePlaceIdChecker"),})
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressChecker {

    /**
     * Type de vérificateur
     */
    private String addressCheckerType;

    /**
     * Constructeur principal de la classe AddressChecker
     */
    public AddressChecker() {
    }

    /**
     * @return the addressCheckerType
     */
    public String getAddressCheckerType() {
        return addressCheckerType;
    }

    /**
     * @param addressCheckerType the addressCheckerType to set
     */
    public void setAddressCheckerType(String addressCheckerType) {
        this.addressCheckerType = addressCheckerType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AddressChecker:{"
                + "addressCheckerType:" + getAddressCheckerType()
                + "}";
    }

}
