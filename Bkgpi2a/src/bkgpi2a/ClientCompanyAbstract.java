package bkgpi2a;

/**
 * Classe décrivant le résumé d'un client : son id et son nom.
 *
 * @author Thierry Baribaud
 * @version 1.31
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
     * Holding (Uuid)
     */
    private String holding;
    
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
     * @return le Uuid de la holding
     */
    public String getHolding() {
        return holding;
    }

    /**
     * holding holding définit le Uuid de la holding
     */
    public void setHolding(String holding) {
        this.holding = holding;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("ClientCompanyAbstract:{"
                + "uid:" + getUid()
                + ", name:" + getName()
                + ", holding:" + getHolding()
                + "}");
    }
}
