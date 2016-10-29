package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un op�rateur r�f�renc�
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("ReferencedOperator")
public class ReferencedOperator extends Operator {

    /**
     * Identifiant de l'op�rateur
     */
    private String operatorUid;

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public ReferencedOperator() {
        setOperatorType("ReferencedOperator");
    }

    /**
     * @return l'identifiant de l'op�rateur
     */
    public String getOperatorUid() {
        return operatorUid;
    }

    /**
     * @param operatorUid d�finit l'identifiant de l'op�rateur
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
