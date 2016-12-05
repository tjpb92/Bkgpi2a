package bkgpi2a;

/**
 * Classe d�crivant une cl�ture d'appel g�n�rique
 *
 * @author Thierry Baribaud
 * @version 0.38
 */
public class EndOfMission {

    /**
     * Code de cl�ture d'appel
     *
     * @see tranresult.4gl
     */
    private int code;

    /**
     * Libell� de cl�ture d'appel
     *
     * @see tranresult.4gl
     */
    private String label;

    /**
     * Identifiant unique de l'aggr�gat auquel appartient l'�v�nement
     */
    private String aggregateUid;

    /**
     * Date o� l'�v�nement s'est pass�
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
     * Code de pr�sence sur site du technicien
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
     * Constructeur bas� sur l'�v�nement PartiallyFixed
     * @param partiallyFixed �v�n�ment d�crivant une cl�ture partielle
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
     * @return l'identifiant unique de l'aggr�gat auquel appartient l'�v�nement
     */
    public String getAggregateUid() {
        return aggregateUid;
    }

    /**
     * @param aggregateUid d�finit l'identifiant unique de l'aggr�gat auquel
     * appartient l'�v�nement
     */
    public void setAggregateUid(String aggregateUid) {
        this.aggregateUid = aggregateUid;
    }

    /**
     * @return la date o� a eu lieu l'�v�nement
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date d�finit la date o� l'�v�nement s'est pass�
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return le code de cl�ture d'appel
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code d�finit le code de cl�ture d'appel
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return le libell� de cl�ture d'appel
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label d�finit le libell� de cl�ture d'appel
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
     * @param stillOnSite d�finit si l'intervnant est sur site TODO : A
     * mod�liser sur forme d'enum plus tard
     */
    public void setStillOnSite(String stillOnSite) {
        this.stillOnSite = stillOnSite;
    }

    /**
     * Traduit la pr�sence sur site du technicien
     *
     * @return la traduction de la pr�sence sur site du technicien
     */
    public String translateStillOnSite() {
        String stillOnSiteTranslated;

        if ("Yes".equals(stillOnSite)) {
            stillOnSiteTranslated = "Oui";
        } else if ("No".equals(stillOnSite)) {
            stillOnSiteTranslated = "Non";
        } else if ("NotAsked".equals(stillOnSite)) {
            stillOnSiteTranslated = "Non demand�e";
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
     * @param report d�finit le rapport d'intervention
     */
    public void setReport(String report) {
        this.report = report;
    }

}
