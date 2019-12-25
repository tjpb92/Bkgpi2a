package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe décrivant un LinkedEntities
 *
 * @author Thierry Baribaud
 * @version 1.30
 * @see https://performanceimmo.github.io/API/#linkedentities
 */
@JsonIgnoreProperties(value = {"holdingUid", "callCenters"})
public class LinkedEntities {

    /**
     * Patrimoine concerné
     */
    private PatrimonyAbstract patrimony;

    /**
     * Société concernée
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
     * @return le patrimoine concerné
     */
    public PatrimonyAbstract getPatrimony() {
        return patrimony;
    }

    /**
     * @param patrimony définit le patrimoine concerné
     */
    public void setPatrimony(PatrimonyAbstract patrimony) {
        this.patrimony = patrimony;
    }

    /**
     * @return le client concerné
     */
    public ClientCompanyAbstract getCompany() {
        return company;
    }

    /**
     * @param company définit le client concerné
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
     * @param category définit la liste des agences du client
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
