package bkgpi2a;

/**
 * Enum�ration d�crivant les types d'individu assign� � un tiket.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/...
 */
public enum AssigneeType {

    /**
     * Fournisseur (carte de visite) r�f�renc� en base de donn�es
     */
    REFERENCED_PROVIDER_CONTACT("ReferencedProviderContact"),
    /**
     * Individu non r�f�renc� en base de donn�es
     */
    ANONYMOUS_ASSIGNEE("AnonymousAssignee"),
    /**
     * Fournisseur (soci�t�) r�f�renc�e en base de donn�es
     */
    REFERENCED_PROVIDER_COMPANY("ReferencedProviderCompany");

    /**
     * Type d'op�rateur
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
