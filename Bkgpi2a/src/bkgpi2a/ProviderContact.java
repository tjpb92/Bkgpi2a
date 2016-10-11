package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe d�crivant un intervenant
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"uid", "label", "phones", "fax", "emails", "active",})
public class ProviderContact {

    /**
     * Identifiant unique du contact.
     */
    private String uid;

    /**
     * Nom du contact.
     */
    private String label;

    /**
     * Liste de num�ros de t�l�phone pour joindre le contact
     */
    @JsonUnwrapped
    private PhoneList phones;

    /**
     * Liste de num�ros de fax pour joindre le contact
     */
    @JsonUnwrapped
    private FaxList fax;

    /**
     * Liste de mails pour joindre le contact
     */
    @JsonUnwrapped
    private EmailList emails;

    /**
     * Indique si le contact est actif ou pas.
     */
    private boolean active;

    /**
     * @return le nom du contact.
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label d�finit le nom du contact.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return l'identifiant unique du contact.
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique du contact.
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return une liste de num�ros de t�l�phone
     */
    public PhoneList getPhones() {
        return phones;
    }

    /**
     * @param phones d�finit une liste de num�ros de t�l�phone.
     */
    public void setPhones(PhoneList phones) {
        this.phones = phones;
    }

    /**
     * @return une liste de num�ros de fax
     */
    public FaxList getFax() {
        return fax;
    }

    /**
     * @param fax d�finit une liste de num�ros de fax.
     */
    public void setFax(FaxList fax) {
        this.fax = fax;
    }

    /**
     * @return une liste de num�ros de mails
     */
    public EmailList getEmails() {
        return emails;
    }

    /**
     * @param emails d�finit une liste de mails
     */
    public void setEmails(EmailList emails) {
        this.emails = emails;
    }

    /**
     * @return l'�tat d'activit� du contact.
     */
    public boolean getActive() {
        return active;
    }

    /**
     * @param active d�finit l'�tat d'activit� du contact.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return les informations sur la filiale.
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{"
                + "uid:" + getUid()
                + ", label:" + getLabel()
                + ", phones:" + getPhones()
                + ", fax:" + getFax()
                + ", emails:" + getEmails()
                + ", active:" + getActive()
                + "}");
    }
}
