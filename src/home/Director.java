package home;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
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
            System.out.println(aktuelleOption);
        });
    }
}
