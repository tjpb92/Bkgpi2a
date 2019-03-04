package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_REQUESTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant la demande d'une intervention : InterventionRequested, #503.
 *
 * @author Thierry Baribaud
 * @version 1.05
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("InterventionRequested")
public class InterventionRequested extends Event {

    /**
     * Opérateur ayant saisi la demande de l'intervention (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Operator operator;

    /**
     * Média utilisé pour demander l'intervention
     */
    private ContactMedium medium;

    /**
     * Individu courant sur l'essai
     */
    private TicketAssignee assignee;

    /**
     * Commentaire ajouté au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe InterventionRequested
     */
    public InterventionRequested() {
        setEventTypeUid(INTERVENTION_REQUESTED.getUid());
        setEventType(INTERVENTION_REQUESTED.getName());
    }

    /**
     * @return l'opérateur ayant saisi la demande de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant saisi la demande de
     * l'intervention
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * Retourne le média utilisé pour demander l'intervention
     *
     * @return le média utilisé pour demander l'intervention
     */
    public ContactMedium getMedium() {
        return medium;
    }

    /**
     * Définit le média utilisé pour demander l'intervention
     *
     * @param medium le média utilisé pour demander l'intervention
     */
    public void setMedium(ContactMedium medium) {
        this.medium = medium;
    }

    /**
     * @return l'individu courant si présent
     */
    public TicketAssignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee définit l'individu courant
     */
    public void setAssignee(TicketAssignee assignee) {
        this.assignee = assignee;
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
        return "InterventionRequested:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getMedium()
                + ", " + getAssignee()
                + ", commentaire:" + getComment()
                + "}";
    }
}