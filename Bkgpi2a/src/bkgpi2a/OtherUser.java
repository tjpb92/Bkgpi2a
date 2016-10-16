package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un super utilisateur
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("otherUser")
public class OtherUser extends User {

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + ":{"
                + super.toString()
                + "}";
    }
}
