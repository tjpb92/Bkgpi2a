package bkgpi2a;

import static bkgpi2a.ContactMediumType.PHONE;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un téléphone
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
@JsonTypeName("Phone")
public class Phone extends ContactMedium {

    /**
     * Numéro de téléphone
     */
    private String phone;

    /**
     * Constructeur principal de la classe Phone
     */
    public Phone() {
        setContactMediumType(PHONE.getName());
    }

    /**
     * @return le numéro de téléphone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone définit le numéro de téléphone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Phone:{"
                + super.toString()
                + ", phone:" + getPhone()
                + "}";
    }
}
