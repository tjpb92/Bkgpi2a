package bkgpi2a;

import static bkgpi2a.TimeSlotType.HOUR_PERIODS;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe décrivant toute une liste de périodes horaires
 * 
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonTypeName("HourPeriods")
public class HourPeriods extends TimeSlot{
   
    private List<HourPeriod> periods;

    /**
     * Retourne la liste des périodes horaires
     *
     * @return la liste des périodes horaires
     */
    public List<HourPeriod> getPeriods() {
        return periods;
    }
    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public HourPeriods() {
        periods = new ArrayList();
        setTimeSlotType(HOUR_PERIODS.getName());
    }

    /**
     * Définit la liste des périodes horaires
     *
     * @param periods la liste des périodes horaires
     */
    public void setPeriods(List<HourPeriod> periods) {
        this.periods = periods;
    }

    /**
     * Ajoute une période horaire à la liste
     * @param hourPeriod période horaire
     */
    public void add(HourPeriod hourPeriod) {
        this.periods.add(hourPeriod);
    }
    
    @Override
    public String toString() {
        return "HourPeriods{" + 
                "periods=" + periods + 
                ", timeSlotPeriod=" + this.getTimeSlotType() +
                '}';
    }
 
}
