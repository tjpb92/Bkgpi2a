package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un container permettant le transfert des contactProviders.
 *
 * @author Thierry Baribaud
 * @version 0.20
 * @see http://performanceimmo.github.io/API/#providercontacts
 */
@JsonPropertyOrder({"_links", "result"})
public class ProviderContactContainer {

    /**
     * Liste de liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Liste des soci�t�s
     */
    @JsonProperty("result")
    private ProviderContactList providerContactList;

    /**
     * Constructeur de la classe PatrimonyContainer
     */
    public ProviderContactContainer() {
        setLinks(new Links());
        setProviderContactList(new ProviderContactList());
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
    public ProviderContactList getProviderContactList() {
        return providerContactList;
    }

    /**
     * @param providerContactList d�finit la liste des providerContacts
     */
    @JsonSetter("result")
    public void setProviderContactList(ProviderContactList providerContactList) {
        this.providerContactList = providerContactList;
    }

    /**
     * Ajoute un providerContact � la liste
     *
     * @param providerContact providerContact � ajouter
     */
    public void add(ProviderContact providerContact) {
        providerContactList.add(providerContact);
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
                + ", providerContactList:" + getProviderContactList()
                + "}";
    }
}
