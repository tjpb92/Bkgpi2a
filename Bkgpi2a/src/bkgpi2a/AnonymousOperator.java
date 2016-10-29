package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un opérateur non référencé
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("AnonymousOperator")
public class AnonymousOperator extends Operator {

    /**
     * Nom de l'opérateur
     */
    private String name;

    /**
     * Constructeur principal de la classe AnonymousOperator
     */
    public AnonymousOperator() {
        setOperatorType("AnonymousOperator");
    }

    /**
     * @return le nom de l'opérateur
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom de l'opérateur
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AnonymousOperator:{"
                + super.toString()
                + ", name:" + getName()
                + "}";
    }
}
