package bkgpi2a;

/**
 * Classe décrivant le résumé d'un item
 *
 * @author Thierry Baribaud
 * @version 1.16
 */
public class ItemAbstract {

    /**
     * Identifiant unique de l'item
     */
    private String uid;

    /**
     * Libellé de l'item
     */
    private String label;

    /**
     * @return l'dentifiant unique de l'item
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'dentifiant unique de l'item
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le libellé de l'item
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le libellé de l'item
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ItemAbstract:{"
                + " uid:" + getUid()
                + ", label:" + getLabel()
                + "}";
    }

}
