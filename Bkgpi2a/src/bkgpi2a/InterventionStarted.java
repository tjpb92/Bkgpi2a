package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_STARTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un d�but d'intervention : InterventionStarted, #532
 *
 * @author Thierry Baribaud
 * @version 1.04
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("InterventionStarted")
public class InterventionStarted extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private TicketAssignee assignee;

    /**
     * Constructeur de la classe InterventionStarted
     */
    public InterventionStarted() {
        setEventTypeUid(INTERVENTION_STARTED.getUid());
        setEventType(INTERVENTION_STARTED.getName());
    }

    /**
     * @return l'op�rateur ayant ajout� l'essai
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant ajout� l'essai
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getStartedDate() {
        return getDate();
    }

    /**
     * @param startedDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setStartedDate(String startedDate) {
        setDate(startedDate);
    }

    /**
     * @return l'intervenant courant si pr�sent
     */
    public TicketAssignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee d�finit l'intervenant courant
     */
    public void setAssignee(TicketAssignee assignee) {
        this.assignee = assignee;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "InterventionStarted:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", startedDate:" + getStartedDate()
                + "}";
    }

}
