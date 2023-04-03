package com.anstel.simplifiedrequest;

import static com.anstel.simplifiedrequest.ContactInfoType.PHONE;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un t�l�phone
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 * @see documentation � mettre � jour
 */
@JsonTypeName("PhoneInfo")
public class PhoneInfo extends ContactInfo {

    /**
     * Num�ro de t�l�phone
     */
    private String phone;

    /**
     * Constructeur principal de la classe PhoneInfo
     */
    public PhoneInfo() {
        setContactType(PHONE.getName());
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
        return "PhoneInfo:{"
                + super.toString()
                + ", phone:" + getPhone()
                + "}";
    }
}
