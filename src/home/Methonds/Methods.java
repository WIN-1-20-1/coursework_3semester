package home.Methonds;

import com.mongodb.client.model.Filters;
import home.Database.Database;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    
    public static int getBudget(String category) {
        int res = 0;
        for (Document document : Database.foundedBudgets) {
            if (document.getObjectId("_id").toString().equals("606624505afe5468c793940f")) {
                res = Integer.parseInt(document.getString(category));
            }
        }
        return res;
    }

    public static int getUsedBudgetForSalary(){
        int res = 0;
        for (Document document : Database.foundedUsers){
            if (document.getInteger("salary") != null && document.getInteger("salary") > 0){
                res += document.getInteger("salary");
            }
        }
        return res;
    }

    public static ArrayList<String> getProjects(){
        ArrayList<String> projects = new ArrayList<>();
        for (Document document : Database.foundedBudgets){
           if (document.getString("name of event") != null) projects.add(document.getString("name of event"));
        }
        return projects;
    }

    public static ArrayList<String> getWorkers() {
        ArrayList<String> workers = new ArrayList<>();
        for (Document document : Database.foundedUsers) {
            if (document.getString("position").equals("worker")) workers.add(document.getString("name"));
        }
        return workers;
    }

    public static void increaseSalary(String name, int salary) {
        int newSalary = 0;
        for (Document document : Database.foundedUsers){
            if (document.getString("name").equals(name)){
                newSalary = document.getInteger("salary") + salary;
            }
        }
        Database.users.updateOne(Filters.eq("name", name), new Document(
                "$set",
                new Document("salary", newSalary)
        ));
    }

    public static void decreaseSalary(String name, int salary) {
        int newSalary = 0;
        for (Document document : Database.foundedUsers){
            if (document.getString("name").equals(name)){
                newSalary = document.getInteger("salary") - salary;
            }
        }
        Database.users.updateOne(Filters.eq("name", name), new Document(
                "$set",
                new Document("salary", newSalary)
        ));
    }

    public static Map<String, Integer> calculateByCategory(){
        Map<String, Integer> res = new HashMap<>();
        int sell = 0;
        int rent = 0;
        for (Document document : Database.foundedObjects) {
            if (document.getInteger("rentPrice") != null && document.getInteger("sellPrice") != null) {
                sell++;
                rent++;
            } else if (document.getInteger("rentPrice") != null){
                rent++;
            } else if (document.getInteger("sellPrice") != null){
                sell++;
            }
        }
        res.put("Sell", sell);
        res.put("Rent", rent);
        return res;
    }

    public static Map<String, Integer> calculateTotalAmount(){
        Map<String, Integer> res = new HashMap<>();
        int sell = 0;
        int rent = 0;
        for (Document document : Database.foundedObjects) {
            if (document.getInteger("rentPrice") != null && document.getInteger("sellPrice") != null) {
                sell += document.getInteger("sellPrice");
                rent += document.getInteger("rentPrice");
            } else if (document.getInteger("rentPrice") != null){
                rent += document.getInteger("rentPrice");
            } else if (document.getInteger("sellPrice") != null){
                sell += document.getInteger("sellPrice");
            }
        }
        res.put("Sell", sell);
        res.put("Rent", rent);
        return res;
    }


}
