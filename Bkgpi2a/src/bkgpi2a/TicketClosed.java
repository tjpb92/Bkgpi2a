package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_CLOSED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant une cl�ture d'appel d�finitive : TicketClosed, #561
 *
 * @author Thierry Baribaud
 * @version 0.39
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonTypeName("TicketClosed")
public class TicketClosed extends Event {

    /**
     * Op�rateur ayant ajout� l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Provider provider;

    /**
     * Nature de la panne
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String brakedownNature;

    /**
     * L'intervenant est-il toujours sur site ?
     * TODO : A mod�liser sur forme d'enum plus tard
     */
    private String stillOnSite;

    /**
     * Rapport d'intervention
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String report;
    
    /**
     * R�sultat
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String result;

    /**
     * Constructeur de la classe ProviderAssigned
     */
    public TicketClosed() {
        setEventTypeUid(TICKET_CLOSED.getUid());
        setEventType(TICKET_CLOSED.getName());
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
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider d�finit l'intervenant courant
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * @return la nature de la panne
     */
    public String getBrakedownNature() {
        return brakedownNature;
    }

    /**
     * @param brakedownNature d�finit la nature de la panne
     */
    public void setBrakedownNature(String brakedownNature) {
        this.brakedownNature = brakedownNature;
    }

    /**
     * @return indique si l'intervnant est sur site
     */
    public String getStillOnSite() {
        return stillOnSite;
    }

    /**
     * @param stillOnSite d�finit si l'intervnant est sur site
     */
    public void setStillOnSite(String stillOnSite) {
        this.stillOnSite = stillOnSite;
    }

    /**
     * @return le rapport d'intervention
     */
    public String getReport() {
        return report;
    }

    /**
     * @param report d�finit le rapport d'intervention
     */
    public void setReport(String report) {
        this.report = report;
    }

    /**
     * @return le r�sultat
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result d�finit le r�sultat
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return la date de saisie de la cl�ture d'intervention
     */
    public String getClosingDate() {
        return getDate();
    }

    /**
     * @param closingDate d�finit la date de saisie de la cl�ture d'intervention
     */
    public void setClosingDate(String closingDate) {
        setDate(closingDate);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketClosed:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", brakedownNature:" + getBrakedownNature()
                + ", stillOnSite:" + getStillOnSite()
                + ", report:" + getReport()
                + ", result:" + getResult()
                + ", closingDate:" + getClosingDate()
                + "}";
    }

}
