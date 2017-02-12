package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.CLOSED_BEYOND_CALL_CENTER_SCOPE;

/**
 * Classe d�crivant un comment ajout� au journal d'un ticket :
 * ClosedBeyondCallCenterScope, #555
 *
 * @author Thierry Baribaud
 * @version 0.42
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("ClosedBeyondCallCenterScope")
public class ClosedBeyondCallCenterScope extends Event {

    /**
     * Code de cl�ture d'appel
     */
    public static final int code = 71;

    /**
     * Libell� de cl�ture d'appel
     */
    public static final String label = "Cloture admin - appel hors p�rim�tre";

    /**
     * Op�rateur ayant archiv� le ticket
     */
    private Operator operator;

    /**
     * Rapport d'intervention. Non impl�ment�, mais souvent pr�sent c�t� centre
     * d'appel, TB, le 12/02/17.
     */
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String report;
    /**
     * Constructeur de la classe ClosedBeyondCallCenterScope
     */
    public ClosedBeyondCallCenterScope() {
        setEventTypeUid(CLOSED_BEYOND_CALL_CENTER_SCOPE.getUid());
        setEventType(CLOSED_BEYOND_CALL_CENTER_SCOPE.getName());
    }

    /**
     * @return l'op�rateur ayant archiv� le ticket
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator d�finit l'op�rateur ayant archiv� le ticket
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la date � laquelle l'�v�nement a eu lieu
     */
    public String getClosingDate() {
        return getDate();
    }

//    /**
//     * @return le rapport d'intervention
//     */
//    public String getReport() {
//        return report;
//    }
//
//    /**
//     * @param report d�finit le rapport d'intervention
//     */
//    public void setReport(String report) {
//        this.report = report;
//    }
    /**
     * @param closingDate d�finit la date � laquelle l'�v�nement a eu lieu
     */
    public void setClosingDate(String closingDate) {
        setDate(closingDate);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ClosedBeyondCallCenterScope:{"
                + super.toString()
                + ", " + getOperator()
                //                + ", report:" + getReport()
                + ", closingDate:" + getClosingDate()
                + "}";
    }
}
