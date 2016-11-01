package bkgpi2a;

import static bkgpi2a.ContactMediumType.MAIL;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un mail
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
@JsonTypeName("Mail")
public class Mail extends ContactMedium {

    /**
     * Numéro de mail
     */
    private String mail;

    /**
     * Constructeur principal de la classe Mail
     */
    public Mail() {
        setContactMediumType(MAIL.getName());
    }

    /**
     * @return le numéro de mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail définit le numéro de mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Mail:{"
                + super.toString()
                + ", mail:" + getMail()
                + "}";
    }
}
