package bkgpi2a;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe décrivant une liste de numéros de fax
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class FaxList {

    /**
     * Liste de numéros de fax
     */
    private List<String> fax;

    /**
     * @return la liste de numéros de fax
     */
    public List<String> getFax() {
        return fax;
    }

    /**
     * Constructeur principal de la classe
     */
    public FaxList() {
        fax = new ArrayList();
    }

    /**
     * Constructeur secondaire de la classe
     *
     * @param fax un numéro de fax
     */
    public FaxList(String fax) {
        this();
        this.addFax(fax);
    }

    /**
     * @param fax définit liste de numéros de fax
     */
    public void setFax(List<String> fax) {
        this.fax = fax;
    }

    /**
     * @param fax ajoute un numéro de fax à la liste
     */
    public void addFax(String fax) {
        this.fax.add(fax);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{fax:" + getFax()
                + "}");
    }
}
