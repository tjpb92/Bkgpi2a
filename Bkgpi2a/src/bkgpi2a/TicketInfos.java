package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe d�finissant les informations d'un ticket
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
     * Personne � rappeler
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContactToCallback contactToCallback;

    /**
     * Num�ro de ticket
     */
    private ClaimNumber claimNumber;

    /**
     * Adresse du lieu d'intervention
     */
    private BasicAddress address;

    /**
     * Desciption du probl�me
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
     * Raisons d'appel alternatives ATTENTION : � impl�menter sous forme de
     * Map[String, Array[String]]
     */
    private Map<String, String[]> altCallPurpose;

    /**
     * Donn�es additionnelles
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
     * @param caller d�finit le nom de l'appelant
     */
    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    /**
     * @return le nom du contact � rappeler
     */
    public ContactToCallback getContactToCallback() {
        return contactToCallback;
    }

    /**
     * @param contactToCallback d�finit le nom du contact � rappeler
     */
    public void setContactToCallback(ContactToCallback contactToCallback) {
        this.contactToCallback = contactToCallback;
    }

    /**
     * @return le num�ro de ticket
     */
    public ClaimNumber getClaimNumber() {
        return claimNumber;
    }

    /**
     * @param claimNumber d�finit le num�ro de ticket
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
     * @param address d�finit l'adresse du lieu d'intervention
     */
    public void setAddress(BasicAddress address) {
        this.address = address;
    }

    /**
     * @return la requ�te de l'appelant
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request d�finit la requ�te de l'appelant
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
     * @param instructions d�finit les instructions sur l'appel
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
     * @param callPurposeLabel d�finit la raison de l'appel
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
     * @param altCallPurpose d�finit les raisons d'appel alternatives
     */
    public void setAltCallPurpose(Map<String, String[]> altCallPurpose) {
        this.altCallPurpose = altCallPurpose;
    }

    /**
     * @return les donn�es additionnelles
     */
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    /**
     * @param additionalData d�finit les donn�es additionnelles
     */
    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    /**
     * Ajoute une donn�e compl�mentaire � la liste
     *
     * @param key clef pour indexer la valeur
     * @param value valeur � indexer
     */
    public void put(String key, String value) {
        this.additionalData.put(key, value);
    }

    /**
     * Ajoute une raisons d'appel alternative � la liste
     *
     * @param key clef pour indexer la valeur
     * @param value tableau de valeurs � indexer
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
