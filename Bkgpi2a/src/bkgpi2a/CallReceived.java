package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CALL_RECEIVED;

/**
 * Classe d�crivant un comment ajout� au journal d'un ticket : CallReceived,
 * #582
 *
 * ATTENTION : � finaliser
 *
 * @author Thierry Baribaud
 * @version 0.34
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid", "callPurpose", "caller", "medium"})
@JsonTypeName("CallReceived")
public class CallReceived extends Event {

    /**
     * Op�rateur ayant ajout� le comment
     */
    private Operator operator;

    /**
     * Commentaire ajout� au ticket
     */
    private String comment;

    /**
     * Constructeur de la classe CallReceived
     */
    public CallReceived() {
        setEventTypeUid(CALL_RECEIVED.getUid());
        setEventType(CALL_RECEIVED.getName());
    }

    /**
     * @return l'op�rateur ayant ajout� le commentaire
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant ajout� le commentaire
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return le commentaire ajout� au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment d�finit le commentaire ajout� au ticket
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "CallReceived:{"
                + super.toString()
                + ", " + getOperator()
                + ", commentaire:" + getComment()
                + "}";
    }
}
