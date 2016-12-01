package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_ARCHIVED;

/**
 * Classe décrivant un comment ajouté au journal d'un ticket : TicketArchived, #590
 *
 * @author Thierry Baribaud
 * @version 0.34
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("TicketArchived")
public class TicketArchived extends Event {

    /**
     * Opérateur ayant archivé le ticket
     */
    private Operator operator;

    /**
     * Message ajouté au ticket
     */
    private String comment;

    /**
     * Constructeur de la classe TicketArchived
     */
    public TicketArchived() {
        setEventTypeUid(TICKET_ARCHIVED.getUid());
        setEventType(TICKET_ARCHIVED.getName());
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
     * @return le commentaire ajouté au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire ajouté au ticket
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
        return "TicketArchived:{"
                + super.toString()
                + ", " + getOperator()
                + ", comment:" + getComment()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
