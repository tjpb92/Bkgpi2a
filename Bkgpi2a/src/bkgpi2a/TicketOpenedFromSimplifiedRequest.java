package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_OPENED_FROM_SIMPLIFIED_REQUEST;

/**
 * Classe d�crivant l'�v�nement ouverture de ticket depuis une demande
 * d'intervention �mise depuis l'application mobile :
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
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;

    /**
     * R�f�rence � la demande d'intervention �mise depuis la mobilit�
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
     * @return la r�f�rence � la demande d'intervention �mise depuis la mobilit�
     */
    public String getFromSimplifiedRequest() {
        return fromSimplifiedRequest;
    }

    /**
     * @param fromSimplifiedRequest d�finit la r�f�rence � la demande
     * d'intervention �mise depuis la mobilit�
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
