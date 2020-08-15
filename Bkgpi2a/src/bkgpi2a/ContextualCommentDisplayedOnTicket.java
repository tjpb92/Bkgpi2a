package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CONTEXTUAL_COMMENT_DISPLAYED_ON_TICKET;

/**
 * Classe décrivant l'événement d'affichage d'un commentaire contextuel sur un
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
     * Opérateur ayant géré le ticket
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
     * @return l'opérateur ayant géré le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant géré le ticket
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
     * @param comment définit le commentaire contextuel
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
