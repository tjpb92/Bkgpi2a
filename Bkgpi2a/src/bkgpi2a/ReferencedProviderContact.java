package bkgpi2a;

import static bkgpi2a.TicketAssigneeType.REFERENCED_PROVIDER_CONTACT;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un fournisseur (carte de visite) référencé
 *
 * @author Thierry Baribaud
 * @version 1.00
 * @see http://performanceimmo.github.io/API/#assigneetype
 */
@JsonTypeName("ReferencedProviderContact")
@JsonPropertyOrder({"providerContactUid", "assigneeType"})
public class ReferencedProviderContact extends TicketAssignee {

    /**
     * Identifiant du fournisseur
     */
    @JsonProperty("providerUid")
    private String providerContactUid;

    /**
     * Constructeur principal de la classe ReferencedProviderContact
     */
    public ReferencedProviderContact() {
        setTicketAssigneeType(REFERENCED_PROVIDER_CONTACT.getName());
    }

    /**
     * @return l'identifiant du fournisseur
     */
    @JsonGetter("providerUid")
    public String getProviderContactUid() {
        return providerContactUid;
    }

    /**
     * @param providerContactUid définit l'identifiant du fournisseur
     */
    @JsonSetter("providerUid")
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