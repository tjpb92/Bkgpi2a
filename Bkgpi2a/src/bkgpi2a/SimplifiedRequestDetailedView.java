package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un SimplifiedRequestDetailedView
 *
 * @author Thierry Baribaud
 * @version 1.30
 * @see https://performanceimmo.github.io/API/#simplifiedrequestdetailedview
 */
@JsonIgnoreProperties(value = {"seen", "qualified"})
public class SimplifiedRequestDetailedView {

    /**
     * Identifiant unique de la demande d'intervention émise depuis
     * l'application mobile
     */
    private String uid;

    /**
     * Etat de la demande d'intervention émise depuis l'application mobile.
     * Declared ou Seen ou Qualified
     */
    private String state;

    /**
     * Catégorie de la demande d'intervention émise depuis l'application mobile
     */
    private OtpCategory category;

    /**
     * Entitées chainées
     */
    private LinkedEntities linkedEntities;

    /**
     * Date de la demande d'intervention
     */
    private String requestDate;

    /**
     * Description de la demande
     */
    private String description;

    /**
     * Contact ayant émis la demande d'intervention depuis l'application mobile
     */
    private CallerTicketQueryView requester;

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * @return l'identifiant unique de la demande d'intervention émise depuis
     * l'application mobile
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la demande d'intervention
     * émise depuis l'application mobile
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return l'état de la demande d'intervention émise depuis l'application
     * mobile
     */
    public String getState() {
        return state;
    }

    /**
     * @param state définit l'état de la demande d'intervention émise depuis
     * l'application mobile
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return la catégorie de la demande d'intervention émise depuis
     * l'application mobile
     */
    public OtpCategory getCategory() {
        return category;
    }

    /**
     * @param category définit la catégorie de la demande d'intervention émise
     * depuis l'application mobile
     */
    public void setTicketUid(OtpCategory category) {
        this.category = category;
    }

    /**
     * @return les entitées liées
     */
    public LinkedEntities getLinkedEntities() {
        return linkedEntities;
    }

    /**
     * @param linkedEntities les entitées liées
     */
    public void setLinkedEntities(LinkedEntities linkedEntities) {
        this.linkedEntities = linkedEntities;
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
     * @return le descriptif de la demande
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description définit le descriptif de la demande
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return le contact à l'origine de la demande
     */
    public CallerTicketQueryView getRequester() {
        return requester;
    }

    /**
     * @param requester définit le contact à l'origine de la demande
     */
    public void setRequester(CallerTicketQueryView requester) {
        this.requester = requester;
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
        return "SimplifiedRequestDetailedView:{"
                + " uid:" + getUid()
                + ", state:" + getState()
                + ", category:" + getCategory()
                + ", linkedEntities:" + getLinkedEntities()
                + ", requestDate:" + getRequestDate()
                + ", description:" + getDescription()
                + ", requester:" + getRequester()
                + ", _links:" + getLinks()
                + "}";
    }

}
