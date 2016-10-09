package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe décrivant le résumé d'une entité : son id et son nom.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class EntityAbstract {

    /**
     * Identifiant unique de l'entité
     */
    private String uid;

    /**
     * Nom de l'entité
     */
    private String label;

    /**
     * Constructeur principal de la classe
     * @param uid Identifiant unique de l'entité
     * @param label Nom de l'entité
     */
    @JsonCreator
    public EntityAbstract(
            @JsonProperty("uid") String uid, 
            @JsonProperty("label") String label) {
        this.uid = uid;
        this.label = label;
    }
    
    /**
     * @return l'identifiant unique de l'entité
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'entité
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de l'entité
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de l'entité
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", label:" + getLabel()
                + "}");
    }
}
