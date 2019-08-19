package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe décrivant un intervenant
 *
 * @author Thierry Baribaud
 * @version 1.17
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
     * Identifiant unique de la société (ProviderContact).
     */
    private String uid;

    /**
     * Identifiant unique de la société dans la base de données Anstel
     */
    @JsonIgnore
    private int id;

    /**
     * Nom de la société (ancienne représentation).
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String label;

    /**
     * Nom de de la société (nouvelle représentation).
     */
    private Name name;
    
    /**
     * Référence à la société (ProviderCompany)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProviderCompanyInContact providerCompany;
    
    /**
     * Liste des activité de la société (ProviderContact)
     */
    private ProviderContactActivityList activities;
    
    /**
     * Références vers les patrimoines associés
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ItemAbstractWithRefList patrimonies;
    
    /**
     * Référence au client (ClientCompany)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ItemAbstract company;

    /**
     * Liste de numéros de téléphone pour joindre de la société
     */
    @JsonUnwrapped
    private PhoneList phones;

    /**
     * Liste de numéros de fax pour joindre de la société
     */
    @JsonUnwrapped
    private FaxList fax;

    /**
     * Liste de mails pour joindre de la société
     */
    @JsonUnwrapped
    private EmailList emails;

    /**
     * Indique si de la société est active ou pas.
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
     * @return le nom de la société
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de la société
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return le nom de la société
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name définit le nom de la société
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return l'identifiant unique de la société
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la société
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return la référence à la société (ProviderCompany)
     */
    public ProviderCompanyInContact getProviderCompany() {
        return providerCompany;
    }

    /**
     * @param providerCompanyInContact définit la référence à la société (ProviderCompany)
     */
    public void setProviderCompany(ProviderCompanyInContact providerCompanyInContact) {
        this.providerCompany = providerCompanyInContact;
    }

    /**
     * @return the activities
     */
    public ProviderContactActivityList getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(ProviderContactActivityList activities) {
        this.activities = activities;
    }

    /**
     * @return la liste des réfences vers les patrimoines associés
     */
    public ItemAbstractWithRefList getPatrimonies() {
        return patrimonies;
    }

    /**
     * @param patrimonies définit la liste des réfences vers les patrimoines associés
     */
    public void setPatrimonies(ItemAbstractWithRefList patrimonies) {
        this.patrimonies = patrimonies;
    }

    /**
     * @return la référence au client (ClientCompany)
     */
    public ItemAbstract getCompany() {
        return company;
    }

    /**
     * @param company définit la référence au client (ClientCompany)
     */
    public void setCompany(ItemAbstract company) {
        this.company = company;
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
     * @return l'état d'activité de la société
     */
    public boolean getActive() {
        return active;
    }

    /**
     * @param active définit l'état d'activité de la société
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
     * @return les informations sur la société.
     */
    @Override
    public String toString() {
        return "ProviderContact:{"
                + "id:" + getId()
                + ", _links:" + getLinks()
                + ", uid:" + getUid()
                + ", label:" + getLabel()
                + ", name:" + getName()
                + ", providerCompany:" + getProviderCompany()
                + ", activities:" + getActivities()
                + ", patrimonies:" + getPatrimonies()
                + ", company:" + getCompany()
                + ", phones:" + getPhones()
                + ", fax:" + getFax()
                + ", emails:" + getEmails()
                + ", active:" + getActive()
                + "}";
    }
}
