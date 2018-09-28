package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_ACCEPTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant la programmation d'une intervention : InterventionAccepted,
 * #505.
 * Remplace MissionAccepted à compter de septembre 2018.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("InterventionAccepted")
public class InterventionAccepted extends Event {

    /**
     * Opérateur ayant saisi la confirmation de l'intervention (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Operator operator;

    /**
     * Individu courant sur l'essai
     */
    private Assignee assignee;

    /**
     * Commentaire ajouté au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe InterventionAccepted
     */
    public InterventionAccepted() {
        setEventTypeUid(INTERVENTION_ACCEPTED.getUid());
        setEventType(INTERVENTION_ACCEPTED.getName());
    }

    /**
     * @return l'opérateur ayant saisi la confirmation de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant saisi la confirmation de
     * l'intervention
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'individu courant si présent
     */
    public Assignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee définit l'individu courant
     */
    public void setAssignee(Assignee assignee) {
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
        return "InterventionAccepted:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", commentaire:" + getComment()
                + "}";
    }
}
