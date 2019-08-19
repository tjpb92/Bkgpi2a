package bkgpi2a;

/**
 * Classe décrivant le résumé d'un item
 *
 * @author Thierry Baribaud
 * @version 1.16
 */
public class ItemAbstractWithRef extends ItemAbstract {

    /**
     * Référence de l'item
     */
    private String ref;

    /**
     * @return la référence de l'item
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref définit la référence de l'item
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ItemAbstractWithRef:{"
                + super.toString()
                + ", ref:" + getRef()
                + "}";
    }

}
