package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un appelant
 *
 * @author Thierry Baribaud
 * @version 0.19
 * @see http://performanceimmo.github.io/API/#callertype
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "callerType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = HumanCaller.class, name = "HumanCaller"),
    @JsonSubTypes.Type(value = AutomatonCaller.class, name = "AutomatonCaller")
})
public abstract class Caller {

    /**
     * Type d'appelant
     */
    private String callerType;

    /**
     * Constructeur principal de la classe Caller
     */
    public Caller() {
    }

    /**
     * @return le type d'appelant
     */
    public String getCallerType() {
        return callerType;
    }

    /**
     * @param callerType définit le type d'appelant
     */
    public void setCallerType(String callerType) {
        this.callerType = callerType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Caller:{"
                + "callerType:" + getCallerType()
                + "}";
    }
}
