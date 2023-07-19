package com.anstel.ticketEvents;

import bkgpi2a.Event;
import bkgpi2a.Operator;
import static bkgpi2a.EventType.OPENING_TICKET_PURPOSE_CORRECTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant l'�v�nement permettant de corriger le motif d'appel sur un
 * ticket : OpeningTicketPurposeCorrected, #675
 *
 * ATTENTION : Op�ration non compatible avec Eole2/Zephir2.
 *
 * @author Thierry Baribaud
 * @version 1.42.6
 * @see
 * <A href="https://declarimmo-org.github.io/API/#A_METTRE_A_JOUR">OpeningTicketPurposeCorrected</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("OpeningTicketPurposeCorrected")
public class OpeningTicketPurposeCorrected extends Event {

    /**
     * UUID du nouveau motif d'appel
     */
    private String otpUid;

    /**
     * Nom du nouveau motif d'appel
     */
    private String otpLabel;

    /**
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;

    /**
     * Constructeur de la classe TicketEventInformationsCorrected
     */
    public OpeningTicketPurposeCorrected() {
        setEventTypeUid(OPENING_TICKET_PURPOSE_CORRECTED.getUid());
        setEventType(OPENING_TICKET_PURPOSE_CORRECTED.getName());
    }

    /**
     * @return l'UUID du nouveau motif d'appel
     */
    public String getOtpUid() {
        return otpUid;
    }

    /**
     * @param otpUid d�finit l'UUID du nouveau motif d'appel
     */
    public void setOtpUid(String otpUid) {
        this.otpUid = otpUid;
    }

    /**
     * @return le nom du nouveau motif d'appel
     */
    public String getOtpLabel() {
        return otpLabel;
    }

    /**
     * @param otpLabel d�finit le nom du nouveau motif d'appel
     */
    public void setOtpLabel(String otpLabel) {
        this.otpLabel = otpLabel;
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
                + ", " + getOtpUid()
                + ", " + getOtpLabel()
                + ", " + getOperator()
                + "}";
    }

}
