package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

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
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        tasksHomeButton.setOnAction(event -> {
            Controller.loadStage(Controller.position, event);
        });
        ArrayList<String> tasks = Methods.getTasks(Controller.id);
        if (tasks.size() > 0) {
            tasksListView.getItems().addAll(tasks);
        } else {
            taskLabel.setText("Keine Aufgaben");
        }

    }

}
