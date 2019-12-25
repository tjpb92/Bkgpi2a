package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe d�crivant un LinkedEntities
 *
 * @author Thierry Baribaud
 * @version 1.30
 * @see https://performanceimmo.github.io/API/#linkedentities
 */
@JsonIgnoreProperties(value = {"holdingUid", "callCenters"})
public class LinkedEntities {

    /**
     * Patrimoine concern�
     */
    private PatrimonyAbstract patrimony;

    /**
     * Soci�t� concern�e
     */
    private ClientCompanyAbstract company;
    
    /**
     * Holding (SafeUuid to be defined)
     */

    /**
     * Liste d'agences du client
     */
    private AgencyAbstractList agencies;

    /**
     * callCenters (SafeUuidList to be defined)
     */
    
    /**
     * @return le patrimoine concern�
     */
    public PatrimonyAbstract getPatrimony() {
        return patrimony;
    }

    /**
     * @param patrimony d�finit le patrimoine concern�
     */
    public void setPatrimony(PatrimonyAbstract patrimony) {
        this.patrimony = patrimony;
    }

    /**
     * @return le client concern�
     */
    public ClientCompanyAbstract getCompany() {
        return company;
    }

    /**
     * @param company d�finit le client concern�
     */
    public void setCompany(ClientCompanyAbstract company) {
        this.company = company;
    }

    /**
     * @return la liste des agences du client
     */
    public AgencyAbstractList getAgencies() {
        return agencies;
    }

    /**
     * @param category d�finit la liste des agences du client
     */
    public void setTicketUid(AgencyAbstractList category) {
        this.agencies = category;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "LinkedEntities:{"
                + " patrimony:" + getPatrimony()
                + ", company:" + getCompany()
                + ", agencies:" + getAgencies()
                + "}";
    }

}
