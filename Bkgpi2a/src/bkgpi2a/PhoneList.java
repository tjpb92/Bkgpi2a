package bkgpi2a;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe d�crivant une liste de num�ros de t�l�phone
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class PhoneList {

    /**
     * Liste de num�ros de t�l�phone
     */
    private List<String> phones;

    /**
     * @return la liste de num�ros de t�l�phone
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
     * @param phone un num�ro de t�l�phone
     */
    public PhoneList(String phone) {
        this();
        this.addPhone(phone);
    }

    /**
     * @param phones d�finit liste de num�ros de t�l�phone
     */
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    /** 
     * @param phone ajoute un num�ro de t�l�phone � la liste
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
