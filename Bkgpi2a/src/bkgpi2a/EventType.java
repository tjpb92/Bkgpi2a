package bkgpi2a;

/**
 * Enum�ration d�crivant les identifiants et libell�s des �v�nements.
 *
 * @author Thierry Baribaud
 * @version 0.18
 */
public enum EventType {

    /* todo ...
     590 = TicketArchived
     600 = CallAnsweredByProvider
     605 = CallNotAnsweredByProvider
     */
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
    TICKET_REOPENED("TicketReopened", 575),
    CALL_EMITTED_TO_USER("CallEmittedToUser", 580),
    TICKET_CANCELED("TicketCanceled", 585),
    
    LOG_TRIAL_ADDED("LogTrialAdded", 565),
    MESSAGE_ADDED("MessageAdded", 570);

    /**
     * Type d'�v�nement
     */
    private final String name;

    /**
     * Identifiant du type d'�v�nement
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
     * @return le type d'�v�nement
     */
    public String getName() {
        return name;
    }

    /**
     * @return l'identifiant du type d'�v�nement
     */
    public int getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return name;
    }
}
