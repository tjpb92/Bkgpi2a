package bkgpi2a;

import static bkgpi2a.EventType.MISSION_REFUSED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant le refus d'une intervention : MissionRefused, #520
 *
 * @author Thierry Baribaud
 * @version 0.39
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("MissionRefused")
public class MissionRefused extends Event {

    /**
     * Opérateur ayant saisi le refus de l'intervention
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private Provider provider;

    /**
     * Commentaire ajouté au ticket
     */
    private String comment;

    /**
     * Constructeur de la classe MissionRefused
     */
    public MissionRefused() {
        setEventTypeUid(MISSION_REFUSED.getUid());
        setEventType(MISSION_REFUSED.getName());
    }

    /**
     * @return l'opérateur ayant saisi le refus de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant saisi le refus de
     * l'intervention
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'intervenant courant si présent
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider définit l'intervenant courant
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * @return le comment ajouté au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le comment ajouté au ticket
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "MissionRefused:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", commentaire:" + getComment()
                //                + ", missionRefusedDate:" + getMissionRefusedDate()
                + "}";
    }
}
