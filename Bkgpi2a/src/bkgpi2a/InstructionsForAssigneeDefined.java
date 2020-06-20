package bkgpi2a;

import static bkgpi2a.EventType.INSTRUCTIONS_FOR_ASSIGNEE_DEFINED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant des instructions laiss�es pour l'intervenant :
 * InstructionsForAssigneeDefined, #60
 *
 * @author Thierry Baribaud
 * @version 1.34
 * @see <A href="http://performanceimmo.github.io/API/#ticketevent">TicketEvent</A>
 */
//@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("InstructionsForAssigneeDefined")
public class InstructionsForAssigneeDefined extends Event {

    /**
     * Op�rateur ayant saisi les instructions (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Operator operator;

    /**
     * Individu courant sur l'essai
     */
    private TicketAssignee assignee;

    /**
     * Instructions ajout�es au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String instructions;

    /**
     * Constructeur de la classe InstructionsForAssigneeDefined
     */
    public InstructionsForAssigneeDefined() {
        setEventTypeUid(INSTRUCTIONS_FOR_ASSIGNEE_DEFINED.getUid());
        setEventType(INSTRUCTIONS_FOR_ASSIGNEE_DEFINED.getName());
    }

    /**
     * @return l'op�rateur ayant saisi les instructions
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant saisi les instructions
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'individu courant si pr�sent
     */
    public TicketAssignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee d�finit l'individu courant
     */
    public void setAssignee(TicketAssignee assignee) {
        this.assignee = assignee;
    }

    /**
     * @return les instructions ajout�es au ticket
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * @param instructions d�finit les instructions ajout�es au ticket
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "InstructionsForAssigneeDefined:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", instructions:" + getInstructions()
                + "}";
    }
}
