package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_CANCELLED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant l'annuation d'un ticket : TicketCancelled, #585
 *
 * @author Thierry Baribaud
 * @version 1.08
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("TicketCancelled")
public class TicketCancelled extends Event {

    /**
     * Opérateur ayant archivé le ticket
     */
    private Operator operator;

    /**
     * Commentaire sur la clôture d'appel (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe TicketCancelled
     */
    public TicketCancelled() {
        setEventTypeUid(TICKET_CANCELLED.getUid());
        setEventType(TICKET_CANCELLED.getName());
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
     * @return le commentaire sur la clôture d'appel
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire sur la clôture d'appel
     */
    public void setComment(String comment) {
        this.comment = comment;
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
        return "TicketCancelled:{"
                + super.toString()
                + ", " + getOperator()
                + ", comment:" + getComment()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
