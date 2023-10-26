package com.anstel.ticketEvents;

import bkgpi2a.ContactToCallback;
import bkgpi2a.Event;
import bkgpi2a.Operator;
import static bkgpi2a.EventType.CONTACT_TO_CALLBACK_CORRECTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant l'�v�nement permettant de corriger la personne � rappeler et 
 * son moyen de liaison sur un ticket : ContactToCallbackCorrected, #705
 *
 * ATTENTION : Op�ration compatible avec Eole2/Zephir2 � impl�menter.
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
     * Personne � rappeler et moyen de liaison
     */
    private ContactToCallback contactToCallback;

    /**
     * Op�rateur ayant g�r� le ticket
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
     * @return la personne � rappeler et son moyen de liaison
     */
    public ContactToCallback getContactToCallback() {
        return contactToCallback;
    }

    /**
     * @param contactToCallback d�finit la personne � rappeler et son moyen de 
     * liaison
     */
    public void setContactToCallback(ContactToCallback contactToCallback) {
        this.contactToCallback = contactToCallback;
    }

    /**
     * @return l'op�rateur ayant g�r� le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant g�r� le ticket
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
