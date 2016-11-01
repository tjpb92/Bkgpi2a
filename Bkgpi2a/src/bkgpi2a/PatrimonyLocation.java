package bkgpi2a;

import static bkgpi2a.LocationReferenceType.PATRIMONY_LOCATION;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant une localisation par patrimoine
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#locationreference
 */
@JsonTypeName("PatrimonyLocation")
public class PatrimonyLocation extends LocationReference {

    /**
     * Identifiant du patrimoine
     */
    private String patrimonyUid;

    /**
     * Constructeur principal de la classe PatrimonyLocation
     */
    public PatrimonyLocation() {
        setLocationReferenceType(PATRIMONY_LOCATION.getName());
    }

    /**
     * @return l'identifiant du patrimoine
     */
    public String getPatrimonyUid() {
        return patrimonyUid;
    }

    /**
     * @param patrimonyUid définit l'identifiant du patrimoine
     */
    public void setPatrimonyUid(String patrimonyUid) {
        this.patrimonyUid = patrimonyUid;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "PatrimonyLocation:{"
                + super.toString()
                + ", patrimonyUid:" + getPatrimonyUid()
                + "}";
    }
}
