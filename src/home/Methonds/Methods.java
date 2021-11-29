package home.Methonds;

import com.mongodb.client.model.Filters;
import home.Database.Database;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Methods {

    public static ArrayList<Document> getTasks(){
        ArrayList<Document> tasks = new ArrayList<Document>();
        for (Document document : Database.foundedTasks) {
            if (!document.getString("status").equals("completed")) {
                tasks.add(document);
            }
        }
        return tasks;
    }

    public static void completeTask(Document document) {
        Database.tasks.updateOne(Filters.eq("_id", document.getObjectId("_id")), new Document(
                "$set",
                new Document("status", "completed")
        ));
    }

    public static String getSalary(ObjectId id) {
        Document founded = Database.users.find(new Document("_id", id)).first();
        assert founded != null;
        return String.valueOf(founded.getInteger("salary"));
    }

    public static ArrayList<String> getMarkCat() {
        ArrayList<String> categories = new ArrayList<String>();
        for (Document document : Database.foundedBudgets) {
            String category = document.getString("place");
            if (!categories.contains(category) && category != null){
                categories.add(category);
            }
        }
        return categories;
    }

    public static float calculateClietnsPerArea(String area) {
        float result;
        float people = 0;
        float clients = 0;
        for (Document document : Database.foundedClients) {
            if(!document.getString("place").equals("")){
                people++;
            }
        }
        for (Document document : Database.foundedClients) {
            if(document.getString("place").equals(area)){
                clients++;
            }
        }
        result = (clients/people) * 100;
        return result;
    }

    public static int markFunds(){
        int funds = 0;
        for (Document document : Database.foundedBudgets) {
            if ("marketing".equals(document.getString("type"))) {
                funds += document.getInteger("cost");
            }
        }
        return funds;
    }

    public static ArrayList<String> getEquipment() {
        ArrayList<String> equipment = new ArrayList<String>();
        for (Document document : Database.foundedEquipment) {
            String str = document.getString("name") + ": " +document.getString("quantity");
            equipment.add(str);
        }
        return equipment;
    }
}
