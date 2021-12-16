package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class MarkCat {

    @FXML
    private Button LogOutButton;

    @FXML
    private Button catHomeButton;

    @FXML
    private ListView<String> catListView;

    @FXML
    void initialize() {
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        catHomeButton.setOnAction(event -> {
            Methods.loadStage(Controller.position, event);
        });
        ArrayList<String> categories = Methods.getMarkCat();
        catListView.getItems().addAll(categories);
    }
}
