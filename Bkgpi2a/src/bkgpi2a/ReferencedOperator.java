package bkgpi2a;

import static bkgpi2a.OperatorType.REFERENCED_OPERATOR;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un op�rateur r�f�renc�
 *
 * @author Thierry Baribaud
 * @version 1.42.11
 * <A href="https://declarimmo-org.github.io/API/#operator">Operator</A>
 */
@JsonTypeName("ReferencedOperator")
public class ReferencedOperator extends Operator {

    /**
     * Identifiant de l'op�rateur
     */
    private String operatorUid;

    /**
     * Constructeur principal de la classe ReferencedOperator
     */
    public ReferencedOperator() {
        setOperatorType(REFERENCED_OPERATOR.getName());
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
