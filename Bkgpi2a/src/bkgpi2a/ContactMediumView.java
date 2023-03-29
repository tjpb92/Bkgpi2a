package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe d�crivant le r�sum� d'un moyen de liaison : son type et sa valeur.
 *
 * @author Thierry Baribaud
 * @version 1.42
 * @see https://performanceimmo.github.io/API/#contactmediumview
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactMediumView {

    /**
     * Type du moyen de liaison
     */
    private String mediumType;

    /**
     * Valeur du moyen de liaison TODO : trouver une meilleure d�finition plus
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
     * @param mediumType d�finit le type du moyen de liaison
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
     * @param identifier d�finit la valeur du moyen de liaison
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("ContactMediumView:{"
                + "mediumType:" + getMediumType()
                + ", identifier:" + getIdentifier()
                + "}");
    }
}
