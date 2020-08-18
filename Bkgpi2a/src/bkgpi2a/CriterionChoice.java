package bkgpi2a;

/**
 * Classe d�crivant un crit�re de choix.
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see
 * <A href="https://performanceimmo.github.io/API/#criterionchoice">CriterionChoice</A>
 */
public class CriterionChoice {

    /**
     * Identifiant unique du crit�re de choix
     */
    private String criterionUid;

    /**
     * Libell� du crit�re de choix
     */
    private String criterionLabel;

    /**
     * Commentaire
     */
    private CriterionValue choice;

    /**
     * @return l'identifiant unique du crit�re de choix
     */
    public String getCriterionUid() {
        return criterionUid;
    }

    /**
     * @param criterionUid d�finit l'identifiant unique du crit�re de choix
     */
    public void setCriterionUid(String criterionUid) {
        this.criterionUid = criterionUid;
    }

    /**
     * @return le libell� du crit�re de choix
     */
    public String getCriterionLabel() {
        return criterionLabel;
    }

    /**
     * @param criterionLabel d�finit le libell� du crit�re de choix
     */
    public void setCriterionLabel(String criterionLabel) {
        this.criterionLabel = criterionLabel;
    }

    /**
     * @return le crit�re de choix
     */
    public CriterionValue getChoice() {
        return choice;
    }

    /**
     * @param choice d�finit le crit�re de choix
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
