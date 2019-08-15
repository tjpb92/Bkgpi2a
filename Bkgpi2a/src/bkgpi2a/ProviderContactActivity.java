package bkgpi2a;

/**
 * Classe d�crivant les activit�s d'une soci�t� (ProviderContact).
 *
 * @author Thierry Baribaud
 * @version 1.13
 * @see https://performanceimmo.github.io/API/#providercontactactivity
 */
public class ProviderContactActivity {

    /**
     * Identifiant unique de l'activit� de la soci�t� (ProviderContact)
     */
    private String activityUid;

    /**
     * Liste de types d'incident
     */
    private SafeUUIDList includedIncidentTypes;

    /**
     * @return the activityUid
     */
    public String getActivityUid() {
        return activityUid;
    }

    /**
     * @param activityUid the activityUid to set
     */
    public void setActivityUid(String activityUid) {
        this.activityUid = activityUid;
    }

    /**
     * @return the includedIncidentTypes
     */
    public SafeUUIDList getIncludedIncidentTypes() {
        return includedIncidentTypes;
    }

    /**
     * @param includedIncidentTypes the includedIncidentTypes to set
     */
    public void setIncludedIncidentTypes(SafeUUIDList includedIncidentTypes) {
        this.includedIncidentTypes = includedIncidentTypes;
    }

    /**
     * @return les informations sur une activit� de la soci�t�.
     */
    @Override
    public String toString() {
        return "ProviderContactActivity:{"
                + "activityUid:" + getActivityUid()
                + ", includedIncidentTypes:" + getIncludedIncidentTypes()
                + "}";
    }
}
