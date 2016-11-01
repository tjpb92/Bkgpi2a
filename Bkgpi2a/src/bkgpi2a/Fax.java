package bkgpi2a;

import static bkgpi2a.ContactMediumType.FAX;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un Fax
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
@JsonTypeName("Fax")
public class Fax extends ContactMedium {

    /**
     * Numéro de fax
     */
    private String fax;

    /**
     * Constructeur principal de la classe Fax
     */
    public Fax() {
        setContactMediumType(FAX.getName());
    }

    /**
     * @return le numéro de fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax définit le numéro de fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Fax:{"
                + super.toString()
                + ", fax:" + getFax()
                + "}";
    }
}
