package bkgpi2a;

/**
 * Classe décrivant le résultat d'une interrogation sur les tickets
 * @author Thierry Baribaud
 * @version 1.25
 * @see http://performanceimmo.github.io/API/#ticketeventresultview
 */
public class TicketEventResultView {
    
    /**
     * Résultats de la requête sur les tickets
     */
    private EventList events;
    
    /**
     * @return retourne le résutlat de la requête
     */
    public EventList getEvents() {
        return events;
    }

    /**
     * @param events définit le résutlat de la requête
     */
    public void setEvents(EventList events) {
        this.events = events;
    }
}
