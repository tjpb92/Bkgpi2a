package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un opérateur
 *
 * @author Thierry Baribaud
 * @version 1.42.11
 * <A href="https://declarimmo-org.github.io/API/#operator">Operator</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "operatorType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ReferencedOperator.class, name = "ReferencedOperator"),
    @JsonSubTypes.Type(value = AnonymousOperator.class, name = "AnonymousOperator"),
    @JsonSubTypes.Type(value = ReferencedUser.class, name = "ReferencedUser"),})
public abstract class Operator {

    /**
     * Type d'opérateur
     */
    private String operatorType;

    /**
     * Constructeur principal de la classe Operator
     */
    public Operator() {
    }

    /**
     * @return le type d'opérateur
     */
    public String getOperatorType() {
        return operatorType;
    }

    /**
     * @param operatorType définit le type d'opérateur
     */
    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Operator:{"
                + "operatorType:" + getOperatorType()
                + "}";
    }
}
