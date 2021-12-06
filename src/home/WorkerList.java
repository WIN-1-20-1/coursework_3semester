package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class WorkerList {

    @FXML
    private Button HomeButton;

    @FXML
    private Button LogOutButton;

    @FXML
    private ListView<String> changeListView;

    @FXML
    void initialize() {
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        HomeButton.setOnAction(event -> Controller.loadStage(Controller.position, event));
        changeListView.getItems().addAll(Methods.getWorkers());
    }
}
