package pi2a;

/**
 * Enum�ration sur les types d'utilisateur
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public enum UserType {

    SUPER_USER("superUser"),
    CALL_CENTER_USER("callCenterUser"),
    CLIENT_ACCOUNT_MANAGER("clientAccountManager"),
    EXECUTIVE("executive");

    private String name = "";

    /**
     * Constructeur de l'enum�ration
     */
    UserType(String name) {
        this.name = name;
    }

    /**
     * @return le nom de l'�num�ration
     */
    @Override
    public String toString() {
        return name;
    }
}
