package bkgpi2a;

/**
 * Enumération sur les types de médium
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#contactmedium
 */
public enum ContactMediumType {

    /**
     * Téléphone
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
     * Constructeur de l'enumération
     */
    ContactMediumType(String name) {
        this.name = name;
    }

    /**
     * @return le type de médium
     */
    public String getName() {
        return name;
    }

    /**
     * @return le nom de l'énumération
     */
    @Override
    public String toString() {
        return name;
    }
}
