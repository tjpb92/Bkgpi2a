package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.CommandType.ASSOCIATE_PROVIDER_CONTACT_TO_COMPANY;

/**
 * Classe d�crivant une commande permettant d'associer un providerContact � une
 * soci�t�.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#incrementprovidercontact
 */
@JsonIgnoreProperties({"_id"})
@JsonTypeName("AssociateProviderContactToCompany")
public class AssociateProviderContactToCompany extends Command {

    /**
     * Identifiant de la soci�t�
     */
    private String companyUid;

    /**
     * Retourne l'identifiant de la soci�t�
     *
     * @return l'identifiant de la soci�t�
     */
    public String getCompanyUid() {
        return companyUid;
    }

    /**
     * D�finit l'identifiant de la soci�t�
     *
     * @param companyUid l'identifiant de la soci�t�
     */
    public void setCompanyUid(String companyUid) {
        this.companyUid = companyUid;
    }

    /**
     * Constructeur de la classe AssociateProviderContactToCompany
     */
    public AssociateProviderContactToCompany() {
        setCommandType(ASSOCIATE_PROVIDER_CONTACT_TO_COMPANY.getName());
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AssociateProviderContactToCompany:{"
                + super.toString()
                + ", companyUid" + getCompanyUid()
                + "}";
    }
}
