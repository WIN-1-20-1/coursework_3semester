package home.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class Worker  {

    @FXML
    private Label workerLabel;

    @FXML
    private ListView<String> WorkerListView;

    String[] option = {"Liste meiner Aufgaben anzeigen", "Aufgabe abschließen", "Liste der abgeschlossenen Aufgaben anzeigen", "Zeige mein Gehalt", "Ausfahrt"};

    String aktuelleOption;

    @FXML
    void initialize(){
        workerLabel.setText( "Hallo, " + Controller.name);

        WorkerListView.getItems().addAll(option);
        WorkerListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                aktuelleOption = WorkerListView.getSelectionModel().getSelectedItem();
                System.out.println(aktuelleOption);
            }
        });
    }
}
