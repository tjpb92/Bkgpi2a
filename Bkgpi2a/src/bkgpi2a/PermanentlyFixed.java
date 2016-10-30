package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.PERMANENTLY_FIXED;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant une cl�ture d'appel d�finitive : PermanentlyFixed, #535
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"date", "eventTypeUid"})
@JsonTypeName("PermanentlyFixed")
public class PermanentlyFixed extends Event {

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
     * Constructeur de la classe ProviderAssigned
     */
    public PermanentlyFixed() {
        setEventTypeUid(PERMANENTLY_FIXED.getUid());
        setEventType(PERMANENTLY_FIXED.getName());
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
        return "PermanentlyFixed:{"
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
