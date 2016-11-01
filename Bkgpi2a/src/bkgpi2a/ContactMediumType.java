package bkgpi2a;

/**
 * Enumération sur les types de médium
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
