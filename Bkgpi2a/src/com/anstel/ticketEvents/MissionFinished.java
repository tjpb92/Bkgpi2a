package com.anstel.ticketEvents;

import bkgpi2a.Event;
import bkgpi2a.Operator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.MISSION_FINISHED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant l'affectation d'un individu (le renfort) � un ticket :
 * MissionFinished, #720.
 *
 * @author Thierry Baribaud
 * @version 1.42.23
 * @see
 * <A href="https://declarimmo-org.github.io/API/#A_METTRE_A_JOUR">MissionFinished</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("MissionFinished")
public class MissionFinished extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
     */
    private Operator operator;

    /**
     * R�f�rence � la soci�t� (laquelle ?)
     */
    private String companyUid;

    /**
     * Date de fin de mission
     */
    private String endMissionDate;

    /**
     * Commentaire ajout� au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe MissionFinished
     */
    public MissionFinished() {
        setEventTypeUid(MISSION_FINISHED.getUid());
        setEventType(MISSION_FINISHED.getName());
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
    public String getCompanyUid() {
        return companyUid;
    }

    /**
     * @param companyUid d�finit l'individu courant
     */
    public void setCompanyUid(String companyUid) {
        this.companyUid = companyUid;
    }

    /**
     * @return la date de fin de mission
     */
    public String getEndMissionDate() {
        return endMissionDate;
    }

    /**
     * @param endMissionDate d�finit la date de fin de mission
     */
    public void setEndMissionDate(String endMissionDate) {
        this.endMissionDate = endMissionDate;
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
        return "MissionFinished:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getCompanyUid()
                + ", endMissionDate:" + getEndMissionDate()
                + ", commentaire:" + getComment()
                + "}";
    }

}
