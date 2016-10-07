package pi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un utilisateur basique
 *
 * @author Thierry Baribaud
 */
public class BasicUser {

    /**
     * Identifiant unique de l'utilisateur basique
     */
    private String uid;

    /**
     * Login de l'utilisateur basique
     */
    private String login;

    /**
     * Prénom de l'utilisateur basique
     */
    private String firstName;

    /**
     * Nom de l'utilisateur basique
     */
    private String lastName;

    /**
     * Rôle de l'utilisateur basique
     */
    @JsonInclude(Include.NON_NULL)
    private String job;

    /**
     * Téléphone de l'utilisateur basique
     */
    @JsonInclude(Include.NON_NULL)
    private String phone;

    /**
     * @return l'identifiant unique de l'utilisateur basique
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'utilisateur basique
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
     * @param login définit le login de l'utilisateur basique
     */
    @JsonSetter("login")
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return le prénom de l'utilisateur basique
     */
    @JsonGetter("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName définit le prénom de l'utilisateur basique
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
     * @param lastName définit le nom de l'utilisateur basique
     */
    @JsonSetter("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return le rôle de l'utilisateur basique
     */
    @JsonGetter("job")
    public String getJob() {
        return job;
    }

    /**
     * @param job définit le rôle de l'utilisateur basique
     */
    @JsonSetter("job")
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return le téléphone de de l'utilisateur basique
     */
    @JsonGetter("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone définit le téléphone de l'utilisateur basique
     */
    @JsonSetter("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
