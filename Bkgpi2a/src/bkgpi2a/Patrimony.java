package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 * Classe d�crivant un patrimoine.
 *
 * @author Thierry Baribaud
 * @version 0.20
 * @see http://performanceimmo.github.io/API/#patrimonies
 */
public class Patrimony {

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Identifiant unique du patrimoine
     */
    private String uid;

    /**
     * Identifiant unique de la soci�t� dans la base de donn�es Anstel
     */
    @JsonIgnore
    private int id;

    /**
     * R�f�rence du patrimoine
     */
    private String ref;

    /**
     * Nom du patrimoine (label)
     */
    private String label;

    /**
     * Agences dont d�pend le patrimoine
     */
    private List<String> agencies;

    /**
     * Adresses du patrimoine
     */
    private List<Address> complementaryAddresses;

    /**
     * Adresses compl�mentaires du patrimoire
     */
    private List<Address> addresses;

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
     * @return l'identifiant unique du patrimoine
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique du patrimoine
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return la r�f�rence du patrimoine
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref d�finit la r�f�rence du patrimoine
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
     * @param label d�finit le nom du patrimoine
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return les agences dont d�pend le patrimoine
     */
    public List<String> getAgencies() {
        return agencies;
    }

    /**
     * @param agencies d�finit les agences dont d�pend le patrimoine
     */
    public void setAgencies(List<String> agencies) {
        this.agencies = agencies;
    }

    /**
     * @return les adresses compl�mentaires
     */
    public List<Address> getComplementaryAddresses() {
        return complementaryAddresses;
    }

    /**
     * @param complementaryAddresses d�finit les adresses compl�mentaires
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
     * @param addresses d�finit les adresses
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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
     * @return l'identifiant unique de la base de donn�es Anstel
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * @param id d�finit l'identifiant unique de la base de donn�es Anstel
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
