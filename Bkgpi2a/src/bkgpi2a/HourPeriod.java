package bkgpi2a;

/**
 * Classe d�crivant une p�riode horaire d�finit par une heure de d�but et une
 * heure de fin.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
public class HourPeriod {

    /**
     * Heure de d�but de p�riode
     */
    private String start;

    /**
     * Heure de fin de p�riode
     */
    private String end;

    /**
     * Heure de fin de p�riode
     *
     * @return l'heure de fin de p�riode
     */
    public String getEnd() {
        return end;
    }

    /**
     * D�finit l'heure de fin de p�riode
     *
     * @param end l'heure de fin de p�riode
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Retourne l'heure de d�but de p�riode
     *
     * @return l'heure de d�but de p�riode
     */
    public String getStart() {
        return start;
    }

    /**
     * D�finit l'heure de d�but de p�riode
     *
     * @param start l'heure de d�but de p�riode
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
