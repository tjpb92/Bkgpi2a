package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_SCHEDULED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant la programmation d'une intervention : InterventionScheduled,
 * #610
 *
 * @author Thierry Baribaud
 * @version 0.21
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("InterventionScheduled")
public class InterventionScheduled extends Event {

    /**
     * Date et heure du d�but de l'intervention
     */
    private String start;

    /**
     * Date et heure de la fin de l'intervention
     */
    private String end;

    /**
     * Op�rateur ayant saisi la programmation de l'intervention
     */
    private Operator operator;

    /**
     * Commentaire ajout� au ticket
     */
    private String comment;

    /**
     * Constructeur de la classe InterventionScheduled
     */
    public InterventionScheduled() {
        setEventTypeUid(INTERVENTION_SCHEDULED.getUid());
        setEventType(INTERVENTION_SCHEDULED.getName());
    }

    /**
     * @return l'op�rateur ayant saisi la programmation de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant saisi la programmation de
     * l'intervention
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
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
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getInterventionScheduledDate() {
        return getDate();
    }

    /**
     * @param interventionScheduledDate d�finit la date � laquelle l'�v�nement a
     * eu lieu
     */
    public void setInterventionScheduledDate(String interventionScheduledDate) {
        setDate(interventionScheduledDate);
    }

    /**
     * @return la date et heure du d�but de l'intervention
     */
    public String getStart() {
        return start;
    }

    /**
     * @param start d�finit la date et heure du d�but de l'intervention
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return la date et heure de la fin de l'intervention
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end d�finit la date et heure de la fin de l'intervention
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "InterventionScheduled:{"
                + super.toString()
                + ", d�but d'intervention:" + getStart()
                + ", fin d'intervention:" + getEnd()
                + ", " + getOperator()
                + ", commentaire:" + getComment()
                + ", interventionScheduledDate:" + getInterventionScheduledDate()
                + "}";
    }
}
