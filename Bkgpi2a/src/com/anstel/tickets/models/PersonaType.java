package com.anstel.tickets.models;

/**
 * Enum�ration d�crivant les types de personne.
 *
 * @author Thierry Baribaud
 * @version 1.42.10
 * <A href="https://declarimmo-org.github.io/API/#persona">Persona</A>
 */
public enum PersonaType {

    /**
     * Prestataire r�f�renc� en base de donn�es
     */
    PROVIDER_PERSONA("ProviderPersona"),
    /**
     * Personne non r�f�renc�e en base de donn�es
     */
    UN_CLASSIFIED_PERSONA("UnClassifiedPersona");

    /**
     * Type de personne
     */
    private final String name;

    /**
     * Constructeur de la classe
     */
    PersonaType(String name) {
        this.name = name;
    }

    /**
     * @return le type de personne
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
