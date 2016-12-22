package bkgpi2a;

/**
 * Enumération sur les types d'appelant
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#callertype
 */
public enum CallerType {

    /**
     * L'appelant est un être humain
     */
    HUMAN_CALLER("HumanCaller"),

    /**
     * L'appelant est un automate
     */
    AUTOMATON_CALLER("AutomatonCaller");

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
