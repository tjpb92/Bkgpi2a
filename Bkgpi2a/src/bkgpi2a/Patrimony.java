package bkgpi2a;

import java.util.List;

/**
 * Classe décrivant un patrimoine.
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
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the agencies
     */
    public List<String> getAgencies() {
        return agencies;
    }

    /**
     * @param agencies the agencies to set
     */
    public void setAgencies(List<String> agencies) {
        this.agencies = agencies;
    }

    /**
     * @return the complementaryAddress
     */
    public List<Address> getComplementaryAddress() {
        return complementaryAddress;
    }

    /**
     * @param complementaryAddress the complementaryAddress to set
     */
    public void setComplementaryAddress(List<Address> complementaryAddress) {
        this.complementaryAddress = complementaryAddress;
    }

    /**
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", ref:" + getRef()
                + ", label:" + getLabel()
                + ", agencies:" + getAgencies()
                + ", addresses:" + getAddresses()
                + ", complementaryAddress:" + getComplementaryAddress()
                + "}");
    }}
