package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.SERVICE_ORDER_SENT;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant l'envoi d'un ordre de service :
 ServiceOrderSentOld, #615
 *
 * @author Thierry Baribaud
 * @version 0.31
 * @see http://performanceimmo.github.io/API/#ticketevent
 * @deprecated le 25/11/16, remplacé par SendingServiceOrderReported
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("ServiceOrderSent")
public class ServiceOrderSentOld extends Event {

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
     * Type d'envoi
     * ATTENTION : à implémenter avec le type ServiceOrderKind ultérieurement
     * @see http://performanceimmo.github.io/API/#serviceorderkind
     */
    private String kindOfSending;
    
    /**
     * Constructeur de la classe ServiceOrderSent
     */
    public ServiceOrderSentOld() {
        setEventTypeUid(SERVICE_ORDER_SENT.getUid());
        setEventType(SERVICE_ORDER_SENT.getName());
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
     * @return le type d'envoi
     */
    public String getKindOfSending() {
        return kindOfSending;
    }

    /**
     * @param kindOfSending définit le type d'envoi
     */
    public void setKindOfSending(String kindOfSending) {
        this.kindOfSending = kindOfSending;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ServiceOrderSent:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", ref:" + getRef()
                + ", kindOfSending:" + getKindOfSending()
                + "}";
    }

}
