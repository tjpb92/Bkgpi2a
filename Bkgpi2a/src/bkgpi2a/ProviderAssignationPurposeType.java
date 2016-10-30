package bkgpi2a;

/**
 * Enumération décrivant les types d'assignation d'intervenant à un ticket.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#providerassignationpurpose
 */
public enum ProviderAssignationPurposeType {

    RECOURSE_CHANGED("RecourseChanged"),
    PURPOSE("Purpose");

    /**
     * Type d'assignation d'intervenant à un ticket
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    ProviderAssignationPurposeType(String name) {
        this.name = name;
    }

    /**
     * @return le type d'assignation d'intervenant à un ticket
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
