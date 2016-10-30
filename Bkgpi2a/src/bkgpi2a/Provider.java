package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un intervenant
 *
 * @author Thierry Baribaud
 * @version October 2016
 * @see http://performanceimmo.github.io/API/#provider
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "providerType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ReferencedProvider.class, name = "ReferencedProvider"),
    @JsonSubTypes.Type(value = AnonymousProvider.class, name = "AnonymousProvider"),
    })
public abstract class Provider {

    /**
     * Type d'intervenant
     */
    private String providerType;

    /**
     * Constructeur principal de la classe Provider
     */
    public Provider() {
    }

    /**
     * @return le type d'intervenant
     */
    public String getProviderType() {
        return providerType;
    }

    /**
     * @param providerType définit le type d'intervenant
     */
    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Provider:{"
                + "providerType:" + getProviderType()
                + "}";
    }
}
