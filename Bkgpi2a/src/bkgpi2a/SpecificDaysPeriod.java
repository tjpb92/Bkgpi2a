package bkgpi2a;

import static bkgpi2a.InterventionPeriodType.SPECIFIC_DAYS_PERIOD;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d�crivant une p�riode d�finit par une liste de jours sp�cifiques.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonTypeName("SpecificDaysPeriod")
@JsonPropertyOrder({"label", "days", "timeSlot", "interventionPeriodType"})
public class SpecificDaysPeriod extends InterventionPeriod {

    /**
     * Liste des jours sp�cifiques
     */
    private List<String> days;

    /**
     * Liste de p�riodes horaires
     */
    private TimeSlot timeSlot;

    /**
     * Retourne la liste des p�riodes horaires
     *
     * @return la liste des p�riodes horaires
     */
    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    /**
     * D�finit la liste des p�riodes horaires
     *
     * @param timeSlot la liste des p�riodes horaires
     */
    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * Retourne la liste des jours sp�cifiques
     *
     * @return la liste des jours sp�cifiques
     */
    public List<String> getDays() {
        return days;
    }

    /**
     * D�finit la liste des jours sp�cifiques
     *
     * @param days la liste des jours sp�cifiques
     */
    public void setDays(List<String> days) {
        this.days = days;
    }

    /**
     * Ajoute un jour sp�cifique � la liste
     *
     * @param day jour � ajouter
     */
    public void add(String day) {
        this.days.add(day);
    }

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public SpecificDaysPeriod() {
        this.days = new ArrayList();
        setInterventionPeriodType(SPECIFIC_DAYS_PERIOD.getName());
    }

    @Override
    public String toString() {
        return "SpecificDaysPeriod{"
                + "Days=" + days
                + ", timeSlot=" + timeSlot
                + ", interventionPeriodType=" + getInterventionPeriodType()
                + '}';
    }

}
