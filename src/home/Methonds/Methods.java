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
}
