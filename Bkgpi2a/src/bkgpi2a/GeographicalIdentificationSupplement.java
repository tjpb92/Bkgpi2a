package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant l'identification g�ographique suppl�mentaire
 *
 * @author Thierry Baribaud
 * @version 1.03
 * @see http://performanceimmo.github.io/API/#basicaddress
 */
public class GeographicalIdentificationSupplement {

    /**
     * Le b�timent
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String building;

    /**
     * Retourne le b�timent
     *
     * @return retourne le b�timent
     */
    public String getBuilding() {
        return building;
    }

    /**
     * D�finit le b�timent
     *
     * @param building le b�timent
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "GeographicalIdentificationSupplement{" + "building=" + building + '}';
    }

}
