package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant une vue réduite d'une Holding
 *
 * @author Thierry Baribaud
 * @version 1.37
 * @see
 * <A href="http://performanceimmo.github.io/API/#holdingqueryview">HoldingQueryView</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("HoldingQueryView")
public class HoldingQueryView {

    /**
     * Identifiant unique de la holding
     */
    private String uid;

    /**
     * Nom de la holding
     */
    private String label;

    /**
     * Constructeur principal de la classe
     *
     * @param uid Identifiant unique de la holding
     * @param label Nom de la holding
     */
    public HoldingQueryView(String uid, String label) {
        this.uid = uid;
        this.label = label;
    }

    /**
     * @return l'identifiant unique de la holding
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la holding
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de la holding
     */
    @JsonGetter("label")
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de la holding
     */
    @JsonSetter("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return les informations sur la holding.
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", label:" + getLabel()
                + "}");
    }
}
