package bkgpi2a;

/**
 * Enumération sur les types de localisation
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#locationreference
 */
public enum LocationReferenceType {

    /**
     * Référence de type Agence
     */
    AGENCY_LOCATION("AgencyLocation"),

    /**
     * Référence de type Patrimoine
     */
    PATRIMONY_LOCATION("PatrimonyLocation");

    private String name = "";

    /**
     * Constructeur de l'enumération
     */
    LocationReferenceType(String name) {
        this.name = name;
    }

    /**
     * @return le type d'appelant
     */
    public String getName() {
        return name;
    }

    /**
     * @return le nom de l'énumération
     */
    @Override
    public String toString() {
        return name;
    }
}
