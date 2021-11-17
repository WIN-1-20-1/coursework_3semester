package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Director {

    @FXML
    private Label DirectorLabel;

    @FXML
    private ListView<String> DirectorListView;

    String[] option = {"Liste aller Abdeckungsbereiche anzeigen", "Liste der Budgetkategorien anzeigen", "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing", "Aktuelle Marketingmittel anzeigen", "Zeigen Sie das für das Gehalt erforderliche Gesamtbudget an", "Erhöhen Sie das Gehalt eines Mitarbeiters", "Senken Sie das Gehalt eines Mitarbeiters", "Zeigen Sie die Liste der Geräte für den Bau von Objekten"};

    String aktuelleOption;

    @FXML
    void initialize(){
        DirectorLabel.setText( "Hallo, " + Controller.name);

        DirectorListView.getItems().addAll(option);
        DirectorListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            aktuelleOption = DirectorListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Liste aller Abdeckungsbereiche anzeigen":
                    Controller.loadStage("ClientsAreas");
                    break;

                case "Liste der Budgetkategorien anzeigen":

                    break;
                case "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing":
                    break;
                case "Aktuelle Marketingmittel anzeigen":
                    int funds = Methods.markFunds();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aktuelle Marketingmittel anzeigen");
                    alert.setHeaderText(funds + "€");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                    break;
                case "Zeigen Sie das für das Gehalt erforderliche Gesamtbudget an":
                    break;
                case "Erhöhen Sie das Gehalt eines Mitarbeiters":
                    break;
                case "Senken Sie das Gehalt eines Mitarbeiters":
                    break;
                case "Zeigen Sie die Liste der Geräte für den Bau von Objekten":
                    break;
                default:
                    break;
            }
        });
    }
}
