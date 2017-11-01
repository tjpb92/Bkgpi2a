package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Classe décrivant une vue réduite d'un patrimoine
 *
 * @author Thierry Baribaud
 * @version 0.47
 */
public class PatrimonyUserQueryView {

    /**
     * Identifiant unique du patrimoine
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Nom du patrimoine
     */
    @JsonProperty("label")
    private String label;

    /**
     * Référence du patrimoine
     */
    @JsonProperty("ref")
    private String ref;

    /**
     * Constructeur principal de la classe
     *
     * @param uid Identifiant unique du patrimoine
     * @param label Nom du patrimoine
     * @param ref Référence du patrimoine
     */
    @JsonCreator
    public PatrimonyUserQueryView(
            @JsonProperty("uid") String uid, 
                        @JsonProperty("label") String label,
            @JsonProperty("ref") String ref) {
        this.uid = uid;
        this.label = label;
        this.ref = ref;
    }

    /**
     * @return l'identifiant unique du patrimoine
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique du patrimoine
     */
    @JsonSetter("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom du patrimoine
     */
    @JsonGetter("label")
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom du patrimoine
     */
    @JsonSetter("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return la référence du patrimoine
     */
    @JsonGetter("ref")
    public String getRef() {
        return ref;
    }

    /**
     * @param ref définit la référence du patrimoine
     */
    @JsonSetter("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return les informations sur le patrimoine.
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", label:" + getLabel()
                + ", ref:" + getRef()
                + "}");
    }
}
