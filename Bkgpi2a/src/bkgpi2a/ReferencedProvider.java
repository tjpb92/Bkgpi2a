package bkgpi2a;

import static bkgpi2a.ProviderType.REFERENCED_PROVIDER;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un intervenant référencé
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("ReferencedProvider")
public class ReferencedProvider extends Provider {

    /**
     * Identifiant de l'intervenant
     */
    private String providerUid;

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public ReferencedProvider() {
        setProviderType(REFERENCED_PROVIDER.getName());
    }

    /**
     * @return l'identifiant de l'intervenant
     */
    public String getProviderUid() {
        return providerUid;
    }

    /**
     * @param providerUid définit l'identifiant de l'intervenant
     */
    public void setProviderUid(String providerUid) {
        this.providerUid = providerUid;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ReferencedProvider:{"
                + super.toString()
                + ", providerUid:" + getProviderUid()
                + "}";
    }
}
