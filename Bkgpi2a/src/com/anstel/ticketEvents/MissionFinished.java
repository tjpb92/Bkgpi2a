package com.anstel.ticketEvents;

import bkgpi2a.Event;
import bkgpi2a.Operator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.MISSION_FINISHED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant l'affectation d'un individu (le renfort) à un ticket :
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
     * Opérateur ayant ajouté l'essai
     */
    private Operator operator;

    /**
     * Référence à la société (laquelle ?)
     */
    private String companyUid;

    /**
     * Date de fin de mission
     */
    private String endMissionDate;

    /**
     * Commentaire ajouté au ticket (optionnel)
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
     * @return l'opérateur ayant ajouté l'essai
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant ajouté l'essai
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'individu courant si présent
     */
    public String getCompanyUid() {
        return companyUid;
    }

    /**
     * @param companyUid définit l'individu courant
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
     * @param endMissionDate définit la date de fin de mission
     */
    public void setEndMissionDate(String endMissionDate) {
        this.endMissionDate = endMissionDate;
    }

    /**
     * @return le commentaire ajouté au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire ajouté au ticket
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
