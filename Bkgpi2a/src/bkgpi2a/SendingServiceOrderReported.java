package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.SENDING_SERVICE_ORDER_REPORTED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant l'envoi d'un ordre de service : SendingServiceOrderReported, #615
 *
 * @author Thierry Baribaud
 * @version 0.31
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("SendingServiceOrderReported")
public class SendingServiceOrderReported extends Event {

    /**
     * Opérateur ayant ajouté l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Provider provider;

    /**
     * Référence de l'ordre de service
     */
    private String ref;

    /**
     * Date à laquelle l'ordre de service a été envoyé
     */
    private String sendingDate;

    /**
     * Constructeur de la classe ServiceOrderSent
     */
    public SendingServiceOrderReported() {
        setEventTypeUid(SENDING_SERVICE_ORDER_REPORTED.getUid());
        setEventType(SENDING_SERVICE_ORDER_REPORTED.getName());
    }

    /**
     * @return l'opérateur ayant ajouté l'essai
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant ajouté l'essai
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la référence de l'ordre de service
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref définit la référence de l'ordre de service
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return l'intervenant courant si présent
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider définit l'intervenant courant
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * @return la date à laquelle l'événement a eu lieu
     */
    public String getReportDate() {
        return getDate();
    }

    /**
     * @param reportDate définit la date à laquelle l'événement a eu lieu
     */
    public void setReportDate(String reportDate) {
        setDate(reportDate);
    }

    /**
     * @return la date à laquelle l'ordre de service a été envoyé
     */
    public String getSendingDate() {
        return sendingDate;
    }

    /**
     * @param sendingDate définit la date à laquelle l'ordre de service a été
     * envoyé
     */
    public void setSendingDate(String sendingDate) {
        this.sendingDate = sendingDate;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "SendingServiceOrderReported:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", ref:" + getRef()
                + ", reportDate:" + getReportDate()
                + ", sendingDate:" + getSendingDate()
                + "}";
    }

}
