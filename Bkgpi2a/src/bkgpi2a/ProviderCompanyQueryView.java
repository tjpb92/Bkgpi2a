package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe d�crivant la vue d'une soci�t� d'un prestataire.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#providercompanies
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderCompanyQueryView {

    /**
     * Identifiant unique de la soci�t� du prestataire
     */
    private String uid;

    /**
     * Nom de la soci�t� du prestataire
     */
    private String name;

    /**
     * Num�ro de SIRET de la soci�t� du prestataire
     */
    private String siretNumber;

    /**
     * @return l'identifiant unique de la soci�t� du prestataire
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de la soci�t� du prestataire
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de la soci�t� du prestataire
     */
    public String getName() {
        return name;
    }

    /**
     * @param name d�finit le nom de la soci�t� du prestataire
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return le num�ro de SIRET de la soci�t� du prestataire
     */
    public String getSiretNumber() {
        return siretNumber;
    }

    /**
     * @param siretNumber d�finit le num�ro de SIRET de la soci�t� du prestataire
     */
    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    /**
     * @return les informations de la soci�t� du prestataire.
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
