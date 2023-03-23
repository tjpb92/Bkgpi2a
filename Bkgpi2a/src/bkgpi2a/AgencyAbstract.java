package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe décrivant le résumé d'une agence : son id et son nom.
 *
 * @author Thierry Baribaud
 * @version 1.40
 * @see
 * <A href="https://performanceimmo.github.io/API/#agencyabstract">AgencyAbstract</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyAbstract {

    /**
     * Identifiant unique de l'agence
     */
    private String uid;

    /**
     * Référence de l'agence (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ref;

    /**
     * Nom du agence
     */
    private String name;

    /**
     * @return la référence de l'agence
     */
    public String getRef() {
        return ref;
    }

    /**
     * @return l'identifiant unique de l'agence
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'agence
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @param ref définit la référence de l'agence
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return le nom de l'agence
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom de l'agence
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return ("AgencyAbstract:{"
                + "uid:" + getUid()
                + ", ref:" + getRef()
                + ", name:" + getName()
                + "}");
    }
}
