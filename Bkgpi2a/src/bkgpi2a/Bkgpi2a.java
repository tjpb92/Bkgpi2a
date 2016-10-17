package bkgpi2a;

import java.io.*;
import utils.ApplicationProperties;
import utils.DBServer;
import utils.DBServerException;

/**
 * Bkgpi2a, programme qui lit les données au travers de l'API Rest d'un serveur
 * Web et les importe dans une base de données locale.
 * @author Thierry Baribaud.
 * @version Octobre 2016
*/
public class Bkgpi2a {

  /**
     * webServerType : prod pour le serveur de production, pre-prod pour le serveur
 de pré-production. Valeur par défaut : pre-prod.
   */
  private String webServerType = "pre-prod";

    /**
     * dbServerType : prod pour le serveur de production, pre-prod pour le serveur
 de pré-production. Valeur par défaut : pre-prod.
     */
  private String dbServerType = "pre-prod";

  /**
   * Constructeur de la classe Bkgpi2a
     * <p>
     * Les arguments en ligne de commande permettent de changer le mode de
     * fonctionnement.</p><ul>
     * <li>-webserver : référence au serveur web source, par défaut fait
     * référence au serveur de pré-production (cf. fichier de paramètres
     * <i>myDatabases.prop</i>) (optionnel)</li>
     * <li>-dbserver : référence à la base de donnée, par défaut fait référence
     * à la base de pré-production (cf. fichier de paramètres
     * <i>myDatabases.prop</i> (optionnel)</li>
     * <li>-b début : date de début de l'extraction à 0h, hier par défaut,
     * format DD/MM/AAAA (optionnel).</li>
     * <li>-b fin : date de fin de l'extraction à 0h, aujourd'hui par défaut,
     * format DD/MM/AAAA (optionnel).</li>
     * <li>-d : le programme fonctionne en mode débug le rendant plus verbeux,
     * désactivé par défaut (optionnel).</li>
     * <li>-t : le programme fonctionne en mode de test, les transactions en
     * base de données ne sont pas exécutées, désactivé par défaut
     * (optionnel).</li>
     * </ul>
     * @param args arguments de la ligne de commande.
     * @throws java.io.IOException en cas d'erreur d'entrée/sortie.
     * @throws pi2a.WebServerException en cas d'erreur avec le serveur Web.
     * @throws utils.DBServerException en cas d'erreur avec le serveur de base de données.
     * @throws pi2a.GetArgsException en cas d'erreur avec les paramètres en ligne de commande
   */
  public Bkgpi2a(String[] args) throws IOException, 
    WebServerException, DBServerException, GetArgsException {

    ApplicationProperties applicationProperties;
    DBServer dbServer;
    WebServer webServer;
    GetArgs getArgs;

    System.out.println("Création d'une instance de Bkgpi2a ...");

    System.out.println("Analyse des arguments de la ligne de commande ...");
    getArgs = new GetArgs(args);
    setWebServerType(getArgs.getWebServerType());
    setDbServerType(getArgs.getDbServerType());

    System.out.println("Lecture des paramètres d'exécution ...");
    applicationProperties = new ApplicationProperties("MyDatabases.prop");

    System.out.println("Lecture des paramètres du serveur Web ...");
    webServer = new WebServer(getWebServerType(), applicationProperties);
    System.out.println(webServer);

    System.out.println("Lecture des paramètres du serveur de base de données ...");
    dbServer = new DBServer(getDbServerType(), applicationProperties);
    System.out.println(dbServer);
  }
  
  /**
   * @param webServerType définit le serveur Web
   */
  private void setWebServerType(String webServerType) {
    this.webServerType = webServerType;
  }

  /**
   * @param dbServerType définit le serveur de base de données
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
   * @return dbServerType le serveur de base de données
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
     * @param args paramètre de ligne de commande (cf. constructeur).
   */
  public static void main(String[] args){
  
    Bkgpi2a bkgpi2a;
  
    System.out.println("Lancement de Bkgpi2a ...");
  
    try {
      bkgpi2a = new Bkgpi2a(args);
      System.out.println(bkgpi2a);
    }
    catch (Exception exception) {
      System.out.println("Problème lors de l'instanciation de Bkgpi2a");
      exception.printStackTrace();
    }
  
    System.out.println("Fin de Bkgpi2a");
  }
}
