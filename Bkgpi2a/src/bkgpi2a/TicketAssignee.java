package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un individu assigné à un ticket
 *
 * @author Thierry Baribaud
 * @version 1.00
 * @see http://performanceimmo.github.io/API/#assigneetype
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "assigneeType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ReferencedProviderContact.class, name = "ReferencedProviderContact"),
    @JsonSubTypes.Type(value = AnonymousAssignee.class, name = "AnonymousAssignee"),
    @JsonSubTypes.Type(value = ReferencedProviderCompany.class, name = "ReferencedProviderCompany"),})
public abstract class TicketAssignee {

    /**
     * Type d'individu assigné à un ticket
     */
//    @JsonProperty("assigneeType")
    private String ticketAssigneeType;

    /**
     * Constructeur principal de la classe TicketAssignee
     */
    public TicketAssignee() {
    }

    /**
     * @return le type d'individu assigné à un ticket
     */
    @JsonGetter("assigneeType")
    public String getTicketAssigneeType() {
        return ticketAssigneeType;
    }

    /**
     * @param ticketAssigneeType définit le type d'individu assigné à un ticket
     */
    @JsonSetter("assigneeType")
    public void setTicketAssigneeType(String ticketAssigneeType) {
        this.ticketAssigneeType = ticketAssigneeType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketAssignee:{"
                + "TicketAssigneeType:" + getTicketAssigneeType()
                + "}";
    }
}