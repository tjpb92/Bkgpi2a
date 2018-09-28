package bkgpi2a;

/**
 * Classe décrivant une limite de temps
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/275
 */
public class Timelimit {

    /**
     * Durée
     */
    private String value;

    /**
     * Unité de temps
     */
    private String unit;

    /**
     * Retourne l'unité de temps
     *
     * @return l'unité de temps
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Définit l'unité de temps
     *
     * @param unit l'unité de temps
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Retourne la durée
     *
     * @return la durée
     */
    public String getValue() {
        return value;
    }

    /**
     * Définit la durée
     *
     * @param value la durée
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TimeLimit{"
                + "value=" + value
                + ", unit=" + unit
                + '}';
    }

}
