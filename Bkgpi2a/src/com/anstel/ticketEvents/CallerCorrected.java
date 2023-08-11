package com.anstel.ticketEvents;

import bkgpi2a.Caller;
import bkgpi2a.CallerType;
import bkgpi2a.Event;
import bkgpi2a.Operator;
import static bkgpi2a.EventType.CALLER_CORRECTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant l'�v�nement permettant de corriger l'appelant et son moyen 
 * de liaison sur un ticket : CallerCorrected, #680
 *
 * ATTENTION : Op�ration compatible avec Eole2/Zephir2 � impl�menter.
 *
 * @author Thierry Baribaud
 * @version 1.42.7
 * @see
 * <A href="https://declarimmo-org.github.io/API/#A_METTRE_A_JOUR">CallerCorrected</A>
 */
@JsonIgnoreProperties(value = {"_id", "eventTypeUid"}, ignoreUnknown = true)
@JsonTypeName("CallerCorrected")
public class CallerCorrected extends Event {

    /**
     * Appelant et moyen de liaison
     */
    private Caller caller;

    /**
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;

    /**
     * Constructeur de la classe CallerCorrected
     */
    public CallerCorrected() {
        setEventTypeUid(CALLER_CORRECTED.getUid());
        setEventType(CALLER_CORRECTED.getName());
    }

    /**
     * @return l'UUID du nouveau motif d'appel
     */
    public Caller getCaller() {
        return caller;
    }

    /**
     * @param caller d�finit l'UUID du nouveau motif d'appel
     */
    public void setCaller(Caller caller) {
        this.caller = caller;
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
        return "CallerCorrected:{"
                + super.toString()
                + ", " + getCaller()
                + ", " + getOperator()
                + "}";
    }

}
