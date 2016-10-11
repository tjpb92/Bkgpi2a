package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * Classe d�crivant une liste de compagnies.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "result"})
@JsonIgnoreProperties({"linksList", "companiesList"})
public class Companies {
    
    /**
     * Liens vers d'autres entit�s.
     */
    @JsonProperty("_links")
    private List<Link> LinksList;
    
    /**
     * Liste de compagnies.
     */
    @JsonProperty("result")
    private List<Company> CompaniesList;
    
    /**
     * @return les liens vers les autres entit�s.
     */
    public List<Link> getLinksList() {
        return LinksList;
    }
    
    /**
     * @param MyLinks d�finit les liens vers les autres entit�s.
     */
    public void setLinksList(List<Link> MyLinks) {
        this.LinksList = MyLinks;
    }
    
    /**
     * @return la liste des compagnies.
     */
    public List<Company> getCompaniesList() {
        return CompaniesList;
    }
    
    /**
     * @param MyCompanies d�finit les liens vers les autres entit�s.
     */
    public void setCompaniesList(List<Company> MyCompanies) {
        this.CompaniesList = MyCompanies;
    }    
}
