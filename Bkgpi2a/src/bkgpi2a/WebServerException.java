package bkgpi2a;

/**
 * Class qui définit une Exception à lancer lorsque l'objet WebServer rencontre
 * une erreur lors de son instanciation.
 * @author Thierry Baribaud.
 * @version 0.25
 */
public class WebServerException extends Exception {

	private final static String ERRMSG = 
		"Problème à l'instanciation de WebServer";

	public WebServerException() {
		System.out.println(ERRMSG);
	}

	public WebServerException(String ErrMsg) {
		System.out.println(ERRMSG + " : " + ErrMsg);
	}
}
