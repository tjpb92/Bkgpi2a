package bkgpi2a;

import static bkgpi2a.InterventionPeriodType.SPECIFIC_DAYS_PERIOD;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe décrivant une période définit par une liste de jours spécifiques.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonTypeName("SpecificDaysPeriod")
@JsonPropertyOrder({"label", "days", "timeSlot", "interventionPeriodType"})
public class SpecificDaysPeriod extends InterventionPeriod {

    /**
     * Liste des jours spécifiques
     */
    private List<String> days;

    /**
     * Liste de périodes horaires
     */
    private TimeSlot timeSlot;

    /**
     * Retourne la liste des périodes horaires
     *
     * @return la liste des périodes horaires
     */
    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    /**
     * Définit la liste des périodes horaires
     *
     * @param timeSlot la liste des périodes horaires
     */
    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * Retourne la liste des jours spécifiques
     *
     * @return la liste des jours spécifiques
     */
    public List<String> getDays() {
        return days;
    }

    /**
     * Définit la liste des jours spécifiques
     *
     * @param days la liste des jours spécifiques
     */
    public void setDays(List<String> days) {
        this.days = days;
    }

    /**
     * Ajoute un jour spécifique à la liste
     *
     * @param day jour à ajouter
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
