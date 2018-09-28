package bkgpi2a;

/**
 * Enum�ration d�crivant les types de p�riodes d'intervention.
 * InterventionPeriod = DateTimePeriod | WeekDaysPeriod | SpecificDaysPeriod
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
public enum InterventionPeriodType {

    /**
     * P�riode entre deux dates
     */
    DATETIME_PERIOD("DateTimePeriod"),
    /**
     * P�riode sur une semaine
     */
    WEEK_DAYS_PERIOD("WeekDaysPeriod"),
    /**
     * Jours sp�cifique
     */
    SPECIFIC_DAYS_PERIOD("SpecificDaysPeriod");

    /**
     * Type de p�riode d'intervention
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    InterventionPeriodType(String name) {
        this.name = name;
    }

    /**
     * @return le type de p�riode d'intervention
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
