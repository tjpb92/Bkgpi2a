package bkgpi2a;

/**
 * Enum�ration sur les types d'appelant
 *
 * @author Thierry Baribaud
 * @version 0.41
 * @see http://performanceimmo.github.io/API/#callertype
 */
public enum CallerType {

    /**
     * L'appelant est un �tre humain
     */
    HUMAN_CALLER("HumanCaller"),

    /**
     * L'appelant est un automate
     */
    AUTOMATON_CALLER("AutomatonCaller");

    private String name = "";

    /**
     * Constructeur de l'enum�ration
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
     * @return le nom de l'�num�ration
     */
    @Override
    public String toString() {
        return name;
    }
}
