package home.Methonds;

import home.Database.Database;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Methods {

    public static ArrayList<String> getTasks(ObjectId id){
        ArrayList<String> tasks = new ArrayList<String>();
        for (Document document : Database.foundedTasks) {
            if (id.toString().equals(document.getObjectId("worker").toString()) && !document.getString("status").equals("completed")) {
                tasks.add(document.getString("task"));
            }
        }
        return tasks;
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
