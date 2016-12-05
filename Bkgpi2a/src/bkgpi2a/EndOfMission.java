package bkgpi2a;

/**
 * Classe décrivant une clôture d'appel générique
 *
 * @author Thierry Baribaud
 * @version 0.38
 */
public class EndOfMission {

    /**
     * Code de clôture d'appel
     *
     * @see tranresult.4gl
     */
    private int code;

    /**
     * Libellé de clôture d'appel
     *
     * @see tranresult.4gl
     */
    private String label;

    /**
     * Identifiant unique de l'aggrégat auquel appartient l'événement
     */
    private String aggregateUid;

    /**
     * Date où l'événement s'est passé
     */
    private String date;

    /**
     * Nature de la panne
     */
    private String brakedownNature;

    /**
     * Code nature de la panne
     *
     * @see tranresult.4gl
     */
    public final static int brakedownNatureCode = 93;

    /**
     * L'intervenant est-il toujours sur site ?
     */
    private String stillOnSite;

    /**
     * Code de présence sur site du technicien
     *
     * @see tranresult.4gl
     */
    public final static int stillOnSiteCode = 73;

    /**
     * Rapport d'intervention
     */
    private String report;

    /**
     * Code du rapport d'intervention
     *
     * @see tranresult.4gl
     */
    public final static int reportCode = 72;
    
    /**
     * Constructeur basé sur l'événement PartiallyFixed
     * @param partiallyFixed événément décrivant une clôture partielle
     */
    public EndOfMission(PartiallyFixed partiallyFixed) {
        setCode(PartiallyFixed.code);
        setLabel(PartiallyFixed.label);
        setAggregateUid(partiallyFixed.getAggregateUid());
        setDate(partiallyFixed.getDate());
        setReport(partiallyFixed.getReport());
        setStillOnSite(partiallyFixed.getStillOnSite());
        setBrakedownNature(partiallyFixed.getBrakedownNature());
    }

    /**
     * @return l'identifiant unique de l'aggrégat auquel appartient l'événement
     */
    public String getAggregateUid() {
        return aggregateUid;
    }

    /**
     * @param aggregateUid définit l'identifiant unique de l'aggrégat auquel
     * appartient l'événement
     */
    public void setAggregateUid(String aggregateUid) {
        this.aggregateUid = aggregateUid;
    }

    /**
     * @return la date où a eu lieu l'événement
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date définit la date où l'événement s'est passé
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return le code de clôture d'appel
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code définit le code de clôture d'appel
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return le libellé de clôture d'appel
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le libellé de clôture d'appel
     */
    public void setLabel(String label) {
        this.label = label;
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
     * @param stillOnSite définit si l'intervnant est sur site TODO : A
     * modéliser sur forme d'enum plus tard
     */
    public void setStillOnSite(String stillOnSite) {
        this.stillOnSite = stillOnSite;
    }

    /**
     * Traduit la présence sur site du technicien
     *
     * @return la traduction de la présence sur site du technicien
     */
    public String translateStillOnSite() {
        String stillOnSiteTranslated;

        if ("Yes".equals(stillOnSite)) {
            stillOnSiteTranslated = "Oui";
        } else if ("No".equals(stillOnSite)) {
            stillOnSiteTranslated = "Non";
        } else if ("NotAsked".equals(stillOnSite)) {
            stillOnSiteTranslated = "Non demandée";
        } else if ("ProviderRefuseToReply".equals(stillOnSite)) {
            stillOnSiteTranslated = "Refus";
        } else {
            stillOnSiteTranslated = "Non disponible";
        }
        return stillOnSiteTranslated;
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

}
