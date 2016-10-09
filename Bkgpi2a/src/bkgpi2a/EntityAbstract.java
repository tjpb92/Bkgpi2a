package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe d�crivant le r�sum� d'une entit� : son id et son nom.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class EntityAbstract {

    /**
     * Identifiant unique de l'entit�
     */
    private String uid;

    /**
     * Nom de l'entit�
     */
    private String label;

    /**
     * Constructeur principal de la classe
     * @param uid Identifiant unique de l'entit�
     * @param label Nom de l'entit�
     */
    @JsonCreator
    public EntityAbstract(
            @JsonProperty("uid") String uid, 
            @JsonProperty("label") String label) {
        this.uid = uid;
        this.label = label;
    }
    
    /**
     * @return l'identifiant unique de l'entit�
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de l'entit�
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de l'entit�
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label d�finit le nom de l'entit�
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
