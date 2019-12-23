package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe décrivant le contact ayant émis la demande d'intervention depuis l'application mobile
 *
 * @author Thierry Baribaud
 * @version 1.29
 * @see https://performanceimmo.github.io/API/#callerticketqueryview
 */
@JsonIgnoreProperties(value = {"medium", "category", "callerInfos", "status"})
public class CallerTicketQueryView {

    /**
     * Identifiant unique du contact
     */
    private String uid;

    /**
     * Nom du contact 
     */
    private String name;

    /**
     * Commentaire
     */
    private String comment;

    /**
     * @return l'identifiant unique du contact
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique du contact
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom du contact
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom du contact
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return le commentaire
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("CallerTicketQueryView:{"
                + "uid:" + getUid()
                + ", name:" + getName()
                + ", comment:" + getComment()
                + "}");
    }
}
