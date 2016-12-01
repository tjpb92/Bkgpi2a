package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CLOSED_BEYOND_CALL_CENTER_SCOPE;

/**
 * Classe décrivant un comment ajouté au journal d'un ticket :
 * ClosedBeyondCallCenterScope, #555
 *
 * @author Thierry Baribaud
 * @version 0.34
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("ClosedBeyondCallCenterScope")
public class ClosedBeyondCallCenterScope extends Event {

    /**
     * Opérateur ayant archivé le ticket
     */
    private Operator operator;

    /**
     * Constructeur de la classe ClosedBeyondCallCenterScope
     */
    public ClosedBeyondCallCenterScope() {
        setEventTypeUid(CLOSED_BEYOND_CALL_CENTER_SCOPE.getUid());
        setEventType(CLOSED_BEYOND_CALL_CENTER_SCOPE.getName());
    }

    /**
     * @return l'opérateur ayant archivé le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant archivé le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la date à laquelle l'événement a eu lieu
     */
    public String getClosingDate() {
        return getDate();
    }

    /**
     * @param closingDate définit la date à laquelle l'événement a eu lieu
     */
    public void setClosingDate(String closingDate) {
        setDate(closingDate);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ClosedBeyondCallCenterScope:{"
                + super.toString()
                + ", " + getOperator()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
