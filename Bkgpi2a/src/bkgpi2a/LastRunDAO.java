package bkgpi2a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Classe qui implémente le pattern DAO pour la classe LastRun
 *
 * @author Thierry Baribaud
 * @version 0.27
 */
public class LastRunDAO extends MongoPatternDAO {

    /**
     * Contructeur principal
     *
     * @param mongoDatabase connexion à la base MongoDB
     */
    public LastRunDAO(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
        this.collection = mongoDatabase.getCollection("lastRun");
    }

    @Override
    public Object select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Récupére la dernière exécution d'un programme par le nom du programme
     *
     * @param programName le nom du programme
     * @return la dernière exécution du programme
     */
    public LastRun find(String programName) {
        LastRun lastRun = null;
        MongoCursor<Document> cursor;

        if (programName.length() > 0) {
            objectMapper = new ObjectMapper();
            cursor = collection.find(new BasicDBObject("programName", programName)).iterator();
            if (cursor.hasNext()) {
                try {
                    lastRun = objectMapper.readValue(cursor.next().toJson(), LastRun.class);
                } catch (IOException ex) {
                    Logger.getLogger(LastRunDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lastRun;
    }

    /**
     * Met à jour la dernière date d'exécution d'un programme
     *
     * @param lastRun
     */
    public void update(LastRun lastRun) {
        UpdateResult updateResult;

        updateResult = collection.updateOne(new BasicDBObject("programName", lastRun.getProgramName()),
                new BasicDBObject("$set", new BasicDBObject("lastRun", lastRun.getLastRun())));

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
     * Ajoute la dernière exécution d'un programme à la collection
     *
     * @param lastRun la dernière exécution d'un programme à ajouter à la
     * collection
     */
    public void insert(LastRun lastRun) {
        try {
            this.collection.insertOne(Document.parse(objectMapper.writeValueAsString(lastRun)));
        } catch (JsonProcessingException exception) {
            Logger.getLogger(LastRunDAO.class.getName()).log(Level.SEVERE, null, exception);
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
