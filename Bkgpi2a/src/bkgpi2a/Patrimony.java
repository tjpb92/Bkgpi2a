package bkgpi2a;

import java.util.List;

/**
 * Classe d�crivant un patrimoine.
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
    private List<Address> complementaryAddress;

    /**
     * Adresses compl�mentaires du patrimoire
     */
    private List<Address> addresses;

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
    public List<Address> getComplementaryAddress() {
        return complementaryAddress;
    }

    /**
     * @param complementaryAddress d�finit les adresses compl�mentaires
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
     * @param addresses d�finit les adresses
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
