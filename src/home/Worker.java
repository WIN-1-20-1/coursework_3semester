package home;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import home.Methonds.Methods;

public class Worker  {

    @FXML
    private Label workerLabel;

    @FXML
    private ListView<String> WorkerListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Liste meiner Aufgaben anzeigen", "Aufgabe abschließen", "Liste der abgeschlossenen Aufgaben anzeigen", "Zeige mein Gehalt"};

    String aktuelleOption;

    @FXML
    void initialize(){
        workerLabel.setText( "Hallo, " + Controller.name);

        WorkerListView.getItems().addAll(option);
        WorkerListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> aktuelleOption = WorkerListView.getSelectionModel().getSelectedItem());
        LogOutButton.setOnAction(Methods::logOut);
    }
}
