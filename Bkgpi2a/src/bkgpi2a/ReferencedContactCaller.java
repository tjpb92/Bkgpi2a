package bkgpi2a;

import static bkgpi2a.CallerType.REFERENCED_CONTACT_CALLER;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un appelant r�f�renc�
 *
 * @author Thierry Baribaud
 * @version 1.42.1
 * @see
 * <A href="https://declarimmo-org.github.io/API/#callertype">CallerType</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ReferencedContactCaller")
public class ReferencedContactCaller extends Caller {

    /**
     * Identifiant de l'appelant
     */
    private String uid;

    /**
     * Constructeur principal de la classe ReferencedContactCaller
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
     * @param uid d�finit l'identifiant de l'appelant
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
