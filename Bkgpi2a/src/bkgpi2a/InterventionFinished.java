package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_FINISHED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un fin d'intervention : InterventionFinished, #534
 *
 * @author Thierry Baribaud
 * @version 0.21
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("InterventionFinished")
public class InterventionFinished extends Event {

    /**
     * Opérateur ayant ajouté l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private Provider provider;

    /**
     * Constructeur de la classe InterventionFinished
     */
    public InterventionFinished() {
        setEventTypeUid(INTERVENTION_FINISHED.getUid());
        setEventType(INTERVENTION_FINISHED.getName());
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
     * @return la date à laquelle l'événement a eu lieu
     */
    public String getFinishedDate() {
        return getDate();
    }

    /**
     * @param finishedDate définit la date à laquelle l'événement a eu lieu
     */
    public void setFinishedDate(String finishedDate) {
        setDate(finishedDate);
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
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Finished:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", finishedDate:" + getFinishedDate()
                + "}";
    }

}
