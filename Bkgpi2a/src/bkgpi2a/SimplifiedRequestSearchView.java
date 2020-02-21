package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un SimplifiedRequestSearchView
 *
 * @author Thierry Baribaud
 * @version 1.33
 * @see https://performanceimmo.github.io/API/#simplifiedrequestsearchview
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimplifiedRequestSearchView {

    /**
     * Identifiant unique de la demande d'intervention �mise depuis l'application mobile
     */
    private String uid;

    /**
     * Etat de la demande d'intervention �mise depuis l'application mobile. 
     * Declared ou Seen ou Qualified
     */
    private String state;

    /**
     * Identifiant unique du ticket associ� (s'il existe) � la demande d'intervention �mise depuis l'application mobile
     */
    private String ticketUid;
    
    /**
     * Cat�gorie de la demande d'intervention �mise depuis l'application mobile
     */
    private OtpCategory category;
    
    /**
     * Patrimoine d'o� provient la demande d'intervention
     */
    private PatrimonyAbstract patrimony;
    
    /**
     * Date de la demande d'intervention
     */
    private String requestDate;

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;
    
    /**
     * @return l'identifiant unique de la demande d'intervention �mise depuis l'application mobile
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de la demande d'intervention �mise depuis l'application mobile
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    /**
     * @return l'�tat de la demande d'intervention �mise depuis l'application mobile
     */
    public String getState() {
        return state;
    }

    /**
     * @param state d�finit l'�tat de la demande d'intervention �mise depuis l'application mobile
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * @return l'identifiant unique du ticket associ� � la demande d'intervention �mise depuis l'application mobile
     */
    public String getTicketUid() {
        return ticketUid;
    }

    /**
     * @param ticketUid d�finit l'identifiant unique du ticket associ� � la demande d'intervention �mise depuis l'application mobile
     */
    public void setTicketUid(String ticketUid) {
        this.ticketUid = ticketUid;
    }
    
    /**
     * @return la cat�gorie de la demande d'intervention �mise depuis l'application mobile
     */
    public OtpCategory getCategory() {
        return category;
    }

    /**
     * @param category d�finit la cat�gorie de la demande d'intervention �mise depuis l'application mobile
     */
    public void setCategory(OtpCategory category) {
        this.category = category;
    }
    
    /**
     * @return le patrimoine d'o� provient la demande d'intervention
     */
    public PatrimonyAbstract getPatrimony() {
        return patrimony;
    }

    /**
     * @param patrimony d�finit le patrimoine d'o� provient la demande d'intervention
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
     * @param requestDate d�finit la date de la demande d'intervention
     */
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
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
