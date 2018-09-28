package bkgpi2a;

import static bkgpi2a.TimeSlotType.ALL_DAY_LONG;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant toute une journée
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonTypeName("AllDayLong")
public class AllDayLong extends TimeSlot {

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public AllDayLong() {
        setTimeSlotType(ALL_DAY_LONG.getName());
    }

}
