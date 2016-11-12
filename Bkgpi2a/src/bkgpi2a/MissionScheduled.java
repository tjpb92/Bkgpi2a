package bkgpi2a;

import static bkgpi2a.EventType.MISSION_SCHEDULED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant la programmation d'une intervention : MissionScheduled, #610
 *
 * @author Thierry Baribaud
 * @version 0.23
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"eventTypeUid"})
@JsonTypeName("MissionScheduled")
public class MissionScheduled extends Event {

    /**
     * Date et heure du d�but de l'intervention
     */
    private String startDate;

    /**
     * Date et heure de la fin de l'intervention
     */
    private String endDate;

    /**
     * Op�rateur ayant saisi la programmation de l'intervention
     */
    private Operator operator;

    /**
     * Commentaire ajout� au ticket
     */
    private String comment;

    /**
     * Constructeur de la classe MissionScheduled
     */
    public MissionScheduled() {
        setEventTypeUid(MISSION_SCHEDULED.getUid());
        setEventType(MISSION_SCHEDULED.getName());
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
                + ", commentaire:" + getComment()
//                + ", missionScheduledDate:" + getMissionScheduledDate()
                + "}";
    }
}
