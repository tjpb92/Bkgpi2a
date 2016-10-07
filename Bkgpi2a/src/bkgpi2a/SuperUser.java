package pi2a;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe décrivant un super utilisateur
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class SuperUser extends BasicUser {
    @JsonProperty("userType")
    private final String userType = "superUser";
//    private final UserType userType = UserType.SUPER_USER;
}
