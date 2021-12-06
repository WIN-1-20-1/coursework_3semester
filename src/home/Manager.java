package home;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Manager {

    @FXML
    private Label ManagerLabel;

    @FXML
    private ListView<String> ManagerListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Liste der Mitarbeiter anzeigen", "Aufgabenliste anzeigen", "Anzeigen einer Liste von Anweisungen für Mitarbeiter", "Liste aller Abdeckungsbereiche anzeigen", "Zeigen Sie den Betrag für Immobilien", "Berechnen Sie% nach Immobilienkategorie"};

    String aktuelleOption;

    @FXML
    void initialize(){
        ManagerLabel.setText( "Hallo, " + Controller.name);

        ManagerListView.getItems().addAll(option);
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        ManagerListView.setOnMouseClicked(event -> {
            aktuelleOption = ManagerListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Liste der Mitarbeiter anzeigen" -> Controller.loadStage("WorkerList", event);
                case "Aufgabenliste anzeigen" -> {}
                case "Anzeigen einer Liste von Anweisungen für Mitarbeiter" -> {}
                case "Liste aller Abdeckungsbereiche anzeigen" -> {}
                case "Zeigen Sie den Betrag für Immobilien" -> {}
                case "Berechnen Sie% nach Immobilienkategorie" -> {}
                default -> {}
            }
        });
    }
}
