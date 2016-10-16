package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 * Classe décrivant un utilisateur générique
 * Alternative à User
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"uid", "login", "company", "managedAgencies", "firstName", "lastName", "job", "phone", "isActive", "userType"})
public class GenericUser {
    
    /**
     * Identifiant unique de l'utilisateur
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Login de l'utilisateur
     */
    @JsonProperty("login")
    private String login;

    /**
     * Prénom de l'utilisateur
     */
    @JsonProperty("firstName")
    private String firstName;

    /**
     * Nom de l'utilisateur
     */
    @JsonProperty("lastName")
    private String lastName;

    /**
     * Rôle de l'utilisateur
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("job")
    private String job;

    /**
     * Téléphone de l'utilisateur
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("phone")
    private String phone;

    /**
     * Etat d'activité de l'utilisateur
     */
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("isActive")
    private boolean isActive;

    /**
     * Société dont dépend l'utilisateur
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("company")
    private CompanyUserQueryView company;
    
    /**
     * Agences supervisées par l'utilisateur
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("managedAgencies")
    private List<AgencyUserQueryView> managedAgencies;
    
    /**
     * Type d'utilisateur
     */
    @JsonProperty("userType")
    private String userType;

    /**
     * Constructeur principal de la classe GenericUser
     */
    public GenericUser() {
    }

    /**
     * @return l'identifiant unique de l'utilisateur
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'utilisateur
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le login de l'utilisateur
     */
    @JsonGetter("login")
    public String getLogin() {
        return login;
    }

    /**
     * @param login définit le login de l'utilisateur
     */
    @JsonSetter("login")
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return le prénom de l'utilisateur
     */
    @JsonGetter("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName définit le prénom de l'utilisateur
     */
    @JsonSetter("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return le nom de l'utilisateur
     */
    @JsonGetter("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName définit le nom de l'utilisateur
     */
    @JsonSetter("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return le rôle de l'utilisateur
     */
    @JsonGetter("job")
    public String getJob() {
        return job;
    }

    /**
     * @param job définit le rôle de l'utilisateur
     */
    @JsonSetter("job")
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return le téléphone de l'utilisateur
     */
    @JsonGetter("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone définit le téléphone de l'utilisateur
     */
    @JsonSetter("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return l'état d'activité de l'utilisateur
     */
    @JsonGetter("isActive")
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive définit l'état d'activité de l'utilisateur
     */
    @JsonSetter("isActive")
    public void setisActive(boolean isActive) {
        this.isActive = isActive;
    }
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
        return this.getClass().getSimpleName()
                + ":{"
                + "uid:" + getUid()
                + ", login:" + getLogin()
                + ", firstName:" + getFirstName()
                + ", lastName:" + getLastName()
                + ", job:" + getJob()
                + ", phone:" + getPhone()
                + ", isActive:" + getIsActive()
                + ", company:" + getCompany()
                + ", managedAgencies:" + getManagedAgencies()
                + ", userType:" + getUserType()
                + "}";
    }

    
}
