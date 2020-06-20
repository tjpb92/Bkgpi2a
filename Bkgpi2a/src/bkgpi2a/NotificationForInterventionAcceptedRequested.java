package bkgpi2a;

import static bkgpi2a.EventType.NOTIFICATION_FOR_INTERVENTION_ACCEPTED_REQUESTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant une notification sur une intervention accept�e :
 * NotificationForInterventionAcceptedRequested, #630
 *
 * @author Thierry Baribaud
 * @version 1.34
 * @see <A href="http://performanceimmo.github.io/API/#ticketevent">TicketEvent</A>
 */
//@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("NotificationForInterventionAcceptedRequested")
public class NotificationForInterventionAcceptedRequested extends Event {

    /**
     * Op�rateur ayant saisi l'acceptation de l'intervention (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Operator operator;

    /**
     * Individu courant sur l'essai
     */
    private TicketAssignee assignee;

    /**
     * Email ajout� au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    /**
     * Constructeur de la classe NotificationForInterventionAcceptedRequested
     */
    public NotificationForInterventionAcceptedRequested() {
        setEventTypeUid(NOTIFICATION_FOR_INTERVENTION_ACCEPTED_REQUESTED.getUid());
        setEventType(NOTIFICATION_FOR_INTERVENTION_ACCEPTED_REQUESTED.getName());
    }

    /**
     * @return l'op�rateur ayant saisi l'acceptation de l'intervention
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant saisi l'acceptation de
     * l'intervention
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
     * @return l'email ajout� au ticket
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email d�finit l'email ajout� au ticket
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "NotificationForInterventionAcceptedRequested:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", email:" + getEmail()
                + "}";
    }
}
