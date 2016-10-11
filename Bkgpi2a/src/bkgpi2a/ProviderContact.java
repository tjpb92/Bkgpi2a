package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe décrivant un intervenant
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
     * Liste de numéros de téléphone pour joindre le contact
     */
    @JsonUnwrapped
    private PhoneList phones;

    /**
     * Liste de numéros de fax pour joindre le contact
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
     * @param label définit le nom du contact.
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
     * @param uid définit l'identifiant unique du contact.
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return une liste de numéros de téléphone
     */
    public PhoneList getPhones() {
        return phones;
    }

    /**
     * @param phones définit une liste de numéros de téléphone.
     */
    public void setPhones(PhoneList phones) {
        this.phones = phones;
    }

    /**
     * @return une liste de numéros de fax
     */
    public FaxList getFax() {
        return fax;
    }

    /**
     * @param fax définit une liste de numéros de fax.
     */
    public void setFax(FaxList fax) {
        this.fax = fax;
    }

    /**
     * @return une liste de numéros de mails
     */
    public EmailList getEmails() {
        return emails;
    }

    /**
     * @param emails définit une liste de mails
     */
    public void setEmails(EmailList emails) {
        this.emails = emails;
    }

    /**
     * @return l'état d'activité du contact.
     */
    public boolean getActive() {
        return active;
    }

    /**
     * @param active définit l'état d'activité du contact.
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
