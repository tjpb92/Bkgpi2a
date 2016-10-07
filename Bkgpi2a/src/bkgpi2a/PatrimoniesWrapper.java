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
public class PatrimoniesWrapper {

    @JsonProperty("_links")
    private List<Link> _links;
    
//    @JsonUnwrapped
    @JsonProperty("result")
    private List<PatrimonyWrapper> result;

    /**
     * @return the _links
     */
    @JsonGetter
    public List<Link> getLinks() {
        return _links;
    }

    /**
     * @param _links the _links to set
     */
    @JsonSetter
    public void setLinks(List<Link> _links) {
        this._links = _links;
    }

    /**
     * @return the patrimoniesWrapper
     */
    @JsonGetter
    public List<PatrimonyWrapper> getPatrimoniesWrapper() {
        return result;
    }

    /**
     * @param patrimoniesWrapper the PatrimoniesWrapper to set
     */
    @JsonSetter
    public void setPatrimoniesWrapper(List<PatrimonyWrapper> patrimoniesWrapper) {
        this.result = patrimoniesWrapper;
    }
}
