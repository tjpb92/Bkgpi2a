package bkgpi2a;

/**
 * Enum�ration sur les types de localisation
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#locationreference
 */
public enum LocationReferenceType {

    /**
     * R�f�rence de type Agence
     */
    AGENCY_LOCATION("AgencyLocation"),

    /**
     * R�f�rence de type Patrimoine
     */
    PATRIMONY_LOCATION("PatrimonyLocation");

    private String name = "";

    /**
     * Constructeur de l'enum�ration
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
     * @return le nom de l'�num�ration
     */
    @Override
    public String toString() {
        return name;
    }
}
