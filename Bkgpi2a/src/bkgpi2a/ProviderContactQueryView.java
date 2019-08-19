package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe d�crivant un ProviderContactQueryView
 *
 * @author Thierry Baribaud
 * @version 1.17
 * @see https://performanceimmo.github.io/API/#providercontactqueryview
 */
@JsonIgnoreProperties(value = { "patrimonies", "company" })
public class ProviderContactQueryView {

    /**
     * La soci�t� ProviderContact
     */
    @JsonUnwrapped
    private ProviderContact providerContact;

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
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderContactQueryView:{"
                + " providerContact:" + getProviderContact()
                + "}";
    }

}
