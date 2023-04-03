package com.anstel.simplifiedrequest;

import static com.anstel.simplifiedrequest.ContactInfoType.PHONE;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un téléphone
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 * @see documentation à mettre à jour
 */
@JsonTypeName("PhoneInfo")
public class PhoneInfo extends ContactInfo {

    /**
     * Numéro de téléphone
     */
    private String phone;

    /**
     * Constructeur principal de la classe PhoneInfo
     */
    public PhoneInfo() {
        setContactType(PHONE.getName());
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
        return "PhoneInfo:{"
                + super.toString()
                + ", phone:" + getPhone()
                + "}";
    }
}
