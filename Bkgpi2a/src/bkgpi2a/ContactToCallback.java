package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant le contact � rappeler
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contacttocallback
 */
@JsonTypeName("ContactToCallback")
public class ContactToCallback {

    /**
     * Nom du contact � rappeler
     */
    private Name name;

    /**
     * Type de medium
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContactMedium medium;

    /**
     * Date de rappel
     */
    private String availability;
    /**
     * Commentaire
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur principal de la classe ContactToCallback
     */
    public ContactToCallback() {
    }

    /**
     * @return le nom du contact � rappeler
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name d�finit le nom du contact � rappeler
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return le moyen de liaison
     */
    public ContactMedium getMedium() {
        return medium;
    }

    /**
     * @param medium d�finit le moyen de liaison
     */
    public void setMedium(ContactMedium medium) {
        this.medium = medium;
    }

    /**
     * @return la date de rappel
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * @param availability d�finit la date de rappel
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * @return le commentaire
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment d�finit le commentaire
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ContactToCallback:{"
                + super.toString()
                + ", name:" + getName()
                + ", medium:" + getMedium()
                + ", availability:" + getAvailability()
                + ", comment:" + getComment()
                + "}";
    }
}
