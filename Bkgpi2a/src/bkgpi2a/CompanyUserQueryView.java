package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant une vue r�duite d'un utilisateur d'une soci�t�
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class CompanyUserQueryView {

    /**
     * Identifiant unique de l'utilisateur d'une soci�t�
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Nom de l'utilisateur d'une soci�t�
     */
    @JsonProperty("label")
    private String label;

    /**
     * Constructeur principal de la classe
     *
     * @param uid Identifiant unique de l'utilisateur d'une soci�t�
     * @param label Nom de l'utilisateur d'une soci�t�
     */
    @JsonCreator
    public CompanyUserQueryView(
            @JsonProperty("uid") String uid, 
            @JsonProperty("label") String label) {
        this.uid = uid;
        this.label = label;
    }

    /**
     * @return l'identifiant unique de l'utilisateur d'une soci�t�
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de l'utilisateur d'une soci�t�
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de l'utilisateur d'une soci�t�
     */
    @JsonGetter("label")
    public String getLabel() {
        return label;
    }

    /**
     * @param label d�finit le nom de l'utilisateur d'une soci�t�
     */
    @JsonSetter("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return les informations sur l'utilisateur d'une soci�t�.
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", label:" + getLabel()
                + "}");
    }
}
