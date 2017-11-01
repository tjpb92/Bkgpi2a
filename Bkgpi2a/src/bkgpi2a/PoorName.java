package bkgpi2a;

import static bkgpi2a.NameType.POOR_NAME;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un nom non qualifié (pauvre)
 *
 * @author Thierry Baribaud
 * @version 0.47
 */
@JsonTypeName("PoorName")
public class PoorName extends Name {

    /**
     * Nom
     */
    private String value;

    /**
     * Constructeur principal de la classe PoorName
     */
    public PoorName() {
        setNameType(POOR_NAME.getName());
    }

    /**
     * @return le nom
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value définit le nom
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "PoorName:{"
                + super.toString()
                + ", value:" + getValue()
                + "}";
    }
}
