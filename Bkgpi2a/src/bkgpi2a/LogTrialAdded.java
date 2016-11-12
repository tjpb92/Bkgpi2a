package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.LOG_TRIAL_ADDED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant un essai ajout� au journal d'un ticket : LogTrialAdded, #565
 *
 * @author Thierry Baribaud
 * @version 0.23
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("LogTrialAdded")
public class LogTrialAdded extends Event {

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
     * Message ajout� au ticket
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
     * @return l'essai ajout� au ticket
     */
    public LogTrial getLogTrial() {
        return logTrial;
    }

    /**
     * @param logTrial d�finit l'essai ajout� au ticket
     */
    public void setLogTrial(LogTrial logTrial) {
        this.logTrial = logTrial;
    }

    /**
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getLogTrialAddedDate() {
        return getDate();
    }

    /**
     * @param logTrialAddedDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setLogTrialAddedDate(String logTrialAddedDate) {
        setDate(logTrialAddedDate);
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
        return "LogTrialAdded:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", logTrial:" + getLogTrial()
                + ", logTrialAddedDate:" + getLogTrialAddedDate()
                + "}";
    }

}
