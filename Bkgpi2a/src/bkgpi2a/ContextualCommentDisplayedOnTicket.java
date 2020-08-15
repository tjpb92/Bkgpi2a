package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CONTEXTUAL_COMMENT_DISPLAYED_ON_TICKET;

/**
 * Classe d�crivant l'�v�nement d'affichage d'un commentaire contextuel sur un
 * ticket : ContextualCommentDisplayedOnTicket, #660
 *
 * @author Thierry Baribaud
 * @version 1.35
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">ContextualCommentDisplayedOnTicket</A>
 */
//@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ContextualCommentDisplayedOnTicket")
public class ContextualCommentDisplayedOnTicket extends Event {

    /**
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;

    /**
     * Commentaire contextuel
     */
//    private ContextualComment comment;
    /**
     * Constructeur de la classe ContextualCommentDisplayedOnTicket
     */
    public ContextualCommentDisplayedOnTicket() {
        setEventTypeUid(CONTEXTUAL_COMMENT_DISPLAYED_ON_TICKET.getUid());
        setEventType(CONTEXTUAL_COMMENT_DISPLAYED_ON_TICKET.getName());
    }

    /**
     * @return l'op�rateur ayant g�r� le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant g�r� le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return le commentaire contextuel
     */
//    public String getComment() {
//        return comment;
//    }
    /**
     * @param comment d�finit le commentaire contextuel
     */
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ContextualCommentDisplayedOnTicket:{"
                + super.toString()
                + ", " + getOperator()
                //                + ", " + getComment()
                + "}";
    }

}
