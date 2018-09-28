package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant la société d'un prestataire ou un prestaire.
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#providercompanies
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProviderCompany {

    /**
     * Identifiant unique du prestataire
     */
    private String uid;

    /**
     * Nom du prestataire
     */
    private String name;

    /**
     * Numéro de SIRET
     */
    private String siretNumber;

    /**
     * Liens entre entités
     */
//    @JsonProperty("_links")
    private Links _links;

    /**
     * @return l'identifiant unique du prestataire
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique du prestataire
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom du prestataire
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom du prestataire
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return le numéro de SIRET du prestataire
     */
    public String getSiretNumber() {
        return siretNumber;
    }

    /**
     * @param siretNumber définit le numéro de SIRET du prestataire
     */
    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    /**
     * @return la liste de liens entre entités
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links définit une liste de liens entre entités
     */
    @JsonSetter("_links")
    public void setLinks(Links _links) {
        this._links = _links;
    }

    /**
     * Ajoute un lien à la liste
     *
     * @param link lien à ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * @return les informations sur la filiale.
     */
    @Override
    public String toString() {
        return "ProviderCompany:{"
                + ", _links:" + getLinks()
                + ", uid:" + getUid()
                + ", name:" + getName()
                + ", siretNumber:" + getSiretNumber()
                + "}";
    }
}
