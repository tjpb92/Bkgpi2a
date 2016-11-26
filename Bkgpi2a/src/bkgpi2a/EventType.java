package bkgpi2a;

/**
 * Enumération décrivant les identifiants et libellés des événements.
 *
 * @author Thierry Baribaud
 * @version 0.31
 */
public enum EventType {

    TICKET_OPENED("TicketOpened", 500),
    MISSION_ACCEPTED("MissionAccepted", 505),
    TICKET_UPDATED("TicketUpdated", 510),
    PROVIDER_ASSIGNED("ProviderAssigned", 515),
    MISSION_REFUSED("MissionRefused", 520),
    ARRIVED_ON_SITE("ArrivedOnSite", 525),
    GONE_FROM_SITE("GoneFromSite", 530),
    INTERVENTION_STARTED("InterventionStarted", 532),
    INTERVENTION_FINISHED("InterventionFinished", 534),
    PERMANENTLY_FIXED("PermanentlyFixed", 535),
    PARTIALLY_FIXED("PartiallyFixed", 540),
    TICKET_CLOSED_IMPOSSIBLE_REPAIR("TicketClosedImpossibleRepair", 545),
    POSTPONED_FIX("PostponedFix", 550),
    CLOSED_BEYOND_SCOPE("ClosedBeyondScope", 555),
    CLOSED_UNSUCCESSFUL_RECALLS("ClosedUnsuccessfulRecalls", 560),
    TICKET_CLOSED("TicketClosed", 561),
    LOG_TRIAL_ADDED("LogTrialAdded", 565),
    MESSAGE_ADDED("MessageAdded", 570),
    TICKET_REOPENED("TicketReopened", 575),
    CALL_EMITTED_TO_USER("CallEmittedToUser", 580),
    TICKET_CANCELED("TicketCanceled", 585),
    TICKET_ARCHIVED("TicketArchived", 590),
    CALL_ANSWERED_BY_PROVIDER("CallAnsweredByProvider", 600),
    CALL_NOT_ANSWERED_BY_PROVIDER("CallNotAnsweredByProvider", 605),
    MISSION_SCHEDULED("MissionScheduled", 610),
    SERVICE_ORDER_SENT("ServiceOrderSent", 615), // deprecated
    SENDING_SERVICE_ORDER_REPORTED("SendingServiceOrderReported", 615);

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
