package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.CommandType.ASSOCIATE_PROVIDER_CONTACT_TO_AGENCY;

/**
 * Classe d�crivant une commande permettant d'associer un providerContact � une
 * agence.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#incrementprovidercontact
 */
@JsonIgnoreProperties({"_id"})
@JsonTypeName("AssociateProviderContactToAgency")
public class AssociateProviderContactToAgency extends Command {

    /**
     * Identifiant de l'agence
     */
    private String agencyUid;

    /**
     * Retourne l'identifiant de l'agence
     *
     * @return l'identifiant de l'agence
     */
    public String getAgencyUid() {
        return agencyUid;
    }

    /**
     * D�finit l'identifiant de l'agence
     *
     * @param agencyUid l'identifiant de l'agence
     */
    public void setAgencyUid(String agencyUid) {
        this.agencyUid = agencyUid;
    }

    /**
     * Constructeur de la classe AssociateProviderContactToAgency
     */
    public AssociateProviderContactToAgency() {
        setCommandType(ASSOCIATE_PROVIDER_CONTACT_TO_AGENCY.getName());
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AssociateProviderContactToAgency:{"
                + super.toString()
                + ", agencyUid" + getAgencyUid()
                + "}";
    }
}
