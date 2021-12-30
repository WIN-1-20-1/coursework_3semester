package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClientsAreas {

    @FXML
    private ListView<String> AreasListView;

    @FXML
    private Button HomeButton;

    @FXML
    private Button LogOutButton;

    String[] stadte = {"Bishkek","Chui", "Talas", "Jalal-Abad", "Osh", "Naryn", "Issyk-Kul", "Batken"};

    String aktuelleOption;

    @FXML
    void initialize() {
        AreasListView.getItems().addAll(stadte);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        HomeButton.setOnAction(event -> Methods.loadStage(Controller.position, event));
        AreasListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            aktuelleOption = AreasListView.getSelectionModel().getSelectedItem();
            double result = Methods.calculateClietnsPerArea(aktuelleOption);
            Methods.alert("Результат!","Клиентов в " + aktuelleOption + " составляет " + Math.floor(result) + "%");
        });
    }

}
