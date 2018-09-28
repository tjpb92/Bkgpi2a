package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant une adresse basique
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/#basicaddress
 */
public class BasicAddress {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String quality;

    /**
     * La voie
     */
    private String street;

    /**
     * Le compl�ment d'adresse
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String complement;

    /**
     * La ville
     */
    private String city;

    /**
     * Le code postal
     */
    private String zipCode;

    /**
     * L'�tat
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String state;

    /**
     * Le pays
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country;

    /**
     * @return the quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * recipientSupplement
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RecipientIdentificationSupplement recipientSupplement;

    /**
     * geographicalSupplement
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GeographicalIdentificationSupplement geographicalSupplement;

    /**
     * @return la voie
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street d�finit la voie
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return la ville
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city d�finit la ville
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return le code postal
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode d�finit le code postal
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return le pays
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country d�finit le pays
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return le compl�ment d'adresse
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @param complement d�finit le compl�ment d'adresse
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * Get the value of recipientSupplement
     *
     * @return the value of recipientSupplement
     */
    public RecipientIdentificationSupplement getRecipientSupplement() {
        return recipientSupplement;
    }

    /**
     * Set the value of recipientSupplement
     *
     * @param recipientSupplement new value of recipientSupplement
     */
    public void setRecipientSupplement(RecipientIdentificationSupplement recipientSupplement) {
        this.recipientSupplement = recipientSupplement;
    }

    /**
     * Get the value of geographicalSupplement
     *
     * @return the value of geographicalSupplement
     */
    public GeographicalIdentificationSupplement getGeographicalSupplement() {
        return geographicalSupplement;
    }

    /**
     * Set the value of geographicalSupplement
     *
     * @param geographicalSupplement new value of geographicalSupplement
     */
    public void setGeographicalSupplement(GeographicalIdentificationSupplement geographicalSupplement) {
        this.geographicalSupplement = geographicalSupplement;
    }

    /**
     * @return l'�tat
     */
    public String getState() {
        return state;
    }

    /**
     * @param state d�finit l'�tat
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return Retourne l'adresse sous forme textuelle
     */
    @Override
    public String toString() {
        return "BasicAddress:{"
                + "quality:" + getQuality()
                + ", street:" + getStreet()
                + ", complement:" + getComplement()
                + ", recipientSupplement:" + getRecipientSupplement()
                + ", geographicalSupplement:" + getGeographicalSupplement()
                + ", zipCode:" + getZipCode()
                + ", city:" + getCity()
                + ", state:" + getState()
                + ", country:" + getCountry()
                + "}";
    }

}
