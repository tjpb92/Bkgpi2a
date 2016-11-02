package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un container permettant le transfert des patrimoines.
 *
 * @author Thierry Baribaud
 * @version 0.20
 * @see http://performanceimmo.github.io/API/#patrimonies
 */
@JsonPropertyOrder({"_links", "result"})
public class PatrimonyContainer {

    /**
     * Liste de liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des sociétés
     */
    @JsonProperty("result")
    private PatrimonyList patrimonyList;

    /**
     * Constructeur de la classe PatrimonyContainer
     */
    public PatrimonyContainer() {
        setLinks(new Links());
        setPatrimonyList(new PatrimonyList());
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
     * @return la liste des agences
     */
    @JsonGetter("result")
    public PatrimonyList getPatrimonyList() {
        return patrimonyList;
    }

    /**
     * @param patrimonyList définit la liste des patrimoines
     */
    @JsonSetter("result")
    public void setPatrimonyList(PatrimonyList patrimonyList) {
        this.patrimonyList = patrimonyList;
    }

    /**
     * Ajoute un patrimoine à la liste
     *
     * @param patrimony patrimoine à ajouter
     */
    public void add(Patrimony patrimony) {
        patrimonyList.add(patrimony);
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
        return "PatrimonyContainer:{"
                + "_links:" + getLinks()
                + ", patrimonyList:" + getPatrimonyList()
                + "}";
    }
}
