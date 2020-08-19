package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.ASSIGNEE_IDENTIFIED;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant l'affectation d'un individu à un ticket :
 * AssigneeIdentified, #515. Remplace ProviderAssigned à compter de septembre
 * 2018.
 *
 * @author Thierry Baribaud
 * @version 1.37
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">AssigneeIdentified</A>
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("AssigneeIdentified")
public class AssigneeIdentified extends Event {

    /**
     * Opérateur ayant ajouté l'essai (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Operator operator;

    /**
     * Individu courant sur l'essai
     */
    @JsonProperty("assignee")
    private TicketAssignee ticketAssignee;

    /**
     * Commentaire ajouté au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe AssigneeIdentified
     */
    public AssigneeIdentified() {
        setEventTypeUid(ASSIGNEE_IDENTIFIED.getUid());
        setEventType(ASSIGNEE_IDENTIFIED.getName());
    }

    /**
     * @return l'opérateur ayant ajouté l'essai
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant ajouté l'essai
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'individu courant si présent
     */
    @JsonGetter("assignee")
    public TicketAssignee getTicketAssignee() {
        return ticketAssignee;
    }

    /**
     * @param ticketAssignee définit l'individu courant
     */
    @JsonSetter("assignee")
    public void setTicketAssignee(TicketAssignee ticketAssignee) {
        this.ticketAssignee = ticketAssignee;
    }

    /**
     * @return le commentaire ajouté au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire ajouté au ticket
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AssigneeIdentified:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getTicketAssignee()
                + ", commentaire:" + getComment()
                + "}";
    }

}
