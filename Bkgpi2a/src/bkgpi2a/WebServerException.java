package bkgpi2a;

/**
 * Class qui d�finit une Exception � lancer lorsque l'objet WebServer rencontre
 * une erreur lors de son instanciation.
 * @author Thierry Baribaud.
 * @version Octobre 2016
 */
class WebServerException extends Exception {

	private final static String ERRMSG = 
		"Probl�me � l'instanciation de WebServer";

	public WebServerException() {
		System.out.println(ERRMSG);
	}

	public WebServerException(String ErrMsg) {
		System.out.println(ERRMSG + " : " + ErrMsg);
	}
}
