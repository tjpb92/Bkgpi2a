package bkgpi2a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Classe qui implémente le pattern DAO pour la classe Users
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class UserDAO extends MongoPatternDAO {

    /**
     * Contructeur principal
     * @param mongoDatabase connexion à la base MongoDB
     */
    public UserDAO(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
        this.collection = mongoDatabase.getCollection("users");
    }
    
    @Override
    public Object select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String uid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Ajoute un utilisateur à la collection 
     * @param user utilisateur à ajouter à la collection
     */
    public void insert(User user) {
        try {
            this.collection.insertOne(Document.parse(objectMapper.writeValueAsString(user)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void filterByUid(String uid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void orderBy(String fieldList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
