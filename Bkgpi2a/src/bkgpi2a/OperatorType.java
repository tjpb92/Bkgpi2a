package bkgpi2a;

/**
 * Enumération décrivant les types d'opérateur.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#operator
 */
public enum OperatorType {

    REFERENCED_OPERATOR("ReferencedOperator"),
    ANONYMOUS_OPERATOR("AnonymousOperator"),
    REFERENCED_USER("ReferencedUser");

    /**
     * Type d'opérateur
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    OperatorType(String name) {
        this.name = name;
    }

    /**
     * @return le type d'opérateur
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
