package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.PROVIDER_ASSIGNED;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant l'affectation d'un intervenant à un ticket :
 * ProviderAssigned, #515
 *
 * @author Thierry Baribaud
 * @version 0.28
 * @see http://performanceimmo.github.io/API/#ticketevent
 */
@JsonIgnoreProperties({"_id", "eventTypeUid", "providerAssignationPurpose"})
@JsonTypeName("ProviderAssigned")
public class ProviderAssigned extends Event {

    /**
     * Opérateur ayant ajouté l'essai
     */
    private Operator operator;

    /**
     * Intervenant courant sur l'essai (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Provider provider;

    /**
     * Raison de l'affectation de l'intervenant au ticket
     */
    @JsonProperty("purpose")
    private ProviderAssignationPurpose providerAssignationPurpose;

    /**
     * Constructeur de la classe ProviderAssigned
     */
    public ProviderAssigned() {
        setEventTypeUid(PROVIDER_ASSIGNED.getUid());
        setEventType(PROVIDER_ASSIGNED.getName());
    }

    /**
     * @return l'opérateur ayant ajouté l'essai
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant ajouté l'essai
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return la raison de l'affectation de l'intervenant au ticket
     */
    @JsonGetter("purpose")
    public ProviderAssignationPurpose getProviderAssignationPurpose() {
        return providerAssignationPurpose;
    }

    /**
     * @param providerAssignationPurpose définit la raison de l'affectation de
     * l'intervenant au ticket
     */
    @JsonSetter("purpose")
    public void setProviderAssignationPurpose(ProviderAssignationPurpose providerAssignationPurpose) {
        this.providerAssignationPurpose = providerAssignationPurpose;
    }

    /**
     * @return l'intervenant courant si présent
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider définit l'intervenant courant
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ProviderAssigned:{"
                + super.toString()
                + ", " + getOperator()
                + ", " + getProvider()
                + ", providerAssignationPurpose:" + getProviderAssignationPurpose()
                + "}";
    }

}
