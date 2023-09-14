package com.anstel.tickets.models;

import static com.anstel.tickets.models.PersonaType.PROVIDER_PERSONA;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un prestataire référencé
 *
 * @author Thierry Baribaud
 * @version 1.42.10
 * <A href="https://declarimmo-org.github.io/API/#persona">Persona</A>
 */
@JsonTypeName("ProviderPersona")
public class ProviderPersona extends Persona {

    /**
     * Identifiant du prestataire
     */
    private String providerUid;

    /**
     * Constructeur principal de la classe ProviderPersona
     */
    public ProviderPersona() {
        setPersonaType(PROVIDER_PERSONA.getName());
    }

    /**
     * @return l'identifiant du prestataire
     */
    public String getProviderUid() {
        return providerUid;
    }

    /**
     * @param providerUid définit l'identifiant du prestataire
     */
    public void setProviderUid(String providerUid) {
        this.providerUid = providerUid;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderPersona:{"
                + super.toString()
                + ", proverderUid:" + getProviderUid()
                + "}";
    }
}
