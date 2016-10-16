package bkgpi2a;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Classe décrivant le pattern DAO pour MongoDB
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public abstract class MongoPatternDAO {

    /**
     * Connexion à la base de données MongoDb
     */
    protected MongoDatabase mongoDatabase;

    /**
     * Collection courante
     */
    protected MongoCollection<Document> collection;
    
    /**
     * Variable intermédiaire recevant l'équivalent d'un objet en Json
     */
    protected String json;
    
    /**
     * Objet servant à traduire les objets en Json
     */
    protected ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Sélectionne un enregistrement.
     *
     * @return l'object sélectionné.
     */
    abstract public Object select();

    /**
     * Met à jour un enregistrement.
     *
     * @param object object à mettre à jour.
     */
    abstract public void update(Object object);

    /**
     * Supprime un enregistrement.
     *
     * @param uid identifiant de l'objet.
     */
    abstract public void delete(String uid);

    /**
     * Insère un enregistrement.
     *
     * @param object Objet à insérer.
     */
    abstract public void insert(Object object);

    /**
     * Sélectionne un enregistrement par son identifiant
     *
     * @param uid identifiant de l'objet.
     */
    abstract public void filterByUid(String uid);

    /**
     * Trie les résultats selon une liste de champ(s)
     * 
     * @param fieldList liste de champs servant à trier les résultats
     */
    abstract public void orderBy(String fieldList);
}
