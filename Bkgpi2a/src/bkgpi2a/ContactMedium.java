package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant un moyen de liaision
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "contactMediumType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Phone.class, name = "Phone"),
    @JsonSubTypes.Type(value = Sms.class, name = "Sms"),
    @JsonSubTypes.Type(value = Fax.class, name = "Fax"),
    @JsonSubTypes.Type(value = Mail.class, name = "Mail")
})
public abstract class ContactMedium {

    /**
     * Type de moyen de liaision
     */
    private String contactMediumType;

    /**
     * Constructeur principal de la classe Operator
     */
    public ContactMedium() {
    }

    /**
     * @return le type de moyen de liaision
     */
    public String getContactMediumType() {
        return contactMediumType;
    }

    /**
     * @param contactMediumType définit le type de moyen de liaision
     */
    public void setContactMediumType(String contactMediumType) {
        this.contactMediumType = contactMediumType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ContactMedium:{"
                + "contactMediumType:" + getContactMediumType()
                + "}";
    }
}
