package bkgpi2a;

import utils.ApplicationProperties;

/**
 * Classe qui d�crit un serveur Web
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
     * Num�ro de port du serveur Web
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
            throw new WebServerException("Nom du serveur Web non d�fini");
        }

        value = applicationProperties.getProperty(serverType + ".webserver.ip");
        if (value != null) {
            setIpAddress(value);
        } else {
            throw new WebServerException("Adresse IP du serveur Web non d�finie");
        }

        value = applicationProperties.getProperty(serverType + ".webserver.port");
        if (value != null) {
            try {
                setPortNumber(Integer.parseInt(value));
            } catch (Exception exception) {
                throw new WebServerException("Le num�ro de port du serveur Web doit �tre un entier");
            }
        } else {
            throw new WebServerException("Num�ro de port du serveur Web non d�fini");
        }

        value = applicationProperties.getProperty(serverType + ".webserver.path");
        if (value != null) {
            setURLPath(value);
        } else {
            throw new WebServerException("Chemin vers API Rest non d�fini");
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
     * Retourne le num�ro de port du serveur Web
     *
     * @return le num�ro de port du serveur Web
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
     * D�finit le nom du serveur Web
     *
     * @param name d�finit le nom du serveur Web
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * D�finit l'adresse IP du serveur Web
     *
     * @param ipAddress l'adresse IP du serveur Web
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * D�finit le port du serveur Web
     *
     * @param portNumber d�finit le port du serveur Web
     */
    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * D�finit le chemin vers les API Rest
     *
     * @param URLPath d�finit le chemin vers les API Rest
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
     * Premier argument pr�cisant le type de serveur : dev/pre-prod/prod
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
            System.out.println("Probl�me de cr�ation d'un serveur Web " + exception);
            exception.printStackTrace();
        }
    }
}
