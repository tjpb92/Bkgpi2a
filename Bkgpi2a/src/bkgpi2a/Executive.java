package pi2a;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * Classe décrivant un utilisateur d'une agence
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"uid", "login", "company", "managedAgencies", "firstName", "lastName", "job", "phone", "userType"})
public class Executive extends BasicUser {
    
    /**
     * Société dont dépend l'utilisateur
     */
    private CompanyUserQueryView company;
    
    /**
     * Agences supervisées par l'utilisateur
     */
    private List<AgencyUserQueryView> managedAgencies;
    
    @JsonProperty("userType")
    private final String userType = "executive";
//    private final UserType userType = UserType.SUPER_USER;

    /**
     * @return la société dont dépend l'utilisateur
     */
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company définit la société dont dépend l'utilisateur
     */
    public void setCompany(CompanyUserQueryView company) {
        this.company = company;
    }

    /**
     * @return les agences supervisées par l'utilisateur
     */
    public List<AgencyUserQueryView> getManagedAgencies() {
        return managedAgencies;
    }

    /**
     * @param managedAgencies définit les agences supervisées par l'utilisateur
     */
    public void setManagedAgencies(List<AgencyUserQueryView> managedAgencies) {
        this.managedAgencies = managedAgencies;
    }
}
