package bkgpi2a;

import static bkgpi2a.ContactMediumType.PHONE;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un t�l�phone
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
@JsonTypeName("Phone")
public class Phone extends ContactMedium {

    /**
     * Num�ro de t�l�phone
     */
    private String phone;

    /**
     * Constructeur principal de la classe Phone
     */
    public Phone() {
        setContactMediumType(PHONE.getName());
    }

    /**
     * @return le num�ro de t�l�phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone d�finit le num�ro de t�l�phone
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
