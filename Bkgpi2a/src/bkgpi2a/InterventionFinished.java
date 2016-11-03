package bkgpi2a;

import static bkgpi2a.EventType.INTERVENTION_FINISHED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un fin d'intervention : InterventionFinished, #534
 *
 * @author Thierry Baribaud
 * @version 0.21
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("InterventionFinished")
public class InterventionFinished extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
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
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getFinishedDate() {
        return getDate();
    }

    /**
     * @param finishedDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setFinishedDate(String finishedDate) {
        setDate(finishedDate);
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
