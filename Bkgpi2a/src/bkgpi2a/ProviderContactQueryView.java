package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe d�crivant un ProviderContactQueryView
 *
 * @author Thierry Baribaud
 * @version 1.15
 * @see https://performanceimmo.github.io/API/#providercontactqueryview
 */
public class ProviderContactQueryView {

    /**
     * La soci�t� ProviderContact
     */
    @JsonUnwrapped
    private ProviderContact providerContact;

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
     * @return la soci�t� providerContact
     */
    public ProviderContact getProviderContact() {
        return providerContact;
    }

    /**
     * @param providerContact d�finit la soci�t�
     */
    public void setProviderContact(ProviderContact providerContact) {
        this.providerContact = providerContact;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderContactQueryView:{"
                + " providerContact:" + getProviderContact()
                + ", providerCompany:" + getProviderCompany()
                + ", activities:" + getActivities()
                + "}";
    }

}
