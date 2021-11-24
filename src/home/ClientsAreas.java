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
        LogOutButton.setOnAction(Methods::logOut);
        HomeButton.setOnAction(event -> {
            Controller.loadStage(Controller.position, event);
        });
        AreasListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            aktuelleOption = AreasListView.getSelectionModel().getSelectedItem();
            double result = Methods.calculateClietnsPerArea(aktuelleOption);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ergebnis");
            alert.setHeaderText("Die Anzahl der Kunden in " + aktuelleOption + " ist " + Math.floor(result) + "%");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.print("");
                }
            });
        });
    }

}
