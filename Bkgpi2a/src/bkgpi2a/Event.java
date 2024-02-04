package bkgpi2a;

import com.anstel.simplifiedrequest.SimplifiedRequestQualified;
import com.anstel.ticketEvents.AssigneeIdentified;
import com.anstel.ticketEvents.BackupAssigneeIdentified;
import com.anstel.ticketEvents.CallEmittedTo;
import com.anstel.ticketEvents.OpeningTicketPurposeCorrected;
import com.anstel.ticketEvents.TicketEventInformationsCorrected;
import com.anstel.ticketEvents.CallerCorrected;
import com.anstel.ticketEvents.ContactNotifiedOfSupport;
import com.anstel.ticketEvents.ContactToCallbackCorrected;
import com.anstel.ticketEvents.ProviderContactedChecked;
import com.anstel.ticketEvents.ProviderIsGoingChecked;
import com.anstel.ticketEvents.InterventionReportGottenFromResident;
import com.anstel.ticketEvents.InterventionReportGottenFromProvider;
import com.anstel.ticketEvents.MissionFinished;
import com.anstel.ticketEvents.TicketOpened;
import com.anstel.ticketEvents.TicketReopened;
import com.anstel.ticketEvents.TicketUpdated;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un événément.
 *
 * @author Thierry Baribaud
 * @version 1.42.23
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "eventType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TicketOpened.class, name = "TicketOpened"),
    @JsonSubTypes.Type(value = InterventionRequested.class, name = "InterventionRequested"),
    @JsonSubTypes.Type(value = TicketInformationsCorrected.class, name = "TicketInformationsCorrected"),
    @JsonSubTypes.Type(value = ProviderAssigned.class, name = "ProviderAssigned"),
    @JsonSubTypes.Type(value = ProviderContactDissociatedFromPatrimony.class, name = "ProviderContactDissociatedFromPatrimony"),
    @JsonSubTypes.Type(value = ProviderContactAssociatedWithPatrimony.class, name = "ProviderContactAssociatedWithPatrimony"),
    @JsonSubTypes.Type(value = AssigneeIdentified.class, name = "AssigneeIdentified"),
    @JsonSubTypes.Type(value = LogTrialAdded.class, name = "LogTrialAdded"),
    @JsonSubTypes.Type(value = PermanentlyFixed.class, name = "PermanentlyFixed"),
    @JsonSubTypes.Type(value = PartiallyFixed.class, name = "PartiallyFixed"),
    @JsonSubTypes.Type(value = TicketClosedImpossibleRepair.class, name = "TicketClosedImpossibleRepair"),
    @JsonSubTypes.Type(value = ClosedAfterSeveralUnsuccessfulRecalls.class, name = "ClosedAfterSeveralUnsuccessfulRecalls"),
    @JsonSubTypes.Type(value = ClosedBeyondCallCenterScope.class, name = "ClosedBeyondCallCenterScope"),
    @JsonSubTypes.Type(value = PostponedFix.class, name = "PostponedFix"),
    
    @JsonSubTypes.Type(value = MissionAccepted.class, name = "MissionAccepted"),    // Deprecated on 2018, September 8th.
    @JsonSubTypes.Type(value = InterventionAccepted.class, name = "InterventionAccepted"),
    
    @JsonSubTypes.Type(value = MissionRefused.class, name = "MissionRefused"),  // Deprecated on 2018, September 8th.
    @JsonSubTypes.Type(value = InterventionRefused.class, name = "InterventionRefused"),
    
    @JsonSubTypes.Type(value = ArrivedOnSite.class, name = "ArrivedOnSite"),
    @JsonSubTypes.Type(value = GoneFromSite.class, name = "GoneFromSite"),
    @JsonSubTypes.Type(value = CallAnsweredByProvider.class, name = "CallAnsweredByProvider"),
    @JsonSubTypes.Type(value = CallNotAnsweredByProvider.class, name = "CallNotAnsweredByProvider"),
    
    @JsonSubTypes.Type(value = MissionScheduled.class, name = "MissionScheduled"),  // Deprecated on 2018, September 8th.
    @JsonSubTypes.Type(value = InterventionScheduled.class, name = "InterventionScheduled"),
    
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
    @JsonSubTypes.Type(value = TicketUpdated.class, name = "TicketUpdated"),
    @JsonSubTypes.Type(value = NotificationForInterventionAcceptedRequested.class, name = "NotificationForInterventionAcceptedRequested"),
    @JsonSubTypes.Type(value = DocumentAttached.class, name = "DocumentAttached"),
    @JsonSubTypes.Type(value = InstructionsForAssigneeDefined.class, name = "InstructionsForAssigneeDefined"),
    @JsonSubTypes.Type(value = TicketOpenedFromSimplifiedRequest.class, name = "TicketOpenedFromSimplifiedRequest"),
    @JsonSubTypes.Type(value = TicketQualifiedByCriteria.class, name = "TicketQualifiedByCriteria"),
    @JsonSubTypes.Type(value = WorkflowAppliedToTicket.class, name = "WorkflowAppliedToTicket"),
    @JsonSubTypes.Type(value = ContextualCommentDisplayedOnTicket.class, name = "ContextualCommentDisplayedOnTicket"),
    @JsonSubTypes.Type(value = AccessRestrictedToTicket.class, name = "AccessRestrictedToTicket"),

    @JsonSubTypes.Type(value = TicketEventInformationsCorrected.class, name = "TicketEventInformationsCorrected"),
    @JsonSubTypes.Type(value = OpeningTicketPurposeCorrected.class, name = "OpeningTicketPurposeCorrected"),
    @JsonSubTypes.Type(value = CallerCorrected.class, name = "CallerCorrected"),
    @JsonSubTypes.Type(value = ProviderIsGoingChecked.class, name = "ProviderIsGoingChecked"),
    @JsonSubTypes.Type(value = ProviderContactedChecked.class, name = "ProviderContactedChecked"),
    @JsonSubTypes.Type(value = InterventionReportGottenFromResident.class, name = "InterventionReportGottenFromResident"),
    @JsonSubTypes.Type(value = InterventionReportGottenFromProvider.class, name = "InterventionReportGottenFromProvider"),
    @JsonSubTypes.Type(value = ContactToCallbackCorrected.class, name = "ContactToCallbackCorrected"),    
    @JsonSubTypes.Type(value = ContactNotifiedOfSupport.class, name = "ContactNotifiedOfSupport"),    
    @JsonSubTypes.Type(value = BackupAssigneeIdentified.class, name = "BackupAssigneeIdentified"),
    @JsonSubTypes.Type(value = MissionFinished.class, name = "MissionFinished"),

    @JsonSubTypes.Type(value = SimplifiedRequestQualified.class, name = "SimplifiedRequestQualified")
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
     * @return la date où a eu lieu l'événement
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
