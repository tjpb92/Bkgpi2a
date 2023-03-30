package bkgpi2a;

import static bkgpi2a.CallerType.REFERENCED_USER_CALLER;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un ??? référencé
 *
 * @author Thierry Baribaud
 * @version 1.42.1
 * @see
 * <A href="https://declarimmo-org.github.io/API/#callertype">CallerType</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ReferencedUserCaller ")
public class ReferencedUserCaller extends Caller {

    /**
     * Identifiant de l'appelant
     */
    private String uid;

    /**
     * Constructeur principal de la classe ReferencedUserCaller
     */
    public ReferencedUserCaller() {
        setCallerType(REFERENCED_USER_CALLER.getName());
    }

    /**
     * @return l'identifiant de l'appelant
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant de l'appelant
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ReferencedUserCaller :{"
                + super.toString()
                + ", uid:" + getUid()
                + "}";
    }
}
