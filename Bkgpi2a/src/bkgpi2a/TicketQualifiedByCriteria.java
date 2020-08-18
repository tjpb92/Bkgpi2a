package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_QUALIFIED_BY_CRITERIA;

/**
 * Classe d�crivant l'�v�nement de qualification de ticket :
 * TicketQualifiedByCriteria, #650
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">TicketQualifiedByCriteria</A>
 */
//@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("TicketQualifiedByCriteria")
public class TicketQualifiedByCriteria extends Event {

    /**
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;
    
    /**
     * Liste de crit�res de choix
     */
    private CriterionChoiceList choices;

    /**
     * Constructeur de la classe TicketQualifiedByCriteria
     */
    public TicketQualifiedByCriteria() {
        setChoices(new CriterionChoiceList());
        setEventTypeUid(TICKET_QUALIFIED_BY_CRITERIA.getUid());
        setEventType(TICKET_QUALIFIED_BY_CRITERIA.getName());
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
     * @return la liste des crit�res de choix
     */
    public CriterionChoiceList getChoices() {
        return choices;
    }

    /**
     * @param choices d�finit la liste des crit�res de choix
     */
    public void setChoices(CriterionChoiceList choices) {
        this.choices = choices;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketQualifiedByCriteria:{"
                + super.toString()
                + ", " + getOperator()
                + ", choices:" + getChoices()
                + "}";
    }

}
