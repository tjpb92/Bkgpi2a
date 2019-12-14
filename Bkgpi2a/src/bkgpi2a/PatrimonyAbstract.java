package bkgpi2a;

/**
 * Classe décrivant le résumé d'un patrimoine : son id, son nom et sa
 * référence.
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
     * Référence du patrimoine
     */
    private String ref;

    /**
     * @return l'identifiant unique du patrimoine
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique du patrimoine
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
     * @param name définit le nom du patrimoine
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return la référence du patrimoine
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref définit la référence du patrimoine
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
