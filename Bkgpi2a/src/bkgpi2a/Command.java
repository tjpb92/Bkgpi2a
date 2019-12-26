package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant une commande.
 *
 * @author Thierry Baribaud
 * @version 1.31
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "commandType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = AssociateProviderContactWithPatrimony.class, name = "AssociateProviderContactWithPatrimony"),
    @JsonSubTypes.Type(value = DissociateProviderContactFromPatrimony.class, name = "DissociateProviderContactFromPatrimony"),
    @JsonSubTypes.Type(value = QualifySimplifiedRequest.class, name = "QualifySimplifiedRequest")
        
//    @JsonSubTypes.Type(value = InterventionRequested.class, name = "InterventionRequested"),
//    @JsonSubTypes.Type(value = TicketInformationsCorrected.class, name = "TicketInformationsCorrected"),
//    @JsonSubTypes.Type(value = ProviderAssigned.class, name = "ProviderAssigned"),
//    @JsonSubTypes.Type(value = AssigneeIdentified.class, name = "AssigneeIdentified"),
//    @JsonSubTypes.Type(value = LogTrialAdded.class, name = "LogTrialAdded"),
//    @JsonSubTypes.Type(value = PermanentlyFixed.class, name = "PermanentlyFixed"),
//    @JsonSubTypes.Type(value = PartiallyFixed.class, name = "PartiallyFixed"),
//    @JsonSubTypes.Type(value = TicketClosedImpossibleRepair.class, name = "TicketClosedImpossibleRepair"),
//    @JsonSubTypes.Type(value = ClosedAfterSeveralUnsuccessfulRecalls.class, name = "ClosedAfterSeveralUnsuccessfulRecalls"),
//    @JsonSubTypes.Type(value = ClosedBeyondCallCenterScope.class, name = "ClosedBeyondCallCenterScope"),
//    @JsonSubTypes.Type(value = PostponedFix.class, name = "PostponedFix"),
//    @JsonSubTypes.Type(value = MissionAccepted.class, name = "MissionAccepted"),    // Deprecated on 2018, September 8th.
//    @JsonSubTypes.Type(value = InterventionAccepted.class, name = "InterventionAccepted"),
//    @JsonSubTypes.Type(value = MissionRefused.class, name = "MissionRefused"),  // Deprecated on 2018, September 8th.
//    @JsonSubTypes.Type(value = InterventionRefused.class, name = "InterventionRefused"),
//    @JsonSubTypes.Type(value = ArrivedOnSite.class, name = "ArrivedOnSite"),
//    @JsonSubTypes.Type(value = GoneFromSite.class, name = "GoneFromSite"),
//    @JsonSubTypes.Type(value = CallAnsweredByProvider.class, name = "CallAnsweredByProvider"),
//    @JsonSubTypes.Type(value = CallNotAnsweredByProvider.class, name = "CallNotAnsweredByProvider"),
//    @JsonSubTypes.Type(value = MissionScheduled.class, name = "MissionScheduled"),  // Deprecated on 2018, September 8th.
//    @JsonSubTypes.Type(value = InterventionScheduled.class, name = "InterventionScheduled"),
//    @JsonSubTypes.Type(value = InterventionStarted.class, name = "InterventionStarted"),
//    @JsonSubTypes.Type(value = InterventionFinished.class, name = "InterventionFinished"),
//    @JsonSubTypes.Type(value = ServiceOrderSent.class, name = "ServiceOrderSent"), // deprecated
//    @JsonSubTypes.Type(value = SendingServiceOrderReported.class, name = "SendingServiceOrderReported"),
//    @JsonSubTypes.Type(value = FormalNoticeForProviderReported.class, name = "FormalNoticeForProviderReported"),
//    @JsonSubTypes.Type(value = InterventionDeadlineDefined.class, name = "InterventionDeadlineDefined"),
//    @JsonSubTypes.Type(value = MessageAdded.class, name = "MessageAdded"),
//    @JsonSubTypes.Type(value = CallEmittedTo.class, name = "CallEmittedTo"),
//    @JsonSubTypes.Type(value = CallReceived.class, name = "CallReceived"),
//    @JsonSubTypes.Type(value = TicketArchived.class, name = "TicketArchived"),
//    @JsonSubTypes.Type(value = TicketReopened.class, name = "TicketReopened"),    
//    @JsonSubTypes.Type(value = TicketClosed.class, name = "TicketClosed"),
//    @JsonSubTypes.Type(value = TicketCancelled.class, name = "TicketCancelled"),
//    @JsonSubTypes.Type(value = TicketUpdated.class, name = "TicketUpdated")
    })
public abstract class Command {

    /**
     * Liens entre entités
     */
//    @JsonProperty("_links")
//    private Links _links;
    /**
     * Identifiant unique de la commande
     */
    private String processUid;

    /**
     * Date où la commande s'est passée
     */
    private String date;

    /**
     * Date à laquelle la commande a été envoyée
     */
    private String sentDate;

    /**
     * Type de la commande
     */
    private String commandType;

    /**
     * Identifiant du type de la commande
     */
    private int commandTypeUid;

    /**
     * Status de la commande
     */
    private int status;

    /**
     * Nombre d'erreur(s) de traitement
     */
    private int nbError;

    /**
     * Constructeur de la classe Command
     */
    public Command() {
//        setLinks(new Links());
        setStatus(0);
        setNbError(0);
    }

    /**
     * @return l'dentifiant unique de la commande
     */
    public String getProcessUid() {
        return processUid;
    }

    /**
     * @param processUid définit l'dentifiant unique de la commande
     */
    public void setProcessUid(String processUid) {
        this.processUid = processUid;
    }

    /**
     * @param date définit la date où la commande s'est passé
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @param sentDate définit la date à laquelle la commande a été envoyé
     */
    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * @return le type de la commande
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * @param commandType définit le type de la commande
     */
    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    /**
     * @return l'identifiant du type de la commande
     */
    public int getCommandTypeUid() {
        return commandTypeUid;
    }

    /**
     * @param commandTypeUid définit l'identifiant du type de la commande
     */
    public void setCommandTypeUid(int commandTypeUid) {
        this.commandTypeUid = commandTypeUid;
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
     * @return le status de la commande
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status définit le status de la commande
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
     * @return la date où a eu lieu la commande
     */
    public String getDate() {
        return date;
    }

    /**
     * @return la date d'envoi de la commande
     */
    public String getSentDate() {
        return sentDate;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Command:{"
                //                + "_links:" + getLinks()
                + "processUid:" + getProcessUid()
                + ", date:" + getDate()
                + ", sentDate:" + getSentDate()
                + ", commandType:" + getCommandType()
                + ", commandTypeUid:" + getCommandTypeUid()
                + ", status:" + getStatus()
                + ", nbError:" + getNbError()
                + "}";
    }
}
