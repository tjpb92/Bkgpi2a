package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Classe abstraite décrivant une raison d'affectation d'un intervenant à un
 * ticket.
 *
 * @author Thierry Baribaud
 * @version October 2016
 * @see http://performanceimmo.github.io/API/#providerassignationpurpose
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "providerAssignationPurposeType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = RecourseChanged.class, name = "RecourseChanged"),
    @JsonSubTypes.Type(value = Purpose.class, name = "Purpose")})
public abstract class ProviderAssignationPurpose {

    /**
     * Type d'affectation d'un intervenant à un ticket
     */
    private String providerAssignationPurposeType;

    /**
     * Constructeur principal de la classe ProviderAssignationPurpose
     */
    public ProviderAssignationPurpose() {
    }

    /**
     * @return le type d'affectation d'un intervenant à un ticket
     */
    public String getProviderAssignationPurposeType() {
        return providerAssignationPurposeType;
    }

    /**
     * @param providerAssignationPurposeType définit le type d'affectation d'un
     * intervenant à un ticketr
     */
    public void setProviderAssignationPurposeType(String providerAssignationPurposeType) {
        this.providerAssignationPurposeType = providerAssignationPurposeType;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderAssignationPurpose:{"
                + "providerAssignationPurposeType:" + getProviderAssignationPurposeType()
                + "}";
    }
}
