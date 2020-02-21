package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un SimplifiedRequestSearchView
 *
 * @author Thierry Baribaud
 * @version 1.33
 * @see https://performanceimmo.github.io/API/#simplifiedrequestsearchview
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimplifiedRequestSearchView {

    /**
     * Identifiant unique de la demande d'intervention émise depuis l'application mobile
     */
    private String uid;

    /**
     * Etat de la demande d'intervention émise depuis l'application mobile. 
     * Declared ou Seen ou Qualified
     */
    private String state;

    /**
     * Identifiant unique du ticket associé (s'il existe) à la demande d'intervention émise depuis l'application mobile
     */
    private String ticketUid;
    
    /**
     * Catégorie de la demande d'intervention émise depuis l'application mobile
     */
    private OtpCategory category;
    
    /**
     * Patrimoine d'où provient la demande d'intervention
     */
    private PatrimonyAbstract patrimony;
    
    /**
     * Date de la demande d'intervention
     */
    private String requestDate;

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;
    
    /**
     * @return l'identifiant unique de la demande d'intervention émise depuis l'application mobile
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la demande d'intervention émise depuis l'application mobile
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    /**
     * @return l'état de la demande d'intervention émise depuis l'application mobile
     */
    public String getState() {
        return state;
    }

    /**
     * @param state définit l'état de la demande d'intervention émise depuis l'application mobile
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * @return l'identifiant unique du ticket associé à la demande d'intervention émise depuis l'application mobile
     */
    public String getTicketUid() {
        return ticketUid;
    }

    /**
     * @param ticketUid définit l'identifiant unique du ticket associé à la demande d'intervention émise depuis l'application mobile
     */
    public void setTicketUid(String ticketUid) {
        this.ticketUid = ticketUid;
    }
    
    /**
     * @return la catégorie de la demande d'intervention émise depuis l'application mobile
     */
    public OtpCategory getCategory() {
        return category;
    }

    /**
     * @param category définit la catégorie de la demande d'intervention émise depuis l'application mobile
     */
    public void setCategory(OtpCategory category) {
        this.category = category;
    }
    
    /**
     * @return le patrimoine d'où provient la demande d'intervention
     */
    public PatrimonyAbstract getPatrimony() {
        return patrimony;
    }

    /**
     * @param patrimony définit le patrimoine d'où provient la demande d'intervention
     */
    public void setPatrimony(PatrimonyAbstract patrimony) {
        this.patrimony = patrimony;
    }
    
    /**
     * @return la date de la demande d'intervention
     */
    public String getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate définit la date de la demande d'intervention
     */
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

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
     * Ajoute un lien à la liste
     *
     * @param link lien à ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "SimplifiedRequestSearchView:{"
                + " uid:" + getUid()
                + ", state:" + getState()
                + ", ticketUid:" + getTicketUid()
                + ", category:" + getCategory()
                + ", patrimony:" + getPatrimony()
                + ", requestDate:" + getRequestDate()
                + ", _links:" + getLinks()
                + "}";
    }

}
