package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.bson.Document;

import java.util.ArrayList;

public class Tasks {

    @FXML
    private Button LogOutButton;

    @FXML
    private Label taskLabel;

    @FXML
    private Button tasksHomeButton;

    @FXML
    private ListView<String> tasksListView;

    @FXML
    void initialize() {
        taskLabel.setText("Aufgaben");
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        tasksHomeButton.setOnAction(event -> Methods.loadStage(Controller.position, event));
        ArrayList<Document> tasks = Methods.getTasks();
        if (tasks.size() > 0) {
            for (Document document : tasks) {
                tasksListView.getItems().add(document.getString("task"));
            }
        } else {
            taskLabel.setText("Keine Aufgaben");
        }
        tasksListView.setOnMouseClicked(event -> {
           String aktuelleOption = tasksListView.getSelectionModel().getSelectedItem();
           for (Document document : tasks) {
               if (document.getString("task").equals(aktuelleOption)){
                    Methods.completeTask(document);
                    tasksListView.getItems().remove(aktuelleOption);
                   if (tasksListView.getItems().isEmpty()) {
                       taskLabel.setText("Keine Aufgaben");
                   }
               }
           }
        });

    }
}
