package com.anstel.ticketEvents;

import bkgpi2a.ContactMedium;
import bkgpi2a.Event;
import bkgpi2a.Operator;
import static bkgpi2a.EventType.INTERVENTION_REPORT_GOTTEN_FROM_RESIDENT;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant l'événement permettant de A_PRECISER sur un ticket :
 * InterventionReportGottenFromResident, #690
 *
 * ATTENTION : Opération compatible avec Eole2/Zephir2, à prévoir.
 *
 * @author Thierry Baribaud
 * @version 1.42.9
 * @see
 * <A href="https://declarimmo-org.github.io/API/#A_METTRE_A_JOUR">InterventionReportGottenFromResident</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("InterventionReportGottenFromResident")
public class InterventionReportGottenFromResident extends Event {

    /**
     * Opérateur ayant géré le ticket
     */
    private Operator operator;

    /**
     * Le destinataire
     */
//    private Persona recipient;
    /**
     * Commentaire
     */
    private String comment;

    /**
     * Moyen de communication.
     */
    private ContactMedium medium;

    /**
     * Constructeur de la classe InterventionReportGottenFromResident
     */
    public InterventionReportGottenFromResident() {
        setEventTypeUid(INTERVENTION_REPORT_GOTTEN_FROM_RESIDENT.getUid());
        setEventType(INTERVENTION_REPORT_GOTTEN_FROM_RESIDENT.getName());
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
     * @return le destinataire
     */
//    public Persona getRecipient() {
//        return recipient;
//    }
    /**
     * @param recipient définit le destinataire
     */
//    public void setRecipient(Persona recipient) {
//        this.recipient = recipient;
//    }
    /**
     * @return le commentaire
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire
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
     * @param medium définit
     */
    public void setMedium(ContactMedium medium) {
        this.medium = medium;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "InterventionReportGottenFromResident:{"
                + super.toString()
                + ", " + getOperator()
                //                + ", " + getRecipient()
                + ", comment:" + getComment()
                + ", " + getMedium()
                + "}";
    }

}
