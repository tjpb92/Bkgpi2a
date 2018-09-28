package bkgpi2a;

import static bkgpi2a.InterventionPeriodType.DATETIME_PERIOD;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant période fixe dans le temps. Elle est définie par une date de
 * début et une date de fin.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonTypeName("DateTimePeriod")
@JsonPropertyOrder({"label", "startDate", "endDate", "interventionPeriodType"})
public class DateTimePeriod extends InterventionPeriod {

    /**
     * Date de début de la période
     */
    private String startDate;

    /**
     * Date de fin de la période
     */
    private String endDate;

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public DateTimePeriod() {
        setInterventionPeriodType(DATETIME_PERIOD.getName());
    }

    /**
     * @return la date de début de la période
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate définit la date de début de la période
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return la date de fin de la période
     */
    public String getEndDate() {
        return startDate;
    }

    /**
     * @param endDate définit la date de fin de la période
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "DateTimePeriod:{"
                + super.toString()
                + ", startDate:" + startDate
                + ", endDate:" + endDate
                + "}";
    }
}
