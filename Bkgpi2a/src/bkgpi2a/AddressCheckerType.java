package bkgpi2a;

/**
 * Enum�ration d�crivant les types de v�rificateurs d'adresses.
 *
 * @author Thierry Baribaud
 * @version 1.11
 * @see http://performanceimmo.github.io/API/#addresschecker
 */
public enum AddressCheckerType {

    /**
     * Identifiant v�rifi� par l'API de Google Maps
     */
    GOOGLE_PLACE_ID_CHECKER("GooglePlaceIdChecker "),

    /**
     * Identifiant v�rifi� par l'API de data.gouv.fr
     */
    DATA_GOUV_API_ID_CHECKER("DataGouvAPIIdChecker");

    /**
     * Type de v�rificateur d'adresses
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    AddressCheckerType(String name) {
        this.name = name;
    }

    /**
     * @return le type de v�rificateur d'adresses
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
