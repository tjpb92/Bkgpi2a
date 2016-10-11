package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 * Classe d�crivant l'objet dans lequel est emball� une liste de patrimoines dans un flux Json.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "result"})
@JsonIgnoreProperties({"links", "patrimoniesWrapper"})
public class PatrimonyWrapperListWrapper {

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private List<Link> _links;
    
    /**
     * La liste des patrimoines dans leur emballage Json
     */
//    @JsonUnwrapped
    @JsonProperty("result")
    private List<PatrimonyWrapper> result;

    /**
     * @return des liens
     */
    @JsonGetter("_links")
    public List<Link> getLinks() {
        return _links;
    }

    /**
     * @param _links d�finit des liens
     */
    @JsonSetter("_links")
    public void setLinks(List<Link> _links) {
        this._links = _links;
    }

    /**
     * @return un patrimoine dans son emballage Json
     */
    @JsonGetter("result")
    public List<PatrimonyWrapper> getPatrimoniesWrapper() {
        return result;
    }

    /**
     * @param patrimoniesWrapper d�finit un patrimoine dans son emballage Json
     */
    @JsonSetter("result")
    public void setPatrimoniesWrapper(List<PatrimonyWrapper> patrimoniesWrapper) {
        this.result = patrimoniesWrapper;
    }
}
