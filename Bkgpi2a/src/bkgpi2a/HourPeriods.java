package bkgpi2a;

import static bkgpi2a.TimeSlotType.HOUR_PERIODS;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d�crivant toute une liste de p�riodes horaires
 * 
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonTypeName("HourPeriods")
public class HourPeriods extends TimeSlot{
   
    private List<HourPeriod> periods;

    /**
     * Retourne la liste des p�riodes horaires
     *
     * @return la liste des p�riodes horaires
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
     * D�finit la liste des p�riodes horaires
     *
     * @param periods la liste des p�riodes horaires
     */
    public void setPeriods(List<HourPeriod> periods) {
        this.periods = periods;
    }

    /**
     * Ajoute une p�riode horaire � la liste
     * @param hourPeriod p�riode horaire
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
