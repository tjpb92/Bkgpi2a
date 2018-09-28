package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.ASSIGNEE_IDENTIFIED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant l'affectation d'un individu à un ticket :
 * AssigneeIdentified, #515.
 * Remplace ProviderAssigned à compter de septembre 2018.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("AssigneeIdentified")
public class AssigneeIdentified extends Event {

    /**
     * Opérateur ayant ajouté l'essai (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Operator operator;

    /**
     * Individu courant sur l'essai
     */
    private Assignee assignee;

    /**
     * Commentaire ajouté au ticket (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur de la classe AssigneeIdentified
     */
    public AssigneeIdentified() {
        setEventTypeUid(ASSIGNEE_IDENTIFIED.getUid());
        setEventType(ASSIGNEE_IDENTIFIED.getName());
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
     * @return l'individu courant si présent
     */
    public Assignee getAssignee() {
        return assignee;
    }

    /**
     * @param assignee définit l'individu courant
     */
    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    /**
     * @return le commentaire ajouté au ticket
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire ajouté au ticket
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AssigneeIdentified:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getAssignee()
                + ", commentaire:" + getComment()
                + "}";
    }

}
