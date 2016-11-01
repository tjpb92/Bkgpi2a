package bkgpi2a;

/**
 * Enum�ration sur les types de m�dium
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
public enum ContactMediumType {
    PHONE("Phone"),
    FAX("Fax"),
    MAIL("Mail"),
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
