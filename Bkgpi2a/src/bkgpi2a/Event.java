package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite d�crivant un �v�n�ment.
 *
 * @author Thierry Baribaud
 * @version 0.40
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "eventType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TicketOpened.class, name = "TicketOpened"),
    @JsonSubTypes.Type(value = ProviderAssigned.class, name = "ProviderAssigned"),
    @JsonSubTypes.Type(value = LogTrialAdded.class, name = "LogTrialAdded"),
    @JsonSubTypes.Type(value = PermanentlyFixed.class, name = "PermanentlyFixed"),
    @JsonSubTypes.Type(value = PartiallyFixed.class, name = "PartiallyFixed"),
    @JsonSubTypes.Type(value = TicketClosedImpossibleRepair.class, name = "TicketClosedImpossibleRepair"),
    @JsonSubTypes.Type(value = ClosedAfterSeveralUnsuccessfulRecalls.class, name = "ClosedAfterSeveralUnsuccessfulRecalls"),
    @JsonSubTypes.Type(value = ClosedBeyondCallCenterScope.class, name = "ClosedBeyondCallCenterScope"),
    @JsonSubTypes.Type(value = PostponedFix.class, name = "PostponedFix"),
    @JsonSubTypes.Type(value = MissionAccepted.class, name = "MissionAccepted"),
    @JsonSubTypes.Type(value = MissionRefused.class, name = "MissionRefused"),
    @JsonSubTypes.Type(value = ArrivedOnSite.class, name = "ArrivedOnSite"),
    @JsonSubTypes.Type(value = GoneFromSite.class, name = "GoneFromSite"),
    @JsonSubTypes.Type(value = CallAnsweredByProvider.class, name = "CallAnsweredByProvider"),
    @JsonSubTypes.Type(value = CallNotAnsweredByProvider.class, name = "CallNotAnsweredByProvider"),
    @JsonSubTypes.Type(value = MissionScheduled.class, name = "MissionScheduled"),
    @JsonSubTypes.Type(value = InterventionStarted.class, name = "InterventionStarted"),
    @JsonSubTypes.Type(value = InterventionFinished.class, name = "InterventionFinished"),
    @JsonSubTypes.Type(value = ServiceOrderSent.class, name = "ServiceOrderSent"), // deprecated
    @JsonSubTypes.Type(value = SendingServiceOrderReported.class, name = "SendingServiceOrderReported"),
    @JsonSubTypes.Type(value = FormalNoticeForProviderReported.class, name = "FormalNoticeForProviderReported"),
    @JsonSubTypes.Type(value = InterventionDeadlineDefined.class, name = "InterventionDeadlineDefined"),
    @JsonSubTypes.Type(value = MessageAdded.class, name = "MessageAdded"),
    @JsonSubTypes.Type(value = CallEmittedTo.class, name = "CallEmittedTo"),
    @JsonSubTypes.Type(value = CallReceived.class, name = "CallReceived"),
    @JsonSubTypes.Type(value = TicketArchived.class, name = "TicketArchived"),
    @JsonSubTypes.Type(value = TicketReopened.class, name = "TicketReopened"),    
    @JsonSubTypes.Type(value = TicketClosed.class, name = "TicketClosed"),
    @JsonSubTypes.Type(value = TicketCancelled.class, name = "TicketCancelled"),
    @JsonSubTypes.Type(value = TicketUpdated.class, name = "TicketUpdated")
    })
public abstract class Event {

    /**
     * Liens entre entit�s
     */
//    @JsonProperty("_links")
//    private Links _links;
    /**
     * Identifiant unique de l'�v�nement
     */
    private String processUid;

    /**
     * Identifiant unique de l'aggr�gat auquel appartient l'�v�nement
     */
    private String aggregateUid;

    /**
     * Date o� l'�v�nement s'est pass�
     */
    private String date;

    /**
     * Date � laquelle l'�v�nement a �t� envoy�
     */
    private String sentDate;

    /**
     * Type d'�v�nement
     */
    private String eventType;

    /**
     * Identifiant du type d'�v�nement
     */
    private int eventTypeUid;

    /**
     * Status de l'�v�nement
     */
    private int status;

    /**
     * Nombre d'erreur(s) de traitement
     */
    private int nbError;

    /**
     * Constructeur de la classe Event
     */
    public Event() {
//        setLinks(new Links());
        setStatus(0);
        setNbError(0);
    }

    /**
     * @return l'dentifiant unique de l'�v�nement
     */
    public String getProcessUid() {
        return processUid;
    }

    /**
     * @param processUid d�finit l'dentifiant unique de l'�v�nement
     */
    public void setProcessUid(String processUid) {
        this.processUid = processUid;
    }

    /**
     * @return l'identifiant unique de l'aggr�gat auquel appartient l'�v�nement
     */
    public String getAggregateUid() {
        return aggregateUid;
    }

    /**
     * @param aggregateUid d�finit l'identifiant unique de l'aggr�gat auquel
     * appartient l'�v�nement
     */
    public void setAggregateUid(String aggregateUid) {
        this.aggregateUid = aggregateUid;
    }

    /**
     * @param date d�finit la date o� l'�v�nement s'est pass�
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @param sentDate d�finit la date � laquelle l'�v�nement a �t� envoy�
     */
    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * @return le type d'�v�nement
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType d�finit le type d'�v�nement
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * @return l'identifiant du type d'�v�nement
     */
    public int getEventTypeUid() {
        return eventTypeUid;
    }

    /**
     * @param eventTypeUid d�finit l'identifiant du type d'�v�nement
     */
    public void setEventTypeUid(int eventTypeUid) {
        this.eventTypeUid = eventTypeUid;
    }

    /**
     * @return la liste de liens entre entit�s
     */
//    @JsonGetter("_links")
//    public Links getLinks() {
//        return _links;
//    }
    /**
     * @param _links d�finit une liste de liens entre entit�s
     */
//    @JsonSetter("_links")
//    public void setLinks(Links _links) {
//        this._links = _links;
//    }
    /**
     * Ajoute un lien � la liste
     *
     * @param link lien � ajouter
     */
//    public void add(Link link) {
//        _links.add(link);
//    }
    /**
     * @return le status de l'�v�nement
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status d�finit le status de l'�v�nement
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return le nombre d'erreur(s) de traitement
     */
    public int getNbError() {
        return nbError;
    }

    /**
     * @param nbError d�finit le nombre d'erreur(s) de traitement
     */
    public void setNbError(int nbError) {
        this.nbError = nbError;
    }

    /**
     * @return la date o� a eu lieu l'�v�nement
     */
    public String getDate() {
        return date;
    }

    /**
     * @return la date d'envoi de l'�v�nement
     */
    public String getSentDate() {
        return sentDate;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Event:{"
                //                + "_links:" + getLinks()
                + "processUid:" + getProcessUid()
                + ", aggregateUid:" + getAggregateUid()
                + ", date:" + getDate()
                + ", sentDate:" + getSentDate()
                + ", eventType:" + getEventType()
                + ", eventTypeUid:" + getEventTypeUid()
                + ", status:" + getStatus()
                + ", nbError:" + getNbError()
                + "}";
    }
}
