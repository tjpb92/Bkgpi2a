package com.anstel.simplifiedrequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant le contact à rappeler dans le contexte des
 * SimplifiedRequests
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 * @see documentation à mettre à jour ...
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ContactToCallback")
public class ContactToCallback {

    /**
     * Nom du contact à rappeler
     */
    private String name;

    /**
     * Type de contact
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContactInfo contact;

    /**
     * Constructeur principal de la classe ContactToCallback
     */
    public ContactToCallback() {
    }

    /**
     * @return le nom du contact à rappeler
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom du contact à rappeler
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return le moyen de liaison
     */
    public ContactInfo getContact() {
        return contact;
    }

    /**
     * @param contact définit le moyen de liaison
     */
    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ContactToCallback:{"
                + ", name:" + getName()
                + ", contact:" + getContact()
                + "}";
    }
}
