package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un container permettant le transfert des soci�t�s.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "result"})
public class CompanyContainer {

    /**
     * Liste de liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des soci�t�s
     */
    @JsonProperty("result")
    private CompanyList companyList;

    /**
     * Constructeur de la classe CompanyContainer
     */
    public CompanyContainer() {
        setCompanyList(new CompanyList());
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
     * @return la liste des compagnies
     */
    @JsonGetter("result")
    public CompanyList getCompanyList() {
        return companyList;
    }

    /**
     * @param companyList d�finit la liste des compagnies
     */
    @JsonSetter("result")
    public void setCompanyList(CompanyList companyList) {
        this.companyList = companyList;
    }

    /**
     * Ajoute une compagnie � la liste
     *
     * @param company soci�t� � ajouter
     */
    public void add(Company company) {
        companyList.add(company);
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
        return "UserContainer:{"
                + "_links:" + getLinks()
                + ", userList:" + getCompanyList()
                + "}";
    }
}
