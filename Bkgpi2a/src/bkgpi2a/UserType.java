package bkgpi2a;

/**
 * Enum�ration sur les types d'utilisateur
 *
 * @author Thierry Baribaud
 * @version 1.37
 * @see
 * <A href="http://performanceimmo.github.io/API/#userqueryview">UserQueryView</A>
 */
public enum UserType {

    SUPER_USER("superUser"),
    CALL_CENTER_USER("callCenterUser"),
    CALL_CENTER_OPERATOR("callCenterOperator"),
    CLIENT_ACCOUNT_MANAGER("clientAccountManager"),
    EXECUTIVE("executive"),
    PATRIMONY_MANAGER("patrimonyManager");

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
