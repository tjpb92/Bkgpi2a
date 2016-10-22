package bkgpi2a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Classe qui impl�mente le pattern DAO pour la classe ProviderContact
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class ProviderContactDAO extends MongoPatternDAO {

    /**
     * Contructeur principal
     * @param mongoDatabase connexion � la base MongoDB
     */
    public ProviderContactDAO(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
        this.collection = mongoDatabase.getCollection("providerContacts");
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
     * Ajoute un intervenant � la collection 
     * @param providerContact intervenant � ajouter � la collection
     */
    public void insert(ProviderContact providerContact) {
        try {
            this.collection.insertOne(Document.parse(objectMapper.writeValueAsString(providerContact)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProviderContactDAO.class.getName()).log(Level.SEVERE, null, ex);
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
