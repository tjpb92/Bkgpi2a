package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.List;

/**
 * Classe d�crivant l'objet dans lequel est emball� une filiale dans un flux Json.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "subsidiary"})
@JsonIgnoreProperties({"links"})
public class SubsidiaryWrapper {

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private List<Link> _links;
    
    /**
     * La filiale dans son emballage Json
     */
    @JsonUnwrapped
    private Subsidiary subsidiary;

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

    /**
     * @return une filiale
     */
    public Subsidiary getSubsidiary() {
        return subsidiary;
    }

    /**
     * @param subsidiary d�finit une filiale
     */
    public void setSubsidiary(Subsidiary subsidiary) {
        this.subsidiary = subsidiary;
    }
}
