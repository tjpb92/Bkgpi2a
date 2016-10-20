package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un utilisateur de centre d'appel
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("callCenterUser")
public class CallCenterUser extends User {

    /**
     * Call center dont dépend l'utilisateur
     */
    @JsonProperty("company")
    private CompanyUserQueryView company;

    /**
     * @return le call center dont dépend l'utilisateur
     */
    @JsonGetter("company")
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company définit le call center dont dépend l'utilisateur
     */
    @JsonSetter("company")
    public void setCompany(CompanyUserQueryView company) {
        this.company = company;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "CallCenterUser:{"
                + super.toString()
                + ", company:" + getCompany()
                + "}";
    }

}
