package com.anstel.ticketEvents;

import bkgpi2a.ContactMedium;
import bkgpi2a.Event;
import bkgpi2a.Operator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CALL_EMITTED_TO;
import com.anstel.tickets.models.Persona;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant un comment ajouté au journal d'un ticket : CallEmittedTo,
 * #580
 *
 * ATTENTION : à ne pas confondre avec son homologue dans
 * <A href="https://performanceimmo.github.io/API/#journaleventdata">JournalEventData</A>
 *
 *
 * @author Thierry Baribaud
 * @version 1.42.23
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">CallEmittedTo</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("CallEmittedTo")
public class CallEmittedTo extends Event {

    /**
     * Opérateur ayant ajouté le comment
     */
    private Operator operator;

    /**
     * Commentaire ajouté au ticket
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;
    
    /**
     * Contact
     */
    private Persona recipient;

    /**
     * Moyen de communication utilisé
     */
    private ContactMedium medium;
    
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
                + ", " + getRecipient()
                + ", " + getMedium()
                + ", commentaire:" + getComment()
                + "}";
    }

    /**
     * @return medium le moyen de communication
     */
    public ContactMedium getMedium() {
        return medium;
    }

    /**
     * @param medium définit le moyen de communication
     */
    public void setMedium(ContactMedium medium) {
        this.medium = medium;
    }

    /**
     * @return recipient le contact
     */
    public Persona getRecipient() {
        return recipient;
    }

    /**
     * @param recipient définit le contact
     */
    public void setRecipient(Persona recipient) {
        this.recipient = recipient;
    }
}
