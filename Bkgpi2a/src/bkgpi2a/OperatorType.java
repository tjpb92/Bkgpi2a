package bkgpi2a;

/**
 * Enumération décrivant les types d'opérateur.
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#operator
 */
public enum OperatorType {

    /**
     * Opérateur référencé en base de données
     */
    REFERENCED_OPERATOR("ReferencedOperator"),

    /**
     * Opérateur non référencé en base de données
     */
    ANONYMOUS_OPERATOR("AnonymousOperator"),

    /**
     * Utilisateur référencé en base de données
     */
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
