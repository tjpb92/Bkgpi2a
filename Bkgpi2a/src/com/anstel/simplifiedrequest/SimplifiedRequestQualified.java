package com.anstel.simplifiedrequest;

import bdd.Fa2pi;
import bkgpi2a.Event;
import static bkgpi2a.EventType.SIMPLIFIED_REQUEST_QUALIFIED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import utils.Md5;

/**
 * Classe décrivant l'événement de qualification d'une demande d'intervention
 * émise depuis l'application mobile : SimplifiedRequestQualified, #805.
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 * @see <A href="https://declarimmo-org.github.io/API/#simplifiedrequestqualified">SimplifiedRequestQualified</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("SimplifiedRequestQualified")
public class SimplifiedRequestQualified extends Event {

    /**
     * Pour convertir les datetimes du format texte au format DateTime et vice
     * versa
     */
    private static final DateTimeFormatter isoDateTimeFormat1 = ISODateTimeFormat.dateTimeParser();
//    private static final DateTimeFormatter isoDateTimeFormat2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static final DateTimeFormatter isoDateTimeFormat2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    /**
     * Identifiant du ticket associé
     */
    private String ticketUid;

    /**
     * Constructeur principal de la classe SimplifiedRequestQualified
     */
    public SimplifiedRequestQualified() {
        setEventTypeUid(SIMPLIFIED_REQUEST_QUALIFIED.getUid());
        setEventType(SIMPLIFIED_REQUEST_QUALIFIED.getName());
    }

    /**
     * Constructeur secondaire de la classe SimplifiedRequestQualified
     *
     * @param fa2pi événement lu depuis la base de données Informix.
     */
    public SimplifiedRequestQualified(Fa2pi fa2pi) {
        this();
        DateTime dateTime;
        String[] buffer;

        setProcessUid(Md5.encode("a10:" + fa2pi.getA10num()));

//        setAggregateUid(Md5.encode(fa2pi.getA10laguid()));
//      ATTENTION : dans a10data nous avons : SRUuid,TicketUuid        
        buffer = fa2pi.getA10data().split(",");
        setAggregateUid(buffer[0]);
        ticketUid = buffer[1];

        dateTime = new DateTime(fa2pi.getA10credate().getTime());
        setDate(dateTime.toString(isoDateTimeFormat2));
        dateTime = new DateTime();
        setSentDate(dateTime.toString(isoDateTimeFormat2));
    }

    /**
     * @return retourne l'identifiant du ticket associé
     */
    public String getTicketUid() {
        return ticketUid;
    }

    /**
     * @param ticketUid définit l'identifiant du ticket associé
     */
    public void setTicketUid(String ticketUid) {
        this.ticketUid = ticketUid;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "SimplifiedRequestQualified:{"
                + super.toString()
                + ", ticketUid:" + getTicketUid()
                + "}";
    }

}
