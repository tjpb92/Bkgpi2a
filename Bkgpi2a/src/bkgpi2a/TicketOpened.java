package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_OPENED;

/**
 * Classe d�crivant l'�v�nement ouverture de ticket : TicketOpened, #500
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("TicketOpened")
public class TicketOpened extends Event {

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
    private TicketInfos ticketInfos;

    /**
     * Constructeur de la classe MessageAdded
     */
    public TicketOpened() {
        setEventTypeUid(TICKET_OPENED.getUid());
        setEventType(TICKET_OPENED.getName());
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
    public TicketInfos getTicketInfos() {
        return ticketInfos;
    }

    /**
     * @param ticketInfos d�finit les informations sur le ticket
     */
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
        return "TicketOpened:{"
                + super.toString()
                + ", " + getLocationRef()
                + ", " + getOperator()
                + ", " + getTicketInfos()
                + ", openedDate:" + getOpenedDate()
                + "}";
    }

}
