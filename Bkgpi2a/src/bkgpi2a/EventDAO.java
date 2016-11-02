package bkgpi2a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Classe qui impl�mente le pattern DAO pour la classe Event
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class EventDAO extends MongoPatternDAO {

    /**
     * Contructeur principal
     * @param mongoDatabase connexion � la base MongoDB
     */
    public EventDAO(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
        this.collection = mongoDatabase.getCollection("events");
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
     * Ajoute un patrimoine � la collection 
     * @param event �v�n�ments � ajouter � la collection
     */
    public void insert(Event event) {
        try {
            this.collection.insertOne(Document.parse(objectMapper.writeValueAsString(event)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
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
