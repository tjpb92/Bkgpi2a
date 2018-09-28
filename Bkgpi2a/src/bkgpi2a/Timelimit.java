package bkgpi2a;

/**
 * Classe d�crivant une limite de temps
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/275
 */
public class Timelimit {

    /**
     * Dur�e
     */
    private String value;

    /**
     * Unit� de temps
     */
    private String unit;

    /**
     * Retourne l'unit� de temps
     *
     * @return l'unit� de temps
     */
    public String getUnit() {
        return unit;
    }

    /**
     * D�finit l'unit� de temps
     *
     * @param unit l'unit� de temps
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Retourne la dur�e
     *
     * @return la dur�e
     */
    public String getValue() {
        return value;
    }

    /**
     * D�finit la dur�e
     *
     * @param value la dur�e
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
