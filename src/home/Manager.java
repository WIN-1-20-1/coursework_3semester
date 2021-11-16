package home;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Manager {

    @FXML
    private Label ManagerLabel;

    @FXML
    private ListView<String> ManagerListView;

    String[] option = {"Liste der Mitarbeiter anzeigen", "Aufgabenliste anzeigen", "Anzeigen einer Liste von Anweisungen für Mitarbeiter", "Liste aller Abdeckungsbereiche anzeigen", "Zeigen Sie den Betrag für Immobilien", "Berechnen Sie% nach Immobilienkategorie"};

    String aktuelleOption;

    @FXML
    void initialize(){
        ManagerLabel.setText( "Hallo, " + Controller.name);

        ManagerListView.getItems().addAll(option);
        ManagerListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            aktuelleOption = ManagerListView.getSelectionModel().getSelectedItem();
            System.out.println(aktuelleOption);
        });
    }
}