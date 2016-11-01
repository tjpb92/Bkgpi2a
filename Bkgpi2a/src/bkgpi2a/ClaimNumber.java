package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe d�crivant deux repr�sentations possibles de num�ros d'appel
 *
 * @author Thierry Baribaud
 * @version 0.19
 * @see http://performanceimmo.github.io/API/#claimnumber
 */
public class ClaimNumber {

    /**
     * Num�ro de ticket du centre d'appel (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String callCenterClaimNumber;

    /**
     * Num�ro de ticket du client (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String clientClaimNumber;

    /**
     * @return le num�ro de ticket du centre d'appel
     */
    public String getCallCenterClaimNumber() {
        return callCenterClaimNumber;
    }

    /**
     * @param callCenterClaimNumber d�finit le num�ro de ticket du centre
     * d'appel
     */
    public void setCallCenterClaimNumber(String callCenterClaimNumber) {
        this.callCenterClaimNumber = callCenterClaimNumber;
    }

    /**
     * @return le num�ro de ticket du client
     */
    public String getClientClaimNumber() {
        return clientClaimNumber;
    }

    /**
     * @param clientClaimNumber d�finit le num�ro de ticket du client
     */
    public void setClientClaimNumber(String clientClaimNumber) {
        this.clientClaimNumber = clientClaimNumber;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ClaimNumber:{"
                + "callCenterClaimNumber:" + getCallCenterClaimNumber()
                + ", clientClaimNumber:" + getClientClaimNumber()
                + "}";
    }
}
