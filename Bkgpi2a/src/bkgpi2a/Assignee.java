package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un individu assigné à un ticket
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/...
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "assigneeType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ReferencedProviderContact.class, name = "ReferencedProviderContact"),
    @JsonSubTypes.Type(value = AnonymousAssignee.class, name = "AnonymousAssignee"),
    @JsonSubTypes.Type(value = ReferencedProviderCompany.class, name = "ReferencedProviderCompany"),})
public abstract class Assignee {

    /**
     * Type d'individu assigné à un ticket
     */
    private String assigneeType;

    /**
     * Constructeur principal de la classe Assignee
     */
    public Assignee() {
    }

    /**
     * @return le type d'individu assigné à un ticket
     */
    public String getAssigneeType() {
        return assigneeType;
    }

    /**
     * @param assigneeType définit le type d'individu assigné à un ticket
     */
    public void setAssigneeType(String assigneeType) {
        this.assigneeType = assigneeType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Assignee:{"
                + "assigneeType:" + getAssigneeType()
                + "}";
    }
}
