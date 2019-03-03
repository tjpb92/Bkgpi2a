package bkgpi2a;

import static bkgpi2a.EventType.GONE_FROM_SITE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un départ de site : GoneFromSite, #530
 *
 * @author Thierry Baribaud
 * @version 1.04
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("GoneFromSite")
public class GoneFromSite extends Event {

    /**
     * Opérateur ayant ajouté l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private TicketAssignee assignee;

    /**
     * Constructeur de la classe GoneFromSite
     */
    public GoneFromSite() {
        setEventTypeUid(GONE_FROM_SITE.getUid());
        setEventType(GONE_FROM_SITE.getName());
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
     * @return l'intervenant courant si présent
     */
    public TicketAssignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee définit l'intervenant courant
     */
    public void setAssignee(TicketAssignee assignee) {
        this.assignee = assignee;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "GoneFromSite:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + "}";
    }

}
