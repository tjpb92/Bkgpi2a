package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CLOSED_AFTER_SEVERAL_UNSUCCESSFUL_RECALLS;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant une clôture d'appel après plusieurs relances infructueuses :
 * ClosedAfterSeveralUnsuccessfulRecalls, #560
 *
 * @author Thierry Baribaud
 * @version 1.39
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">ClosedAfterSeveralUnsuccessfulRecalls</A>
 */
//JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ClosedAfterSeveralUnsuccessfulRecalls")
public class ClosedAfterSeveralUnsuccessfulRecalls extends Event {

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
     * Constructeur de la classe ClosedAfterSeveralUnsuccessfulRecalls
     */
    public ClosedAfterSeveralUnsuccessfulRecalls() {
        setEventTypeUid(CLOSED_AFTER_SEVERAL_UNSUCCESSFUL_RECALLS.getUid());
        setEventType(CLOSED_AFTER_SEVERAL_UNSUCCESSFUL_RECALLS.getName());
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
     * @return la date à laquelle l'événement a eu lieu
     */
    public String getClosingDate() {
        return getDate();
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
        return "ClosedAfterSeveralUnsuccessfulRecalls:{"
                + super.toString()
                + ", " + getOperator()
                + ", comment:" + getComment()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
