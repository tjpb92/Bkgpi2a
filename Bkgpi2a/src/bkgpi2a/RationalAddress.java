package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant une adresse rationnelle
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#addressforcommand
 */
public class RationalAddress {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String quality;
    
    /**
     * Le numéro de voie
     */
    private String number;
    
    /**
     * La voie
     */
    private String street;
    
    /**
     * Le complément d'adresse
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
     * L'état
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
     * @return le numéro de voie
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number définit le numéro de voie
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return la voie
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street définit la voie
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
     * @param city définit la ville
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
     * @param zipCode définit le code postal
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
     * @param country définit le pays
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return le complément d'adresse
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @param complement définit le complément d'adresse
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * @return l'état
     */
    public String getState() {
        return state;
    }

    /**
     * @param state définit l'état
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return Retourne l'adresse sous forme textuelle
     */
    @Override
    public String toString() {
        return "RationalAddress:{"
                + "quality:" + getQuality()
                + ", number:" + getNumber()
                + ", street:" + getStreet()
                + ", complement:" + getComplement()
                + ", zipCode:" + getZipCode()
                + ", city:" + getCity()
                + ", state:" + getState()
                + ", country:" + getCountry()
                + "}";
    }

}
