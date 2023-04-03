package com.anstel.simplifiedrequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un moyen de liaision
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 * @see documentation à mettre à jour
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "contactType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = PhoneInfo.class, name = "Phone"),
    @JsonSubTypes.Type(value = MailInfo.class, name = "Mail")
})
public abstract class ContactInfo {

    /**
     * Type de moyen de liaision
     */
    private String contactType;

    /**
     * Constructeur principal de la classe ContactInfo
     */
    public ContactInfo() {
    }

    /**
     * @return le type de moyen de liaision
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * @param contactType définit le type de moyen de liaision
     */
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ContactInfo:{"
                + "contactType:" + getContactType()
                + "}";
    }
}
