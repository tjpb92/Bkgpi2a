package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CLOSED_AFTER_SEVERAL_UNSUCCESSFUL_RECALLS;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant une cl�ture d'appel apr�s plusieurs relances infructueuses :
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
     * Op�rateur ayant archiv� le ticket
     */
    private Operator operator;

    /**
     * Commentaire sur la cl�ture d'appel (optionnel)
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
     * @return l'op�rateur ayant archiv� le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant archiv� le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return le commentaire sur la cl�ture d'appel
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment d�finit le commentaire sur la cl�ture d'appel
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getClosingDate() {
        return getDate();
    }

    /**
     * @param closingDate d�finit la date � laquelle l'�v�nement a eu lieu
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
