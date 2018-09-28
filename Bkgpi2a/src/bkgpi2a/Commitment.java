package bkgpi2a;

/**
 * Classe d�crivant un engagement contractuel
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/275
 */
public class Commitment {

    /**
     * R�f�rence de l'activit� concern�e
     */
    private String activityUid;

    /**
     * Retourne l'identifiant de l'activit�
     *
     * @return l'identifiant de l'activit�
     */
    public String getActivityUid() {
        return activityUid;
    }

    /**
     * D�finit l'identifiant de l'activit�
     *
     * @param activityUid l'identifiant de l'activit�
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
