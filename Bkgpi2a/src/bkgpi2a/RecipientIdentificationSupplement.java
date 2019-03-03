package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant des informations suppl�mentaires sur la localisation
 *
 * @author Thierry Baribaud
 * @version 1.03
 * @see http://performanceimmo.github.io/API/#basicaddress
 */
public class RecipientIdentificationSupplement {

    /**
     * Etage
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String floor;

    /**
     * Num�ro d'appartement
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String unit;

    /**
     * Entr�e
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String entrance;

    /**
     * Num�ro de cabine d'ascenseur
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String elevator;

    /**
     * Num�ro d'escalier
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String staircase;

    /**
     * Retourne le num�ro d'escalier
     *
     * @return le num�ro d'escalier
     */
    public String getStaircase() {
        return staircase;
    }

    /**
     * D�finit le num�ro d'escalier
     *
     * @param staircase le num�ro d'escalier
     */
    public void setStaircase(String staircase) {
        this.staircase = staircase;
    }

    /**
     * Retourne le num�ro de cabine d'ascenseur
     *
     * @return le num�ro de cabine d'ascenseur
     */
    public String getElevator() {
        return elevator;
    }

    /**
     * D�finit le num�ro de cabine d'ascenseur
     *
     * @param elevator le num�ro de cabine d'ascenseur
     */
    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    /**
     * Retourne le num�ro d'entr�e
     *
     * @return le num�ro d'entr�e
     */
    public String getEntrance() {
        return entrance;
    }

    /**
     * D�finit le num�ro d'entr�e
     *
     * @param entrance le num�ro d'entr�e
     */
    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    /**
     * Retourne le num�ro d'appartement
     *
     * @return the value of unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * D�finit le num�ro d'appartement
     *
     * @param unit new value of unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Retourne l'�tage
     *
     * @return the value of floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * D�finit l'�tage
     *
     * @param floor l'�tage
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "RecipientIdentificationSupplement{"
                + "floor=" + floor
                + ", unit=" + unit
                + ", entrance=" + entrance
                + ", elevator=" + elevator
                + ", staircase=" + staircase
                + '}';
    }

}
