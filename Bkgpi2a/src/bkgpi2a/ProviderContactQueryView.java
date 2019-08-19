package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe décrivant un ProviderContactQueryView
 *
 * @author Thierry Baribaud
 * @version 1.17
 * @see https://performanceimmo.github.io/API/#providercontactqueryview
 */
@JsonIgnoreProperties(value = { "patrimonies", "company" })
public class ProviderContactQueryView {

    /**
     * La société ProviderContact
     */
    @JsonUnwrapped
    private ProviderContact providerContact;

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
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderContactQueryView:{"
                + " providerContact:" + getProviderContact()
                + "}";
    }

}
