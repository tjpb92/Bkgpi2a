package bkgpi2a;

/**
 * Enum�ration d�crivant les types d'op�rateur.
 *
 * @author Thierry Baribaud
 * @version 1.42.11
 * <A href="https://declarimmo-org.github.io/API/#operator">Operator</A>
 */
public enum OperatorType {

    /**
     * Op�rateur r�f�renc� en base de donn�es
     */
    REFERENCED_OPERATOR("ReferencedOperator"),

    /**
     * Op�rateur non r�f�renc� en base de donn�es
     */
    ANONYMOUS_OPERATOR("AnonymousOperator"),

    /**
     * Utilisateur r�f�renc� en base de donn�es
     */
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
