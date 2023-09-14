package com.anstel.tickets.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant une personne
 *
 * @author Thierry Baribaud
 * @version 1.42.10
 * <A href="https://declarimmo-org.github.io/API/#persona">Persona</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "personaType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ProviderPersona.class, name = "ProviderPersona")
    ,
    @JsonSubTypes.Type(value = UnClassifiedPersona.class, name = "UnClassifiedPersona"),})
public abstract class Persona {

    /**
     * Type de personne
     */
    private String personaType;

    /**
     * Constructeur principal de la classe Persona
     */
    public Persona() {
    }

    /**
     * @return le type de personne
     */
    public String getPersonaType() {
        return personaType;
    }

    /**
     * @param personaType définit le type d'opérateur
     */
    public void setPersonaType(String personaType) {
        this.personaType = personaType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Persona:{"
                + "personaType:" + getPersonaType()
                + "}";
    }
}
