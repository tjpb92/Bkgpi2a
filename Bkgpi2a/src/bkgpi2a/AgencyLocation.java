package bkgpi2a;

import static bkgpi2a.LocationReferenceType.AGENCY_LOCATION;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant une localisation par agence
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see <A href="http://performanceimmo.github.io/API/#locationreference">AgencyLocation</A>
 */
@JsonTypeName("AgencyLocation")
public class AgencyLocation extends LocationReference {

    /**
     * Identifiant de l'agence
     */
    private String agencyUid;

    /**
     * Constructeur principal de la classe AgencyLocation
     */
    public AgencyLocation() {
        setLocationReferenceType(AGENCY_LOCATION.getName());
    }

    /**
     * @return l'identifiant de l'agence
     */
    public String getAgencyUid() {
        return agencyUid;
    }

    /**
     * @param agencyUid définit l'identifiant de l'agence
     */
    public void setAgencyUid(String agencyUid) {
        this.agencyUid = agencyUid;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AgencyLocation:{"
                + super.toString()
                + ", agencyUid:" + getAgencyUid()
                + "}";
    }
}
