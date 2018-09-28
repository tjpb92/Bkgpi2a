package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_SCHEDULED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant la programmation d'une intervention : InterventionScheduled, #610
 * Remplace MissionScheduled � compter de septembre 2018.
 * 
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("InterventionScheduled")
public class InterventionScheduled extends Event {

    /**
     * Date et heure du d�but de l'intervention
     */
    private String startDate;

    /**
     * Date et heure de la fin de l'intervention
     */
    private String endDate;

    /**
     * Op�rateur ayant saisi la programmation de l'intervention (optionnel)
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
     * @return la date � laquelle l'�v�nement a eu lieu
     */
//    public DateTime getMissionScheduledDate() {
//        return getDate();
//    }
    /**
     * @param missionScheduledDate d�finit la date � laquelle l'�v�nement a eu
     * lieu
     */
//    public void setMissionScheduledDate(String missionScheduledDate) {
//        setDate(missionScheduledDate);
//    }
    /**
     * @return la date et heure du d�but de l'intervention
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate d�finit la date et heure du d�but de l'intervention
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return la date et heure de la fin de l'intervention
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate d�finit la date et heure de la fin de l'intervention
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "MissionScheduled:{"
                + super.toString()
                + ", d�but d'intervention:" + getStartDate()
                + ", fin d'intervention:" + getEndDate()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", commentaire:" + getComment()
                //                + ", missionScheduledDate:" + getMissionScheduledDate()
                + "}";
    }
}
