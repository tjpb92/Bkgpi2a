package bkgpi2a;

/**
 * Classe décrivant un essai au journal. Cet essai est repris dans l'événement LogTrialAdded.
 * 
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#logtrial
 * @see tranresult.4gl
 */
public class LogTrial {
    
    /**
     * Code de l'essai
     */
    private String trialCode;
    
    /**
     * Libellé de l'essai
     */
    private String trialLabel;

    /**
     * @return le code de l'essai
     */
    public String getTrialCode() {
        return trialCode;
    }

    /**
     * @param trialCode définit le code de l'essai
     */
    public void setTrialCode(String trialCode) {
        this.trialCode = trialCode;
    }

    /**
     * @return le libellé de l'essai
     */
    public String getTrialLabel() {
        return trialLabel;
    }

    /**
     * @param trialLabel définit le libellé de l'essai
     */
    public void setTrialLabel(String trialLabel) {
        this.trialLabel = trialLabel;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "LogTrial:{"
                + "trialCode:" + getTrialCode()
                + ", trialLabel:" + getTrialLabel()
                + "}";
    }
}
