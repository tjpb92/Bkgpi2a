package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe d�crivant un intervenant
 *
 * @author Thierry Baribaud
 * @version 0.47
 * @see http://performanceimmo.github.io/API/#providercontacts
 */
//@JsonPropertyOrder({"uid", "label", "phones", "fax", "emails", "active",})
public class ProviderContact {

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Identifiant unique du contact.
     */
    private String uid;

    /**
     * Identifiant unique de la soci�t� dans la base de donn�es Anstel
     */
    @JsonIgnore
    private int id;

    /**
     * Nom du contact (ancienne repr�sentation).
     */
    private String label;

    /**
     * Nom de l'appelant (nouvelle repr�sentation).
     */
    private Name name;

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
     * @return la liste de liens entre entit�s
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links d�finit une liste de liens entre entit�s
     */
    @JsonSetter("_links")
    public void setLinks(Links _links) {
        this._links = _links;
    }

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
     * @return le nom du contact.
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name d�finit le nom du contact.
     */
    public void setName(Name name) {
        this.name = name;
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
     * Ajoute un lien � la liste
     *
     * @param link lien � ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * @return l'identifiant unique de la base de donn�es Anstel
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * @param id d�finit l'identifiant unique de la base de donn�es Anstel
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return les informations sur la filiale.
     */
    @Override
    public String toString() {
        return "ProviderContact:{"
                + "id:" + getId()
                + ", _links:" + getLinks()
                + ", uid:" + getUid()
                + ", label:" + getLabel()
                + ", name:" + getName()
                + ", phones:" + getPhones()
                + ", fax:" + getFax()
                + ", emails:" + getEmails()
                + ", active:" + getActive()
                + "}";
    }
}
