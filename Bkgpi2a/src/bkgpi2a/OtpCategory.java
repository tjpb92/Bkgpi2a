package bkgpi2a;

/**
 * Classe décrivant le résumé d'une raison d'appel OTP : son id, son nom et son
 * icône.
 *
 * @author Thierry Baribaud
 * @version 1.28
 * @see https://performanceimmo.github.io/API/#otpcategory
 */
public class OtpCategory {

    /**
     * Identifiant unique de la catégorie
     */
    private String uid;

    /**
     * Nom de la catégorie
     */
    private String label;

    /**
     * Identifiant de l'icône de la catégorie
     */
    private String iconId;

    /**
     * @return l'identifiant unique de la catégorie
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la catégorie
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de la catégorie
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de la catégorie
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return l'identifiant de l'icône de la catégorie
     */
    public String getIconId() {
        return iconId;
    }

    /**
     * @param iconId définit l'identifiant de l'icône de la catégorie
     */
    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("OtpCategory:{"
                + "uid:" + getUid()
                + ", label:" + getLabel()
                + ", iconId:" + getIconId()
                + "}");
    }
}
