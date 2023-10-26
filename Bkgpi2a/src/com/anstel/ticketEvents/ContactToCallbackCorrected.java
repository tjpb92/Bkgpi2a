package com.anstel.ticketEvents;

import bkgpi2a.ContactToCallback;
import bkgpi2a.Event;
import bkgpi2a.Operator;
import static bkgpi2a.EventType.CONTACT_TO_CALLBACK_CORRECTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant l'événement permettant de corriger la personne à rappeler et 
 * son moyen de liaison sur un ticket : ContactToCallbackCorrected, #705
 *
 * ATTENTION : Opération compatible avec Eole2/Zephir2 à implémenter.
 *
 * @author Thierry Baribaud
 * @version 1.42.12
 * @see
 * <A href="https://declarimmo-org.github.io/API/#A_METTRE_A_JOUR">ContactToCallbackCorrected</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("ContactToCallbackCorrected")
public class ContactToCallbackCorrected extends Event {

    /**
     * Personne à rappeler et moyen de liaison
     */
    private ContactToCallback contactToCallback;

    /**
     * Opérateur ayant géré le ticket
     */
    private Operator operator;

    /**
     * Constructeur de la classe ContactToCallbackCorrected
     */
    public ContactToCallbackCorrected() {
        setEventTypeUid(CONTACT_TO_CALLBACK_CORRECTED.getUid());
        setEventType(CONTACT_TO_CALLBACK_CORRECTED.getName());
    }

    /**
     * @return la personne à rappeler et son moyen de liaison
     */
    public ContactToCallback getContactToCallback() {
        return contactToCallback;
    }

    /**
     * @param contactToCallback définit la personne à rappeler et son moyen de 
     * liaison
     */
    public void setContactToCallback(ContactToCallback contactToCallback) {
        this.contactToCallback = contactToCallback;
    }

    /**
     * @return l'opérateur ayant géré le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant géré le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ContactToCallbackCorrected:{"
                + super.toString()
                + ", " + getContactToCallback()
                + ", " + getOperator()
                + "}";
    }

}
