package bkgpi2a;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe décrivant une liste de numéros de téléphone
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class PhoneList {

    /**
     * Liste de numéros de téléphone
     */
    private List<String> phones;

    /**
     * @return la liste de numéros de téléphone
     */
    public List<String> getPhones() {
        return phones;
    }

    /**
     * Constructeur principal de la classe
     */
    public PhoneList() {
        phones = new ArrayList();
    }
    
    /**
     * Constructeur secondaire de la classe
     * @param phone un numéro de téléphone
     */
    public PhoneList(String phone) {
        this();
        this.addPhone(phone);
    }

    /**
     * @param phones définit liste de numéros de téléphone
     */
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    /** 
     * @param phone ajoute un numéro de téléphone à la liste
     */
    public void addPhone(String phone) {
        phones.add(phone);
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{phones:" + getPhones()
                + "}");
    }
}
