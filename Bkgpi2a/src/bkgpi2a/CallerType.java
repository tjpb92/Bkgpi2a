package bkgpi2a;

/**
 * Enumération sur les types d'appelant
 *
 * @author Thierry Baribaud
 * @version 1.34
 * @see <A href="http://performanceimmo.github.io/API/#callertype">CallerType</A>
 */
public enum CallerType {

    /**
     * L'appelant est un être humain
     */
    HUMAN_CALLER("HumanCaller"),
    /**
     * L'appelant est un automate
     */
    AUTOMATON_CALLER("AutomatonCaller"),
    /**
     * L'appelant est déjà référencé comme PatrimonyContact
     */
    REFERENCED_CONTACT_CALLER("ReferencedContactCaller");

    private String name = "";

    /**
     * Constructeur de l'enumération
     */
    CallerType(String name) {
        this.name = name;
    }

    /**
     * @return le type d'appelant
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
