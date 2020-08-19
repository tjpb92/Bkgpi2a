package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant le résumé d'une entité : son id et son nom.
 *
 * @author Thierry Baribaud
 * @version 1.37
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("EntityAbstract")
public class EntityAbstract {

    /**
     * Identifiant unique de l'entité
     */
    private String uid;

    /**
     * Nom de l'entité (ancienne version)
     */
    private String label;

//    /**
//     * Nom de l'entité (nouvelle version)
//     */
//    private String name;

//    /**
//     * Constructeur principal de la classe
//     *
//     * @param uid Identifiant unique de l'entité
//     * @param label Nom de l'entité
//     */
//    @JsonCreator
//    public EntityAbstract(
//            @JsonProperty("uid") String uid,
//            @JsonProperty("label") String label) {
//        this.uid = uid;
//        this.label = label;
//    }
    /**
     * @return l'identifiant unique de l'entité
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique de l'entité
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le nom de l'entité (ancienne version)
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label définit le nom de l'entité (ancienne version)
     */
    public void setLabel(String label) {
        this.label = label;
    }

//    /**
//     * @return le nom de l'entité (nouvelle version)
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * @param name définit le nom de l'entité (nouvelle version)
//     */
//    public void setName(String name) {
//        this.name = name;
//    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return (this.getClass().getName()
                + ":{uid:" + getUid()
                + ", label:" + getLabel()
//                + ", name:" + getName()
                + "}");
    }
}
