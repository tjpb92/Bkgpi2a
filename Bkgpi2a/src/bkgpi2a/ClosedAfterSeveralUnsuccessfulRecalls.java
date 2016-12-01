package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CLOSED_AFTER_SEVERAL_UNSUCCESSFUL_RECALLS;

/**
 * Classe d�crivant un comment ajout� au journal d'un ticket :
 * ClosedAfterSeveralUnsuccessfulRecalls, #560
 *
 * @author Thierry Baribaud
 * @version 0.34
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("ClosedAfterSeveralUnsuccessfulRecalls")
public class ClosedAfterSeveralUnsuccessfulRecalls extends Event {

    /**
     * Op�rateur ayant archiv� le ticket
     */
    private Operator operator;

    /**
     * Constructeur de la classe ClosedAfterSeveralUnsuccessfulRecalls
     */
    public ClosedAfterSeveralUnsuccessfulRecalls() {
        setEventTypeUid(CLOSED_AFTER_SEVERAL_UNSUCCESSFUL_RECALLS.getUid());
        setEventType(CLOSED_AFTER_SEVERAL_UNSUCCESSFUL_RECALLS.getName());
    }

    /**
     * @return l'op�rateur ayant archiv� le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant archiv� le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getClosingDate() {
        return getDate();
    }

    /**
     * @param closingDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setClosingDate(String closingDate) {
        setDate(closingDate);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ClosedAfterSeveralUnsuccessfulRecalls:{"
                + super.toString()
                + ", " + getOperator()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
