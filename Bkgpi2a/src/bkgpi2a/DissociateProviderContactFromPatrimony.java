package bkgpi2a;

import static bkgpi2a.CommandType.DISSOCIATE_PROVIDER_CONTACT_FROM_PATRIMONY;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant la dissociation de la relation entre un prestataire (ProviderContact) et d'un patrimoine (Patrimony) : DissociateProviderContactFromPatrimony, #1475
 *
 * @author Thierry Baribaud
 * @version 1.26
 * @see http://performanceimmo.github.io/API/#providercontactevent
 */
@JsonIgnoreProperties({"_id", "sentDate", "commandTypeUid", "status", "nbError"})
@JsonTypeName("DissociateProviderContactFromPatrimony")
@JsonPropertyOrder({ "processUid", "patrimonyUid", "date", "commandType" })
public class DissociateProviderContactFromPatrimony extends Command {

    /**
     * Identifiant unique du patrimoine
     */
    private String patrimonyUid;

    /**
     * Constructeur principal de la classe DissociateProviderContactFromPatrimony
     */
    public DissociateProviderContactFromPatrimony() {
        setCommandTypeUid(DISSOCIATE_PROVIDER_CONTACT_FROM_PATRIMONY.getUid());
        setCommandType(DISSOCIATE_PROVIDER_CONTACT_FROM_PATRIMONY.getName());
    }

    /**
     * Constructeur secondaire de la classe DissociateProviderContactFromPatrimony
     * Construit la commande à partir de l'événement
     * @param providerContactDissociatedFromPatrimony événement associé à la commande.
     */
    public DissociateProviderContactFromPatrimony(ProviderContactDissociatedFromPatrimony providerContactDissociatedFromPatrimony) {
        this();
        setProcessUid(providerContactDissociatedFromPatrimony.getProcessUid());
        setPatrimonyUid(providerContactDissociatedFromPatrimony.getPatrimonyUid());
        setDate(providerContactDissociatedFromPatrimony.getDate());
        setSentDate(providerContactDissociatedFromPatrimony.getSentDate());
    }
    
    /**
     * @return l'identifiant unique du patrimoine
     */
    public String getPatrimonyUid() {
        return patrimonyUid;
    }

    /**
     * @param patrimonyUid définit l'identifiant unique du patrimoine
     */
    public void setPatrimonyUid(String patrimonyUid) {
        this.patrimonyUid = patrimonyUid;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "DissociateProviderContactFromPatrimony:{"
                + super.toString()
                + ", patrimonyUid:" + getPatrimonyUid()
                + "}";
    }
}
