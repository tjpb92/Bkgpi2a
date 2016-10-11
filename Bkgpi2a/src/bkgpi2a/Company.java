package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

/**
 * Classe décrivant une compagnie
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonPropertyOrder({"_links", "companyType", "isActive", "label", "uid"})
@JsonIgnoreProperties({"linksList", "active"})
public class Company {
    
    /**
     * Liens vers d'autres entités.
     */
    @JsonProperty("_links")
    private List<Link> LinksList;
    
    /**
     * Définit le type de compagnie (utiliser une enum plus tard) :
     * <UL>
     * <LI>CallCenter</LI>
     * <LI>ClientAccount</LI>
     * <LI>ClientAccountHolding</LI>
     * </UL>
     */
    private String CompanyType;
    
    /**
     * Indique si la compagnie est active ou pas.
     */
    @JsonProperty("isActive")
    private boolean Active;
    
    /**
     * Nom de la compagnie.
     */
    private String Label;
    
    /**
     * Identifiant unique de la compagnie.
     */
    private String Uid;

    /**
     * Constructeur principal de la classe Company.
     * @param MyLinks liens vers d'autres entités.
     * @param MyCompanyType le type de compagnie.
     * @param MyActive l'état d'activité de la compagnie.
     * @param MyLabel le nom de la compagnie.
     * @param MyUid l'indentifiant unique de la comapgnie.
     */
    @JsonCreator
    public Company(
            @JsonProperty("_links") List<Link> MyLinks, 
            @JsonProperty("companyType") String MyCompanyType, 
            @JsonProperty("isActive") boolean MyActive, 
            @JsonProperty("label") String MyLabel, 
            @JsonProperty("uid") String MyUid) {
        this.LinksList = MyLinks;
        this.CompanyType = MyCompanyType;
        this.Active = MyActive;
        this.Label = MyLabel;
        this.Uid = MyUid;
    }
    
    /**
     * @return les liens vers les autres entités.
     */
    public List<Link> getLinksList() {
        return LinksList;
    }
    
    /**
     * @param MyLinks définit les liens vers les autres entités.
     */
    public void setLinksList(List<Link> MyLinks) {
        this.LinksList = MyLinks;
    }
    
    /**
     * @return le type de la compagnie.
     */
    public String getCompanyType() {
        return CompanyType;
    }

    /**
     * @param MyCompanyType définit le type de la compagnie.
     */
    public void setCompanyType(String MyCompanyType) {
        this.CompanyType = MyCompanyType;
    }

    /**
     * @return l'état d'activité de la compagnie.
     */
    public boolean getActive() {
        return Active;
    }

    /**
     * @param MyActive définit l'état d'activité de la compagnie.
     */
    public void setActive(boolean MyActive) {
        this.Active = MyActive;
    }

    /**
     * @return le nom de la compagnie.
     */
    public String getLabel() {
        return Label;
    }

    /**
     * @param MyLabel définit le nom de la compagnie.
     */
    public void setLabel(String MyLabel) {
        this.Label = MyLabel;
    }

    /**
     * @return l'identifiant unique de la compagnie.
     */
    public String getUid() {
        return Uid;
    }

    /**
     * @param MyUid définit l'identifiant unique de la compagnie.
     */
    public void setUid(String MyUid) {
        this.Uid = MyUid;
    }
    
    /**
     * @return les informations sur la compagnie.
     */
    @Override
    public String toString() {
        return(this.getClass().getName() + 
                ":{_link:" + getLinksList() + 
                ", companyType:" + getCompanyType() + 
                ", isActive:" + getActive() + 
                ", label:"+ getLabel() + 
                ", uid:"+ getUid() + 
                "}");
    }
}
