package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant une localisation
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#locationreference
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "locationReferenceType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = AgencyLocation.class, name = "AgencyLocation"),
    @JsonSubTypes.Type(value = PatrimonyLocation.class, name = "PatrimonyLocation")
})
public abstract class LocationReference {

    /**
     * Type de localisation
     */
    private String locationReferenceType;

    /**
     * Constructeur principal de la classe LocationReference
     */
    public LocationReference() {
    }

    /**
     * @return le type de localisation
     */
    public String getLocationReferenceType() {
        return locationReferenceType;
    }

    /**
     * @param locationReferenceType définit le type de localisation
     */
    public void setLocationReferenceType(String locationReferenceType) {
        this.locationReferenceType = locationReferenceType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "LocationReference:{"
                + "locationReferenceType:" + getLocationReferenceType()
                + "}";
    }
}
