package com.anstel.simplifiedrequest;

/**
 * Enumération sur les types de contacts
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 * @see documentation à mettre à jour ...
 */
public enum ContactInfoType {

    /**
     * Téléphone
     */
    PHONE("Phone"),

     /**
     * Email
     */
    MAIL("Mail");


    private String name = "";

    /**
     * Constructeur de l'enumération
     */
    ContactInfoType(String name) {
        this.name = name;
    }

    /**
     * @return le type de médium
     */
    public String getName() {
        return name;
    }

    /**
     * @return le nom de l'énumération
     */
    @Override
    public String toString() {
        return name;
    }
}
