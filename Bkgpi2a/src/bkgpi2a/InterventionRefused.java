package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_REFUSED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant le refus d'une intervention : InterventionRefused, #520
 * Remplace MissionRefused � compter de septembre 2018.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("InterventionRefused")
public class InterventionRefused extends Event {

    /**
     * Op�rateur ayant saisi le refus de l'intervention (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Operator operator;

    /**
     * Individu courant sur l'essai
     */
    private Assignee assignee;

    /**
     * Commentaire ajout� au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe InterventionRefused
     */
    public InterventionRefused() {
        setEventTypeUid(INTERVENTION_REFUSED.getUid());
        setEventType(INTERVENTION_REFUSED.getName());
    }

    /**
     * @return l'op�rateur ayant saisi le refus de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant saisi le refus de
     * l'intervention
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'individu courant si pr�sent
     */
    public Assignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee d�finit l'individu courant
     */
    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    /**
     * @return le comment ajout� au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment d�finit le comment ajout� au ticket
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "InterventionRefused:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", commentaire:" + getComment()
                + "}";
    }
}
