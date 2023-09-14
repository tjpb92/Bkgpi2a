package com.anstel.tickets.models;

import bkgpi2a.Provider;
import static com.anstel.tickets.models.PersonaType.PROVIDER_PERSONA;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un prestataire référencé
 *
 * @author Thierry Baribaud
 * @version 1.42.11
 * <A href="https://declarimmo-org.github.io/API/#persona">Persona</A>
 */
@JsonTypeName("ProviderPersona")
public class ProviderPersona extends Persona {

    /**
     * Prestataire
     */
    private Provider provider;

    /**
     * Constructeur principal de la classe ProviderPersona
     */
    public ProviderPersona() {
        setPersonaType(PROVIDER_PERSONA.getName());
    }

    /**
     * @return le prestataire
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider définit le prestataire
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderPersona:{"
                + super.toString()
                + ", proverder:" + getProvider()
                + "}";
    }
}
