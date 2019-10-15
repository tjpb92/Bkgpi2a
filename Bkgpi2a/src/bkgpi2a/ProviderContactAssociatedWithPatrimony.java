package bkgpi2a;

import bdd.Fa2pi;
import static bkgpi2a.EventType.PROVIDER_CONTACT_ASSOCIATED_WITH_PATRIMONY;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import utils.Md5;

/**
 * Classe décrivant l'association d'un ProviderContact et d'un Patrimony :
 * ProviderContactAssociatedWithPatrimony, #470.
 *
 * @author Thierry Baribaud
 * @version 1.26
 * @see http://performanceimmo.github.io/API/#providercontactevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("ProviderContactAssociatedWithPatrimony")
public class ProviderContactAssociatedWithPatrimony extends Event {

    /**
     * Pour convertir les datetimes du format texte au format DateTime et vice
     * versa
     */
    private static final DateTimeFormatter isoDateTimeFormat1 = ISODateTimeFormat.dateTimeParser();
//    private static final DateTimeFormatter isoDateTimeFormat2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static final DateTimeFormatter isoDateTimeFormat2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    /**
     * Identifiant du patrimoine à dissocier
     */
    private String patrimonyUid;

    /**
     * Constructeur principal de la classe
     * ProviderContactDissociatedFromPatrimony
     */
    public ProviderContactAssociatedWithPatrimony() {
        setEventTypeUid(PROVIDER_CONTACT_ASSOCIATED_WITH_PATRIMONY.getUid());
        setEventType(PROVIDER_CONTACT_ASSOCIATED_WITH_PATRIMONY.getName());
    }

    /**
     * Constructeur secondaire de la classe
     * ProviderContactAssociatedWithPatrimony
     *
     * @param fa2pi événement lu depuis la base de données Informix.
     */
    public ProviderContactAssociatedWithPatrimony(Fa2pi fa2pi) {
        this();
        DateTime dateTime;

        setProcessUid(Md5.encode("a10:" + fa2pi.getA10num()));
        setAggregateUid(Md5.encode(fa2pi.getA10laguid()));
        dateTime = new DateTime(fa2pi.getA10credate().getTime());
        setDate(dateTime.toString(isoDateTimeFormat2));
        dateTime = new DateTime();
        setSentDate(dateTime.toString(isoDateTimeFormat2));
        patrimonyUid = Md5.encode("s3:" + fa2pi.getA10unum() + ":" + fa2pi.getA10data());
    }

    /**
     * @return retourne l'identifiant du patrimoine à dissocier
     */
    public String getPatrimonyUid() {
        return patrimonyUid;
    }

    /**
     * @param patrimonyUid définit l'identifiant du patrimoine à dissocier
     */
    public void setPatrimonyUid(String patrimonyUid) {
        this.patrimonyUid = patrimonyUid;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderContactAssociatedWithPatrimony:{"
                + super.toString()
                + ", patrimonyUid:" + getPatrimonyUid()
                + "}";
    }

}
