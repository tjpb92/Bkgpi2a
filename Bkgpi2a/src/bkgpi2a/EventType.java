package bkgpi2a;

/**
 * Enumération décrivant les identifiants et libellés des événements.
 *
 * @author Thierry Baribaud
 * @version 1.31
 */
public enum EventType {

    PROVIDER_CONTACT_ASSOCIATED_WITH_PATRIMONY("ProviderContactAssociatedWithPatrimony ", 470),
    PROVIDER_CONTACT_DISSOCIATED_FROM_PATRIMONY("ProviderContactDissociatedFromPatrimony", 475),

    TICKET_OPENED("TicketOpened", 500),
    INTERVENTION_REQUESTED("InterventionRequested", 503),
    TICKET_INFORMATIONS_CORRECTED("TicketInformationsCorrected", 504),
    
    MISSION_ACCEPTED("MissionAccepted", 505),   // Deprecated on 2018, September 8th, see INTERVENTION_ACCEPTED 
    INTERVENTION_ACCEPTED("InterventionAccepted", 505),
    
    TICKET_UPDATED("TicketUpdated", 510),
    
    PROVIDER_ASSIGNED("ProviderAssigned", 515), // Deprecated on 2018, September 8th, see ASSIGNEE_IDENTIFIED
    ASSIGNEE_IDENTIFIED("AssigneeIdentified", 515),
    
    MISSION_REFUSED("MissionRefused", 520),     // Deprecated on 2018, September 8th, see INTERVENTION_REFUSED
    INTERVENTION_REFUSED("InterventionRefused", 520),
    
    ARRIVED_ON_SITE("ArrivedOnSite", 525),
    GONE_FROM_SITE("GoneFromSite", 530),
    INTERVENTION_STARTED("InterventionStarted", 532),
    INTERVENTION_FINISHED("InterventionFinished", 534),
    PERMANENTLY_FIXED("PermanentlyFixed", 535),
    PARTIALLY_FIXED("PartiallyFixed", 540),
    TICKET_CLOSED_IMPOSSIBLE_REPAIR("TicketClosedImpossibleRepair", 545),
    POSTPONED_FIX("PostponedFix", 550),
    CLOSED_BEYOND_CALL_CENTER_SCOPE("ClosedBeyondCallCenterScope", 555),
    CLOSED_AFTER_SEVERAL_UNSUCCESSFUL_RECALLS("ClosedAfterSeveralUnsuccessfulRecalls", 560),
    TICKET_CLOSED("TicketClosed", 561),
    
    CLOSED_QUOTE_REQUESTED("ClosedQuoteRequested", 563),
    
    LOG_TRIAL_ADDED("LogTrialAdded", 565),
    MESSAGE_ADDED("MessageAdded", 570),
    TICKET_REOPENED("TicketReopened", 575),
    CALL_EMITTED_TO("CallEmittedTo", 580),
    CALL_RECEIVED("CallReceived", 582),
    TICKET_CANCELLED("TicketCancelled", 585),
    TICKET_ARCHIVED("TicketArchived", 590),
    CALL_ANSWERED_BY_PROVIDER("CallAnsweredByProvider", 600),
    CALL_NOT_ANSWERED_BY_PROVIDER("CallNotAnsweredByProvider", 605),
    
    MISSION_SCHEDULED("MissionScheduled", 610),     // Deprecated on 2018, September 8th, see INTERVENTION_SCHEDULED
    INTERVENTION_SCHEDULED("InterventionScheduled", 610),
    
    SERVICE_ORDER_SENT("ServiceOrderSent", 615), // deprecated
    SENDING_SERVICE_ORDER_REPORTED("SendingServiceOrderReported", 615),
    FORMAL_NOTICE_FOR_PROVIDER_REPORTED("FormalNoticeForProviderReported", 620),
    INTERVENTION_DEADLINE_DEFINED("InterventionDeadlineDefined", 625),
    
    SIMPLIFIED_REQUEST_QUALIFIED("SimplifiedRequestQualified", 805)
    ;

    /**
     * Type d'événement
     */
    private final String name;

    /**
     * Identifiant du type d'événement
     */
    private final int uid;

    /**
     * Constructeur de la classe
     */
    EventType(String name, int uid) {
        this.name = name;
        this.uid = uid;
    }

    /**
     * @return le type d'événement
     */
    public String getName() {
        return name;
    }

    /**
     * @return l'identifiant du type d'événement
     */
    public int getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return name;
    }
}
