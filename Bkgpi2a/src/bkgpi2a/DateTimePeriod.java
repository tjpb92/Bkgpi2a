package bkgpi2a;

import static bkgpi2a.InterventionPeriodType.DATETIME_PERIOD;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant p�riode fixe dans le temps. Elle est d�finie par une date de
 * d�but et une date de fin.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonTypeName("DateTimePeriod")
@JsonPropertyOrder({"label", "startDate", "endDate", "interventionPeriodType"})
public class DateTimePeriod extends InterventionPeriod {

    /**
     * Date de d�but de la p�riode
     */
    private String startDate;

    /**
     * Date de fin de la p�riode
     */
    private String endDate;

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public DateTimePeriod() {
        setInterventionPeriodType(DATETIME_PERIOD.getName());
    }

    /**
     * @return la date de d�but de la p�riode
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate d�finit la date de d�but de la p�riode
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return la date de fin de la p�riode
     */
    public String getEndDate() {
        return startDate;
    }

    /**
     * @param endDate d�finit la date de fin de la p�riode
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
