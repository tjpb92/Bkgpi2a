package bkgpi2a;

/**
 * Enumération décrivant les identifiants et libellés des événements.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public enum EventType {

    /* todo ...
     535 = PermanentlyFixed
     540 = PartialyFixed
     545 = ImpossibleRepair
     550 = PostponedFix
     555 = ClosedBeyondScope
     560 = ClosedUnsuccessfulRecalls
     561 = TicketClosed
     565 = LogTrialAdded
     575 = TicketReopened
     580 = CallEmittedToUser
     585 = TicketCanceled
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
    
    LOG_TRIAL_ADDED("LogTrialAdded", 565),
    MESSAGE_ADDED("MessageAdded", 570);

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
