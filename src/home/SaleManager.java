package home;

import javafx.fxml.FXML;
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

    String[] option = {"Liste aller Abdeckungsbereiche anzeigen", "Liste der Budgetkategorien anzeigen", "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing", "Aktuelle Marketingmittel anzeigen", "Zeigen Sie das für das Gehalt erforderliche Gesamtbudget an", "Erhöhen Sie das Gehalt eines Mitarbeiters", "Senken Sie das Gehalt eines Mitarbeiters", "Zeigen Sie die Liste der Geräte für den Bau von Objekten"};

    String aktuelleOption;

    @FXML
    void initialize(){
        SaleManagerLabel.setText( "Hallo, " + Controller.name);
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        SaleManagerListView.getItems().addAll(option);
        SaleManagerListView.setOnMouseClicked(event -> {
            aktuelleOption = SaleManagerListView.getSelectionModel().getSelectedItem();
            System.out.println(aktuelleOption);
        });
    }
}

