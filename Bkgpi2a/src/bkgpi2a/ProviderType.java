package bkgpi2a;

/**
 * Enumération décrivant les types d'intervenant.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#provider
 */
public enum ProviderType {

    REFERENCED_PROVIDER("ReferencedProvider"),
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
