package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Director {

    @FXML
    private Label DirectorLabel;

    @FXML
    private ListView<String> DirectorListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Liste aller Abdeckungsbereiche anzeigen", "Liste der Budgetkategorien anzeigen", "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing", "Aktuelle Marketingmittel anzeigen", "Zeigen Sie das für das Gehalt erforderliche Gesamtbudget an", "Erhöhen Sie das Gehalt eines Mitarbeiters", "Senken Sie das Gehalt eines Mitarbeiters", "Zeigen Sie die Liste der Geräte für den Bau von Objekten"};

    String aktuelleOption;

    @FXML
    void initialize(){
        DirectorLabel.setText( "Hallo, " + Controller.name);
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        DirectorListView.getItems().addAll(option);
        DirectorListView.setOnMouseClicked(event -> {
            aktuelleOption = DirectorListView.getSelectionModel().getSelectedItem();
        switch (aktuelleOption) {
            case "Liste aller Abdeckungsbereiche anzeigen":
                Controller.loadStage("ClientsAreas", event);
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
                Controller.loadStage("Equipment", event);
                break;
            default:
                break;
        }
        });
    }
}
