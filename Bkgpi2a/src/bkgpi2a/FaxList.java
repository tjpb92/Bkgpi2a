package bkgpi2a;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe d�crivant une liste de num�ros de fax
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class FaxList {

    /**
     * Liste de num�ros de fax
     */
    private List<String> fax;

    /**
     * @return la liste de num�ros de fax
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
     * @param fax un num�ro de fax
     */
    public FaxList(String fax) {
        this();
        this.addFax(fax);
    }

    /**
     * @param fax d�finit liste de num�ros de fax
     */
    public void setFax(List<String> fax) {
        this.fax = fax;
    }

    /**
     * @param fax ajoute un num�ro de fax � la liste
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
