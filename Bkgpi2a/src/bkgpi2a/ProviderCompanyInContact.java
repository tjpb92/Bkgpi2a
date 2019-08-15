package bkgpi2a;

/**
 * Classe décrivant un ProviderCompanyInContact
 * @author Thierry Baribaud
 * @version 1.13
 * @see https://performanceimmo.github.io/API/#providercompanyincontact
 */
public class ProviderCompanyInContact {
    
    /**
     * Référence à la ProviderCompany
     */
    private String uid;
    
    /**
     * Nom de la ProviderCompany
     */
    private String name;
    
    /**
     * Numéro de Siret de la ProviderCompany
     */
    private String siretNumber;

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the siretNumber
     */
    public String getSiretNumber() {
        return siretNumber;
    }

    /**
     * @param siretNumber the siretNumber to set
     */
    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    /**
     * @return les informations sur le ProviderCompanyInContact
     */
    @Override
    public String toString() {
        return "ProviderCompanyInContact:{"
                + ", uid:" + getUid()
                + ", name:" + getName()
                + ", siretNumber:" + getSiretNumber()
                + "}";
    }    
    
    
}
