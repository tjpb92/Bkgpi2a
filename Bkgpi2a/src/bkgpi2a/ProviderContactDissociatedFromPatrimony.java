package bkgpi2a;

import bdd.Fa2pi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.PROVIDER_CONTACT_DISSOCIATED_FROM_PATRIMONY;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import utils.Md5;

/**
 * Classe d�crivant la dissociation d'un ProviderCOntact et d'un Patrimony :
 * ProviderContactDissociatedFromPatrimony, #475.
 *
 * @author Thierry Baribaud
 * @version 1.22
 * @see http://performanceimmo.github.io/API/#providercontactevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("ProviderContactDissociatedFromPatrimony")
public class ProviderContactDissociatedFromPatrimony extends Event {

    /**
     * Pour convertir les datetimes du format texte au format DateTime et vice
     * versa
     */
    private static final DateTimeFormatter isoDateTimeFormat1 = ISODateTimeFormat.dateTimeParser();
    private static final DateTimeFormatter isoDateTimeFormat2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    /**
     * Identifiant du patrimoine � dissocier
     */
    private String patrimonyUid;

    /**
     * Constructeur principal de la classe
     * ProviderContactDissociatedFromPatrimony
     */
    public ProviderContactDissociatedFromPatrimony() {
        setEventTypeUid(PROVIDER_CONTACT_DISSOCIATED_FROM_PATRIMONY.getUid());
        setEventType(PROVIDER_CONTACT_DISSOCIATED_FROM_PATRIMONY.getName());
    }

    /**
     * Constructeur secondaire de la classe
     * ProviderContactDissociatedFromPatrimony
     *
     * @param fa2pi �v�nement lu depuis la base de donn�es Informix.
     */
    public ProviderContactDissociatedFromPatrimony(Fa2pi fa2pi) {
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
     * @return retourne l'identifiant du patrimoine � dissocier
     */
    public String getPatrimonyUid() {
        return patrimonyUid;
    }

    /**
     * @param patrimonyUid d�finit l'identifiant du patrimoine � dissocier
     */
    public void setPatrimonyUid(String patrimonyUid) {
        this.patrimonyUid = patrimonyUid;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderContactDissociatedFromPatrimony:{"
                + super.toString()
                + ", patrimonyUid:" + getPatrimonyUid()
                + "}";
    }

}
