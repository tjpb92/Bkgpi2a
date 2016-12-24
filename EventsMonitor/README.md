# Events monitor

Programme Java permettant de surveiller l'activité d'une base de données MongoDb

##Utilisation:
```
java EventsMonitor [-dbserver db] [-d] [-t] 
```
où :
* ```-dbserver db``` est la référence à la base de données, par défaut désigne la base de données de développement. Voir fichier *EventsMonitor.prop* (optionnel).
* ```-d``` le programme s'exécute en mode débug, il est beaucoup plus verbeux. Désactivé par défaut (paramètre optionnel).
* ```-t``` le programme s'exécute en mode test, les transcations en base de données ne sont pas faites. Désactivé par défaut (paramètre optionnel).

##Pré-requis :
- Java 6 ou supérieur.
- Driver Mongodb pour Java
- Jackson

##Références:

http://websystique.com/java/json/jackson-convert-java-object-to-from-json/

http://www.baeldung.com/jackson-annotations
http://tutorials.jenkov.com/java-json/jackson-annotations.html
http://websystique.com/java/json/jackson-json-annotations-example/
https://avaldes.com/json-tutorial-jackson-annotations-part-2/
https://www.mkyong.com/java/jackson-tree-model-example/
https://www.tutorialspoint.com/jackson/jackson_tree_model.htm

https://www.javacodegeeks.com/2012/09/simple-rest-client-in-java.html
https://jersey.java.net/documentation/latest/client.html

https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
http://alvinalexander.com/blog/post/java/simple-https-example
https://www.mkyong.com/java/java-https-client-httpsurlconnection-example/

http://java2s.com/Tutorials/Java/URL_Connection_Address/Get_and_set_cookie_through_URLConnection_in_Java.htm

https://buzut.fr/commandes-de-base-de-mongodb/

