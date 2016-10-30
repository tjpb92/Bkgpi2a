package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un événément.
 *
 * @author Thierry Baribaud
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "eventType")
@JsonSubTypes({
    //    @JsonSubTypes.Type(value = ReferencedOperator.class, name = "ReferencedOperator"),
    @JsonSubTypes.Type(value = LogTrialAdded.class, name = "LogTrialAdded"),
    @JsonSubTypes.Type(value = MessageAdded.class, name = "MessageAdded")})
public abstract class Event {

    /**
     * Identifiant unique de l'événement
     */
    private String processUid;

    /**
     * Identifiant unique de l'aggrégat auquel appartient l'événement
     */
    private String aggregateUid;

    /**
     * Date où l'événement s'est passé
     */
    private String date;

    /**
     * Date à laquelle l'événement a été envoyé
     */
    private String sentDate;

    /**
     * Type d'événement
     */
    private String eventType;

    /**
     * Identifiant du type d'événement
     */
    private int eventTypeUid;

    /**
     * @return l'dentifiant unique de l'événement
     */
    public String getProcessUid() {
        return processUid;
    }

    /**
     * @param processUid définit l'dentifiant unique de l'événement
     */
    public void setProcessUid(String processUid) {
        this.processUid = processUid;
    }

    /**
     * @return l'identifiant unique de l'aggrégat auquel appartient l'événement
     */
    public String getAggregateUid() {
        return aggregateUid;
    }

    /**
     * @param aggregateUid définit l'identifiant unique de l'aggrégat auquel
     * appartient l'événement
     */
    public void setAggregateUid(String aggregateUid) {
        this.aggregateUid = aggregateUid;
    }

    /**
     * @return la date où l'événement s'est passé
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date définit la date où l'événement s'est passé
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return la date à laquelle l'événement a été envoyé
     */
    public String getSentDate() {
        return sentDate;
    }

    /**
     * @param sentDate définit la date à laquelle l'événement a été envoyé
     */
    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * @return le type d'événement
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType définit le type d'événement
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * @return l'identifiant du type d'événement
     */
    public int getEventTypeUid() {
        return eventTypeUid;
    }

    /**
     * @param eventTypeUid définit l'identifiant du type d'événement
     */
    public void setEventTypeUid(int eventTypeUid) {
        this.eventTypeUid = eventTypeUid;
    }

    @Override
    public String toString() {
        return "Event:{"
                + "processUid:" + getProcessUid()
                + ", aggregateUid:" + getAggregateUid()
                + ", date:" + getDate()
                + ", sentDate:" + getSentDate()
                + ", eventType:" + getEventType()
                + ", eventTypeUid:" + getEventTypeUid()
                + "}";
    }
}
