package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un container permettant le transfert de prestataires
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#providercompanies
 */
@JsonPropertyOrder({"_links", "result"})
public class ProviderCompanyContainer {

    /**
     * Liste de liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des soci�t�s
     */
    @JsonProperty("result")
    private ProviderCompanyList providerCompanyList;

    /**
     * Constructeur de la classe ProviderCompanyContainer
     */
    public ProviderCompanyContainer() {
        this._links = new Links();
        this.providerCompanyList = new ProviderCompanyList();
    }

    /**
     * @return la liste de liens entre entit�s
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links d�finit la liste de liens entre entit�s
     */
    @JsonSetter("_links")
    public void setLinks(Links _links) {
        this._links = _links;
    }

    /**
     * @return la liste des prestataires
     */
    @JsonGetter("result")
    public ProviderCompanyList getProviderCompanyList() {
        return providerCompanyList;
    }

    /**
     * @param providerCompanyList d�finit la liste des prestataires
     */
    @JsonSetter("result")
    public void setProviderCompanyList(ProviderCompanyList providerCompanyList) {
        this.providerCompanyList = providerCompanyList;
    }

    /**
     * Ajoute un prestataire � la liste
     *
     * @param providerCompany prestataire � ajouter
     */
    public void add(ProviderCompany providerCompany) {
        providerCompanyList.add(providerCompany);
    }

    /**
     * Ajoute un lien � la liste
     *
     * @param link lien � ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * Retourne le contenu d'un container
     *
     * @return le contenu d'un container
     */
    @Override
    public String toString() {
        return "ProviderContactContainer:{"
                + "_links:" + getLinks()
                + ", providerCompanyList:" + getProviderCompanyList()
                + "}";
    }
}
