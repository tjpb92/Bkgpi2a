package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant une vue réduite d'un utilisateur d'une agence
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class AgencyUserQueryView {

    /**
     * Identifiant unique de l'utillisateur d'une agence
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Nom de l'utillisateur d'une agence
     */
    @JsonProperty("label")
    private String label;

    /**
     * Constructeur principal de la classe
     *
     * @param uid Identifiant unique de l'utillisateur d'une agence
     * @param label Nom de l'utillisateur d'une agence
     */
    @JsonCreator
    public AgencyUserQueryView(
            @JsonProperty("uid") String uid, 
            @JsonProperty("label") String label) {
        this.uid = uid;
        this.label = label;
    }

    /**
     * @return l'identifiant unique de l'utillisateur d'une agence
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'utillisateur d'une agence
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de l'utillisateur d'une agence
     */
    @JsonGetter("label")
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de l'utillisateur d'une agence
     */
    @JsonSetter("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return les informations sur l'utillisateur d'une agence.
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", label:" + getLabel()
                + "}");
    }
}
