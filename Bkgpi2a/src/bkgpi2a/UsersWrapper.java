package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 * Classe d�crivant l'objet dans lequel est emball� une liste d'utilisateurs dans un flux Json.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"result", "_links"})
@JsonIgnoreProperties({"links", "usersWrapper"})
public class UsersWrapper {

    /**
     * La liste des utilisateurs dans leur emballage Json
     */
//    @JsonUnwrapped
    @JsonProperty("result")
    private List<UserWrapper> result;

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private List<Link> _links;
    
    /**
     * @return un utilisateur dans son emballage Json
     */
    @JsonGetter("result")
    public List<UserWrapper> getUsersWrapper() {
        return result;
    }

    /**
     * @param usersWrapper d�finit un utilisateur dans son emballage Json
     */
    @JsonSetter("result")
    public void setUsersWrapper(List<UserWrapper> usersWrapper) {
        this.result = usersWrapper;
    }

    /**
     * @return des liens
     */
    @JsonGetter
    public List<Link> getLinks() {
        return _links;
    }

    /**
     * @param _links d�finit des liens
     */
    @JsonSetter
    public void setLinks(List<Link> _links) {
        this._links = _links;
    }

}
