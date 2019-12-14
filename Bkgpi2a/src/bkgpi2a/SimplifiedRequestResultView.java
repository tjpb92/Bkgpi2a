package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un container permettant le transfert des demandes d'intervention émises depuis l'application mobile
 *
 * @author Thierry Baribaud
 * @version 1.28
 * @see https://performanceimmo.github.io/API/#simplifiedrequestresultview
 */
@JsonPropertyOrder({"_links", "result"})
@JsonIgnoreProperties(value = {"aggregations"})
public class SimplifiedRequestResultView {

    /**
     * Aggrégation (pour usage futur)
     */
//    Aggregations aggregations;

    /**
     * Liste de liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des sociétés
     */
    @JsonProperty("result")
    private SimplifiedRequestSearchViewList simplifiedRequestSearchViewList;

    /**
     * Constructeur de la classe SimplifiedRequestResultView
     */
    public SimplifiedRequestResultView() {
        setLinks(new Links());
        setSimplifiedRequestSearchViewList(new SimplifiedRequestSearchViewList());
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
     * @return la liste des demandes d'intervention émises depuis l'application mobile
     */
    @JsonGetter("result")
    public SimplifiedRequestSearchViewList getSimplifiedRequestSearchViewList() {
        return simplifiedRequestSearchViewList;
    }

    /**
     * @param simplifiedRequestSearchViewList définit la liste des demandes d'intervention émises depuis l'application mobile
     */
    @JsonSetter("result")
    public void setSimplifiedRequestSearchViewList(SimplifiedRequestSearchViewList simplifiedRequestSearchViewList) {
        this.simplifiedRequestSearchViewList = simplifiedRequestSearchViewList;
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
        return "SimplifiedRequestSearchViewList:{"
                + "_links:" + getLinks()
                + ", result:" + getSimplifiedRequestSearchViewList()
                + "}";
    }
}
