package bkgpi2a;

/**
 * Classe qui d�finit une Exception � lancer lorsque l'objet WebServer rencontre
 * une erreur lors de son instanciation.
 *
 * @author Thierry Baribaud.
 * @version 1.10
 */
public class WebServerException extends Exception {

    private final static String ERRMSG
            = "Probl�me � l'instanciation de WebServer";

    /**
     * Exception sans message d'information
     */
    public WebServerException() {
        super(ERRMSG);
    }

    /**
     * Exception avec message d'information
     *
     * @param ErrMsg message d'information
     */
    public WebServerException(String ErrMsg) {
        super(ERRMSG + " : " + ErrMsg);
    }
}
