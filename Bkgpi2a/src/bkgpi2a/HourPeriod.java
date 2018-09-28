package bkgpi2a;

/**
 * Classe décrivant une période horaire définit par une heure de début et une
 * heure de fin.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
public class HourPeriod {

    /**
     * Heure de début de période
     */
    private String start;

    /**
     * Heure de fin de période
     */
    private String end;

    /**
     * Heure de fin de période
     *
     * @return l'heure de fin de période
     */
    public String getEnd() {
        return end;
    }

    /**
     * Définit l'heure de fin de période
     *
     * @param end l'heure de fin de période
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Retourne l'heure de début de période
     *
     * @return l'heure de début de période
     */
    public String getStart() {
        return start;
    }

    /**
     * Définit l'heure de début de période
     *
     * @param start l'heure de début de période
     */
    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "HourPeriod{"
                + "start=" + start
                + ", end=" + end
                + '}';
    }

}
