package bkgpi2a;

/**
 * Classe d�crivant le r�sum� d'un item
 *
 * @author Thierry Baribaud
 * @version 1.16
 */
public class ItemAbstractWithRef extends ItemAbstract {

    /**
     * R�f�rence de l'item
     */
    private String ref;

    /**
     * @return la r�f�rence de l'item
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref d�finit la r�f�rence de l'item
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
