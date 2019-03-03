package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant l'identification géographique supplémentaire
 *
 * @author Thierry Baribaud
 * @version 1.03
 * @see http://performanceimmo.github.io/API/#basicaddress
 */
public class GeographicalIdentificationSupplement {

    /**
     * Le bâtiment
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String building;

    /**
     * Retourne le bâtiment
     *
     * @return retourne le bâtiment
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Définit le bâtiment
     *
     * @param building le bâtiment
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "GeographicalIdentificationSupplement{" + "building=" + building + '}';
    }

}
