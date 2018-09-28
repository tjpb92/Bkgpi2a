package bkgpi2a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Classe qui implémente le pattern DAO pour la classe ProviderCompany
 * @author Thierry Baribaud
 * @version 0.48
 */
public class ProviderCompanyDAO extends MongoPatternDAO {

    /**
     * Contructeur principal
     * @param mongoDatabase connexion à la base MongoDB
     */
    public ProviderCompanyDAO(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
        this.collection = mongoDatabase.getCollection("providerCompanies");
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
     * Ajoute une société d'un fournisseur à la collection 
     * @param providerCompany société d'un fournisseur à ajouter à la collection
     */
    public void insert(ProviderCompany providerCompany) {
        try {
            this.collection.insertOne(Document.parse(objectMapper.writeValueAsString(providerCompany)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProviderCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
