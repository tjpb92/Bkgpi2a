package bkgpi2a;

import static bkgpi2a.CommandType.ASSOCIATE_PROVIDER_CONTACT_WITH_PATRIMONY;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant la relation d'association entre un prestataire (ProviderContact) et d'un patrimoine (Patrimony) : AssociateProviderContactWithPatrimony, #1470
 *
 * @author Thierry Baribaud
 * @version 1.20
 * @see http://performanceimmo.github.io/API/#...
 */
@JsonIgnoreProperties({"_id", "commandTypeUid"})
@JsonTypeName("AssociateProviderContactWithPatrimony")
public class AssociateProviderContactWithPatrimony extends Command {

    /**
     * Constructeur de la classe AssociateProviderContactWithPatrimony
     */
    public AssociateProviderContactWithPatrimony() {
        setCommandTypeUid(ASSOCIATE_PROVIDER_CONTACT_WITH_PATRIMONY.getUid());
        setCommandType(ASSOCIATE_PROVIDER_CONTACT_WITH_PATRIMONY.getName());
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AssociateProviderContactWithPatrimony:{"
                + super.toString()
                + "}";
    }
}
