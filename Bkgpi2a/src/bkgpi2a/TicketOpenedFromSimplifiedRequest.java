package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_OPENED_FROM_SIMPLIFIED_REQUEST;

/**
 * Classe décrivant l'événement ouverture de ticket depuis une demande
 * d'intervention émise depuis l'application mobile :
 * TicketOpenedFromSimplifiedRequest, #645
 *
 * @author Thierry Baribaud
 * @version 1.35
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">TicketOpenedFromSimplifiedRequest</A>
 */
//@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("TicketOpenedFromSimplifiedRequest")
public class TicketOpenedFromSimplifiedRequest extends Event {

    /**
     * Opérateur ayant géré le ticket
     */
    private Operator operator;

    /**
     * Référence à la demande d'intervention émise depuis la mobilité
     */
    private String fromSimplifiedRequest;

    /**
     * Constructeur de la classe TicketOpenedFromSimplifiedRequest
     */
    public TicketOpenedFromSimplifiedRequest() {
        setEventTypeUid(TICKET_OPENED_FROM_SIMPLIFIED_REQUEST.getUid());
        setEventType(TICKET_OPENED_FROM_SIMPLIFIED_REQUEST.getName());
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
     * @return la référence à la demande d'intervention émise depuis la mobilité
     */
    public String getFromSimplifiedRequest() {
        return fromSimplifiedRequest;
    }

    /**
     * @param fromSimplifiedRequest définit la référence à la demande
     * d'intervention émise depuis la mobilité
     */
    public void setFromSimplifiedRequest(String fromSimplifiedRequest) {
        this.fromSimplifiedRequest = fromSimplifiedRequest;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketOpenedFromSimplifiedRequest:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getFromSimplifiedRequest()
                + "}";
    }

}
