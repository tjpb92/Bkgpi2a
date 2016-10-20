package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe définissant un lien entre entités.
 *
 * @version Octobre 2016
 * @author Thierry Baribaud
 */
//@JsonPropertyOrder({"href", "method", "rel"})
public class Link {

    /**
     * Référence du lien
     */
    private String Href;

    /**
     * Méthode d'interrogation
     */
    private String Method;

    /**
     * Lien relatif
     */
    private String Rel;

    /**
     * Constructeur principal de la classe Link.
     *
     * @param MyHref Référence du lien
     * @param MyMethod Méthode d'interrogation
     * @param MyRel Lien relatif
     */
    @JsonCreator
    public Link(
            @JsonProperty("href") String MyHref,
            @JsonProperty("method") String MyMethod,
            @JsonProperty("rel") String MyRel) {
        this.Href = MyHref;
        this.Method = MyMethod;
        this.Rel = MyRel;
    }

    /**
     * @return la référence au lien
     */
    public String getHref() {
        return Href;
    }

    /**
     * @param href définit la référence au lien
     */
    public void setHref(String href) {
        this.Href = href;
    }

    /**
     * @return la méthode d'interrogation
     */
    public String getMethod() {
        return Method;
    }

    /**
     * @param method définit la méthode d'interrogation
     */
    public void setMethod(String method) {
        this.Method = method;
    }

    /**
     * @return le lien relatif
     */
    public String getRel() {
        return Rel;
    }

    /**
     * @param rel définit le lien relatif
     */
    public void setRel(String rel) {
        this.Rel = rel;
    }

    /**
     * @return le lien sous forme textuelle
     */
    @Override
    public String toString() {
        return "Link:{href:" + getHref()
                + ", method:" + getMethod()
                + ", rel:" + getRel()
                + "}";
    }
}
