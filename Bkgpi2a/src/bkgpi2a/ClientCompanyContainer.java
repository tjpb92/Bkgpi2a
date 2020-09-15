package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un container permettant le transfert des sociétés. Remplace
 * CompanyContainer.
 *
 * @author Thierry Baribaud
 * @version 1.39
 */
@JsonPropertyOrder({"_links", "result"})
public class ClientCompanyContainer {

    /**
     * Liste de liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des sociétés
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
     * @return la liste de liens entre entités
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links définit la liste de liens entre entités
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
     * @param clientCompanyList définit la liste des compagnies
     */
    @JsonSetter("result")
    public void setClientCompanyList(ClientCompanyList clientCompanyList) {
        this.clientCompanyList = clientCompanyList;
    }

    /**
     * Ajoute une compagnie à la liste
     *
     * @param clientCompany société à ajouter
     */
    public void add(ClientCompany clientCompany) {
        clientCompanyList.add(clientCompany);
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
