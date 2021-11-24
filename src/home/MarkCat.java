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
        LogOutButton.setOnAction(Methods::logOut);
        catHomeButton.setOnAction(event -> {
            Controller.loadStage(Controller.position, event);
        });
        ArrayList<String> categories = Methods.getMarkCat();
        catListView.getItems().addAll(categories);
    }
}
