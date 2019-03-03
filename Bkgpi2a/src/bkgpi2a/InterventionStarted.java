package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_STARTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un début d'intervention : InterventionStarted, #532
 *
 * @author Thierry Baribaud
 * @version 1.04
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("InterventionStarted")
public class InterventionStarted extends Event {

    /**
     * Opérateur ayant ajouté l'essai
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
     * @return la date à laquelle l'événement a eu lieu
     */
    public String getStartedDate() {
        return getDate();
    }

    /**
     * @param startedDate définit la date à laquelle l'événement a eu lieu
     */
    public void setStartedDate(String startedDate) {
        setDate(startedDate);
    }

    /**
     * @return l'intervenant courant si présent
     */
    public TicketAssignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee définit l'intervenant courant
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
