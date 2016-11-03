package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe définissant les informations d'un ticket
 *
 * @author Thierry Baribaud
 * @version 0.21
 * @see http://performanceimmo.github.io/API/#ticketinfos
 */
public class TicketInfos {

    /**
     * Appelant
     */
    private Caller caller;

    /**
     * Personne à rappeler
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContactToCallback contactToCallback;

    /**
     * Numéro de ticket
     */
    private ClaimNumber claimNumber;

    /**
     * Adresse du lieu d'intervention
     */
    private BasicAddress address;

    /**
     * Desciption du problème
     */
    private String request;

    /**
     * Instruction sur l'incident
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String instructions;

    /**
     * Raison de l'appel
     */
    private String callPurposeLabel;

    /**
     * Raisons d'appel alternatives ATTENTION : à implémenter sous forme de
     * Map[String, Array[String]]
     */
    private Map<String, String[]> altCallPurpose;

    /**
     * Données additionnelles
     */
    private Map<String, String> additionalData;

    /**
     * Constructeur de la classe TicketInfos
     */
    public TicketInfos() {
        additionalData = new HashMap<>();
        altCallPurpose = new HashMap<>();
    }

    /**
     * @return le nom de l'appelant
     */
    public Caller getCaller() {
        return caller;
    }

    /**
     * @param caller définit le nom de l'appelant
     */
    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    /**
     * @return le nom du contact à rappeler
     */
    public ContactToCallback getContactToCallback() {
        return contactToCallback;
    }

    /**
     * @param contactToCallback définit le nom du contact à rappeler
     */
    public void setContactToCallback(ContactToCallback contactToCallback) {
        this.contactToCallback = contactToCallback;
    }

    /**
     * @return le numéro de ticket
     */
    public ClaimNumber getClaimNumber() {
        return claimNumber;
    }

    /**
     * @param claimNumber définit le numéro de ticket
     */
    public void setClaimNumber(ClaimNumber claimNumber) {
        this.claimNumber = claimNumber;
    }

    /**
     * @return l'adresse du lieu d'intervention
     */
    public BasicAddress getAddress() {
        return address;
    }

    /**
     * @param address définit l'adresse du lieu d'intervention
     */
    public void setAddress(BasicAddress address) {
        this.address = address;
    }

    /**
     * @return la requête de l'appelant
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request définit la requête de l'appelant
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * @return les instructions sur l'appel
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * @param instructions définit les instructions sur l'appel
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * @return la raison de l'appel
     */
    public String getCallPurposeLabel() {
        return callPurposeLabel;
    }

    /**
     * @param callPurposeLabel définit la raison de l'appel
     */
    public void setCallPurposeLabel(String callPurposeLabel) {
        this.callPurposeLabel = callPurposeLabel;
    }

    /**
     * @return les raisons d'appel alternatives
     */
    public Map<String, String[]> getAltCallPurpose() {
        return altCallPurpose;
    }

    /**
     * @param altCallPurpose définit les raisons d'appel alternatives
     */
    public void setAltCallPurpose(Map<String, String[]> altCallPurpose) {
        this.altCallPurpose = altCallPurpose;
    }

    /**
     * @return les données additionnelles
     */
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    /**
     * @param additionalData définit les données additionnelles
     */
    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    /**
     * Ajoute une donnée complémentaire à la liste
     *
     * @param key clef pour indexer la valeur
     * @param value valeur à indexer
     */
    public void put(String key, String value) {
        this.additionalData.put(key, value);
    }

    /**
     * Ajoute une raisons d'appel alternative à la liste
     *
     * @param key clef pour indexer la valeur
     * @param value tableau de valeurs à indexer
     */
    public void put(String key, String[] value) {
        this.altCallPurpose.put(key, value);
    }

    /**
     * @return Retourne l'adresse sous forme textuelle
     */
    @Override
    public String toString() {
        return "TicketInfo:{"
                + "caller:" + getCaller()
                + ", contactToCallback:" + getContactToCallback()
                + ", claimNumber:" + getClaimNumber()
                + ", address:" + getAddress()
                + ", request:" + getRequest()
                + ", instructions:" + getInstructions()
                + ", callPurposeLabel:" + getCallPurposeLabel()
                + ", altCallPurpose:" + getAltCallPurpose()
                + ", additionalData:" + getAdditionalData()
                + "}";
    }
}
