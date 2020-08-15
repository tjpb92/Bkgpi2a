package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.WORKFLOW_APPLIED_TO_TICKET;

/**
 * Classe d�crivant l'�v�nement d'application d'un workflow � un ticket :
 * WorkflowAppliedToTicket, #655
 *
 * @author Thierry Baribaud
 * @version 1.35
 * @see
 * <A href="http://performanceimmo.github.io/API/#ticketevent">WorkflowAppliedToTicket</A>
 */
//@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("WorkflowAppliedToTicket")
public class WorkflowAppliedToTicket extends Event {

    /**
     * Op�rateur ayant g�r� le ticket
     */
    private Operator operator;

    /**
     * R�f�rence au workflow
     */
    private String workflow;

    /**
     * Constructeur de la classe WorkflowAppliedToTicket
     */
    public WorkflowAppliedToTicket() {
        setEventTypeUid(WORKFLOW_APPLIED_TO_TICKET.getUid());
        setEventType(WORKFLOW_APPLIED_TO_TICKET.getName());
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
     * @return la r�f�rence au workflow
     */
    public String getWorkflow() {
        return workflow;
    }

    /**
     * @param workflow d�finit la r�f�rence au workflow
     */
    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "WorkflowAppliedToTicket:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getWorkflow()
                + "}";
    }

}
