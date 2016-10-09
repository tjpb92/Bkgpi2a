package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un utilisateur de centre d'appel
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
//@JsonPropertyOrder({"uid", "login", "company", "firstName", "lastName", "job", "phone", "userType"})
public class CallCenterUser extends BasicUser {

    /**
     * Call center dont d�pend l'utilisateur
     */
    @JsonProperty("company")
    private CompanyUserQueryView company;

    @JsonProperty("userType")
    private final String userType = "callCenterUser";

// Pas satisfaisant, oblige � cr�er getter/setter.    
//    private final static String userType = "callCenterUser";
//    private final UserType userType = UserType.SUPER_USER;
    
    /**
     * Contructeur principal de la classe
     * C'est n�cessaire pour bien s�rialiser/des�rialiser la classe avec Jackson
     */
//    @JsonCreator
//    public CallCenterUser() {
//    }
    
    /**
     * @return le call center dont d�pend l'utilisateur
     */
    @JsonGetter("company")
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company d�finit le call center dont d�pend l'utilisateur
     */
    @JsonSetter("company")
    public void setCompany(CompanyUserQueryView company) {
        this.company = company;
    }

//    /**
//     * @return le type d'utilisateur
//     */
//    @JsonGetter("userType")
//    public String getUserType() {
//        return userType;
//    }
//
//    /**
//     * @param userType d�finit le type d'utilisateur
//     */
//    @JsonSetter("userType")
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{"
                + super.toString()
                + ", company:" + getCompany()
                + ", userType:" + userType
                + "}");
    }

}
