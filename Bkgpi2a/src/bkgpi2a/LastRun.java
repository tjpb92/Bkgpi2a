package bkgpi2a;

/**
 * Classse donnant la derni�re date d'ex�cution d'un programme donn�
 *
 * @author Thierry Baribaud
 * @version 0.26
 */
public class LastRun {

    /**
     * Nom du programme
     */
    private String programName;

    /**
     * Date de derni�re ex�cution
     */
    private String lastRun;

    /**
     * @return le nom du programme
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * @param programName d�finit le nom du programme
     */
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    /**
     * @return la date de derni�re ex�cution
     */
    public String getLastRun() {
        return lastRun;
    }

    /**
     * @param lastRun d�finit la date de derni�re ex�cution
     */
    public void setLastRun(String lastRun) {
        this.lastRun = lastRun;
    }

    /**
     * @return Retourne la derni�re ex�cution sous forme textuelle
     */
    @Override
    public String toString() {
        return "LastRun:{programName:" + getProgramName()
                + ", lastRun:" + getLastRun()
                + "}";
    }
}
