package home;

import home.Methonds.Methods;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SaleManager {

    @FXML
    private Label SaleManagerLabel;

    @FXML
    private ListView<String> SaleManagerListView;

    @FXML
    private Button LogOutButton;

    String[] option = {
            "Liste aller Abdeckungsbereiche anzeigen",
            "Liste der Budgetkategorien anzeigen",
            "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing"};

    String aktuelleOption;

    @FXML
    void initialize() {
        SaleManagerLabel.setText("Hallo, " + Controller.name);
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        SaleManagerListView.getItems().addAll(option);
        SaleManagerListView.setOnMouseClicked(event -> {
            aktuelleOption = SaleManagerListView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            switch (aktuelleOption) {
                case "Liste aller Abdeckungsbereiche anzeigen" -> Controller.loadStage("RentSell", event);
                case "Liste der Budgetkategorien anzeigen" -> Controller.loadStage("ClientList", event);
                case "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing" -> Controller.loadStage("ApartmentList", event);
            }
        });
    }
}

