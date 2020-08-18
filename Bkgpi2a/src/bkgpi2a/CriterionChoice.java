package bkgpi2a;

/**
 * Classe décrivant un critère de choix.
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see
 * <A href="https://performanceimmo.github.io/API/#criterionchoice">CriterionChoice</A>
 */
public class CriterionChoice {

    /**
     * Identifiant unique du critère de choix
     */
    private String criterionUid;

    /**
     * Libellé du critère de choix
     */
    private String criterionLabel;

    /**
     * Commentaire
     */
    private CriterionValue choice;

    /**
     * @return l'identifiant unique du critère de choix
     */
    public String getCriterionUid() {
        return criterionUid;
    }

    /**
     * @param criterionUid définit l'identifiant unique du critère de choix
     */
    public void setCriterionUid(String criterionUid) {
        this.criterionUid = criterionUid;
    }

    /**
     * @return le libellé du critère de choix
     */
    public String getCriterionLabel() {
        return criterionLabel;
    }

    /**
     * @param criterionLabel définit le libellé du critère de choix
     */
    public void setCriterionLabel(String criterionLabel) {
        this.criterionLabel = criterionLabel;
    }

    /**
     * @return le critère de choix
     */
    public CriterionValue getChoice() {
        return choice;
    }

    /**
     * @param choice définit le critère de choix
     */
    public void setChoice(CriterionValue choice) {
        this.choice = choice;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("CriterionChoice:{"
                + "criterionUid:" + getCriterionUid()
                + ", criterionLabel:" + getCriterionLabel()
                + ", choice:" + getChoice()
                + "}");
    }
}
