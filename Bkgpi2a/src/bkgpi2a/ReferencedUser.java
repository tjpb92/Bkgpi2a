package bkgpi2a;

import static bkgpi2a.OperatorType.REFERENCED_USER;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un utilisateur référencé
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#operator
 */
@JsonTypeName("ReferencedUser")
public class ReferencedUser extends Operator {

    /**
     * Identifiant de l'utilisateur
     */
    private String userUid;

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public ReferencedUser() {
        setOperatorType(REFERENCED_USER.getName());
    }

    /**
     * @return l'identifiant de l'utilisateur
     */
    public String getUserUid() {
        return userUid;
    }

    /**
     * @param userUid définit l'identifiant de l'utilisateur
     */
    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ReferencedUser:{"
                + super.toString()
                + ", userUid:" + getUserUid()
                + "}";
    }
}
