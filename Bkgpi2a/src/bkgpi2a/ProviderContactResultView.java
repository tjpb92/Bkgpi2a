package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un container permettant le transfert des sociétés (ProviderContact).
 *
 * @author Thierry Baribaud
 * @version 1.15
 * @see https://performanceimmo.github.io/API/#providercontactresultview
 */
@JsonPropertyOrder({"_links", "result"})
public class ProviderContactResultView {

    /**
     * Liste de liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des sociétés
     */
    @JsonProperty("result")
    private ProviderContactQueryViewList providerContactQueryViewtList;

    /**
     * Constructeur de la classe ProviderContactResultView
     */
    public ProviderContactResultView() {
        setLinks(new Links());
        setProviderContactQueryViewtList(new ProviderContactQueryViewList());
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
     * @return la liste des providerContacts
     */
    @JsonGetter("result")
    public ProviderContactQueryViewList getProviderContactQueryViewtList() {
        return providerContactQueryViewtList;
    }

    /**
     * @param providerContactQueryViewtList définit la liste des providerContacts
     */
    @JsonSetter("result")
    public void setProviderContactQueryViewtList(ProviderContactQueryViewList providerContactQueryViewtList) {
        this.providerContactQueryViewtList = providerContactQueryViewtList;
    }

//    /**
//     * Ajoute un providerContact à la liste
//     *
//     * @param providerContactQueryView providerContact à ajouter
//     */
//    public void add(ProviderContactQueryViewList providerContactQueryView) {
//        providerContactQueryViewtList.add(providerContactQueryView);
//    }

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
        return "ProviderContactResultView:{"
                + "_links:" + getLinks()
                + ", result:" + getProviderContactQueryViewtList()
                + "}";
    }
}
