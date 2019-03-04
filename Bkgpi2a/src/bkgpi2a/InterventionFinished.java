package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_FINISHED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant une fin d'intervention : InterventionFinished, #534
 *
 * @author Thierry Baribaud
 * @version 1.04
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("InterventionFinished")
public class InterventionFinished extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private TicketAssignee assignee;

    /**
     * Constructeur de la classe InterventionFinished
     */
    public InterventionFinished() {
        setEventTypeUid(INTERVENTION_FINISHED.getUid());
        setEventType(INTERVENTION_FINISHED.getName());
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
    public String getFinishedDate() {
        return getDate();
    }

    /**
     * @param finishedDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setFinishedDate(String finishedDate) {
        setDate(finishedDate);
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
        return "InterventionFinished:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", finishedDate:" + getFinishedDate()
                + "}";
    }

}
