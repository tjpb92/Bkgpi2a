package bkgpi2a;

import static bkgpi2a.CommandType.QUALIFY_SIMPLIFIED_REQUEST;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant la commande de qualification d'une demande d'intervention
 * �mise depuis l'application mobile : QualifySimplifiedRequest, #1805
 *
 * @author Thierry Baribaud
 * @version 1.31
 * @see https://performanceimmo.github.io/API/#qualify-a-simplifiedrequest
 */
@JsonIgnoreProperties({"_id", "date", "sentDate", "commandTypeUid", "status", "nbError"})
@JsonTypeName("QualifySimplifiedRequest")
@JsonPropertyOrder({"processUid", "ticketUid", "commandType"})
public class QualifySimplifiedRequest extends Command {

    /**
     * Identifiant unique du ticket associ�
     */
    private String ticketUid;

    /**
     * Constructeur principal de la classe QualifySimplifiedRequest
     */
    public QualifySimplifiedRequest() {
        setCommandTypeUid(QUALIFY_SIMPLIFIED_REQUEST.getUid());
        setCommandType(QUALIFY_SIMPLIFIED_REQUEST.getName());
    }

    /**
     * Constructeur secondaire de la classe QualifySimplifiedRequest Construit
     * la commande � partir de l'�v�nement
     *
     * @param simplifiedRequestQualified �v�nement associ� � la commande.
     */
    public QualifySimplifiedRequest(SimplifiedRequestQualified simplifiedRequestQualified) {
        this();
        setProcessUid(simplifiedRequestQualified.getProcessUid());
        setTicketUid(simplifiedRequestQualified.getTicketUid());
        setDate(simplifiedRequestQualified.getDate());
        setSentDate(simplifiedRequestQualified.getSentDate());
    }

    /**
     * @return l'identifiant unique du ticket associ�
     */
    public String getTicketUid() {
        return ticketUid;
    }

    /**
     * @param ticketUid d�finit l'identifiant unique du ticket associ�
     */
    public void setTicketUid(String ticketUid) {
        this.ticketUid = ticketUid;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "QualifySimplifiedRequest:{"
                + super.toString()
                + ", ticketUid:" + getTicketUid()
                + "}";
    }
}
