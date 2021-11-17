package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Equipment {

    @FXML
    private Button HomeButton;

    @FXML
    private Button LogOutButton;

    @FXML
    private ListView<String> equipmentListView;

    @FXML
    private Label taskLabel;

    @FXML
    void initialize() {
        LogOutButton.setOnAction(Methods::logOut);
        HomeButton.setOnAction(event -> {
            Controller.loadStage(Controller.position);
        });
        equipmentListView.getItems().addAll(Methods.getEquipment());
    }
}
