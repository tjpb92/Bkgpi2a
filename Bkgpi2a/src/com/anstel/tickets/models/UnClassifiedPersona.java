package com.anstel.tickets.models;

import bkgpi2a.Name;
import static com.anstel.tickets.models.PersonaType.UN_CLASSIFIED_PERSONA;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant une personne non r�f�renc�e en base de donn�es
 *
 * @author Thierry Baribaud
 * @version 1.42.10
 * <A href="https://declarimmo-org.github.io/API/#persona">Persona</A>
 */
@JsonTypeName("UnClassifiedPersona")
public class UnClassifiedPersona extends Persona {

    /**
     * Nom de la personne non r�f�renc�e
     */
    private Name name;

    /**
     * Constructeur principal de la classe UnClassifiedPersona
     */
    public UnClassifiedPersona() {
        setPersonaType(UN_CLASSIFIED_PERSONA.getName());
    }

    /**
     * @return le nom de la personne non r�f�renc�e
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name d�finit le nom de la personne non r�f�renc�e
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "UnClassifiedPersona:{"
                + super.toString()
                + ", name:" + getName()
                + "}";
    }
}
