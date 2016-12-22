package bkgpi2a;

/**
 * Enum�ration d�crivant les types d'intervenant.
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#name
 */
public enum NameType {

    /**
     * Nom peu qualifi�, pauvre en information
     */
    POOR_NAME("PoorName"),

    /**
     * Nom bien qualifi�, riche en informations
     */
    CIVIL_NAME("CivilName");

    /**
     * Type d'intervenant
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    NameType(String name) {
        this.name = name;
    }

    /**
     * @return le type d'intervenant
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
