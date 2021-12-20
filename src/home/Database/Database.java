package home.Database;

//MongoDB imports
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {
    //Verbindung zur cloud
    public static MongoClient client = new MongoClient(new MongoClientURI("mongodb+srv://chermashev:win120@cluster0.pgvgc.mongodb.net/test"));
    
    //Verbindung zur database
    public static MongoDatabase database = client.getDatabase("documents");

    //Deklarieren von Sammlungsvariablen
    public static MongoCollection<Document> users = Database.database.getCollection("users");
    public static MongoCollection<Document> tasks = Database.database.getCollection("tasks");
    public static MongoCollection<Document> clients = Database.database.getCollection("clients");
    public static MongoCollection<Document> objects = Database.database.getCollection("objects");
    public static MongoCollection<Document> budget = Database.database.getCollection(" budget");
    public static MongoCollection<Document> equipment = Database.database.getCollection("equipment");

    //Alle Objekte abrufen
    public static FindIterable<Document> foundedUsers = users.find();
    public static FindIterable<Document> foundedTasks = tasks.find();
    public static FindIterable<Document> foundedClients = clients.find();
    public static FindIterable<Document> foundedObjects = objects.find();
    public static FindIterable<Document> foundedBudgets = budget.find();
    public static FindIterable<Document> foundedEquipment = equipment.find();
}