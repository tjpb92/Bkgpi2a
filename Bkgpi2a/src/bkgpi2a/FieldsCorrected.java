package bkgpi2a;

/**
 * Classe d�crivant les champs modifi�s d'un ticket
 *
 * @author Thierry Baribaud
 * @version 1.05
 * @see http://performanceimmo.github.io/API/#fieldstocorrect
 */
public class FieldsCorrected {

    /**
     * Nature de la demande
     */
    private String request;

    /**
     * Instructions sur le ticket
     */
    private String instructions;

    /**
     * Rapport d'intervention
     */
    private String closingReport;

    /**
     * @return la nature de la demande
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request D�finit la nature de la demande
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * @return les instructions sur le ticket
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * @param instructions d�finit les instructions sur le ticket
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * @return le rapport d'intervention
     */
    public String getClosingReport() {
        return closingReport;
    }

    /**
     * @param closingReport d�finit le rapport d'intervention
     */
    public void setClosingReport(String closingReport) {
        this.closingReport = closingReport;
    }

    /**
     * @return Retourne l'adresse sous forme textuelle
     */
    @Override
    public String toString() {
        return "FieldsCorrected:{"
                + "request:" + getRequest()
                + ", instructions:" + getInstructions()
                + ", closingReport:" + getClosingReport()
                + "}";
    }
}
