package bkgpi2a;

import static bkgpi2a.ProviderType.ANONYMOUS_PROVIDER;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un intervenant non référencé
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("AnonymousProvider")
public class AnonymousProvider extends Provider {

    /**
     * Nom de l'intervenant
     */
    private String name;

    /**
     * Constructeur principal de la classe AnonymousProvider
     */
    public AnonymousProvider() {
        setProviderType(ANONYMOUS_PROVIDER.getName());
    }

    /**
     * @return le nom de l'intervenant
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom de l'intervenant
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AnonymousProvider:{"
                + super.toString()
                + ", name:" + getName()
                + "}";
    }
}
