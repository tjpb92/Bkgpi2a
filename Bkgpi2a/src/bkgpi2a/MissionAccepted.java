package bkgpi2a;

import static bkgpi2a.EventType.MISSION_ACCEPTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant la programmation d'une intervention : MissionAccepted, #505
 *
 * @author Thierry Baribaud
 * @version 0.29
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("MissionAccepted")
public class MissionAccepted extends Event {

    /**
     * Opérateur ayant saisi la programmation de l'intervention
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Provider provider;

    /**
     * Commentaire ajouté au ticket
     */
    private String comment;

    /**
     * Constructeur de la classe MissionAccepted
     */
    public MissionAccepted() {
        setEventTypeUid(MISSION_ACCEPTED.getUid());
        setEventType(MISSION_ACCEPTED.getName());
    }

    /**
     * @return l'opérateur ayant saisi la programmation de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant saisi la programmation de
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
        return "MissionAccepted:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", commentaire:" + getComment()
                //                + ", missionAcceptedDate:" + getMissionAcceptedDate()
                + "}";
    }
}
