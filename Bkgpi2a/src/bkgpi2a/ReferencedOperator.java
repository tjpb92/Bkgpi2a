package bkgpi2a;

import static bkgpi2a.OperatorType.REFERENCED_OPERATOR;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un opérateur référencé
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#operator
 */
@JsonTypeName("ReferencedOperator")
public class ReferencedOperator extends Operator {

    /**
     * Identifiant de l'opérateur
     */
    private String operatorUid;

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public ReferencedOperator() {
        setOperatorType(REFERENCED_OPERATOR.getName());
    }

    /**
     * @return l'identifiant de l'opérateur
     */
    public String getOperatorUid() {
        return operatorUid;
    }

    /**
     * @param operatorUid définit l'identifiant de l'opérateur
     */
    public void setOperatorUid(String operatorUid) {
        this.operatorUid = operatorUid;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ReferencedOperator:{"
                + super.toString()
                + ", operatorUid:" + getOperatorUid()
                + "}";
    }
}
