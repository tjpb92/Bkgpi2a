package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe décrivant un intervenant
 *
 * @author Thierry Baribaud
 * @version 0.47
 * @see http://performanceimmo.github.io/API/#providercontacts
 */
//@JsonPropertyOrder({"uid", "label", "phones", "fax", "emails", "active",})
public class ProviderContact {

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Identifiant unique du contact.
     */
    private String uid;

    /**
     * Identifiant unique de la société dans la base de données Anstel
     */
    @JsonIgnore
    private int id;

    /**
     * Nom du contact (ancienne représentation).
     */
    private String label;

    /**
     * Nom de l'appelant (nouvelle représentation).
     */
    private Name name;

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
     * @return la liste de liens entre entités
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links définit une liste de liens entre entités
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
     * @param label définit le nom du contact.
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
     * @param name définit le nom du contact.
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
     * Ajoute un lien à la liste
     *
     * @param link lien à ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * @return l'identifiant unique de la base de données Anstel
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * @param id définit l'identifiant unique de la base de données Anstel
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
