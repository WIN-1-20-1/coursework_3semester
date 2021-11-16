package home.Methonds;

import home.Database.Database;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Methods {
    public static void logOut(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

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
        String salary = String.valueOf(founded.getInteger("salary"));
        return salary;
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
}
