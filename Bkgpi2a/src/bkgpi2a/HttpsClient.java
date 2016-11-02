package bkgpi2a;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.net.ssl.HttpsURLConnection;
/**
 * Classe réalisant des requetes GET/POST en HTTPS. Origine :
 * https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 *
 * @author Thierry Baribaud
 * @version 0.20
 */
public class HttpsClient {

    private final static String USER_AGENT = "Mozilla/5.0";

    /**
     * URL du site Web
     */
    private static String baseUrl;

    /**
     * Identifiants pour accéder au site Web
     */
    private static Identifiants identifiants;

    private final static String API_PATH = "/api/v1/";

    static final String LOGIN_CMDE = "login";
    static final String COMPANIES_CMDE = "companies";
    static final String SUBSIDIARIES_CMDE = "subsidiaries";
    static final String AGENCIES_CMDE = "agencies";
    static final String USERS_CMDE = "users";
    static final String PATRIMONIES_CMDE = "patrimonies";
    static final String PROVIDER_CONTACTS_CMDE = "providercontacts";
    static final String EVENTS_CMDE = "events";

    private String cookies = null;
    private int responseCode = 0;
    private String response = null;
    private String acceptRange = null;
    private String contentRange = null;

    /**
     * Constructeur principal de la classe
     *
     * @param baseUrl URL du site Web
     * @param identifiants identifiants pour accéder au site Web
     */
    public HttpsClient(String baseUrl, Identifiants identifiants) {
        HttpsClient.baseUrl = baseUrl;
        HttpsClient.identifiants = identifiants;
    }

    // HTTP GET request
    public void sendGet(String Command) throws Exception {

        String commandUrl;
        URL url;
        HttpsURLConnection connection;

        commandUrl = baseUrl + API_PATH + Command;
        url = new URL(commandUrl);
        connection = (HttpsURLConnection) url.openConnection();

        // optional default is GET
        connection.setRequestMethod("GET");

        //add request header
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("Cookie", getCookies());

        System.out.println("Sending 'GET' request to URL : " + commandUrl);
        getResponseCode(connection);
        setAcceptRange(connection.getHeaderField("Accept-Range"));
        System.out.println("Accept-Range : " + getAcceptRange());
        setContentRange(connection.getHeaderField("Content-Range"));
        System.out.println("Content-Range : " + getContentRange());
        HttpsClient.this.getResponse(connection);
        connection.disconnect();
    }

    // HTTP POST request
    public void sendPost(String Command) throws Exception {

        String commandUrl;
        URL url;
        HttpsURLConnection connection;
        DataOutputStream dataOutputStream;
        String urlParameters;

        commandUrl = baseUrl + API_PATH + Command;
        urlParameters = identifiants.toJson();

        url = new URL(commandUrl);
        connection = (HttpsURLConnection) url.openConnection();

        //add request header
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Content-Type", "application/json");

        // Send post request
        connection.setDoOutput(true);
        dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes(urlParameters);
        dataOutputStream.flush();
        dataOutputStream.close();

        System.out.println("Sending 'POST' request to URL : " + commandUrl);
        System.out.println("Post parameters : " + urlParameters);
        getResponseCode(connection);
        HttpsClient.this.getCookies(connection);
        HttpsClient.this.getResponse(connection);
        connection.disconnect();
    }

    private void getCookies(HttpsURLConnection MyConnection) {
        String cookies;

        cookies = MyConnection.getHeaderField("Set-Cookie");
        if (cookies != null) {
            System.out.println("Cookie(s)=" + cookies);
            setCookies(cookies);
        }
    }

    private void getResponseCode(HttpsURLConnection MyConnection) {
        setResponseCode(0);
        try {
            setResponseCode(MyConnection.getResponseCode());
            System.out.println("Response Code : " + getResponseCode());
        } catch (IOException ex) {
            Logger.getLogger(HttpsClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getResponse(HttpsURLConnection MyConnection) {
        BufferedReader bufferedReader;
        StringBuffer response = null;
        String myInputLine;

        setResponse(null);
        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(MyConnection.getInputStream()));
            response = new StringBuffer();

            while ((myInputLine = bufferedReader.readLine()) != null) {
                response.append(myInputLine);
            }
            bufferedReader.close();

            if (response != null) {
                setResponse(response.toString());
                //print result
                System.out.println(response.toString());
            }

        } catch (IOException ex) {
            Logger.getLogger(HttpsClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the cookies
     */
    public String getCookies() {
        return cookies;
    }

    /**
     * @param cookies the cookies to set
     */
    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    /**
     * @return the responseCode
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return the acceptRange
     */
    public String getAcceptRange() {
        return acceptRange;
    }

    /**
     * @param acceptRange the acceptRange to set
     */
    public void setAcceptRange(String acceptRange) {
        this.acceptRange = acceptRange;
    }

    /**
     * @return the contentRange
     */
    public String getContentRange() {
        return contentRange;
    }

    /**
     * @param contentRange the contentRange to set
     */
    public void setContentRange(String contentRange) {
        this.contentRange = contentRange;
    }
}
