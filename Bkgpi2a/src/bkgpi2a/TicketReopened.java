package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_REOPENED;

/**
 * Classe décrivant la réouverture d'un ticket : TicketReopened, #575
 *
 * @author Thierry Baribaud
 * @version 0.39
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("TicketReopened")
public class TicketReopened extends Event {

    /**
     * Opérateur ayant archivé le ticket
     */
    private Operator operator;

    /**
     * Raison de la réouverture du ticket
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
     * @return l'opérateur ayant récupéré le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant récupéré le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la raison de la réouverture du ticket
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose définit la raison de la réouverture du ticket
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
