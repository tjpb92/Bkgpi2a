package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.MESSAGE_ADDED;

/**
 * Classe d�crivant un message ajout� au journal d'un ticket : MessageAdded, #570
 *
 * @author Thierry Baribaud
 * @version 0.28
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("MessageAdded")
public class MessageAdded extends Event {

    /**
     * Op�rateur ayant ajout� le message
     */
    private Operator operator;

    /**
     * Message ajout� au ticket
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
     * @return l'op�rateur ayant ajout� le message
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant ajout� le message
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return le message ajout� au ticket
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message d�finit le message ajout� au ticket
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getMessageAddedDate() {
        return getDate();
    }

    /**
     * @param messageAddedDate d�finit la date � laquelle l'�v�nement a eu lieu
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
