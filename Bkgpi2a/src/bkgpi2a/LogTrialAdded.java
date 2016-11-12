package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.LOG_TRIAL_ADDED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant un essai ajouté au journal d'un ticket : LogTrialAdded, #565
 *
 * @author Thierry Baribaud
 * @version 0.23
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("LogTrialAdded")
public class LogTrialAdded extends Event {

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
     * Message ajouté au ticket
     */
    private LogTrial logTrial;

    /**
     * Constructeur de la classe LogTrialAdded
     */
    public LogTrialAdded() {
        setEventTypeUid(LOG_TRIAL_ADDED.getUid());
        setEventType(LOG_TRIAL_ADDED.getName());
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
     * @return l'essai ajouté au ticket
     */
    public LogTrial getLogTrial() {
        return logTrial;
    }

    /**
     * @param logTrial définit l'essai ajouté au ticket
     */
    public void setLogTrial(LogTrial logTrial) {
        this.logTrial = logTrial;
    }

    /**
     * @return la date à laquelle l'événement a eu lieu
     */
    public String getLogTrialAddedDate() {
        return getDate();
    }

    /**
     * @param logTrialAddedDate définit la date à laquelle l'événement a eu lieu
     */
    public void setLogTrialAddedDate(String logTrialAddedDate) {
        setDate(logTrialAddedDate);
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
        return "LogTrialAdded:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", logTrial:" + getLogTrial()
                + ", logTrialAddedDate:" + getLogTrialAddedDate()
                + "}";
    }

}
