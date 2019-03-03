package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant des informations supplémentaires sur la localisation
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
     * Numéro d'appartement
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String unit;

    /**
     * Entrée
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String entrance;

    /**
     * Numéro de cabine d'ascenseur
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String elevator;

    /**
     * Numéro d'escalier
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String staircase;

    /**
     * Retourne le numéro d'escalier
     *
     * @return le numéro d'escalier
     */
    public String getStaircase() {
        return staircase;
    }

    /**
     * Définit le numéro d'escalier
     *
     * @param staircase le numéro d'escalier
     */
    public void setStaircase(String staircase) {
        this.staircase = staircase;
    }

    /**
     * Retourne le numéro de cabine d'ascenseur
     *
     * @return le numéro de cabine d'ascenseur
     */
    public String getElevator() {
        return elevator;
    }

    /**
     * Définit le numéro de cabine d'ascenseur
     *
     * @param elevator le numéro de cabine d'ascenseur
     */
    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    /**
     * Retourne le numéro d'entrée
     *
     * @return le numéro d'entrée
     */
    public String getEntrance() {
        return entrance;
    }

    /**
     * Définit le numéro d'entrée
     *
     * @param entrance le numéro d'entrée
     */
    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    /**
     * Retourne le numéro d'appartement
     *
     * @return the value of unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Définit le numéro d'appartement
     *
     * @param unit new value of unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Retourne l'étage
     *
     * @return the value of floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * Définit l'étage
     *
     * @param floor l'étage
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
