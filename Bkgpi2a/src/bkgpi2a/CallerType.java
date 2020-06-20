package bkgpi2a;

/**
 * Enum�ration sur les types d'appelant
 *
 * @author Thierry Baribaud
 * @version 1.34
 * @see <A href="http://performanceimmo.github.io/API/#callertype">CallerType</A>
 */
public enum CallerType {

    /**
     * L'appelant est un �tre humain
     */
    HUMAN_CALLER("HumanCaller"),
    /**
     * L'appelant est un automate
     */
    AUTOMATON_CALLER("AutomatonCaller"),
    /**
     * L'appelant est d�j� r�f�renc� comme PatrimonyContact
     */
    REFERENCED_CONTACT_CALLER("ReferencedContactCaller");

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
