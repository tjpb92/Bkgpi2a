package bkgpi2a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Classe qui implémente le pattern DAO pour la classe SimplifiedRequestSearchView
 *
 * @author Thierry Baribaud
 * @version 1.32
 */
public class SimplifiedRequestDAO extends MongoPatternDAO {

    /**
     * Contructeur principal
     *
     * @param mongoDatabase connexion à la base MongoDB
     */
    public SimplifiedRequestDAO(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
        this.collection = mongoDatabase.getCollection("simplifiedRequests");
    }

    @Override
    public Object select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retrouve une demande d'intervention par son identifiant
     *
     * @param uid identifiant unique de la demande d'intervention
     * @return la demande d'intervention correspondante ou null si elle n'existe pas
     */
    public SimplifiedRequestSearchView findOne(String uid) {
        SimplifiedRequestSearchView simplifiedRequestSearchView = null;
        MongoCursor<Document> cursor;

        cursor = collection.find(new BasicDBObject("uid", uid)).iterator();
        if (cursor.hasNext()) {
            try {
                simplifiedRequestSearchView = objectMapper.readValue(cursor.next().toJson(), SimplifiedRequestSearchView.class);
            } catch (IOException exception) {
//            Logger.getLogger(SimplifiedRequestDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR : impossible de convertir une demande d'intervention de Json en objet " + exception);
            }
        }
        cursor.close();

        return simplifiedRequestSearchView;
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
     * Ajoute une demande simplifiée à la collection
     *
     * @param simplifiedRequestSearchView demande simplifée à ajouter à la collection
     */
    public void insert(SimplifiedRequestSearchView simplifiedRequestSearchView) {
        try {
            this.collection.insertOne(Document.parse(objectMapper.writeValueAsString(simplifiedRequestSearchView)));
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SimplifiedRequestDAO.class.getName()).log(Level.SEVERE, "ERROR : insertion impossible, erreur dans un champ" + ex.toString());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(SimplifiedRequestDAO.class.getName()).log(Level.SEVERE, null, ex);
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
