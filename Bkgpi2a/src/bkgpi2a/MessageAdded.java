package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.MESSAGE_ADDED;

/**
 * Classe décrivant un message ajouté au journal d'un ticket : MessageAdded, #570
 *
 * @author Thierry Baribaud
 * @version 0.28
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("MessageAdded")
public class MessageAdded extends Event {

    /**
     * Opérateur ayant ajouté le message
     */
    private Operator operator;

    /**
     * Message ajouté au ticket
     */
    private String message;

    /**
     * Constructeur de la classe MessageAdded
     */
    public MessageAdded() {
        setEventTypeUid(MESSAGE_ADDED.getUid());
        setEventType(MESSAGE_ADDED.getName());
    }
    
    /**
     * @return l'opérateur ayant ajouté le message
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant ajouté le message
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return le message ajouté au ticket
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message définit le message ajouté au ticket
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return la date à laquelle l'événement a eu lieu
     */
    public String getMessageAddedDate() {
        return getDate();
    }

    /**
     * @param messageAddedDate définit la date à laquelle l'événement a eu lieu
     */
    public void setMessageAddedDate(String messageAddedDate) {
        setDate(messageAddedDate);
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "MessageAdded:{"
                + super.toString()
                + ", " + getOperator()
                + ", message:" + getMessage()
                + ", messageAddedDate:" + getMessageAddedDate()
                + "}";
    }
}
