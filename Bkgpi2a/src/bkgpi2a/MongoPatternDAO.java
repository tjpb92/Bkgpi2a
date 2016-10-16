package bkgpi2a;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Classe d�crivant le pattern DAO pour MongoDB
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public abstract class MongoPatternDAO {

    /**
     * Connexion � la base de donn�es MongoDb
     */
    protected MongoDatabase mongoDatabase;

    /**
     * Collection courante
     */
    protected MongoCollection<Document> collection;
    
    /**
     * Variable interm�diaire recevant l'�quivalent d'un objet en Json
     */
    protected String json;
    
    /**
     * Objet servant � traduire les objets en Json
     */
    protected ObjectMapper objectMapper = new ObjectMapper();

    /**
     * S�lectionne un enregistrement.
     *
     * @return l'object s�lectionn�.
     */
    abstract public Object select();

    /**
     * Met � jour un enregistrement.
     *
     * @param object object � mettre � jour.
     */
    abstract public void update(Object object);

    /**
     * Supprime un enregistrement.
     *
     * @param uid identifiant de l'objet.
     */
    abstract public void delete(String uid);

    /**
     * Ins�re un enregistrement.
     *
     * @param object Objet � ins�rer.
     */
    abstract public void insert(Object object);

    /**
     * S�lectionne un enregistrement par son identifiant
     *
     * @param uid identifiant de l'objet.
     */
    abstract public void filterByUid(String uid);

    /**
     * Trie les r�sultats selon une liste de champ(s)
     * 
     * @param fieldList liste de champs servant � trier les r�sultats
     */
    abstract public void orderBy(String fieldList);
}
