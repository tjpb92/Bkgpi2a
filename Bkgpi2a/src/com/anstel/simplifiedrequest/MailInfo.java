package com.anstel.simplifiedrequest;

import static com.anstel.simplifiedrequest.ContactInfoType.MAIL;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un mail
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 * @see documentation à mettre à jour
 */
@JsonTypeName("MailInfo")
public class MailInfo extends ContactInfo {

    /**
     * Email
     */
    private String mail;

    /**
     * Constructeur principal de la classe MailInfo
     */
    public MailInfo() {
        setContactType(MAIL.getName());
    }

    /**
     * @return le mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail définit le mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "MailInfo:{"
                + super.toString()
                + ", mail:" + getMail()
                + "}";
    }
}
