package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static bkgpi2a.EventType.DOCUMENT_ATTACHED;

/**
 * Classe décrivant un document ajouté au ticket : DocumentAttached, #635
 *
 * @author Thierry Baribaud
 * @version 1.34
 * @see <A href="http://performanceimmo.github.io/API/...">DocumentAttached</A>
 */
//@JsonIgnoreProperties({"_id", "date", "eventTypeUid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("DocumentAttached")
public class DocumentAttached extends Event {

    /**
     * Opérateur ayant ajouté le document
     */
    private Operator operator;

    /**
     * Identifiant du document ajouté au ticket
     */
    private String documentUid;

    /**
     * Nom du fichier attaché au ticket
     */
    private String fileName;

    /**
     * Constructeur de la classe DocumentAttached
     */
    public DocumentAttached() {
        setEventTypeUid(DOCUMENT_ATTACHED.getUid());
        setEventType(DOCUMENT_ATTACHED.getName());
    }

    /**
     * @return l'opérateur ayant ajouté le document
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator définit l'opérateur ayant ajouté le document
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return l'identifiant du document ajouté au ticket
     */
    public String getDocumentUid() {
        return documentUid;
    }

    /**
     * @param documentUid définit l'identifiant du document ajouté au ticket
     */
    public void setDocumentUid(String documentUid) {
        this.documentUid = documentUid;
    }

    /**
     * @return le nom du fichier attaché au ticket
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName définit le nom du fichier attaché au ticket
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "DocumentAttached:{"
                + super.toString()
                + ", " + getOperator()
                + ", documentUid:" + getDocumentUid()
                + ", fileName:" + getFileName()
                + "}";
    }
}
