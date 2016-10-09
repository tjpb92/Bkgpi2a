package bkgpi2a;

/**
 * Classe décrivant une adresse 
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class RationalAddress {
    
    private String uid;
    // private String quality; A IMPLEMENTER
    private String number;
    private String street;
    private String complement;
    private String city;
    private String zipCode;
    // private String state; A IMPLEMENTER
    private String country;

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return le complement d'adresse
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @param complement définit le complement d'adresse
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }
    
    /**
     * @return Retourne l'adresse sous forme textuelle
     */
    @Override
    public String toString() {
        return(this.getClass().getName() + 
                ":{uid:" + getUid() + 
                ", number:" + getNumber() + 
                ", street:" + getStreet() + 
                ", complement:" + getComplement() + 
                ", city:" + getCity() + 
                ", zipCode:" + getZipCode() + 
                ", country:" + getCountry() + 
                "}");        
    }

}
