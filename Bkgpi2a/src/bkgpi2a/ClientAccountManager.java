package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un manager de centre d'appel
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"uid", "login", "company", "firstName", "lastName", "job", "phone", "userType"})
public class ClientAccountManager extends BasicUser {

    /**
     * Call center dont dépend le manager
     */
    @JsonProperty("company")
    private CompanyUserQueryView company;

    @JsonProperty("userType")
    private final String userType = "clientAccountManager";
//    private final UserType userType = UserType.SUPER_USER;

    /**
     * @return le call center dont dépend le manager
     */
    @JsonGetter("company")
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company définit le call center dont dépend le manager
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
        return (this.getClass().getName()
                + ":{"
                + super.toString()
                + ", company:" + getCompany()
                + ", userType:" + userType
                + "}");
    }

}
