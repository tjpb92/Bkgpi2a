package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CALL_EMITTED_TO;

/**
 * Classe décrivant un comment ajouté au journal d'un ticket : CallEmittedTo,
 * #580
 *
 * ATTENTION : à finaliser
 *
 * @author Thierry Baribaud
 * @version 1.37
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">CallEmittedTo</A>
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid", "recipient", "medium"})
@JsonTypeName("CallEmittedTo")
public class CallEmittedTo extends Event {

    /**
     * Opérateur ayant ajouté le comment
     */
    private Operator operator;

    /**
     * Commentaire ajouté au ticket
     */
    private String comment;

    /**
     * Constructeur de la classe CallEmittedTo
     */
    public CallEmittedTo() {
        setEventTypeUid(CALL_EMITTED_TO.getUid());
        setEventType(CALL_EMITTED_TO.getName());
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
        return "CallEmittedTo:{"
                + super.toString()
                + ", " + getOperator()
                + ", commentaire:" + getComment()
                + "}";
    }
}
