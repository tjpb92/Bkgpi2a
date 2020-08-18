package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_QUALIFIED_BY_CRITERIA;

/**
 * Classe décrivant l'événement de qualification de ticket :
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
     * Opérateur ayant géré le ticket
     */
    private Operator operator;
    
    /**
     * Liste de critères de choix
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
     * @return l'opérateur ayant géré le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant géré le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la liste des critères de choix
     */
    public CriterionChoiceList getChoices() {
        return choices;
    }

    /**
     * @param choices définit la liste des critères de choix
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
