package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe d�crivant un utilisateur simple
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "userType")
@JsonSubTypes({
    @Type(value = SuperUser.class, name = "superUser"),
    @Type(value = CallCenterUser.class, name = "callCenterUser"),
    @Type(value = ClientAccountManager.class, name = "clientAccountManager"),
    @Type(value = Executive.class, name = "executive")
})
public abstract class User {

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

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
     * Pr�nom de l'utilisateur
     */
    @JsonProperty("firstName")
    private String firstName;

    /**
     * Nom de l'utilisateur
     */
    @JsonProperty("lastName")
    private String lastName;

    /**
     * R�le de l'utilisateur
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("job")
    private String job;

    /**
     * T�l�phone de l'utilisateur
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("phone")
    private String phone;

    /**
     * Etat d'activit� de l'utilisateur
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("isActive")
    private boolean isActive;

    /**
     * Constructeur principal de la classe User
     */
    public User() {
    }

    /**
     * @return l'identifiant unique de l'utilisateur
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de l'utilisateur
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
     * @param login d�finit le login de l'utilisateur
     */
    @JsonSetter("login")
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return le pr�nom de l'utilisateur
     */
    @JsonGetter("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName d�finit le pr�nom de l'utilisateur
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
     * @param lastName d�finit le nom de l'utilisateur
     */
    @JsonSetter("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return le r�le de l'utilisateur
     */
    @JsonGetter("job")
    public String getJob() {
        return job;
    }

    /**
     * @param job d�finit le r�le de l'utilisateur
     */
    @JsonSetter("job")
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return le t�l�phone de l'utilisateur
     */
    @JsonGetter("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone d�finit le t�l�phone de l'utilisateur
     */
    @JsonSetter("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return l'�tat d'activit� de l'utilisateur
     */
    @JsonGetter("isActive")
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive d�finit l'�tat d'activit� de l'utilisateur
     */
    @JsonSetter("isActive")
    public void setisActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return la liste de liens entre entit�s
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links d�finit une liste de liens entre entit�s
     */
    @JsonSetter("_links")
    public void setLinks(Links _links) {
        this._links = _links;
    }

    /**
     * Ajoute un lien � la liste
     *
     * @param link lien � ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "User:{_links:" + getLinks()
                + ", uid:" + getUid()
                + ", login:" + getLogin()
                + ", firstName:" + getFirstName()
                + ", lastName:" + getLastName()
                + ", job:" + getJob()
                + ", phone:" + getPhone()
                + ", isActive:" + getIsActive()
                + "}";
    }
}
