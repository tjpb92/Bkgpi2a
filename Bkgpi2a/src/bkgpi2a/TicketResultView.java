package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe d�crivant le r�sultat d'une interrogation sur les tickets
 * @author Thierry Baribaud
 * @version 1.25
 * @see http://performanceimmo.github.io/API/#ticketresultview
 */
@JsonIgnoreProperties(value = {"aggregations"})
public class TicketResultView {
    
    /**
     * R�sultats de la requ�te sur les tickets
     */
    private EventList events;
    
    /**
     * Aggr�gation (pour usage futur)
     */
//    Aggregations aggregations;

    /**
     * @return retourne le r�sutlat de la requ�te
     */
    public EventList getEvents() {
        return events;
    }

    /**
     * @param events d�finit le r�sutlat de la requ�te
     */
    public void setEvents(EventList events) {
        this.events = events;
    }
}
