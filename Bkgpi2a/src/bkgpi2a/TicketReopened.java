package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_REOPENED;

/**
 * Classe d�crivant la r�ouverture d'un ticket : TicketReopened, #575
 *
 * @author Thierry Baribaud
 * @version 0.39
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("TicketReopened")
public class TicketReopened extends Event {

    /**
     * Op�rateur ayant archiv� le ticket
     */
    private Operator operator;

    /**
     * Raison de la r�ouverture du ticket
     */
    private String purpose;

    /**
     * Constructeur de la classe TicketReopened
     */
    public TicketReopened() {
        setEventTypeUid(TICKET_REOPENED.getUid());
        setEventType(TICKET_REOPENED.getName());
    }

    /**
     * @return l'op�rateur ayant r�cup�r� le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant r�cup�r� le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la raison de la r�ouverture du ticket
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose d�finit la raison de la r�ouverture du ticket
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketReopened:{"
                + super.toString()
                + ", " + getOperator()
                + ", purpose:" + getPurpose()
                + "}";
    }
}
