package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un événément.
 *
 * @author Thierry Baribaud
 * @version 0.35
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
    @JsonSubTypes.Type(value = TicketCancelled.class, name = "TicketCancelled"),
    @JsonSubTypes.Type(value = TicketUpdated.class, name = "TicketUpdated")
    })
public abstract class Event {

    /**
     * Liens entre entités
     */
//    @JsonProperty("_links")
//    private Links _links;
    /**
     * Identifiant unique de l'événement
     */
    private String processUid;

    /**
     * Identifiant unique de l'aggrégat auquel appartient l'événement
     */
    private String aggregateUid;

    /**
     * Date où l'événement s'est passé
     */
    private String date;

    /**
     * Date à laquelle l'événement a été envoyé
     */
    private String sentDate;

    /**
     * Type d'événement
     */
    private String eventType;

    /**
     * Identifiant du type d'événement
     */
    private int eventTypeUid;

    /**
     * Status de l'événement
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
     * @return l'dentifiant unique de l'événement
     */
    public String getProcessUid() {
        return processUid;
    }

    /**
     * @param processUid définit l'dentifiant unique de l'événement
     */
    public void setProcessUid(String processUid) {
        this.processUid = processUid;
    }

    /**
     * @return l'identifiant unique de l'aggrégat auquel appartient l'événement
     */
    public String getAggregateUid() {
        return aggregateUid;
    }

    /**
     * @param aggregateUid définit l'identifiant unique de l'aggrégat auquel
     * appartient l'événement
     */
    public void setAggregateUid(String aggregateUid) {
        this.aggregateUid = aggregateUid;
    }

    /**
     * @param date définit la date où l'événement s'est passé
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @param sentDate définit la date à laquelle l'événement a été envoyé
     */
    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * @return le type d'événement
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType définit le type d'événement
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * @return l'identifiant du type d'événement
     */
    public int getEventTypeUid() {
        return eventTypeUid;
    }

    /**
     * @param eventTypeUid définit l'identifiant du type d'événement
     */
    public void setEventTypeUid(int eventTypeUid) {
        this.eventTypeUid = eventTypeUid;
    }

    /**
     * @return la liste de liens entre entités
     */
//    @JsonGetter("_links")
//    public Links getLinks() {
//        return _links;
//    }
    /**
     * @param _links définit une liste de liens entre entités
     */
//    @JsonSetter("_links")
//    public void setLinks(Links _links) {
//        this._links = _links;
//    }
    /**
     * Ajoute un lien à la liste
     *
     * @param link lien à ajouter
     */
//    public void add(Link link) {
//        _links.add(link);
//    }
    /**
     * @return le status de l'événement
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status définit le status de l'événement
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
     * @param nbError définit le nombre d'erreur(s) de traitement
     */
    public void setNbError(int nbError) {
        this.nbError = nbError;
    }

    /**
     * @return la date où à eu lieu l'événement
     */
    public String getDate() {
        return date;
    }

    /**
     * @return la date d'envoi de l'événement
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
