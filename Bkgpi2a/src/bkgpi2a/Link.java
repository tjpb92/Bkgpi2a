package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe d�finissant un lien entre entit�s.
 * @version Octobre 2016
 * @author Thierry Baribaud
 */
//@JsonPropertyOrder({"href", "method", "rel"})
public class Link {
    
    /**
     * R�f�rence du lien
     */
    private String Href;
    
    /**
     * M�thode d'interrogation
     */
    private String Method;
    
    /**
     * Lien relatif
     */
    private String Rel;

    /**
     * Constructeur principal de la classe Link.
     * 
     * @param MyHref R�f�rence du lien
     * @param MyMethod M�thode d'interrogation
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
     * @return la r�f�rence au lien
     */
    public String getHref() {
        return Href;
    }

    /**
     * @param href d�finit la r�f�rence au lien
     */
    public void setHref(String href) {
        this.Href = href;
    }

    /**
     * @return la m�thode d'interrogation
     */
    public String getMethod() {
        return Method;
    }

    /**
     * @param method d�finit la m�thode d'interrogation
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
     * @param rel d�finit le lien relatif
     */
    public void setRel(String rel) {
        this.Rel = rel;
    }

    /**
     * @return le lien sous forme textuelle
     */
    @Override
    public String toString() {
        return(this.getClass().getName() + 
                ":{href:" + getHref() + 
                ", method:" + getMethod() + 
                ", rel:"+ getRel() + 
                "}");
    }
}
