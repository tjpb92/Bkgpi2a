package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant un utilisateur basique
 *
 * @author Thierry Baribaud
 */
public class BasicUser {

    /**
     * Identifiant unique de l'utilisateur basique
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Login de l'utilisateur basique
     */
    @JsonProperty("login")
    private String login;

    /**
     * Pr�nom de l'utilisateur basique
     */
    @JsonProperty("firstName")
    private String firstName;

    /**
     * Nom de l'utilisateur basique
     */
    @JsonProperty("lastName")
    private String lastName;

    /**
     * R�le de l'utilisateur basique
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("job")
    private String job;

    /**
     * T�l�phone de l'utilisateur basique
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("phone")
    private String phone;

    /**
     * Constructeur principal de la classe BasicUser
     */
    public BasicUser() {
    }

    /**
     * @return l'identifiant unique de l'utilisateur basique
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de l'utilisateur basique
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le login de l'utilisateur basique
     */
    @JsonGetter("login")
    public String getLogin() {
        return login;
    }

    /**
     * @param login d�finit le login de l'utilisateur basique
     */
    @JsonSetter("login")
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return le pr�nom de l'utilisateur basique
     */
    @JsonGetter("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName d�finit le pr�nom de l'utilisateur basique
     */
    @JsonSetter("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return le nom de l'utilisateur basique
     */
    @JsonGetter("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName d�finit le nom de l'utilisateur basique
     */
    @JsonSetter("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return le r�le de l'utilisateur basique
     */
    @JsonGetter("job")
    public String getJob() {
        return job;
    }

    /**
     * @param job d�finit le r�le de l'utilisateur basique
     */
    @JsonSetter("job")
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return le t�l�phone de de l'utilisateur basique
     */
    @JsonGetter("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone d�finit le t�l�phone de l'utilisateur basique
     */
    @JsonSetter("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", login:" + getLogin()
                + ", firstName:" + getFirstName()
                + ", lastName:" + getLastName()
                + ", job:" + getJob()
                + ", phone:" + getPhone()
                + "}");
    }
}
