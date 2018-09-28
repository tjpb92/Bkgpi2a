package bkgpi2a;

/**
 * Enumération décrivant les types de périodes d'intervention.
 * InterventionPeriod = DateTimePeriod | WeekDaysPeriod | SpecificDaysPeriod
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
public enum InterventionPeriodType {

    /**
     * Période entre deux dates
     */
    DATETIME_PERIOD("DateTimePeriod"),
    /**
     * Période sur une semaine
     */
    WEEK_DAYS_PERIOD("WeekDaysPeriod"),
    /**
     * Jours spécifique
     */
    SPECIFIC_DAYS_PERIOD("SpecificDaysPeriod");

    /**
     * Type de période d'intervention
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    InterventionPeriodType(String name) {
        this.name = name;
    }

    /**
     * @return le type de période d'intervention
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
