package bkgpi2a;

/**
 * Classe décrivant le résumé d'une agence : son id et son nom.
 *
 * @author Thierry Baribaud
 * @version 1.30
 * @see https://performanceimmo.github.io/API/#agencyabstract
 */
public class AgencyAbstract {

    /**
     * Identifiant unique de l'agence
     */
    private String uid;

    /**
     * Nom du agence
     */
    private String name;

    /**
     * @return l'identifiant unique de l'agence
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'agence
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de l'agence
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom de l'agence
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("AgencyAbstract:{"
                + "uid:" + getUid()
                + ", name:" + getName()
                + "}");
    }
}
