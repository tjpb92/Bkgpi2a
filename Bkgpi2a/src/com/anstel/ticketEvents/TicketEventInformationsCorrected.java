package com.anstel.ticketEvents;

import bkgpi2a.Event;
import bkgpi2a.Operator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_EVENT_INFORMATIONS_CORRECTED;

/**
 * Classe d�crivant l'�v�nement permettant de modifier des informations sur un
 * ticket : TicketEventInformationsCorrected, #670
 *
 * @author Thierry Baribaud
 * @version 1.42.6
 * @see
 * <A href="https://declarimmo-org.github.io/API/#A_METTRE_A_JOUR">TicketEventInformationsCorrected</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("TicketEventInformationsCorrected")
public class TicketEventInformationsCorrected extends Event {

    /**
     * Ev�nement cibl�
     */
    private String targetedEvent;

    /**
     * Text explicatif
     */
    private String text;

    /**
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;

    /**
     * Constructeur de la classe TicketEventInformationsCorrected
     */
    public TicketEventInformationsCorrected() {
        setEventTypeUid(TICKET_EVENT_INFORMATIONS_CORRECTED.getUid());
        setEventType(TICKET_EVENT_INFORMATIONS_CORRECTED.getName());
    }

    /**
     * @return l'�v�nement clibl�
     */
    public String getTargetedEvent() {
        return targetedEvent;
    }

    /**
     * @param targetedEvent d�finit l'�venement � cibler
     */
    public void setTargetedEvent(String targetedEvent) {
        this.targetedEvent = targetedEvent;
    }

    /**
     * @return le texte explicatif
     */
    public String getText() {
        return text;
    }

    /**
     * @param text d�finit le texte explicatif
     */
    public void setText(String text) {
        this.text = text;
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
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketEventInformationsCorrected:{"
                + super.toString()
                + ", " + getTargetedEvent()
                + ", " + getText()
                + ", " + getOperator()
                + "}";
    }

}
