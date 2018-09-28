package bkgpi2a;

/**
 * Classe décrivant un engagement contractuel
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/275
 */
public class Commitment {

    /**
     * Référence de l'activité concernée
     */
    private String activityUid;

    /**
     * Retourne l'identifiant de l'activité
     *
     * @return l'identifiant de l'activité
     */
    public String getActivityUid() {
        return activityUid;
    }

    /**
     * Définit l'identifiant de l'activité
     *
     * @param activityUid l'identifiant de l'activité
     */
    public void setActivityUid(String activityUid) {
        this.activityUid = activityUid;
    }

    @Override
    public String toString() {
        return "Commitment{"
                + "activityUid=" + activityUid
                + '}';
    }

}
