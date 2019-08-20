package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe d�crivant un ProviderContactQueryView
 *
 * @author Thierry Baribaud
 * @version 1.19
 * @see https://performanceimmo.github.io/API/#providercontactqueryview
 */
public class ProviderContactDetailedQueryView {

    /**
     * La soci�t� ProviderContact
     */
    @JsonUnwrapped
    private ProviderContact providerContact;

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * @return la soci�t� providerContact
     */
    public ProviderContact getProviderContact() {
        return providerContact;
    }

    /**
     * @param providerContact d�finit la soci�t�
     */
    public void setProviderContact(ProviderContact providerContact) {
        this.providerContact = providerContact;
    }

    /**
     * @return la liste de liens entre entit�s
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links d�finit une liste de liens entre entit�s
     */
    @JsonSetter("_links")
    public void setLinks(Links _links) {
        this._links = _links;
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
