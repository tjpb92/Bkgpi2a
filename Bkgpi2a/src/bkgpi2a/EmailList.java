package bkgpi2a;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe décrivant une liste de mails
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class EmailList {

    /**
     * Liste de mails
     */
    private List<String> emails;

    /**
     * @return la liste de mails
     */
    public List<String> getEmails() {
        return emails;
    }

    /**
     * Constructeur principal de la classe
     */
    public EmailList() {
        emails = new ArrayList();
    }
    
    /**
     * Constructeur secondaire de la classe
     * @param email un mail
     */
    public EmailList(String email) {
        this();
        this.addEmail(email);
    }

    /**
     * @param emails définit liste de mails
     */
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    /** 
     * @param email ajoute un mail à la liste
     */
    public void addEmail(String email) {
        emails.add(email);
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{mails:" + getEmails()
                + "}");
    }
}
