package bkgpi2a;

import static bkgpi2a.TicketAssigneeType.REFERENCED_PROVIDER_COMPANY;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un fournisseur (société) référencé
 *
 * @author Thierry Baribaud
 * @version 1.00
 * @see http://performanceimmo.github.io/API/#assigneetype
 */
@JsonTypeName("ReferencedProviderCompany")
@JsonPropertyOrder({"providerCompanyUid", "assigneeType"})
public class ReferencedProviderCompany extends TicketAssignee {

    /**
     * Identifiant du fournisseur
     */
    private String providerCompanyUid;

    /**
     * Constructeur principal de la classe ReferencedProviderCompany
     */
    public ReferencedProviderCompany() {
        setTicketAssigneeType(REFERENCED_PROVIDER_COMPANY.getName());
    }

    /**
     * @return l'identifiant du fournisseur
     */
    public String getProviderCompanyUid() {
        return providerCompanyUid;
    }

    /**
     * @param providerCompanyUid définit l'identifiant du fournisseur
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