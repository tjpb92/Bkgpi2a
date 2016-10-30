package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.TICKET_CLOSED_IMPOSSIBLE_REPAIR;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant une clôture d'appel impossible : TicketClosedImpossibleRepair, #545
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("TicketClosedImpossibleRepair")
public class TicketClosedImpossibleRepair extends Event {

    /**
     * Opérateur ayant ajouté l'essai
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
     * TODO : A modéliser sur forme d'enum plus tard
     */
    private String stillOnSite;

    /**
     * Rapport d'intervention
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String report;

    /**
     * Constructeur de la classe ProviderAssigned
     */
    public TicketClosedImpossibleRepair() {
        setEventTypeUid(TICKET_CLOSED_IMPOSSIBLE_REPAIR.getUid());
        setEventType(TICKET_CLOSED_IMPOSSIBLE_REPAIR.getName());
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
     * @return l'intervenant courant si présent
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider définit l'intervenant courant
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
     * @param brakedownNature définit la nature de la panne
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
     * @param stillOnSite définit si l'intervnant est sur site
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
     * @param report définit le rapport d'intervention
     */
    public void setReport(String report) {
        this.report = report;
    }

    /**
     * @return la date de saisie de la clôture d'intervention
     */
    public String getClosingDate() {
        return getDate();
    }

    /**
     * @param closingDate définit la date de saisie de la clôture d'intervention
     */
    public void setClosingDate(String closingDate) {
        setDate(closingDate);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketClosedImpossibleRepair:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", brakedownNature:" + getBrakedownNature()
                + ", stillOnSite:" + getStillOnSite()
                + ", report:" + getReport()
                + ", closingDate:" + getClosingDate()
                + "}";
    }

}
