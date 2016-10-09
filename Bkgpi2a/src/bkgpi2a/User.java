package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 * Classe décrivant un utilisateur générique
 * Au 8 octobre 2016, c'est une copie de l'utilisateur Executive
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"uid", "login", "company", "managedAgencies", "firstName", "lastName", "job", "phone", "userType"})
public class User extends BasicUser {
    
    /**
     * Société dont dépend l'utilisateur
     */
    @JsonProperty("company")
    private CompanyUserQueryView company;
    
    /**
     * Agences supervisées par l'utilisateur
     */
    @JsonProperty("managedAgencies")
    private List<AgencyUserQueryView> managedAgencies;
    
    /**
     * Type d'utilisateur
     */
    @JsonProperty("userType")
    private String userType;

    /**
     * @return la société dont dépend l'utilisateur
     */
    @JsonGetter("company")
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company définit la société dont dépend l'utilisateur
     */
    @JsonSetter("company")
    public void setCompany(CompanyUserQueryView company) {
        this.company = company;
    }

    /**
     * @return les agences supervisées par l'utilisateur
     */
    @JsonGetter("managedAgencies")
    public List<AgencyUserQueryView> getManagedAgencies() {
        return managedAgencies;
    }

    /**
     * @param managedAgencies définit les agences supervisées par l'utilisateur
     */
    @JsonSetter("managedAgencies")
    public void setManagedAgencies(List<AgencyUserQueryView> managedAgencies) {
        this.managedAgencies = managedAgencies;
    }
    
    /**
     * @return le type d'utilisateur
     */
    @JsonGetter("userType")
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    @JsonSetter("userType")
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{"
                + super.toString()
                + ", company:" + getCompany()
                + ", managedAgencies:" + getManagedAgencies()
                + ", userType:" + getUserType()
                + "}");
    }

    
}
