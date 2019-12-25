package bkgpi2a;

/**
 * Classe décrivant le résumé d'un client : son id et son nom.
 *
 * @author Thierry Baribaud
 * @version 1.30
 * @see https://performanceimmo.github.io/API/#clientcompanyabstract
 */
public class ClientCompanyAbstract {

    /**
     * Identifiant unique du client
     */
    private String uid;

    /**
     * Nom du client
     */
    private String name;

    /**
     * @return l'identifiant unique du client
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique du client
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom du client
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom du client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("ClientCompanyAbstract:{"
                + "uid:" + getUid()
                + ", name:" + getName()
                + "}");
    }
}
