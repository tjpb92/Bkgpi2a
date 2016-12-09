package bkgpi2a;

import static bkgpi2a.EventType.ARRIVED_ON_SITE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant une arrivée sur site : ArrivedOnSite, #525
 *
 * @author Thierry Baribaud
 * @version 0.39
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid"})
@JsonTypeName("ArrivedOnSite")
public class ArrivedOnSite extends Event {

    /**
     * Opérateur ayant ajouté l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai
     */
    private Provider provider;

    /**
     * Constructeur de la classe ArrivedOnSite
     */
    public ArrivedOnSite() {
        setEventTypeUid(ARRIVED_ON_SITE.getUid());
        setEventType(ARRIVED_ON_SITE.getName());
    }

    /**
     * @return l'opérateur ayant ajouté l'essai
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant ajouté l'essai
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'intervenant courant si présent
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider définit l'intervenant courant
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ArrivedOnSite:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + "}";
    }

}
