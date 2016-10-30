package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un nom
 *
 * @author Thierry Baribaud
 * @version October 2016
 * @see http://performanceimmo.github.io/API/#name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "nameType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = PoorName.class, name = "PoorName"),
    @JsonSubTypes.Type(value = CivilName.class, name = "CivilName"),})
public abstract class Name {

    /**
     * Type de nom
     */
    private String nameType;

    /**
     * Constructeur principal de la classe Name
     */
    public Name() {
    }

    /**
     * @return le type de nom
     */
    public String getNameType() {
        return nameType;
    }

    /**
     * @param nameType définit le type de nom
     */
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Name:{"
                + "nameType:" + getNameType()
                + "}";
    }
}
