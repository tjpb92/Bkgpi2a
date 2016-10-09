package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.List;

/**
 * Classe décrivant l'objet dans lequel est emballé un utilisateur dans un flux
 * Json.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"user", "_links"})
@JsonIgnoreProperties({"links"})
public class UserWrapper {

    /**
     * l'utilisateur
     */
    @JsonUnwrapped
    @JsonProperty("user")
    private User user;

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private List<Link> _links;

    /**
     * @return un utilisateur
     */
    @JsonGetter("user")
    public User getUser() {
        return user;
    }

    /**
     * @param user définit un utilisateur
     */
    @JsonSetter("user")
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return des liens
     */
    @JsonGetter("_links")
    public List<Link> getLinks() {
        return _links;
    }

    /**
     * @param _links définit des liens
     */
    @JsonSetter("_links")
    public void setLinks(List<Link> _links) {
        this._links = _links;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{"
                + "user:" + getUser()
                + ", _links:" + getLinks()
                + "}");
    }
}
