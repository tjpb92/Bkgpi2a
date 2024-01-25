package com.anstel.ticketEvents;

import bkgpi2a.Event;
import bkgpi2a.Operator;
import bkgpi2a.TicketAssignee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.BACKUP_ASSIGNEE_IDENTIFIED;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant l'affectation d'un individu (le renfort) � un ticket :
 * BackupAssigneeIdentified, #715.
 *
 * @author Thierry Baribaud
 * @version 1.42.18
 * @see
 * <A href="https://declarimmo-org.github.io/API/#A_METTRE_A_JOUR">BackupAssigneeIdentified</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("BackupAssigneeIdentified")
public class BackupAssigneeIdentified extends Event {

    /**
     * Op�rateur ayant ajout� l'essai (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Operator operator;

    /**
     * Individu courant sur l'essai
     */
//    @JsonProperty("assignee")
    private TicketAssignee assignee;

    /**
     * Commentaire ajout� au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe BackupAssigneeIdentified
     */
    public BackupAssigneeIdentified() {
        setEventTypeUid(BACKUP_ASSIGNEE_IDENTIFIED.getUid());
        setEventType(BACKUP_ASSIGNEE_IDENTIFIED.getName());
    }

    /**
     * @return l'op�rateur ayant ajout� l'essai
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant ajout� l'essai
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'individu courant si pr�sent
     */
//    @JsonGetter("assignee")
    public TicketAssignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee d�finit l'individu courant
     */
//    @JsonSetter("assignee")
    public void setAssignee(TicketAssignee assignee) {
        this.assignee = assignee;
    }

    /**
     * @return le commentaire ajout� au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment d�finit le commentaire ajout� au ticket
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "BackupAssigneeIdentified:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", commentaire:" + getComment()
                + "}";
    }

}
