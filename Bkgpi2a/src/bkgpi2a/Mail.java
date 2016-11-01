package bkgpi2a;

import static bkgpi2a.ContactMediumType.MAIL;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un mail
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
@JsonTypeName("Mail")
public class Mail extends ContactMedium {

    /**
     * Num�ro de mail
     */
    private String mail;

    /**
     * Constructeur principal de la classe Mail
     */
    public Mail() {
        setContactMediumType(MAIL.getName());
    }

    /**
     * @return le num�ro de mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail d�finit le num�ro de mail
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
