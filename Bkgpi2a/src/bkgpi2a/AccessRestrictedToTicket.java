package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.ACCESS_RESTRICTED_TO_TICKET;

/**
 * Classe d�crivant l'�v�nement permettant de restreindre l'acc�s � un ticket :
 * AccessRestrictedToTicket, #655
 *
 * @author Thierry Baribaud
 * @version 1.38
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">AccessRestrictedToTicket</A>
 */
//@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("AccessRestrictedToTicket")
public class AccessRestrictedToTicket extends Event {

    /**
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;

    /**
     * Constructeur de la classe AccessRestrictedToTicket
     */
    public AccessRestrictedToTicket() {
        setEventTypeUid(ACCESS_RESTRICTED_TO_TICKET.getUid());
        setEventType(ACCESS_RESTRICTED_TO_TICKET.getName());
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
        return "AccessRestrictedToTicket:{"
                + super.toString()
                + ", " + getOperator()
                + "}";
    }

}
