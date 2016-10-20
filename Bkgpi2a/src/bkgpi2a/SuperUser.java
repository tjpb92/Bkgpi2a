package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un super utilisateur
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("superUser")
public class SuperUser extends User {

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "SuperUser:{"
                + super.toString()
                + "}";
    }
}
