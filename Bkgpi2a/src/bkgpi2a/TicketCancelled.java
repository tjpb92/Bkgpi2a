package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_CANCELLED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant l'annuation d'un ticket : TicketCancelled, #585
 *
 * @author Thierry Baribaud
 * @version 1.08
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
     * Commentaire sur la cl�ture d'appel (optionnel)
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
     * @return le commentaire sur la cl�ture d'appel
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment d�finit le commentaire sur la cl�ture d'appel
     */
    public void setComment(String comment) {
        this.comment = comment;
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
                + ", comment:" + getComment()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
