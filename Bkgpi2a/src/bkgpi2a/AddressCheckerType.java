package bkgpi2a;

/**
 * Enumération décrivant les types de vérificateurs d'adresses.
 *
 * @author Thierry Baribaud
 * @version 1.11
 * @see http://performanceimmo.github.io/API/#addresschecker
 */
public enum AddressCheckerType {

    /**
     * Identifiant vérifié par l'API de Google Maps
     */
    GOOGLE_PLACE_ID_CHECKER("GooglePlaceIdChecker "),

    /**
     * Identifiant vérifié par l'API de data.gouv.fr
     */
    DATA_GOUV_API_ID_CHECKER("DataGouvAPIIdChecker");

    /**
     * Type de vérificateur d'adresses
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    AddressCheckerType(String name) {
        this.name = name;
    }

    /**
     * @return le type de vérificateur d'adresses
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
