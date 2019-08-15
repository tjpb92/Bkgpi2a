package bkgpi2a;

/**
 * Classe d�crivant un ProviderContactQueryView
 * @author Thierry Baribaud
 * @version 1.13
 * @see https://performanceimmo.github.io/API/#providercontactqueryview
 */
public class ProviderContactQueryView extends ProviderContact{
    
    /**
     * R�f�rence � la soci�t� (ProviderCompany)
     */
    private ProviderCompanyInContact providerCompany;
    
    /**
     * Liste des activit� de la soci�t� (ProviderContact)
     */
    private ProviderContactActivityList activities;

    /**
     * @return the providerCompany
     */
    public ProviderCompanyInContact getProviderCompany() {
        return providerCompany;
    }

    /**
     * @param providerCompany the providerCompany to set
     */
    public void setProviderCompany(ProviderCompanyInContact providerCompany) {
        this.providerCompany = providerCompany;
    }

    /**
     * @return the activities
     */
    public ProviderContactActivityList getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(ProviderContactActivityList activities) {
        this.activities = activities;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderContactQueryView:{"
                + super.toString()
                + ", providerCompany:" + getProviderCompany()
                + ", activities:" + getActivities()
                + "}";
    }
    
}
