package bkgpi2a;

import java.util.List;

/**
 * Classe d�crivant un patrimoine.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class Patrimony {
    
    private String uid;
    private String ref;
    private String label;
    private List<String> agencies;
    private List<Address> complementaryAddress;
    private List<Address> addresses;

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the ref
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref the ref to set
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

}
