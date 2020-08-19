package bkgpi2a;

import static bkgpi2a.EventType.ARRIVED_ON_SITE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant une arriv�e sur site : ArrivedOnSite, #525
 *
 * @author Thierry Baribaud
 * @version 1.37
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">ArrivedOnSite</A>
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("ArrivedOnSite")
public class ArrivedOnSite extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private TicketAssignee assignee;

    /**
     * Constructeur de la classe ArrivedOnSite
     */
    public ArrivedOnSite() {
        setEventTypeUid(ARRIVED_ON_SITE.getUid());
        setEventType(ARRIVED_ON_SITE.getName());
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
        return "ArrivedOnSite:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + "}";
    }

}
