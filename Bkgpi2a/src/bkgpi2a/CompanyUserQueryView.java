package pi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant une vue réduite d'un utilisateur d'une société
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class CompanyUserQueryView {

    /**
     * Identifiant unique de l'utilisateur d'une société
     */
    private String uid;

    /**
     * Nom de l'utilisateur d'une société
     */
    private String label;

    /**
     * Constructeur principal de la classe
     *
     * @param uid Identifiant unique de l'utilisateur d'une société
     * @param label Nom de l'utilisateur d'une société
     */
    public CompanyUserQueryView(String uid, String label) {
        this.uid = uid;
        this.label = label;
    }

    /**
     * @return l'identifiant unique de l'utilisateur d'une société
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'utilisateur d'une société
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de l'utilisateur d'une société
     */
    @JsonGetter("label")
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de l'utilisateur d'une société
     */
    @JsonSetter("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return les informations sur l'utilisateur d'une société.
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", label:" + getLabel()
                + "}");
    }
}
