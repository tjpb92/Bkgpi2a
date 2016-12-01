package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CALL_RECEIVED;

/**
 * Classe décrivant un comment ajouté au journal d'un ticket : CallReceived,
 * #582
 *
 * ATTENTION : à finaliser
 *
 * @author Thierry Baribaud
 * @version 0.34
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid", "callPurpose", "caller", "medium"})
@JsonTypeName("CallReceived")
public class CallReceived extends Event {

    /**
     * Opérateur ayant ajouté le comment
     */
    private Operator operator;

    /**
     * Commentaire ajouté au ticket
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
     * @return l'opérateur ayant ajouté le commentaire
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant ajouté le commentaire
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
