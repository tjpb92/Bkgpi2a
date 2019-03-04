package bkgpi2a;

import static bkgpi2a.EventType.TICKET_INFORMATIONS_CORRECTED;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant les champs à corriger dans un ticket :
 * TicketInformationsCorrected, #504
 *
 * @author Thierry Baribaud
 * @version 1.05
 * @see http://performanceimmo.github.io/API/#fieldstocorrect
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("TicketInformationsCorrected")
public class TicketInformationsCorrected extends Event {

    /**
     * Opérateur ayant ajouté l'essai
     */
    private Operator operator;

    /**
     * Informations à corriger
     */
    private FieldsCorrected fieldsCorrected;

    /**
     * Constructeur de la classe InterventionFinished
     */
    public TicketInformationsCorrected() {
        setEventTypeUid(TICKET_INFORMATIONS_CORRECTED.getUid());
        setEventType(TICKET_INFORMATIONS_CORRECTED.getName());
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
     * @return les champs à corriger dans le ticket
     */
    public FieldsCorrected getFieldsCorrected() {
        return fieldsCorrected;
    }

    /**
     * @param fieldsCorrected définit les champs à corriger dans le ticket
     */
    public void setFieldsCorrected(FieldsCorrected fieldsCorrected) {
        this.fieldsCorrected = fieldsCorrected;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketInformationsCorrected:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getFieldsCorrected()
                + "}";
    }

}
