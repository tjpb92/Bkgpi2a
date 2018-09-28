package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant une commande.
 *
 * @author Thierry Baribaud
 * @version 0.48
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "commandType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = AssociateProviderContactToCompany.class, name = "AssociateProviderContactToCompany"),
    @JsonSubTypes.Type(value = AssociateProviderContactToAgency.class, name = "AssociateProviderContactToAgency")
})
public abstract class Command {

    /**
     * Identifiant unique de la commande
     */
    private String processUid;

    /**
     * Identifiant unique de l'aggrégat auquel appartient la commande
     */
    private String aggregateUid;

    /**
     * Date où la commande s'est passée
     */
    private String date;

    /**
     * Type de commande
     */
    private String commandType;

    /**
     * Constructeur de la classe Event
     */
    public Command() {
    }

    /**
     * @return la dentifiant unique de la commande
     */
    public String getProcessUid() {
        return processUid;
    }

    /**
     * @param processUid définit la dentifiant unique de la commande
     */
    public void setProcessUid(String processUid) {
        this.processUid = processUid;
    }

    /**
     * @return la identifiant unique de la aggrégat auquel appartient la
     * commande
     */
    public String getAggregateUid() {
        return aggregateUid;
    }

    /**
     * @param aggregateUid définit la identifiant unique de la aggrégat auquel
     * appartient la commande
     */
    public void setAggregateUid(String aggregateUid) {
        this.aggregateUid = aggregateUid;
    }

    /**
     * @param date définit la date où la commande s'est passé
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return le type d'commande
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * @param commandType définit le type d'commande
     */
    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    /**
     * @return la date où a eu lieu la commande
     */
    public String getDate() {
        return date;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Command:{"
                + "processUid:" + getProcessUid()
                + ", aggregateUid:" + getAggregateUid()
                + ", date:" + getDate()
                + ", eventType:" + getCommandType()
                + "}";
    }
}
