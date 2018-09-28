package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant une plage horaire.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "timeSlotType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = AllDayLong.class, name = "AllDayLong"),
    @JsonSubTypes.Type(value = HourPeriods.class, name = "HourPeriods"),})
public abstract class TimeSlot {

    /**
     * Type de plage horaire
     */
    private String timeSlotType;

    /**
     * Constructeur principal de la classe TimeSlot
     */
    public TimeSlot() {
    }

    /**
     * @return le type de plage horaire
     */
    public String getTimeSlotType() {
        return timeSlotType;
    }

    /**
     * @param timeSlotType définit le type de plage horaire
     */
    public void setTimeSlotType(String timeSlotType) {
        this.timeSlotType = timeSlotType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TimeSlot:{"
                + "interventionPeriodType:" + timeSlotType
                + "}";
    }

}
