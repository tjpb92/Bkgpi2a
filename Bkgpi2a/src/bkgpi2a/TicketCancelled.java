package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_CANCELED;

/**
 * Classe d�crivant un comment ajout� au journal d'un ticket :
 * TicketCancelled, #585
 *
 * @author Thierry Baribaud
 * @version 0.34
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("TicketCancelled")
public class TicketCancelled extends Event {

    /**
     * Op�rateur ayant archiv� le ticket
     */
    private Operator operator;

    /**
     * Constructeur de la classe TicketCancelled
     */
    public TicketCancelled() {
        setEventTypeUid(TICKET_CANCELED.getUid());
        setEventType(TICKET_CANCELED.getName());
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
        return "TicketCancelled:{"
                + super.toString()
                + ", " + getOperator()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
