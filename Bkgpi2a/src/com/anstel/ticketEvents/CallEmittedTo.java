package com.anstel.ticketEvents;

import bkgpi2a.Event;
import bkgpi2a.Operator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CALL_EMITTED_TO;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant un comment ajout� au journal d'un ticket : CallEmittedTo,
 * #580
 *
 * ATTENTION : � finaliser avec recipient et medium.
 *
 * ATTENTION : � ne pas confondre avec son homologue dans
 * <A href="https://performanceimmo.github.io/API/#journaleventdata">JournalEventData</A>
 *
 *
 * @author Thierry Baribaud
 * @version 1.42.16
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">CallEmittedTo</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid", "recipient", "medium"}, ignoreUnknown = true)
@JsonTypeName("CallEmittedTo")
public class CallEmittedTo extends Event {

    /**
     * Op�rateur ayant ajout� le comment
     */
    private Operator operator;

    /**
     * Commentaire ajout� au ticket
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe CallEmittedTo
     */
    public CallEmittedTo() {
        setEventTypeUid(CALL_EMITTED_TO.getUid());
        setEventType(CALL_EMITTED_TO.getName());
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
        return "CallEmittedTo:{"
                + super.toString()
                + ", " + getOperator()
                + ", commentaire:" + getComment()
                + "}";
    }
}
