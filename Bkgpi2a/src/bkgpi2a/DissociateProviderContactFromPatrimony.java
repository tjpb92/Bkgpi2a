package bkgpi2a;

import static bkgpi2a.CommandType.DISSOCIATE_PROVIDER_CONTACT_FROM_PATRIMONY;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant la dissociation de la relation entre un prestataire (ProviderContact) et d'un patrimoine (Patrimony) : DissociateProviderContactFromPatrimony, #1475
 *
 * @author Thierry Baribaud
 * @version 1.20
 * @see http://performanceimmo.github.io/API/#...
 */
@JsonIgnoreProperties({"_id", "sentDate", "commandTypeUid", "status", "nbError"})
@JsonTypeName("DissociateProviderContactFromPatrimony")
public class DissociateProviderContactFromPatrimony extends Command {

    /**
     * Identifiant unique du patrimoine
     */
    private String patrimonyUid;

    /**
     * Constructeur de la classe DissociateProviderContactFromPatrimony
     */
    public DissociateProviderContactFromPatrimony() {
        setCommandTypeUid(DISSOCIATE_PROVIDER_CONTACT_FROM_PATRIMONY.getUid());
        setCommandType(DISSOCIATE_PROVIDER_CONTACT_FROM_PATRIMONY.getName());
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
