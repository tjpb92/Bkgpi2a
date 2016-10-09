package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 * Classe décrivant l'objet dans lequel est emballé une liste d'agences dans un flux Json.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "result"})
@JsonIgnoreProperties({"links", "AgencyWrapperList"})
public class AgencyWrapperListWrapper {

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private List<Link> _links;
    
    /**
     * La liste des agences dans leur emballage Json
     */
//    @JsonUnwrapped
    @JsonProperty("result")
    private List<AgencyWrapper> AgencyWrapperList;

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
     * @return une liste d'agences dans son emballage Json
     */
    @JsonGetter("result")
    public List<AgencyWrapper> getAgencyWrapperList() {
        return AgencyWrapperList;
    }

    /**
     * @param AgencyWrapperList définit une liste d'agences dans son emballage Json
     */
    @JsonSetter("result")
    public void setAgencyWrapperList(List<AgencyWrapper> AgencyWrapperList) {
        this.AgencyWrapperList = AgencyWrapperList;
    }
}
