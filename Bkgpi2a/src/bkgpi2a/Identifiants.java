package bkgpi2a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe décrivant les identifiants  permettant de se connecter à l'Event Store.
 * 
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class Identifiants {
    
    /**
     * Identifiant de l'utilisateur
     */
    private String Login;
    
    /**
     * Mot de passe de l'utilisateur
     */
    private String Password;

    /** 
     * Constructeur principal de la classe
     * @param MyLogin Identifiant de l'utilisateur
     * @param MyPassword Mot de passe de l'utilisateur
     */
    public Identifiants(String MyLogin, String MyPassword) {
        this.Login = MyLogin;
        this.Password = MyPassword;
    }
    
    /**
     * Constructeur secondaire de la classe
     */
    public Identifiants() {
    }
    
    /**
     * @return l'identifiant Login de l'utilisateur.
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login définit l'identifant de l'utilisateur.
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return le mot de passe de l'utilisateur
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password définit le mot de passe de l'utilisateur
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    /**
     * @return retourne l'objet sous forme de Json
     */
    public String toJson() {
        ObjectMapper MyObjectMapper;
        String MyJson;
        
        MyJson = "";
        try {
            MyObjectMapper = new ObjectMapper();
            MyJson = MyObjectMapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Identifiants.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return MyJson;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + 
                ":{login:" + getLogin() + 
                ", password:" + getPassword() + 
                "}";
    }
}
