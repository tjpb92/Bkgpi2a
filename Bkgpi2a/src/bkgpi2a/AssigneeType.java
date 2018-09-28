package bkgpi2a;

/**
 * Enumération décrivant les types d'individu assigné à un tiket.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/...
 */
public enum AssigneeType {

    /**
     * Fournisseur (carte de visite) référencé en base de données
     */
    REFERENCED_PROVIDER_CONTACT("ReferencedProviderContact"),
    /**
     * Individu non référencé en base de données
     */
    ANONYMOUS_ASSIGNEE("AnonymousAssignee"),
    /**
     * Fournisseur (société) référencée en base de données
     */
    REFERENCED_PROVIDER_COMPANY("ReferencedProviderCompany");

    /**
     * Type d'opérateur
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    AssigneeType(String name) {
        this.name = name;
    }

    /**
     * @return le type d'individu
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
