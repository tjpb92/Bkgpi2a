package bkgpi2a;

/**
 * Classe d�crivant le r�sum� d'un patrimoine : son id, son nom et sa
 * r�f�rence.
 *
 * @author Thierry Baribaud
 * @version 1.28
 * @see https://performanceimmo.github.io/API/#patrimonyabstract
 */
public class PatrimonyAbstract {

    /**
     * Identifiant unique du patrimoine
     */
    private String uid;

    /**
     * Nom du patrimoine 
     */
    private String name;

    /**
     * R�f�rence du patrimoine
     */
    private String ref;

    /**
     * @return l'identifiant unique du patrimoine
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique du patrimoine
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom du patrimoine
     */
    public String getName() {
        return name;
    }

    /**
     * @param name d�finit le nom du patrimoine
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return la r�f�rence du patrimoine
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref d�finit la r�f�rence du patrimoine
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("PatrimonyAbstract:{"
                + "uid:" + getUid()
                + ", name:" + getName()
                + ", ref:" + getRef()
                + "}");
    }
}
