package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.List;

/**
 * Classe d�crivant l'objet dans lequel est emball� un patrimoine dans un flux Json.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "patrimony"})
@JsonIgnoreProperties({"links"})
public class PatrimonyWrapper {

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private List<Link> _links;
    
    /**
     * Le patrimoinre dans son emballage Json
     */
    @JsonUnwrapped
    private Patrimony patrimony;

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
     * @return un patrimoine
     */
    public Patrimony getPatrimony() {
        return patrimony;
    }

    /**
     * @param patrimony d�finit un patrimoine
     */
    public void setPatrimony(Patrimony patrimony) {
        this.patrimony = patrimony;
    }
}
