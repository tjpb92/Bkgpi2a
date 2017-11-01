package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe d�crivant une soci�t� (company). Remplace la classe Company.
 *
 * @author Thierry Baribaud
 * @version 0.47
 * @see http://performanceimmo.github.io/API/#clientcompanies
 */
@JsonIgnoreProperties({"_id"})
public class ClientCompany {

    /**
     * Liens entre entit�s
     */
    @JsonProperty("_links")
    private Links _links;

    /**
     * Identifiant unique de la soci�t�
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Identifiant unique de la soci�t� dans la base de donn�es Anstel
     */
    @JsonIgnore
    private int id;

    /**
     * Nom de la soci�t�
     */
    @JsonProperty("label")
    private String label;

    /**
     * Type de soci�t�
     */
    private String companyType;

    /**
     * Num�ro de Siret de la soci�t�
     */
    private String siretNumber;

    /**
     * Type de facturation de la soci�t� A impl�menter ult�rieurement : data
     * CompanyBillingType = SponsoredAccount | PremiumAccount | StandardAccount
     */
    private String billingType;

    /**
     * Etat d'activit� de la soci�t�
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
     * @return l'identifiant unique de la soci�t�
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid d�finit l'identifiant unique de la soci�t�
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le label de la soci�t�
     */
    @JsonGetter("login")
    public String getLabel() {
        return label;
    }

    /**
     * @param label d�finit le nom de la soci�t�
     */
    @JsonSetter("login")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return l'�tat d'activit� de la soci�t�
     */
    @JsonGetter("isActive")
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive d�finit l'�tat d'activit� de la soci�t�
     */
    @JsonSetter("isActive")
    public void setisActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return le type de soci�t�
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType d�finit le type de soci�t�
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * @return le num�ro de Siret de la soci�t�.
     */
    public String getSiretNumber() {
        return siretNumber;
    }

    /**
     * @param siretNumber d�finit le num�ro de Siret de la soci�t�.
     */
    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    /**
     * @return le type de facturation de la soci�t�.
     */
    public String getBillingType() {
        return billingType;
    }

    /**
     * @param billingType d�finit le type de facturation de la soci�t�.
     */
    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    /**
     * @return la liste de liens entre entit�s
     */
    @JsonGetter("_links")
    public Links getLinks() {
        return _links;
    }

    /**
     * @param _links d�finit une liste de liens entre entit�s
     */
    @JsonSetter("_links")
    public void setLinks(Links _links) {
        this._links = _links;
    }

    /**
     * Ajoute un lien � la liste
     *
     * @param link lien � ajouter
     */
    public void add(Link link) {
        _links.add(link);
    }

    /**
     * @return l'identifiant unique de la base de donn�es Anstel
     */
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * @param id d�finit l'identifiant unique de la base de donn�es Anstel
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
