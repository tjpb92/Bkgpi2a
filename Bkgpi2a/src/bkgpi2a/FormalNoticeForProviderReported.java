package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.FORMAL_NOTICE_FOR_PROVIDER_REPORTED;

/**
 * Classe d�crivant l'envoi d'un ordre de service :
 * FormalNoticeForProviderReported, #620
 *
 * @author Thierry Baribaud
 * @version 0.38
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("FormalNoticeForProviderReported")
public class FormalNoticeForProviderReported extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private Provider provider;

    /**
     * R�f�rence de l'ordre de service
     */
    private String ref;

    /**
     * Date de fin des travaux
     */
    private String deadline;

    /**
     * Constructeur de la classe ServiceOrderSent
     */
    public FormalNoticeForProviderReported() {
        setEventTypeUid(FORMAL_NOTICE_FOR_PROVIDER_REPORTED.getUid());
        setEventType(FORMAL_NOTICE_FOR_PROVIDER_REPORTED.getName());
    }

    /**
     * @return l'op�rateur ayant ajout� l'essai
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant ajout� l'essai
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la r�f�rence de l'ordre de service
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref d�finit la r�f�rence de l'ordre de service
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return l'intervenant courant si pr�sent
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider d�finit l'intervenant courant
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getReportDate() {
        return getDate();
    }

    /**
     * @param reportDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setReportDate(String reportDate) {
        setDate(reportDate);
    }

    /**
     * @return la date de fin des travaux
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * @param deadline d�finit la date de fin des travaux
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "FormalNoticeForProviderReported:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", ref:" + getRef()
                + ", reportDate:" + getReportDate()
                + ", deadline:" + getDeadline()
                + "}";
    }

}
