package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un SimplifiedRequestDetailedView
 *
 * @author Thierry Baribaud
 * @version 1.30
 * @see https://performanceimmo.github.io/API/#simplifiedrequestdetailedview
 */
@JsonIgnoreProperties(value = {"seen", "qualified"})
public class SimplifiedRequestDetailedView {

    /**
     * Identifiant unique de la demande d'intervention �mise depuis
     * l'application mobile
     */
    private String uid;

    /**
     * Etat de la demande d'intervention �mise depuis l'application mobile.
     * Declared ou Seen ou Qualified
     */
    private String state;

    /**
     * Cat�gorie de la demande d'intervention �mise depuis l'application mobile
     */
    private OtpCategory category;

    /**
     * Entit�es chain�es
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
     * Contact ayant �mis la demande d'intervention depuis l'application mobile
     */
    private CallerTicketQueryView requester;

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * @return l'identifiant unique de la demande d'intervention �mise depuis
     * l'application mobile
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de la demande d'intervention
     * �mise depuis l'application mobile
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return l'�tat de la demande d'intervention �mise depuis l'application
     * mobile
     */
    public String getState() {
        return state;
    }

    /**
     * @param state d�finit l'�tat de la demande d'intervention �mise depuis
     * l'application mobile
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return la cat�gorie de la demande d'intervention �mise depuis
     * l'application mobile
     */
    public OtpCategory getCategory() {
        return category;
    }

    /**
     * @param category d�finit la cat�gorie de la demande d'intervention �mise
     * depuis l'application mobile
     */
    public void setTicketUid(OtpCategory category) {
        this.category = category;
    }

    /**
     * @return les entit�es li�es
     */
    public LinkedEntities getLinkedEntities() {
        return linkedEntities;
    }

    /**
     * @param linkedEntities les entit�es li�es
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
     * @param requestDate d�finit la date de la demande d'intervention
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
     * @param description d�finit le descriptif de la demande
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return le contact � l'origine de la demande
     */
    public CallerTicketQueryView getRequester() {
        return requester;
    }

    /**
     * @param requester d�finit le contact � l'origine de la demande
     */
    public void setRequester(CallerTicketQueryView requester) {
        this.requester = requester;
    }

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
     * Ajoute un lien � la liste
     *
     * @param link lien � ajouter
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
