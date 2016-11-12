package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_UPDATED;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant l'�v�nement de mise � jour du ticket : TicketUpdated, #510
 *
 * @author Thierry Baribaud
 * @version 0.23
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("TicketUpdated")
public class TicketUpdated extends Event {

    /**
     * R�f�rence � l'agence ou au patrimoine
     */
    private LocationReference locationRef;

    /**
     * Op�rateur ayant ajout� le ticketInfos
     */
    private Operator operator;

    /**
     * Informations sur le ticket
     */
    @JsonProperty("ticket")
    private TicketInfos ticketInfos;

    /**
     * Constructeur de la classe MessageAdded
     */
    public TicketUpdated() {
        setEventTypeUid(TICKET_UPDATED.getUid());
        setEventType(TICKET_UPDATED.getName());
    }

    /**
     * @return la r�f�rence � l'agence ou au patrimoine
     */
    public LocationReference getLocationRef() {
        return locationRef;
    }

    /**
     * @param locationRef d�finit la r�f�rence � l'agence ou au patrimoine
     */
    public void setLocationRef(LocationReference locationRef) {
        this.locationRef = locationRef;
    }

    /**
     * @return l'op�rateur ayant ajout� le ticketInfos
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant ajout� le ticketInfos
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return les informations sur le ticket
     */
    @JsonGetter("ticket")
    public TicketInfos getTicketInfos() {
        return ticketInfos;
    }

    /**
     * @param ticketInfos d�finit les informations sur le ticket
     */
    @JsonSetter("ticket")
    public void setTicketInfos(TicketInfos ticketInfos) {
        this.ticketInfos = ticketInfos;
    }

    /**
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getOpenedDate() {
        return getDate();
    }

    /**
     * @param openedDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setOpenedDate(String openedDate) {
        setDate(openedDate);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketUpdated:{"
                + super.toString()
                + ", " + getLocationRef()
                + ", " + getOperator()
                + ", " + getTicketInfos()
                + ", openedDate:" + getOpenedDate()
                + "}";
    }

}
