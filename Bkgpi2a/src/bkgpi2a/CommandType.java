package bkgpi2a;

/**
 * Enum�ration d�crivant les identifiants et libell�s des commandes.
 *
 * @author Thierry Baribaud
 * @version 0.48
 */
public enum CommandType {

    ASSOCIATE_PROVIDER_CONTACT_TO_COMPANY("AssociateProviderContactToCompany"),
    ASSOCIATE_PROVIDER_CONTACT_TO_AGENCY("AssociateProviderContactToAgency");

    /**
     * Type d'�v�nement
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    CommandType(String name) {
        this.name = name;
    }

    /**
     * @return le type d'�v�nement
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
