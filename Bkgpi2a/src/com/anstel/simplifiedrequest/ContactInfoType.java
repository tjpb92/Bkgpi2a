package com.anstel.simplifiedrequest;

/**
 * Enum�ration sur les types de contacts
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 * @see documentation � mettre � jour ...
 */
public enum ContactInfoType {

    /**
     * T�l�phone
     */
    PHONE("Phone"),

     /**
     * Email
     */
    MAIL("Mail");


    private String name = "";

    /**
     * Constructeur de l'enum�ration
     */
    ContactInfoType(String name) {
        this.name = name;
    }

    /**
     * @return le type de m�dium
     */
    public String getName() {
        return name;
    }

    /**
     * @return le nom de l'�num�ration
     */
    @Override
    public String toString() {
        return name;
    }
}
