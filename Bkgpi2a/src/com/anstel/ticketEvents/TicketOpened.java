package com.anstel.ticketEvents;

import bkgpi2a.Event;
import bkgpi2a.LocationReference;
import bkgpi2a.Operator;
import bkgpi2a.TicketInfos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_OPENED;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe d�crivant l'�v�nement ouverture de ticket : TicketOpened, #500
 *
 * @author Thierry Baribaud
 * @version 1.42.22
 * @see
 * <A href="https://declarimmo-org.github.io/#ticketevent">TicketOpened</A>
 */
@JsonIgnoreProperties(value = {"_id", "date", "eventTypeUid"}, ignoreUnknown = true)
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
    @JsonProperty("ticket")
    private TicketInfos ticketInfos;

    /**
     * Date de saisie du ticket
     */
    private String OpenedDate;

    /**
     * Constructeur de la classe TicketOpened
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
//        return getDate();
        return this.OpenedDate;
    }

    /**
     * @param openedDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setOpenedDate(String openedDate) {
//        setDate(openedDate);
        this.OpenedDate = openedDate;
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
