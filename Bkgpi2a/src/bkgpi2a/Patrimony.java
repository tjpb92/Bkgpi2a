package bkgpi2a;

import java.util.List;

/**
 * Classe décrivant un patrimoine.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class Patrimony {

    /**
     * Identifiant unique du patrimoine
     */
    private String uid;

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
    private List<Address> complementaryAddress;

    /**
     * Adresses complémentaires du patrimoire
     */
    private List<Address> addresses;

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
    public List<Address> getComplementaryAddress() {
        return complementaryAddress;
    }

    /**
     * @param complementaryAddress définit les adresses complémentaires
     */
    public void setComplementaryAddress(List<Address> complementaryAddress) {
        this.complementaryAddress = complementaryAddress;
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
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getSimpleName()
                + ":{uid:" + getUid()
                + ", ref:" + getRef()
                + ", label:" + getLabel()
                + ", agencies:" + getAgencies()
                + ", addresses:" + getAddresses()
                + ", complementaryAddress:" + getComplementaryAddress()
                + "}");
    }
}
