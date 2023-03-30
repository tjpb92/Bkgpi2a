package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite d�crivant un appelant
 *
 * @author Thierry Baribaud
 * @version 1.42.1
 * @see <A href="https://declarimmo-org.github.io/API/#callertype">CallerType</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "callerType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = HumanCaller.class, name = "HumanCaller")
    ,
    @JsonSubTypes.Type(value = AutomatonCaller.class, name = "AutomatonCaller")
    ,
    @JsonSubTypes.Type(value = ReferencedContactCaller.class, name = "ReferencedContactCaller")
    ,
    @JsonSubTypes.Type(value = ReferencedUserCaller.class, name = "ReferencedUserCaller")
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
     * @param callerType d�finit le type d'appelant
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
