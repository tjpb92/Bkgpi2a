package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.List;

/**
 * Classe décrivant l'objet dans lequel est emballé un utilisateur dans un flux Json.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "user"})
@JsonIgnoreProperties({"links"})
public class UserWrapper {

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private List<Link> _links;
    
    /**
     * L'utilisateur dans son emballage Json
     */
    @JsonUnwrapped
    private GenericUser user;

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
     * @return un utilisateur
     */
    @JsonGetter("user")
    public GenericUser getUser() {
        return user;
    }

    /**
     * @param user définit un utilisateur
     */
    @JsonSetter("user")
    public void setUser(GenericUser user) {
        this.user = user;
    }
}
