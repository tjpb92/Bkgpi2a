package bkgpi2a;

/**
 * Classe décrivant deux représentations possibles de numéros d'appel
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#claimnumber
 */
public class ClaimNumber {

    /**
     * Numéro de ticket du centre d'appel (optionnel)
     */
    private String callCenterClaimNumber;

    /**
     * Numéro de ticket du client (optionnel)
     */
    private String clientClaimNumber;

    /**
     * @return le numéro de ticket du centre d'appel
     */
    public String getCallCenterClaimNumber() {
        return callCenterClaimNumber;
    }

    /**
     * @param callCenterClaimNumber définit le numéro de ticket du centre
     * d'appel
     */
    public void setCallCenterClaimNumber(String callCenterClaimNumber) {
        this.callCenterClaimNumber = callCenterClaimNumber;
    }

    /**
     * @return le numéro de ticket du client
     */
    public String getClientClaimNumber() {
        return clientClaimNumber;
    }

    /**
     * @param clientClaimNumber définit le numéro de ticket du client
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
