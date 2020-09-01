package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.ACCESS_RESTRICTED_TO_TICKET;

/**
 * Classe décrivant l'événement permettant de restreindre l'accès à un ticket :
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
     * Opérateur ayant géré le ticket
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
