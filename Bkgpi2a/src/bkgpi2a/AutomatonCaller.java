package bkgpi2a;

import static bkgpi2a.CallerType.AUTOMATON_CALLER;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un appelant de type automate
 *
 * @author Thierry Baribaud
 * @version 1.42.1
 * @see
 * <A href="https://declarimmo-org.github.io/API/#callertype">CallerType</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("AutomatonCaller")
public class AutomatonCaller extends Caller {

    /**
     * Constructeur principal de la classe AutomatonCaller
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
