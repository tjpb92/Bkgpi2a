package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe décrivant la vue d'une société d'un prestataire.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#providercompanies
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderCompanyQueryView {

    /**
     * Identifiant unique de la société du prestataire
     */
    private String uid;

    /**
     * Nom de la société du prestataire
     */
    private String name;

    /**
     * Numéro de SIRET de la société du prestataire
     */
    private String siretNumber;

    /**
     * @return l'identifiant unique de la société du prestataire
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la société du prestataire
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de la société du prestataire
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom de la société du prestataire
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return le numéro de SIRET de la société du prestataire
     */
    public String getSiretNumber() {
        return siretNumber;
    }

    /**
     * @param siretNumber définit le numéro de SIRET de la société du prestataire
     */
    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    /**
     * @return les informations de la société du prestataire.
     */
    @Override
    public String toString() {
        return "ProviderCompanyQueryView:{"
                + ", uid:" + getUid()
                + ", name:" + getName()
                + ", siretNumber:" + getSiretNumber()
                + "}";
    }
}
