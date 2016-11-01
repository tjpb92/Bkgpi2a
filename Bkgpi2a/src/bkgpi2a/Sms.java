package bkgpi2a;

import static bkgpi2a.ContactMediumType.SMS;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un SMS
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
@JsonTypeName("Sms")
public class Sms extends ContactMedium {

    /**
     * Num�ro de SMS
     */
    private String phone;

    /**
     * Constructeur principal de la classe Sms
     */
    public Sms() {
        setContactMediumType(SMS.getName());
    }

    /**
     * @return le num�ro de SMS
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone d�finit le num�ro de SMS
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Sms:{"
                + super.toString()
                + ", phone:" + getPhone()
                + "}";
    }
}
