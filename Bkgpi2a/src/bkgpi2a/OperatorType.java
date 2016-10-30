package bkgpi2a;

/**
 * Enum�ration d�crivant les types d'op�rateur.
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
     * Type d'op�rateur
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    OperatorType(String name) {
        this.name = name;
    }

    /**
     * @return le type d'op�rateur
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
