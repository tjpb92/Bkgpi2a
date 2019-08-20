package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe décrivant un ProviderContactQueryView
 *
 * @author Thierry Baribaud
 * @version 1.19
 * @see https://performanceimmo.github.io/API/#providercontactqueryview
 */
public class ProviderContactDetailedQueryView {

    /**
     * La société ProviderContact
     */
    @JsonUnwrapped
    private ProviderContact providerContact;

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * @return la société providerContact
     */
    public ProviderContact getProviderContact() {
        return providerContact;
    }

    /**
     * @param providerContact définit la société
     */
    public void setProviderContact(ProviderContact providerContact) {
        this.providerContact = providerContact;
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
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderContactDetailedQueryView:{"
                + " providerContact:" + getProviderContact()
                + ", _links:" + getLinks()
                + "}";
    }

}
