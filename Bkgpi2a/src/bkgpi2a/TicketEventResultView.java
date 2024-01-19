package bkgpi2a;

/**
 * Classe d�crivant le r�sultat d'une interrogation sur les tickets
 * @author Thierry Baribaud
 * @version 1.42.15
 * @see http://performanceimmo.github.io/API/#ticketeventresultview
 */
public class TicketEventResultView {
    
    /**
     * R�sultats de la requ�te sur les tickets
     * ATTENTION : bug ici, il ne s'agit pas de la liste des �v�nements mais
     * de celle des �v�nements au journal.
     */
    private EventList events;
    
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
