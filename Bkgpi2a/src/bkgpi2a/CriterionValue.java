package bkgpi2a;

/**
 * Classe d�crivant la valeur d'un crit�re de choix.
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see
 * <A href="https://performanceimmo.github.io/API/#criterionvalue">CriterionValue</A>
 */
public class CriterionValue {

    /**
     * Identifiant unique de la valeur du crit�re de choix
     */
    private String uid;

    /**
     * Valeur du crit�re de choix
     */
    private String value;

    /**
     * @return l'identifiant unique de la valeur du crit�re de choix
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de la valeur du crit�re de choix
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return la valeur du crit�re de choix
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value d�finit la valeur du crit�re de choix
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("CriterionValue:{"
                + "uid:" + getUid()
                + ", value:" + getValue()
                + "}");
    }
}
