package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.INTERVENTION_DEADLINE_DEFINED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant l'envoi d'un ordre de service : InterventionDeadLineDefined,
 * #625
 *
 * @author Thierry Baribaud
 * @version 0.33
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("InterventionDeadLineDefined")
public class InterventionDeadLineDefined extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Provider provider;

    /**
     * Date de fin des travaux
     */
    private String deadline;

    /**
     * Constructeur de la classe ServiceOrderSent
     */
    public InterventionDeadLineDefined() {
        setEventTypeUid(INTERVENTION_DEADLINE_DEFINED.getUid());
        setEventType(INTERVENTION_DEADLINE_DEFINED.getName());
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
        return "InterventionDeadLineDefined:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", deadline:" + getDeadline()
                + "}";
    }

}
