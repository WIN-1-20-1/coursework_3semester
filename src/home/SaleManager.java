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
            "Продажа и аренда",
            "Клиенты",
            "Апартаменты"};

    String aktuelleOption;

    @FXML
    void initialize() {
        SaleManagerLabel.setText("Привет, " + Controller.name);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        SaleManagerListView.getItems().addAll(option);
        SaleManagerListView.setOnMouseClicked(event -> {
            aktuelleOption = SaleManagerListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Продажа и аренда" -> Methods.loadStage("RentSell", event);
                case "Клиенты" -> Methods.loadStage("ClientList", event);
                case "Апартаменты" -> Methods.loadStage("ApartmentList", event);
            }
        });
    }
}

