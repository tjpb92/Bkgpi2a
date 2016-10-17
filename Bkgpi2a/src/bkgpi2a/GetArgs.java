package bkgpi2a;

/*
 * Cette classe sert � v�rifier et � r�cup�rer les arguments pass�s en ligne de
 * commande au programme Bkgpi2a.
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetArgs {

    private static final DateFormat MyDateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
     * BegDate : date de d�but de l'export � 0h. Valeur par d�faut : la veille.
     */
    private Timestamp BegDate = new Timestamp((new java.util.Date().getTime()) - 1000 * 60 * 60 * 24);

    /**
     * EndDate : date de fin de l'export � 0h. Valeur par d�faut : aujourd'hui.
     */
    private Timestamp EndDate = new Timestamp(new java.util.Date().getTime());

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
     * @return BegDate : date de d�but de l'export � 0h.
     */
    public Timestamp getBegDate() {
        return (BegDate);
    }

    /**
     * @return EndDate : date de fin de l'export � 0h.
     */
    public Timestamp getEndDate() {
        return (EndDate);
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
     * @param BegDate : date de d�but de l'export � 0h.
     */
    public void setBegDate(Timestamp BegDate) {
        this.BegDate = BegDate;
    }

    /**
     * @param EndDate : date de fin de l'export � 0h.
     */
    public void setEndDate(Timestamp EndDate) {
        this.EndDate = EndDate;
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
     * @throws pi2a.GetArgsException en cas d'erreur sur les param�tres
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
                + " [-b d�but] [-f fin] [-d] [-t]");
    }

    /**
     * Affiche le contenu de GetArgs.
     *
     * @return retourne le contenu de GetArgs.
     */
    @Override
    public String toString() {
        return "GetArg: {"
                + "webServerType=" + webServerType
                + ", dbServerType=" + dbServerType
                + ", d�but=" + MyDateFormat.format(BegDate)
                + ", fin=" + MyDateFormat.format(EndDate)
                + ", debugMode=" + debugMode
                + ", testMode=" + testMode
                + "}";
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
}
