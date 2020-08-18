package bkgpi2a;

/**
 * Classe décrivant la valeur d'un critère de choix.
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see
 * <A href="https://performanceimmo.github.io/API/#criterionvalue">CriterionValue</A>
 */
public class CriterionValue {

    /**
     * Identifiant unique de la valeur du critère de choix
     */
    private String uid;

    /**
     * Valeur du critère de choix
     */
    private String value;

    /**
     * @return l'identifiant unique de la valeur du critère de choix
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la valeur du critère de choix
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return la valeur du critère de choix
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value définit la valeur du critère de choix
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
