package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.List;

/**
 * Classe décrivant l'objet dans lequel est emballé une agence dans un flux Json.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "agency"})
@JsonIgnoreProperties({"links"})
public class AgencyWrapper {

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private List<Link> _links;
    
    /**
     * L'agence dans son emballage Json
     */
    @JsonUnwrapped
    private Agency agency;

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
     * @return une agence
     */
    @JsonGetter("agency")
    public Agency getAgency() {
        return agency;
    }

    /**
     * @param agency définit une agence
     */
    @JsonSetter("agency")
    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
