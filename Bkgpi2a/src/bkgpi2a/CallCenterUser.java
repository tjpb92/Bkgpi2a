package pi2a;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Classe décrivant un utilisateur de centre d'appel
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"uid", "login", "company", "firstName", "lastName", "job", "phone", "userType"})
public class CallCenterUser extends BasicUser {
    
    /**
     * Call center dont dépend l'utilisateur
     */
    private CompanyUserQueryView company;
    
    @JsonProperty("userType")
    private final String userType = "callCenterUser";
//    private final UserType userType = UserType.SUPER_USER;

    /**
     * @return le call center dont dépend l'utilisateur
     */
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company définit le call center dont dépend l'utilisateur
     */
    public void setCompany(CompanyUserQueryView company) {
        this.company = company;
    }
}
