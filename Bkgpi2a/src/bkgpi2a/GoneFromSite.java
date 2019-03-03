package bkgpi2a;

import static bkgpi2a.EventType.GONE_FROM_SITE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un d�part de site : GoneFromSite, #530
 *
 * @author Thierry Baribaud
 * @version 1.04
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("GoneFromSite")
public class GoneFromSite extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
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
     * @return l'intervenant courant si pr�sent
     */
    public TicketAssignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee d�finit l'intervenant courant
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
