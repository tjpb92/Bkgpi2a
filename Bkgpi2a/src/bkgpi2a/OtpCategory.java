package bkgpi2a;

/**
 * Classe d�crivant le r�sum� d'une raison d'appel OTP : son id, son nom et son
 * ic�ne.
 *
 * @author Thierry Baribaud
 * @version 1.28
 * @see https://performanceimmo.github.io/API/#otpcategory
 */
public class OtpCategory {

    /**
     * Identifiant unique de la cat�gorie
     */
    private String uid;

    /**
     * Nom de la cat�gorie
     */
    private String label;

    /**
     * Identifiant de l'ic�ne de la cat�gorie
     */
    private String iconId;

    /**
     * @return l'identifiant unique de la cat�gorie
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de la cat�gorie
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de la cat�gorie
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label d�finit le nom de la cat�gorie
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return l'identifiant de l'ic�ne de la cat�gorie
     */
    public String getIconId() {
        return iconId;
    }

    /**
     * @param iconId d�finit l'identifiant de l'ic�ne de la cat�gorie
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
