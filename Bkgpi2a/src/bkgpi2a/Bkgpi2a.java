package bkgpi2a;

import java.io.*;
import utils.ApplicationProperties;
import utils.DBServer;
import utils.DBServerException;

/**
 * Bkgpi2a, programme qui lit les donn�es au travers de l'API Rest d'un serveur
 * Web et les importe dans une base de donn�es locale.
 * @author Thierry Baribaud.
 * @version Octobre 2016
*/
public class Bkgpi2a {

  /**
     * webServerType : prod pour le serveur de production, pre-prod pour le serveur
 de pr�-production. Valeur par d�faut : pre-prod.
   */
  private String webServerType = "pre-prod";

    /**
     * dbServerType : prod pour le serveur de production, pre-prod pour le serveur
 de pr�-production. Valeur par d�faut : pre-prod.
     */
  private String dbServerType = "pre-prod";

  /**
   * Constructeur de la classe Bkgpi2a
     * <p>
     * Les arguments en ligne de commande permettent de changer le mode de
     * fonctionnement.</p><ul>
     * <li>-webserver : r�f�rence au serveur web source, par d�faut fait
     * r�f�rence au serveur de pr�-production (cf. fichier de param�tres
     * <i>myDatabases.prop</i>) (optionnel)</li>
     * <li>-dbserver : r�f�rence � la base de donn�e, par d�faut fait r�f�rence
     * � la base de pr�-production (cf. fichier de param�tres
     * <i>myDatabases.prop</i> (optionnel)</li>
     * <li>-b d�but : date de d�but de l'extraction � 0h, hier par d�faut,
     * format DD/MM/AAAA (optionnel).</li>
     * <li>-b fin : date de fin de l'extraction � 0h, aujourd'hui par d�faut,
     * format DD/MM/AAAA (optionnel).</li>
     * <li>-d : le programme fonctionne en mode d�bug le rendant plus verbeux,
     * d�sactiv� par d�faut (optionnel).</li>
     * <li>-t : le programme fonctionne en mode de test, les transactions en
     * base de donn�es ne sont pas ex�cut�es, d�sactiv� par d�faut
     * (optionnel).</li>
     * </ul>
     * @param args arguments de la ligne de commande.
     * @throws java.io.IOException en cas d'erreur d'entr�e/sortie.
     * @throws pi2a.WebServerException en cas d'erreur avec le serveur Web.
     * @throws utils.DBServerException en cas d'erreur avec le serveur de base de donn�es.
     * @throws pi2a.GetArgsException en cas d'erreur avec les param�tres en ligne de commande
   */
  public Bkgpi2a(String[] args) throws IOException, 
    WebServerException, DBServerException, GetArgsException {

    ApplicationProperties applicationProperties;
    DBServer dbServer;
    WebServer webServer;
    GetArgs getArgs;

    System.out.println("Cr�ation d'une instance de Bkgpi2a ...");

    System.out.println("Analyse des arguments de la ligne de commande ...");
    getArgs = new GetArgs(args);
    setWebServerType(getArgs.getWebServerType());
    setDbServerType(getArgs.getDbServerType());

    System.out.println("Lecture des param�tres d'ex�cution ...");
    applicationProperties = new ApplicationProperties("MyDatabases.prop");

    System.out.println("Lecture des param�tres du serveur Web ...");
    webServer = new WebServer(getWebServerType(), applicationProperties);
    System.out.println(webServer);

    System.out.println("Lecture des param�tres du serveur de base de donn�es ...");
    dbServer = new DBServer(getDbServerType(), applicationProperties);
    System.out.println(dbServer);
  }
  
  /**
   * @param webServerType d�finit le serveur Web
   */
  private void setWebServerType(String webServerType) {
    this.webServerType = webServerType;
  }

  /**
   * @param dbServerType d�finit le serveur de base de donn�es
   */
  private void setDbServerType(String dbServerType) {
    this.dbServerType = dbServerType;
  }

  /**
   * @return webServerType le serveur web
   */
  private String getWebServerType() {
    return(webServerType);
  }

  /**
   * @return dbServerType le serveur de base de donn�es
   */
  private String getDbServerType() {
    return(dbServerType);
  }

  /**
   * Retourne le contenu de Bkgpi2a 
   * @return retourne le contenu de Bkgpi2a
   */
  @Override
  public String toString() {
    return "Bkgpi2a:{webServer=" + getWebServerType() +
           ", dbServer=" + getDbServerType();
  }

  /**
   * Programme principal pour lancer Bkgpi2a.
     * @param args param�tre de ligne de commande (cf. constructeur).
   */
  public static void main(String[] args){
  
    Bkgpi2a bkgpi2a;
  
    System.out.println("Lancement de Bkgpi2a ...");
  
    try {
      bkgpi2a = new Bkgpi2a(args);
      System.out.println(bkgpi2a);
    }
    catch (Exception exception) {
      System.out.println("Probl�me lors de l'instanciation de Bkgpi2a");
      exception.printStackTrace();
    }
  
    System.out.println("Fin de Bkgpi2a");
  }
}
