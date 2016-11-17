package bkgpi2a;

/*
 * Cette classe sert � v�rifier et � r�cup�rer les arguments pass�s en ligne de
 * commande au programme Bkgpi2a ou pi2a-client.
 * @author Thierry Baribaud
 * @version 0.26
 */
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetArgs {

    private static final DateFormat MyDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * webServerType : prod pour le serveur de production, pre-prod pour le
     * serveur de pr�-production. Valeur par d�faut : pre-prod.
     */
    private String webServerType = "pre-prod";

    /**
     * dbServerType : prod pour le serveur de production, pre-prod pour le
     * serveur de pr�-production. Valeur par d�faut : pre-prod.
     */
    private String dbServerType = "pre-prod";

    /**
     * begDate : date de d�but de l'export � 0h. Valeur par d�faut : la veille.
     */
    private Timestamp begDate = new Timestamp((new java.util.Date().getTime()) - 1000 * 60 * 60 * 24);

    /**
     * endDate : date de fin de l'export � 0h. Valeur par d�faut : aujourd'hui.
     */
    private Timestamp endDate = new Timestamp(new java.util.Date().getTime());

    /**
     * readCompanies : demande la lecture des soci�t�s (true/false). Valeur par
     * d�faut : false.
     */
    private boolean readCompanies = false;

    /**
     * readPatrimonies : demande la lecture des patrimoines (true/false). Valeur par
     * d�faut : false.
     */
    private boolean readPatrimonies = false;

    /**
     * readProviders : demande la lecture des fournisseurs (true/false). Valeur par
     * d�faut : false.
     */
    private boolean readProviders = false;

    /**
     * readEvents : demande la lecture des �v�nements (true/false). Valeur par
     * d�faut : false.
     */
    private boolean readEvents = false;

    /**
     * debugMode : fonctionnement du programme en mode debug (true/false).
     * Valeur par d�faut : false.
     */
    private boolean debugMode = false;

    /**
     * testMode : fonctionnement du programme en mode test (true/false). Valeur
     * par d�faut : false.
     */
    private boolean testMode = false;

    /**
     * @return webServerType : retourne la valeur pour le serveur source.
     */
    public String getWebServerType() {
        return (webServerType);
    }

    /**
     * @return begDate : date de d�but de l'export � 0h.
     */
    public Timestamp getBegDate() {
        return (begDate);
    }

    /**
     * @return endDate : date de fin de l'export � 0h.
     */
    public Timestamp getEndDate() {
        return (endDate);
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
     * @param webServerType : d�finit le serveur web � la source.
     */
    public void setWebServerType(String webServerType) {
        this.webServerType = webServerType;
    }

    /**
     * @param begDate : date de d�but de l'export � 0h.
     */
    public void setBegDate(Timestamp begDate) {
        this.begDate = begDate;
    }

    /**
     * @param endDate : date de fin de l'export � 0h.
     */
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
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
     * @param args arguments de la ligne de commande.
     * @throws GetArgsException en cas d'erreur sur les param�tres
     */
    public GetArgs(String args[]) throws GetArgsException {

        int i;
        int n;
        int ip1;
        Date date;

        // Demande une analyse d'une date valide
        MyDateFormat.setLenient(false);
        n = args.length;

        System.out.println("nargs=" + n);
//    for(i=0; i<n; i++) System.out.println("args["+i+"]="+Args[i]);
        i = 0;
        while (i < n) {
//            System.out.println("args[" + i + "]=" + Args[i]);
            ip1 = i + 1;
            if (args[i].equals("-webserver")) {
                if (ip1 < n) {
                    if (args[ip1].equals("pre-prod") || args[ip1].equals("prod")) {
                        setWebServerType(args[ip1]);
                    } else {
                        throw new GetArgsException("Mauvais serveur web : " + args[ip1]);
                    }
                    i = ip1;
                } else {
                    throw new GetArgsException("Serveur Web non d�fini");
                }
            } else if (args[i].equals("-dbserver")) {
                if (ip1 < n) {
                    if (args[ip1].equals("pre-prod") || args[ip1].equals("prod")) {
                        setDbServerType(args[ip1]);
                    } else {
                        throw new GetArgsException("Mauvaise base de donn�es : " + args[ip1]);
                    }
                    i = ip1;
                } else {
                    throw new GetArgsException("Base de donn�es non d�finie");
                }
            } else if (args[i].equals("-b")) {
                if (ip1 < n) {
                    try {
                        date = (Date) MyDateFormat.parse(args[ip1]);
                        setBegDate(new Timestamp(date.getTime()));
                        i = ip1;
                    } catch (Exception exception) {
                        throw new GetArgsException("La date de d�but doit �tre valide jj/mm/aaaa : " + args[ip1]);
                    }
                } else {
                    throw new GetArgsException("Date de d�but non d�finie");
                }
            } else if (args[i].equals("-e")) {
                if (ip1 < n) {
                    try {
                        date = (Date) MyDateFormat.parse(args[ip1]);
                        setEndDate(new Timestamp(date.getTime()));
                        i = ip1;
                    } catch (Exception exception) {
                        throw new GetArgsException("La date de fin doit �tre valide jj/mm/aaaa : " + args[ip1]);
                    }
                } else {
                    throw new GetArgsException("Date de fin non d�finie");
                }
            } else if (args[i].equals("-companies")) {
                setReadCompanies(true);
            } else if (args[i].equals("-patrimonies")) {
                setReadPatrimonies(true);
            } else if (args[i].equals("-providers")) {
                setReadProviders(true);
            } else if (args[i].equals("-events")) {
                setReadEvents(true);
            } else if (args[i].equals("-d")) {
                setDebugMode(true);
            } else if (args[i].equals("-t")) {
                setTestMode(true);
            } else {
                throw new GetArgsException("Mauvais argument : " + args[i]);
            }
            i++;
        }
        if (getBegDate().after(getEndDate())) {
            throw new GetArgsException("La date de d�but " + MyDateFormat.format(getBegDate())
                    + " doit �tre ant�rieure � la date de fin " + MyDateFormat.format(getEndDate()));
        }
    }

    /**
     * Affiche le mode d'utilisation du programme.
     */
    public static void usage() {
        System.out.println("Usage : java Bkgpi2a -webserver prod -dbserver prod"
                + " [-b d�but] [-f fin]"
                + " [-companies] [-patrimonies] [-providers] [-events]"
                + " [-d] [-t]");
    }

    /**
     * @return le serveur de base de donn�es de destination
     */
    public String getDbServerType() {
        return dbServerType;
    }

    /**
     * @param dbServerType d�finit le serveur de base de donn�es de destination
     */
    public void setDbServerType(String dbServerType) {
        this.dbServerType = dbServerType;
    }

    /**
     * @return s'il faut lire ou non les soci�t�s
     */
    public boolean getReadCompanies() {
        return readCompanies;
    }

    /**
     * @param readCompanies demande ou non la lecture des soci�t�s
     */
    public void setReadCompanies(boolean readCompanies) {
        this.readCompanies = readCompanies;
    }

    /**
     * @return s'il faut lire ou non les patrimoines
     */
    public boolean getReadPatrimonies() {
        return readPatrimonies;
    }

    /**
     * @param readPatrimonies demande ou non la lecture des patrimoines
     */
    public void setReadPatrimonies(boolean readPatrimonies) {
        this.readPatrimonies = readPatrimonies;
    }

    /**
     * @return s'il faut lire ou non les fournisseurs
     */
    public boolean getReadProviders() {
        return readProviders;
    }

    /**
     * @param readProviders demande ou non la lecture des fournisseurs
     */
    public void setReadProviders(boolean readProviders) {
        this.readProviders = readProviders;
    }

    /**
     * @return s'il faut lire ou non les �v�nements
     */
    public boolean getReadEvents() {
        return readEvents;
    }

    /**
     * @param readEvents demande ou non la lecture des �v�nements
     */
    public void setReadEvents(boolean readEvents) {
        this.readEvents = readEvents;
    }

    /**
     * Affiche le contenu de GetArgs.
     *
     * @return retourne le contenu de GetArgs.
     */
    @Override
    public String toString() {
        return "GetArg: {"
                + "webServerType:" + getWebServerType()
                + ", dbServerType:" + getDbServerType()
                + ", d�but:" + MyDateFormat.format(getBegDate())
                + ", fin:" + MyDateFormat.format(getEndDate())
                + ", companies:" + getReadCompanies()
                + ", patrimonies:" + getReadPatrimonies()
                + ", providers:" + getReadProviders()
                + ", events:" + getReadEvents()
                + ", debugMode:" + getDebugMode()
                + ", testMode:" + getTestMode()
                + "}";
    }
}
