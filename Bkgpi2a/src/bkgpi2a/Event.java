package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite d�crivant un �v�n�ment.
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
     * Identifiant unique de l'�v�nement
     */
    private String processUid;

    /**
     * Identifiant unique de l'aggr�gat auquel appartient l'�v�nement
     */
    private String aggregateUid;

    /**
     * Date o� l'�v�nement s'est pass�
     */
    private String date;

    /**
     * Date � laquelle l'�v�nement a �t� envoy�
     */
    private String sentDate;

    /**
     * Type d'�v�nement
     */
    private String eventType;

    /**
     * Identifiant du type d'�v�nement
     */
    private int eventTypeUid;

    /**
     * @return l'dentifiant unique de l'�v�nement
     */
    public String getProcessUid() {
        return processUid;
    }

    /**
     * @param processUid d�finit l'dentifiant unique de l'�v�nement
     */
    public void setProcessUid(String processUid) {
        this.processUid = processUid;
    }

    /**
     * @return l'identifiant unique de l'aggr�gat auquel appartient l'�v�nement
     */
    public String getAggregateUid() {
        return aggregateUid;
    }

    /**
     * @param aggregateUid d�finit l'identifiant unique de l'aggr�gat auquel
     * appartient l'�v�nement
     */
    public void setAggregateUid(String aggregateUid) {
        this.aggregateUid = aggregateUid;
    }

    /**
     * @return la date o� l'�v�nement s'est pass�
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date d�finit la date o� l'�v�nement s'est pass�
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return la date � laquelle l'�v�nement a �t� envoy�
     */
    public String getSentDate() {
        return sentDate;
    }

    /**
     * @param sentDate d�finit la date � laquelle l'�v�nement a �t� envoy�
     */
    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * @return le type d'�v�nement
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType d�finit le type d'�v�nement
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * @return l'identifiant du type d'�v�nement
     */
    public int getEventTypeUid() {
        return eventTypeUid;
    }

    /**
     * @param eventTypeUid d�finit l'identifiant du type d'�v�nement
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
