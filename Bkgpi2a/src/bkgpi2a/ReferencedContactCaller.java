package bkgpi2a;

import static bkgpi2a.CallerType.REFERENCED_CONTACT_CALLER;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un appelant référencé
 *
 * @author Thierry Baribaud
 * @version 1.34
 * @see <A href="http://performanceimmo.github.io/API/#callertype">CallerType</A>
 */
@JsonTypeName("ReferencedContactCaller")
public class ReferencedContactCaller extends Caller {

    /**
     * Identifiant de l'appelant
     */
    private String uid;

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public ReferencedContactCaller() {
        setCallerType(REFERENCED_CONTACT_CALLER.getName());
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
        return "ReferencedContactCaller:{"
                + super.toString()
                + ", uid:" + getUid()
                + "}";
    }
}
