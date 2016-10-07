package pi2a;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Classe d�crivant un manager de centre d'appel
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"uid", "login", "company", "firstName", "lastName", "job", "phone", "userType"})
public class ClientAccountManager extends BasicUser {
    
    /**
     * Call center dont d�pend le manager
     */
    private CompanyUserQueryView company;
    
    @JsonProperty("userType")
    private final String userType = "clientAccountManager";
//    private final UserType userType = UserType.SUPER_USER;

    /**
     * @return le call center dont d�pend le manager
     */
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company d�finit le call center dont d�pend le manager
     */
    public void setCompany(CompanyUserQueryView company) {
        this.company = company;
    }
}
