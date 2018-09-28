package bkgpi2a;

import static bkgpi2a.AssigneeType.REFERENCED_PROVIDER_COMPANY;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un fournisseur (soci�t�) r�f�renc�
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/...
 */
@JsonTypeName("ReferencedProviderCompany")
@JsonPropertyOrder({"providerCompanyUid", "assigneeType"})
public class ReferencedProviderCompany extends Assignee {

    /**
     * Identifiant du fournisseur
     */
    private String providerCompanyUid;

    /**
     * Constructeur principal de la classe ReferencedProviderCompany
     */
    public ReferencedProviderCompany() {
        setAssigneeType(REFERENCED_PROVIDER_COMPANY.getName());
    }

    /**
     * @return l'identifiant du fournisseur
     */
    public String getProviderCompanyUid() {
        return providerCompanyUid;
    }

    /**
     * @param providerCompanyUid d�finit l'identifiant du fournisseur
     */
    public void setProviderCompanyUid(String providerCompanyUid) {
        this.providerCompanyUid = providerCompanyUid;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ReferencedProviderCompany:{"
                + super.toString()
                + ", providerCompanyUid:" + getProviderCompanyUid()
                + "}";
    }
}
