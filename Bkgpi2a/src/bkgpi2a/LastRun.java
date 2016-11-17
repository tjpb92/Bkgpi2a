package bkgpi2a;

/**
 * Classse donnant la dernière date d'exécution d'un programme donné
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
     * Date de dernière exécution
     */
    private String lastRun;

    /**
     * @return le nom du programme
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * @param programName définit le nom du programme
     */
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    /**
     * @return la date de dernière exécution
     */
    public String getLastRun() {
        return lastRun;
    }

    /**
     * @param lastRun définit la date de dernière exécution
     */
    public void setLastRun(String lastRun) {
        this.lastRun = lastRun;
    }

    /**
     * @return Retourne la dernière exécution sous forme textuelle
     */
    @Override
    public String toString() {
        return "LastRun:{programName:" + getProgramName()
                + ", lastRun:" + getLastRun()
                + "}";
    }
}
