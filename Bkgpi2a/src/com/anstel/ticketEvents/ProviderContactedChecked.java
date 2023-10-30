package com.anstel.ticketEvents;

import bkgpi2a.ContactMedium;
import bkgpi2a.Event;
import bkgpi2a.Operator;
import static bkgpi2a.EventType.PROVIDER_CONTACTED_CHECKED;
import com.anstel.tickets.models.Persona;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant l'�v�nement permettant d'indiquer sur un ticket qu'une prise
 * de contact du prestataire est v�rifi�e : ProviderContactedChecked, #690
 *
 * ATTENTION : Op�ration compatible avec Eole2/Zephir2, � pr�voir.
 *
 * @author Thierry Baribaud
 * @version 1.42.13
 * @see
 * <A href="https://declarimmo-org.github.io/API/#A_METTRE_A_JOUR">ProviderContactedChecked</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("ProviderContactedChecked")
public class ProviderContactedChecked extends Event {

    /**
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;

    /**
     * Le destinataire
     */
    private Persona recipient;
    /**
     * Commentaire
     */
    private String comment;

    /**
     * Moyen de communication.
     */
    private ContactMedium medium;

    /**
     * Constructeur de la classe ProviderContactedChecked
     */
    public ProviderContactedChecked() {
        setEventTypeUid(PROVIDER_CONTACTED_CHECKED.getUid());
        setEventType(PROVIDER_CONTACTED_CHECKED.getName());
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
     * @return le destinataire
     */
    public Persona getRecipient() {
        return recipient;
    }

    /**
     * @param recipient d�finit le destinataire
     */
    public void setRecipient(Persona recipient) {
        this.recipient = recipient;
    }

    /**
     * @return le commentaire
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment d�finit le commentaire
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return le moyen de commnication
     */
    public ContactMedium getMedium() {
        return medium;
    }

    /**
     * @param medium d�finit
     */
    public void setMedium(ContactMedium medium) {
        this.medium = medium;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderContactedChecked:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getRecipient()
                + ", comment:" + getComment()
                + ", " + getMedium()
                + "}";
    }

}
