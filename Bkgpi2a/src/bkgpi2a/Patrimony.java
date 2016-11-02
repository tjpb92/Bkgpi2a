package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 * Classe décrivant un patrimoine.
 *
 * @author Thierry Baribaud
 * @version 0.20
 * @see http://performanceimmo.github.io/API/#patrimonies
 */
public class Patrimony {

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Identifiant unique du patrimoine
     */
    private String uid;

    /**
     * Identifiant unique de la société dans la base de données Anstel
     */
    @JsonIgnore
    private int id;

    /**
     * Référence du patrimoine
     */
    private String ref;

    /**
     * Nom du patrimoine (label)
     */
    private String label;

    /**
     * Agences dont dépend le patrimoine
     */
    private List<String> agencies;

    /**
     * Adresses du patrimoine
     */
    private List<Address> complementaryAddresses;

    /**
     * Adresses complémentaires du patrimoire
     */
    private List<Address> addresses;

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
     * @return l'identifiant unique du patrimoine
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique du patrimoine
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return la référence du patrimoine
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref définit la référence du patrimoine
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return le nom du patrimoine
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom du patrimoine
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return les agences dont dépend le patrimoine
     */
    public List<String> getAgencies() {
        return agencies;
    }

    /**
     * @param agencies définit les agences dont dépend le patrimoine
     */
    public void setAgencies(List<String> agencies) {
        this.agencies = agencies;
    }

    /**
     * @return les adresses complémentaires
     */
    public List<Address> getComplementaryAddresses() {
        return complementaryAddresses;
    }

    /**
     * @param complementaryAddresses définit les adresses complémentaires
     */
    public void setComplementaryAddresses(List<Address> complementaryAddresses) {
        this.complementaryAddresses = complementaryAddresses;
    }

    /**
     * @return les adresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses définit les adresses
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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
     * @return l'identifiant unique de la base de données Anstel
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * @param id définit l'identifiant unique de la base de données Anstel
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Patrimony:{"
                + "id:" + getId()
                + ", _links:" + getLinks()
                + ", uid:" + getUid()
                + ", ref:" + getRef()
                + ", label:" + getLabel()
                + ", agencies:" + getAgencies()
                + ", addresses:" + getAddresses()
                + ", complementaryAddress:" + getComplementaryAddresses()
                + "}";
    }
}
