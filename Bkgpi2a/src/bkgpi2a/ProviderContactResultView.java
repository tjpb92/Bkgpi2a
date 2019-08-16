package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un container permettant le transfert des soci�t�s (ProviderContact).
 *
 * @author Thierry Baribaud
 * @version 1.15
 * @see https://performanceimmo.github.io/API/#providercontactresultview
 */
@JsonPropertyOrder({"_links", "result"})
public class ProviderContactResultView {

    /**
     * Liste de liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des soci�t�s
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
     * @return la liste des providerContacts
     */
    @JsonGetter("result")
    public ProviderContactQueryViewList getProviderContactQueryViewtList() {
        return providerContactQueryViewtList;
    }

    /**
     * @param providerContactQueryViewtList d�finit la liste des providerContacts
     */
    @JsonSetter("result")
    public void setProviderContactQueryViewtList(ProviderContactQueryViewList providerContactQueryViewtList) {
        this.providerContactQueryViewtList = providerContactQueryViewtList;
    }

//    /**
//     * Ajoute un providerContact � la liste
//     *
//     * @param providerContactQueryView providerContact � ajouter
//     */
//    public void add(ProviderContactQueryViewList providerContactQueryView) {
//        providerContactQueryViewtList.add(providerContactQueryView);
//    }

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
        return "ProviderContactResultView:{"
                + "_links:" + getLinks()
                + ", result:" + getProviderContactQueryViewtList()
                + "}";
    }
}
