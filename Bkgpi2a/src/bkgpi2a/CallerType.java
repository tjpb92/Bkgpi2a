package bkgpi2a;

/**
 * Enumération sur les types d'appelant
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#callertype
 */
public enum CallerType {
    HUMAN_CALLER("HumanCaller"),
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
