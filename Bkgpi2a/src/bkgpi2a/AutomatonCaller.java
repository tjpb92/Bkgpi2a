package bkgpi2a;

import static bkgpi2a.CallerType.AUTOMATON_CALLER;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un appelant de type automate
 *
 * @author Thierry Baribaud
 * @version 0.18
 * @see http://performanceimmo.github.io/API/#callertype
 */
@JsonTypeName("AutomatonCaller")
public class AutomatonCaller extends Caller {

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public AutomatonCaller() {
        setCallerType(AUTOMATON_CALLER.getName());
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AutomatonCaller:{"
                + super.toString()
                + "}";
    }
}
