package bkgpi2a;

import static bkgpi2a.AssigneeType.REFERENCED_PROVIDER_CONTACT;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un fournisseur (carte de visite) référencé
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/...
 */
@JsonTypeName("ReferencedProviderContact")
@JsonPropertyOrder({"providerContactUid", "assigneeType"})
public class ReferencedProviderContact extends Assignee {

    /**
     * Identifiant du fournisseur
     */
    private String providerContactUid;

    /**
     * Constructeur principal de la classe ReferencedProviderContact
     */
    public ReferencedProviderContact() {
        setAssigneeType(REFERENCED_PROVIDER_CONTACT.getName());
    }

    /**
     * @return l'identifiant du fournisseur
     */
    public String getProviderContactUid() {
        return providerContactUid;
    }

    /**
     * @param providerContactUid définit l'identifiant du fournisseur
     */
    public void setProviderContactUid(String providerContactUid) {
        this.providerContactUid = providerContactUid;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ReferencedProviderContact:{"
                + super.toString()
                + ", providerContactUid:" + getProviderContactUid()
                + "}";
    }
}
