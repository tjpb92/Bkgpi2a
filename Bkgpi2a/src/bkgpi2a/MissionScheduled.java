package bkgpi2a;

import static bkgpi2a.EventType.MISSION_SCHEDULED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant la programmation d'une intervention : MissionScheduled, #610
 *
 * @author Thierry Baribaud
 * @version 0.23
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"eventTypeUid"})
@JsonTypeName("MissionScheduled")
public class MissionScheduled extends Event {

    /**
     * Date et heure du début de l'intervention
     */
    private String startDate;

    /**
     * Date et heure de la fin de l'intervention
     */
    private String endDate;

    /**
     * Opérateur ayant saisi la programmation de l'intervention
     */
    private Operator operator;

    /**
     * Commentaire ajouté au ticket
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
     * @return l'opérateur ayant saisi la programmation de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant saisi la programmation de
     * l'intervention
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return le comment ajouté au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le comment ajouté au ticket
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return la date à laquelle l'événement a eu lieu
     */
//    public DateTime getMissionScheduledDate() {
//        return getDate();
//    }

    /**
     * @param missionScheduledDate définit la date à laquelle l'événement a eu
     * lieu
     */
//    public void setMissionScheduledDate(String missionScheduledDate) {
//        setDate(missionScheduledDate);
//    }
    
    /**
     * @return la date et heure du début de l'intervention
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate définit la date et heure du début de l'intervention
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
     * @param endDate définit la date et heure de la fin de l'intervention
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
                + ", début d'intervention:" + getStartDate()
                + ", fin d'intervention:" + getEndDate()
                + ", " + getOperator()
                + ", commentaire:" + getComment()
//                + ", missionScheduledDate:" + getMissionScheduledDate()
                + "}";
    }
}
