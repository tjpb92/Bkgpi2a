package bkgpi2a;

/**
 * Enumération décrivant les types d'intervenant.
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#provider
 */
public enum ProviderType {

    /**
     * Fournisseur référencé en base de données
     */
    REFERENCED_PROVIDER("ReferencedProvider"),
    /**
     * Fournisseur non référencé en base de données
     */
    ANONYMOUS_PROVIDER("AnonymousProvider");

    /**
     * Type d'intervenant
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    ProviderType(String name) {
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
