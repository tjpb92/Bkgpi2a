package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un container permettant le transfert des soci�t�s. Remplace
 * CompanyContainer.
 *
 * @author Thierry Baribaud
 * @version 1.39
 */
@JsonPropertyOrder({"_links", "result"})
public class ClientCompanyContainer {

    /**
     * Liste de liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des soci�t�s
     */
    @JsonProperty("result")
    private ClientCompanyList clientCompanyList;

    /**
     * Constructeur de la classe CompanyContainer
     */
    public ClientCompanyContainer() {
        setLinks(new Links());
        setClientCompanyList(new ClientCompanyList());
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
    public ClientCompanyList getClientCompanyList() {
        return clientCompanyList;
    }

    /**
     * @param clientCompanyList d�finit la liste des compagnies
     */
    @JsonSetter("result")
    public void setClientCompanyList(ClientCompanyList clientCompanyList) {
        this.clientCompanyList = clientCompanyList;
    }

    /**
     * Ajoute une compagnie � la liste
     *
     * @param clientCompany soci�t� � ajouter
     */
    public void add(ClientCompany clientCompany) {
        clientCompanyList.add(clientCompany);
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
        return "CompanyContainer:{"
                + "_links:" + getLinks()
                + ", clientCompanyList:" + getClientCompanyList()
                + "}";
    }
}
