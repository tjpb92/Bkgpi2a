package bkgpi2a;

import static bkgpi2a.NameType.POOR_NAME;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un nom non qualifié (pauvre)
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("PoorName")
public class PoorName extends Name {

    /**
     * Nom
     */
    private String name;

    /**
     * Constructeur principal de la classe PoorName
     */
    public PoorName() {
        setNameType(POOR_NAME.getName());
    }

    /**
     * @return le nom
     */
    public String getName() {
        return name;
    }

    /**
     * @param name définit le nom
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "PoorName:{"
                + super.toString()
                + ", name:" + getName()
                + "}";
    }
}
