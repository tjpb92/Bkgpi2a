package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un container permettant le transfert des événements.
 *
 * @author Thierry Baribaud
 * @version 0.22
 */
//@JsonPropertyOrder({"_links", "result"})
public class EventContainer {

    /**
     * Liste de liens entre entités
     */
//    @JsonProperty("_links")
//    private Links _links;

    /**
     * Liste des événements
     */
//    @JsonProperty("result")
    @JsonProperty("events")
    private EventList eventList;

    /**
     * Constructeur de la classe EventContainer
     */
    public EventContainer() {
//        setLinks(new Links());
        setEventList(new EventList());
    }

    /**
     * @return la liste de liens entre entités
     */
//    @JsonGetter("_links")
//    public Links getLinks() {
//        return _links;
//    }

    /**
     * @param _links définit la liste de liens entre entités
     */
//    @JsonSetter("_links")
//    public void setLinks(Links _links) {
//        this._links = _links;
//    }

    /**
     * @return la liste des événements
     */
//    @JsonGetter("result")
    @JsonGetter("events")
    public EventList getEventList() {
        return eventList;
    }

    /**
     * @param eventList définit la liste des compagnies
     */
//    @JsonSetter("result")
    @JsonSetter("events")
    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }

    /**
     * Ajoute un événement à la liste
     *
     * @param event événement à ajouter
     */
    public void add(Event event) {
        eventList.add(event);
    }

    /**
     * Ajoute un lien à la liste
     *
     * @param link lien à ajouter
     */
//    public void add(Link link) {
//        _links.add(link);
//    }

    /**
     * Retourne le contenu d'un container
     *
     * @return le contenu d'un container
     */
    @Override
    public String toString() {
        return "EventContainer:{"
//                + "_links:" + getLinks()
                + ", eventList:" + getEventList()
                + "}";
    }
}
