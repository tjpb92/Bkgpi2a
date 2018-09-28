package bkgpi2a;

/**
 * Enumération décrivant les types de plages horaires. 
 * TimeSlot = AllDayLong | HourPeriods
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
public enum TimeSlotType {

    /**
     * Toute la journée
     */
    ALL_DAY_LONG("AllDayLong"),
    /**
     * Périodes horaires
     */
    HOUR_PERIODS("HourPeriods");

    /**
     * Type de plage horaire
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    TimeSlotType(String name) {
        this.name = name;
    }

    /**
     * @return le type de plage horaire
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
