package bkgpi2a;

import static bkgpi2a.EventType.CALL_ANSWERED_BY_PROVIDER;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant l'événement de réponse d'un intervenant à une sollicitation :
 * CallAnsweredByProvider, #600
 *
 * @author Thierry Baribaud
 * @version 1.38
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">CallAnsweredByProvider</A>
 */
//@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("CallAnsweredByProvider")
public class CallAnsweredByProvider extends Event {

    /**
     * Opérateur ayant saisi la programmation de l'intervention
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private Provider provider;

    /**
     * Commentaire ajouté au ticket
     */
    private String comment;

    /**
     * Constructeur de la classe CallAnsweredByProvider
     */
    public CallAnsweredByProvider() {
        setEventTypeUid(CALL_ANSWERED_BY_PROVIDER.getUid());
        setEventType(CALL_ANSWERED_BY_PROVIDER.getName());
    }

    /**
     * @return l'opérateur ayant saisi la programmation de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant saisi la programmation de
     * l'intervention
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
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
     * @return le comment ajouté au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le comment ajouté au ticket
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "CallAnsweredByProvider:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", commentaire:" + getComment()
                + "}";
    }
}
