package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CLOSED_BEYOND_CALL_CENTER_SCOPE;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant un comment ajouté au journal d'un ticket :
 * ClosedBeyondCallCenterScope, #555
 *
 * @author Thierry Baribaud
 * @version 1.08
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("ClosedBeyondCallCenterScope")
public class ClosedBeyondCallCenterScope extends Event {

    /**
     * Code de clôture d'appel
     */
    public static final int code = 71;

    /**
     * Libellé de clôture d'appel
     */
    public static final String label = "Cloture admin - appel hors périmètre";

    /**
     * Opérateur ayant archivé le ticket
     */
    private Operator operator;

    /**
     * Commentaire sur la clôture d'appel (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe ClosedBeyondCallCenterScope
     */
    public ClosedBeyondCallCenterScope() {
        setEventTypeUid(CLOSED_BEYOND_CALL_CENTER_SCOPE.getUid());
        setEventType(CLOSED_BEYOND_CALL_CENTER_SCOPE.getName());
    }

    /**
     * @return l'opérateur ayant archivé le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant archivé le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la date à laquelle l'événement a eu lieu
     */
    public String getClosingDate() {
        return getDate();
    }

    /**
     * @return le commentaire sur la clôture d'appel
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire sur la clôture d'appel
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @param closingDate définit la date à laquelle l'événement a eu lieu
     */
    public void setClosingDate(String closingDate) {
        setDate(closingDate);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ClosedBeyondCallCenterScope:{"
                + super.toString()
                + ", " + getOperator()
                + ", comment:" + getComment()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
