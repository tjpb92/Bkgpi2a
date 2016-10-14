package bkgpi2a;

/**
 * Classe décrivant une adresse 
 * -- AddressReference à terme, hérite de RationalAddress --
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class Address {
    
    private String uid;
    private String number;
    private String street;
    private String city;
    private String zipCode;
    private String country;
    private GeoLocation geoLocation;
    private Checker checker;
    private EntityAbstract building;

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
     * @return the geoLocation
     */
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    /**
     * @param geoLocation the geoLocation to set
     */
    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    /**
     * @return the checker
     */
    public Checker getChecker() {
        return checker;
    }

    /**
     * @param checker the checker to set
     */
    public void setChecker(Checker checker) {
        this.checker = checker;
    }
    

    /**
     * @return la référence à un building
     */
    public EntityAbstract getBuilding() {
        return building;
    }

    /**
     * @param building définit la référence à un building
     */
    public void setBuilding(EntityAbstract building) {
        this.building = building;
    }
    /**
     * @return Retourne l'adresse sous forme textuelle
     */
    @Override
    public String toString() {
        return(this.getClass().getSimpleName() + 
                ":{uid:" + getUid() + 
                ", number:" + getNumber() + 
                ", street:" + getStreet() + 
                ", city:" + getCity() + 
                ", zipCode:" + getZipCode() + 
                ", country:" + getCountry() + 
                ", geoLocation:" + getGeoLocation() + 
                ", checker:" + getChecker() + 
                ", building:" + getBuilding() + 
                "}");        
    }
}
