package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant un container permettant le transfert des utilisateurs.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "result"})
public class UserContainer {

    /**
     * Liste de liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * liste des utilisateurs
     */
    @JsonProperty("result")
    private UserList userList;

    /**
     * Constructeur de la classe UserContainer
     */
    public UserContainer() {
        setUserList(new UserList());
    }

    /**
     * @return la liste de liens entre entités
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links définit la liste de liens entre entités
     */
    @JsonSetter("_links")
    public void setLinks(Links _links) {
        this._links = _links;
    }

    /**
     * @return la liste des utilisateurs
     */
    @JsonGetter("result")
    public UserList getUserList() {
        return userList;
    }

    /**
     * @param userList définit la liste des utilisateurs
     */
    @JsonSetter("result")
    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    /**
     * Ajoute un utilisateur à la liste
     *
     * @param user utilisateur à ajouter
     */
    public void add(User user) {
        userList.add(user);
    }

    /**
     * Ajoute un lien à la liste
     *
     * @param link lien à ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * Retourne le contenu d'un container
     *
     * @return le contenu d'un container
     */
    @Override
    public String toString() {
        return "UserContainer:{"
                + "_links:" + getLinks()
                + ", userList:" + getUserList()
                + "}";
    }
}
