package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant une société (company). Remplace la classe Company.
 *
 * @author Thierry Baribaud
 * @version 0.47
 * @see http://performanceimmo.github.io/API/#clientcompanies
 */
@JsonIgnoreProperties({"_id"})
public class ClientCompany {

    /**
     * Liens entre entités
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Identifiant unique de la société
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Identifiant unique de la société dans la base de données Anstel
     */
    @JsonIgnore
    private int id;

    /**
     * Nom de la société
     */
    @JsonProperty("label")
    private String label;

    /**
     * Type de société
     */
    private String companyType;

    /**
     * Numéro de Siret de la société
     */
    private String siretNumber;

    /**
     * Type de facturation de la société A implémenter ultérieurement : data
     * CompanyBillingType = SponsoredAccount | PremiumAccount | StandardAccount
     */
    private String billingType;

    /**
     * Etat d'activité de la société
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("isActive")
    private boolean isActive;

    /**
     * Constructeur principal de la classe Company
     */
    public ClientCompany() {
    }

    /**
     * @return l'identifiant unique de la société
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de la société
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le label de la société
     */
    @JsonGetter("login")
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de la société
     */
    @JsonSetter("login")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return l'état d'activité de la société
     */
    @JsonGetter("isActive")
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive définit l'état d'activité de la société
     */
    @JsonSetter("isActive")
    public void setisActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return le type de société
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType définit le type de société
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * @return le numéro de Siret de la société.
     */
    public String getSiretNumber() {
        return siretNumber;
    }

    /**
     * @param siretNumber définit le numéro de Siret de la société.
     */
    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    /**
     * @return le type de facturation de la société.
     */
    public String getBillingType() {
        return billingType;
    }

    /**
     * @param billingType définit le type de facturation de la société.
     */
    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    /**
     * @return la liste de liens entre entités
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links définit une liste de liens entre entités
     */
    @JsonSetter("_links")
    public void setLinks(Links _links) {
        this._links = _links;
    }

    /**
     * Ajoute un lien à la liste
     *
     * @param link lien à ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * @return l'identifiant unique de la base de données Anstel
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * @param id définit l'identifiant unique de la base de données Anstel
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Company:{"
                + "id:" + getId()
                + ", _links:" + getLinks()
                + ", uid:" + getUid()
                + ", label:" + getLabel()
                + ", siretNumber" + getSiretNumber()
                + ", billingType" + getBillingType()
                + ", isActive:" + getIsActive()
                + ", companyType:" + getCompanyType()
                + "}";
    }
}
