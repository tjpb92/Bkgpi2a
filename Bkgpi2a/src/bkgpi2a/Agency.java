package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe décrivant une agence.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"active", "address", "company", "emails", "fax", "label", "phones", "ref", "uid"})
public class Agency {

    /**
     * Identifiant unique de l'agence
     */
    private String uid;

    /**
     * Nom de l'agence
     */
    private String label;

//    /**
//     * Identifiant et nom de l'agence
//     */
//    @JsonUnwrapped
//    @JsonIgnoreProperties({"name"})
//    private EntityAbstract agencyAbstract;
    /**
     * Etat d'activité de l'agence
     */
    private boolean active;

    /**
     * Adresse de l'agence
     */
    @JsonIgnoreProperties({"uid"})
    private RationalAddress address;

    /**
     * Compagnie dont dépend l'agence
     */
    private EntityAbstract company;

    /**
     * Liste de emails pour joindre l'agence
     */
    @JsonUnwrapped
    private EmailList emails;

    /**
     * Liste de téléphone pour joindre l'agence
     */
    @JsonUnwrapped
    private PhoneList phones;

    /**
     * Fax de l'agence
     */
    private String fax;

//    /**
//     * @return the agencyAbstract
//     */
//    public EntityAbstract getAgencyAbstract() {
//        return agencyAbstract;
//    }
//    /**
//     * @param agencyAbstract the agencyAbstract to set
//     */
//    public void setAgencyAbstract(EntityAbstract agencyAbstract) {
//        this.agencyAbstract = agencyAbstract;
//    }
    /**
     * @return l'identifiant unique de l'agence
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'agence
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return l'état d'activité de l'agence
     */
    public boolean getActive() {
        return active;
    }

    /**
     * @param active définit l'état d'activité de l'agence
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return les adresses de l'agence
     */
    public RationalAddress getAddress() {
        return address;
    }

    /**
     * @param address définit les adresses de l'agence
     */
    public void setAddress(RationalAddress address) {
        this.address = address;
    }

    /**
     * @return la société dont dépend l'agence
     */
    public EntityAbstract getCompany() {
        return company;
    }

    /**
     * @param company définit la société dont dépend l'agence
     */
    public void setCompany(EntityAbstract company) {
        this.company = company;
    }

    /**
     * @return la liste des mails pour contacter l'agence
     */
    public EmailList getEmails() {
        return emails;
    }

    /**
     * @param emails définit la liste des mails pour contacter l'agence
     */
    public void setEmails(EmailList emails) {
        this.emails = emails;
    }

    /**
     * @return la liste des numéros de téléphone pour contacter l'agence
     */
    public PhoneList getPhones() {
        return phones;
    }

    /**
     * @param phones définit la liste des numéros de téléphone pour contacter
     * l'agence
     */
    public void setPhones(PhoneList phones) {
        this.phones = phones;
    }

    /**
     * @return le fax pour contacter l'agence
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax définit le fax pour contacter l'agence
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Référence à l'agence
     */
    private String ref;

    /**
     * @return la référence de l'agence
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref définit la référence de l'agence
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return le nom de l'agence
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de l'agence
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{"
                + "active:" + getActive()
                + ", address:" + getAddress()
                + ", company:" + getCompany()
                + ", mails:" + getEmails()
                + ", fax:" + getFax()
                + ", phones:" + getPhones()
                + ", uid:" + getUid()
                //                + ", name:" + getAgencyAbstract().getName()
                + "}");
    }
}
