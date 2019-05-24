package bkgpi2a;

/**
 * Cette classe sert à vérifier et à récupérer les arguments passés en ligne de
 * commande au programme Bkgpi2a.
 *
 * @author Thierry Baribaud
 * @version 1.10
 */
public class GetArgs {

    /**
     * mongoDbServerType : prod pour le serveur de production, pre-prod pour le
     * serveur de pré-production. Valeur par défaut : pre-prod.
     */
    private String mongoDbServerType = "pre-prod";

    /**
     * informixDbServerType : prod pour le serveur de production, pre-prod pour
     * le serveur de pré-production. Valeur par défaut : pre-prod.
     */
    private String informixDbServerType = "pre-prod";

    /**
     * retention : durée de conservation des événements en base de données.
     * Valeur par défaut : 7 jours.
     */
    private int retention = 7;

    /**
     * debugMode : fonctionnement du programme en mode debug (true/false).
     * Valeur par défaut : false.
     */
    private boolean debugMode = false;

    /**
     * testMode : fonctionnement du programme en mode test (true/false). Valeur
     * par défaut : false.
     */
    private boolean testMode = false;

    /**
     * @return mongoDbServerType : retourne la valeur pour le serveur source.
     */
    public String getMongoDbServerType() {
        return (mongoDbServerType);
    }

    /**
     * @return debugMode : retourne le mode de fonctionnement debug.
     */
    public boolean getDebugMode() {
        return (debugMode);
    }

    /**
     * @return testMode : retourne le mode de fonctionnement test.
     */
    public boolean getTestMode() {
        return (testMode);
    }

    /**
     * @param mongoDbServerType : définit le type de serveur MongoDb.
     */
    public void setMongoDbServerType(String mongoDbServerType) {
        this.mongoDbServerType = mongoDbServerType;
    }

    /**
     * @param debugMode : fonctionnement du programme en mode debug
     * (true/false).
     */
    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    /**
     * @param testMode : fonctionnement du programme en mode test (true/false).
     */
    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    /**
     *
     * @param args arguments de la ligne de commande.
     * @throws GetArgsException en cas d'erreur sur les paramÃ¨tres
     */
    public GetArgs(String args[]) throws GetArgsException {

        int i;
        int n;
        int ip1;
        n = args.length;
        System.out.println("nargs=" + n);
//    for(i=0; i<n; i++) System.out.println("args["+i+"]="+Args[i]);
        i = 0;
        while (i < n) {
//            System.out.println("args[" + i + "]=" + Args[i]);
            ip1 = i + 1;
            if (args[i].equals("-mgodb")) {
                if (ip1 < n) {
                    if (args[ip1].equals("pre-prod") || args[ip1].equals("prod")) {
                        setMongoDbServerType(args[ip1]);
                    } else {
                        throw new GetArgsException("Mauvais serveur MongoDb : " + args[ip1]);
                    }
                    i = ip1;
                } else {
                    throw new GetArgsException("Serveur MongoDb non défini");
                }
            } else if (args[i].equals("-ifxdb")) {
                if (ip1 < n) {
                    if (args[ip1].equals("pre-prod") || args[ip1].equals("prod")
                            || args[ip1].equals("pre-prod2") || args[ip1].equals("prod2")) {
                        setInformixDbServerType(args[ip1]);
                    } else {
                        throw new GetArgsException("Mauvais serveur Informix : " + args[ip1]);
                    }
                    i = ip1;
                } else {
                    throw new GetArgsException("Serveur Informix non défini");
                }
            } else if (args[i].equals("-d")) {
                setDebugMode(true);
            } else if (args[i].equals("-t")) {
                setTestMode(true);
            } else {
                throw new GetArgsException("Mauvais argument : " + args[i]);
            }
            i++;
        }
    }

    /**
     * Affiche le mode d'utilisation du programme.
     */
    public static void usage() {
        System.out.println("Usage : java Bkgpi2a -mgodb prod -ifxdb prod"
                + " [-d] [-t]");
    }

    /**
     * @return le serveur de base de donnï¿½es de destination
     */
    public String getInformixDbServerType() {
        return informixDbServerType;
    }

    /**
     * @param informixDbServerType définit le serveur de base de donnï¿½es de
     * destination
     */
    public void setInformixDbServerType(String informixDbServerType) {
        this.informixDbServerType = informixDbServerType;
    }

    /**
     * Affiche le contenu de GetArgs.
     *
     * @return retourne le contenu de GetArgs.
     */
    @Override
    public String toString() {
        return "GetArg: {"
                + "mgodb=" + mongoDbServerType
                + ", ifxdb=" + informixDbServerType
                + ", debugMode=" + debugMode
                + ", testMode=" + testMode
                + "}";
    }

    /**
     * @return the retention
     */
    public int getRetention() {
        return retention;
    }

    /**
     * @param retention the retention to set
     */
    public void setRetention(int retention) {
        this.retention = retention;
    }

}
