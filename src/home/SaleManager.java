package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SaleManager {

    @FXML
    private Label SaleManagerLabel;

    @FXML
    private ListView<String> SaleManagerListView;

    @FXML
    private Button LogOutButton;

    String[] option = {
            "Wohnungen verkaufen oder mieten",
            "Kundenliste und Kundendaten",
            "Liste und Informationen zu den Apartments"};

    String aktuelleOption;

    @FXML
    void initialize() {
        SaleManagerLabel.setText("Hallo, " + Controller.name);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        SaleManagerListView.getItems().addAll(option);
        SaleManagerListView.setOnMouseClicked(event -> {
            aktuelleOption = SaleManagerListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Wohnungen verkaufen oder mieten" -> Methods.loadStage("RentSell", event);
                case "Kundenliste und Kundendaten" -> Methods.loadStage("ClientList", event);
                case "Liste und Informationen zu den Apartments" -> Methods.loadStage("ApartmentList", event);
            }
        });
    }
}

