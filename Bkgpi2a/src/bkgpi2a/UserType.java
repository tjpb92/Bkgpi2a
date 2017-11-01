package bkgpi2a;

/**
 * Enumération sur les types d'utilisateur
 *
 * @author Thierry Baribaud
 * @version 0.47
 */
public enum UserType {

    SUPER_USER("superUser"),
    CALL_CENTER_USER("callCenterUser"),
    CLIENT_ACCOUNT_MANAGER("clientAccountManager"),
    EXECUTIVE("executive"),
    PATRIMONY_MANAGER("patrimonyManager");

    private String name = "";

    /**
     * Constructeur de l'enumération
     */
    UserType(String name) {
        this.name = name;
    }

    /**
     * @return le nom de l'énumération
     */
    @Override
    public String toString() {
        return name;
    }
}
