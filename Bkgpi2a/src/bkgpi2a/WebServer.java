package bkgpi2a;

import utils.ApplicationProperties;

/**
 * Classe qui décrit un serveur Web
 * @author Thierry Baribaud
 * @version 0.41
 */
public class WebServer {

    /**
     * Nom du serveur Web
     */
    private String name;

    /**
     * Adresse IP du serveur Web
     */
    private String ipAddress;

    /**
     * Numéro de port du serveur Web
     */
    private int portNumber;

    /**
     * Chemin pour les API Rest
     */
    private String URLPath;

    /**
     * Constructeur principal de la classe WebServer
     *
     * @param serverType type de serveur : dev/pre-prod/prod.
     * @param applicationProperties Application properties.
     * @throws bkgpi2a.WebServerException
     */
    public WebServer(String serverType, ApplicationProperties applicationProperties)
            throws WebServerException {
        String value;

        value = applicationProperties.getProperty(serverType + ".webserver.name");
        if (value != null) {
            setName(value);
        } else {
            throw new WebServerException("Nom du serveur Web non défini");
        }

        value = applicationProperties.getProperty(serverType + ".webserver.ip");
        if (value != null) {
            setIpAddress(value);
        } else {
            throw new WebServerException("Adresse IP du serveur Web non définie");
        }

        value = applicationProperties.getProperty(serverType + ".webserver.port");
        if (value != null) {
            try {
                setPortNumber(Integer.parseInt(value));
            } catch (Exception exception) {
                throw new WebServerException("Le numéro de port du serveur Web doit être un entier");
            }
        } else {
            throw new WebServerException("Numéro de port du serveur Web non défini");
        }

        value = applicationProperties.getProperty(serverType + ".webserver.path");
        if (value != null) {
            setURLPath(value);
        } else {
            throw new WebServerException("Chemin vers API Rest non défini");
        }
    }

    /**
     * Retourne le nom du serveur Web
     *
     * @return le nom du serveur Web
     */
    public String getName() {
        return (name);
    }

    /**
     * Retourne l'adresse IP du serveur Web
     *
     * @return l'adresse IP du serveur Web
     */
    public String getIpAddress() {
        return (ipAddress);
    }

    /**
     * Retourne le numéro de port du serveur Web
     *
     * @return le numéro de port du serveur Web
     */
    public int getPortNumber() {
        return (portNumber);
    }

    /**
     * Retourne le chemin vers les API Rest
     *
     * @return le chemin vers les API Rest
     */
    public String getURLPath() {
        return (URLPath);
    }

    /**
     * Définit le nom du serveur Web
     *
     * @param name définit le nom du serveur Web
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Définit l'adresse IP du serveur Web
     *
     * @param ipAddress l'adresse IP du serveur Web
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * Définit le port du serveur Web
     *
     * @param portNumber définit le port du serveur Web
     */
    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * Définit le chemin vers les API Rest
     *
     * @param URLPath définit le chemin vers les API Rest
     */
    public void setURLPath(String URLPath) {
        this.URLPath = URLPath;
    }

    /**
     * Retourne les valeurs sous forme textuelle
     *
     * @return Retourne les valeurs sous forme textuelle
     */
    @Override
    public String toString() {
        return "WebServer:{name:" + name + ", URL:" + ipAddress + ":" + portNumber + "/"
                + URLPath;
    }

    /**
     * Programme principal pour tester la classe WebServer.
     *
     * @param args arguments en ligne de commande
     * Premier argument précisant le type de serveur : dev/pre-prod/prod
     */
    public static void main(String[] args) {
        ApplicationProperties applicationProperties;
        WebServer webServer;

        if (args.length != 2) {
            System.out.println("Usage : java WebServer -webserver server-type");
            System.exit(0);
        }

        try {
            applicationProperties = new ApplicationProperties("MyDatabases.prop");
            webServer = new WebServer(args[1], applicationProperties);
            System.out.println(webServer);
        } catch (Exception exception) {
            System.out.println("Problème de création d'un serveur Web " + exception);
            exception.printStackTrace();
        }
    }
}
