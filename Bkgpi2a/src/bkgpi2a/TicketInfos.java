package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe définissant les informations d'un ticket
 *
 * @author Thierry Baribaud
 * @version 0.20
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
    private RationalAddress address;
    
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
     * Raisons d'appel alternatives
     * ATTENTION : à implémenter sous forme de Map[String, Array[String]]
     */
    private Map<String, String[]> altCallPurpose;

    /**
     * Données additionnelles
     */
    private Map <String, String> additionalData;

    
    /**
     * Constructeur de la classe TicketInfos
     */
    public TicketInfos() {
        additionalData = new HashMap <>();
        altCallPurpose = new HashMap <>();
    }
    /**
     * @return the caller
     */
    public Caller getCaller() {
        return caller;
    }

    /**
     * @param caller the caller to set
     */
    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    /**
     * @return the contactToCallback
     */
    public ContactToCallback getContactToCallback() {
        return contactToCallback;
    }

    /**
     * @param contactToCallback the contactToCallback to set
     */
    public void setContactToCallback(ContactToCallback contactToCallback) {
        this.contactToCallback = contactToCallback;
    }

    /**
     * @return the claimNumber
     */
    public ClaimNumber getClaimNumber() {
        return claimNumber;
    }

    /**
     * @param claimNumber the claimNumber to set
     */
    public void setClaimNumber(ClaimNumber claimNumber) {
        this.claimNumber = claimNumber;
    }

    /**
     * @return the address
     */
    public RationalAddress getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(RationalAddress address) {
        this.address = address;
    }

    /**
     * @return the request
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * @return the instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * @param instructions the instructions to set
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * @return the callPurposeLabel
     */
    public String getCallPurposeLabel() {
        return callPurposeLabel;
    }

    /**
     * @param callPurposeLabel the callPurposeLabel to set
     */
    public void setCallPurposeLabel(String callPurposeLabel) {
        this.callPurposeLabel = callPurposeLabel;
    }

    /**
     * @return the altCallPurpose
     */
    public Map<String, String[]> getAltCallPurpose() {
        return altCallPurpose;
    }

    /**
     * @param altCallPurpose the altCallPurpose to set
     */
    public void setAltCallPurpose(Map<String, String[]> altCallPurpose) {
        this.altCallPurpose = altCallPurpose;
    }

    /**
     * @return the additionalData
     */
    public Map <String, String> getAdditionalData() {
        return additionalData;
    }

    /**
     * @param additionalData the additionalData to set
     */
    public void setAdditionalData(Map <String, String> additionalData) {
        this.additionalData = additionalData;
    }

    /**
     * Ajoute une donnée complémentaire à la liste
     * @param key clef pour indexer la valeur
     * @param value valeur à indexer
     */
    public void put(String key, String value) {
        this.additionalData.put(key, value);
    }

    /**
     * Ajoute une donnée complémentaire à la liste
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
