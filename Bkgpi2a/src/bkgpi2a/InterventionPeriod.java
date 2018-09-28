package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite d�crivant p�riode d'intervention.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/276
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "interventionPeriodType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = DateTimePeriod.class, name = "DateTimePeriod"),
    @JsonSubTypes.Type(value = WeekDaysPeriod.class, name = "WeekDaysPeriod"),
    @JsonSubTypes.Type(value = SpecificDaysPeriod.class, name = "SpecificDaysPeriod"),})
public abstract class InterventionPeriod {

    /**
     * Nom de la p�riode d'intervention
     */
    private String label;

    /**
     * Type de p�riode d'intervention
     */
    private String interventionPeriodType;

    /**
     * Constructeur principal de la classe InterventionPeriod
     */
    public InterventionPeriod() {
    }

    /**
     * @return le type de p�riode d'intervention
     */
    public String getInterventionPeriodType() {
        return interventionPeriodType;
    }

    /**
     * @param interventionPeriodType d�finit le type de p�riode d'intervention
     */
    public void setInterventionPeriodType(String interventionPeriodType) {
        this.interventionPeriodType = interventionPeriodType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "InterventionPeriod:{"
                + "label:" + label
                + ", interventionPeriodType:" + interventionPeriodType
                + "}";
    }

    /**
     * @return le nom de la de p�riode d'intervention
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label d�finit le nom de la p�riode d'intervention
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
