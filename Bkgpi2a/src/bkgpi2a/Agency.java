package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe d�crivant une agence.
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
     * Etat d'activit� de l'agence
     */
    private boolean active;

    /**
     * Adresse de l'agence
     */
    @JsonIgnoreProperties({"uid"})
    private RationalAddress address;

    /**
     * Compagnie dont d�pend l'agence
     */
    private EntityAbstract company;

    /**
     * Liste de emails pour joindre l'agence
     */
    @JsonUnwrapped
    private EmailList emails;

    /**
     * Liste de t�l�phone pour joindre l'agence
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
     * @param uid d�finit l'identifiant unique de l'agence
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return l'�tat d'activit� de l'agence
     */
    public boolean getActive() {
        return active;
    }

    /**
     * @param active d�finit l'�tat d'activit� de l'agence
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
     * @param address d�finit les adresses de l'agence
     */
    public void setAddress(RationalAddress address) {
        this.address = address;
    }

    /**
     * @return la soci�t� dont d�pend l'agence
     */
    public EntityAbstract getCompany() {
        return company;
    }

    /**
     * @param company d�finit la soci�t� dont d�pend l'agence
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
     * @param emails d�finit la liste des mails pour contacter l'agence
     */
    public void setEmails(EmailList emails) {
        this.emails = emails;
    }

    /**
     * @return la liste des num�ros de t�l�phone pour contacter l'agence
     */
    public PhoneList getPhones() {
        return phones;
    }

    /**
     * @param phones d�finit la liste des num�ros de t�l�phone pour contacter
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
     * @param fax d�finit le fax pour contacter l'agence
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * R�f�rence � l'agence
     */
    private String ref;

    /**
     * @return la r�f�rence de l'agence
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref d�finit la r�f�rence de l'agence
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
     * @param label d�finit le nom de l'agence
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
