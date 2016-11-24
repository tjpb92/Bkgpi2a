package bkgpi2a;


/**
 * Classe décrivant un ordre de service
 *
 * @author Thierry Baribaud
 * @version 0.291
 * @see http://performanceimmo.github.io/API/#serviceorder
 */
public class ServiceOrder {

    /**
     * Référence de l'ordre de service
     */
    private String ref;

    /**
     * Date d'envoi de l'ordre de service
     */
    private String sendingDate;

    /**
     * @return la référence de l'ordre de service
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref définit la référence de l'ordre de service
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return la date d'envoi de l'ordre de service
     */
    public String getSendingDate() {
        return sendingDate;
    }

    /**
     * @param sendingDate définit la date d'envoi de l'ordre de service
     */
    public void setSendingDate(String sendingDate) {
        this.sendingDate = sendingDate;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ServiceOrder:{"
                + ", ref:" + getRef()
                + ", sendingDate:" + getRef()
                + "}";
    }
}
