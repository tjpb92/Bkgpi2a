package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe qui décrit une filiale d'une compagnie
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"companyType", "isActive", "label", "uid"})
@JsonIgnoreProperties({"active"})
public class Subsidiary {

    /**
     * Définit le type de filiale (utiliser une enum plus tard) :
     */
    private String companyType;

    /**
     * Indique si la filiale est active ou pas.
     */
    @JsonProperty("isActive")
    private boolean active;

    /**
     * Nom de la filiale.
     */
    private String label;

    /**
     * Identifiant unique de la filiale.
     */
    private String uid;

    /**
     * @return le type de la filiale.
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType définit le type de la filiale.
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * @return l'état d'activité de la filiale.
     */
    @JsonGetter("isActive")
    public boolean getActive() {
        return active;
    }

    /**
     * @param active définit l'état d'activité de la filiale.
     */
    @JsonSetter("isActive")
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return le nom de la filiale.
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de la filiale.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return l'identifiant unique de la filiale.
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la filiale.
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return les informations sur la filiale.
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{"
                + "companyType:" + getCompanyType()
                + ", isActive:" + getActive()
                + ", label:" + getLabel()
                + ", uid:" + getUid()
                + "}");
    }
}
