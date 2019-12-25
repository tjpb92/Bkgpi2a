package bkgpi2a;

/**
 * Classe décrivant le résumé d'un moyen de liaison : son type et sa valeur.
 *
 * @author Thierry Baribaud
 * @version 1.30
 * @see https://performanceimmo.github.io/API/#contactmediumview
 */
public class ContactMediumView {

    /**
     * Type du moyen de liaison
     */
    private String mediumType;

    /**
     * Valeur du moyen de liaison TODO : trouver une meilleure définition plus
     * tard
     */
    private String identifier;

    /**
     * @return le type du moyen de liaison
     */
    public String getMediumType() {
        return mediumType;
    }

    /**
     * @param mediumType définit le type du moyen de liaison
     */
    public void setMediumType(String mediumType) {
        this.mediumType = mediumType;
    }

    /**
     * @return la valeur du moyen de liaison
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier définit la valeur du moyen de liaison
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("AgencyAbstract:{"
                + "mediumType:" + getMediumType()
                + ", identifier:" + getIdentifier()
                + "}");
    }
}
