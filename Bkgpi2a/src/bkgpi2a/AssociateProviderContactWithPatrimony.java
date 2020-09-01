package bkgpi2a;

import static bkgpi2a.CommandType.ASSOCIATE_PROVIDER_CONTACT_WITH_PATRIMONY;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant la relation d'association entre un prestataire
 * (ProviderContact) et d'un patrimoine (Patrimony) :
 * AssociateProviderContactWithPatrimony, #1470
 *
 * @author Thierry Baribaud
 * @version 1.38
 * @see
 * <A href="http://performanceimmo.github.io/API/#incrementprovidercontact">AssociateProviderContactWithPatrimony</A>
 */
//@JsonIgnoreProperties({"_id", "sentDate", "commandTypeUid", "status", "nbError"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("AssociateProviderContactWithPatrimony")
@JsonPropertyOrder({"processUid", "patrimonyUid", "date", "commandType"})
public class AssociateProviderContactWithPatrimony extends Command {

    /**
     * Identifiant unique du patrimoine
     */
    private String patrimonyUid;

    /**
     * Constructeur principal de la classe AssociateProviderContactWithPatrimony
     */
    public AssociateProviderContactWithPatrimony() {
        setCommandTypeUid(ASSOCIATE_PROVIDER_CONTACT_WITH_PATRIMONY.getUid());
        setCommandType(ASSOCIATE_PROVIDER_CONTACT_WITH_PATRIMONY.getName());
    }

    /**
     * Constructeur secondaire de la classe
     * AssociateProviderContactWithPatrimony Construit la commande à partir de
     * l'événement
     *
     * @param providerContactAssociatedWithPatrimony événement associé à la
     * commande.
     */
    public AssociateProviderContactWithPatrimony(ProviderContactAssociatedWithPatrimony providerContactAssociatedWithPatrimony) {
        this();
        setProcessUid(providerContactAssociatedWithPatrimony.getProcessUid());
        setPatrimonyUid(providerContactAssociatedWithPatrimony.getPatrimonyUid());
        setDate(providerContactAssociatedWithPatrimony.getDate());
        setSentDate(providerContactAssociatedWithPatrimony.getSentDate());
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
        return "AssociateProviderContactWithPatrimony:{"
                + super.toString()
                + ", patrimonyUid:" + getPatrimonyUid()
                + "}";
    }
}
