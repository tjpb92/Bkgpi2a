package bkgpi2a;

import static bkgpi2a.EventType.CALL_ANSWERED_BY_PROVIDER;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant l'�v�nement de r�ponse d'un intervenant � une sollicitation :
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
     * Op�rateur ayant saisi la programmation de l'intervention
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private Provider provider;

    /**
     * Commentaire ajout� au ticket
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
     * @return l'op�rateur ayant saisi la programmation de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant saisi la programmation de
     * l'intervention
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
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
     * @return le comment ajout� au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment d�finit le comment ajout� au ticket
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
