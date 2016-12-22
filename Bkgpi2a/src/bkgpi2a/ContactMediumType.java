package bkgpi2a;

/**
 * Enum�ration sur les types de m�dium
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
public enum ContactMediumType {

    /**
     * T�l�phone
     */
    PHONE("Phone"),

    /**
     * Fax
     */
    FAX("Fax"),

    /**
     * Email
     */
    MAIL("Mail"),

    /**
     * SMS
     */
    SMS("SMS");

    private String name = "";

    /**
     * Constructeur de l'enum�ration
     */
    ContactMediumType(String name) {
        this.name = name;
    }

    /**
     * @return le type de m�dium
     */
    public String getName() {
        return name;
    }

    /**
     * @return le nom de l'�num�ration
     */
    @Override
    public String toString() {
        return name;
    }
}
