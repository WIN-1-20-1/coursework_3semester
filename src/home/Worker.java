package home;

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

    String[] option = {"Liste meiner Aufgaben anzeigen", "Zeige mein Gehalt"};

    String aktuelleOption;

    @FXML
    void initialize(){
        workerLabel.setText( "Hallo, " + Controller.name);

        WorkerListView.getItems().addAll(option);
        WorkerListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            aktuelleOption = WorkerListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Liste meiner Aufgaben anzeigen" -> Controller.loadStage("tasks");
                case "Zeige mein Gehalt" -> Controller.loadStage("WorkerSalary");
                default -> {
                }
            }
        });
        LogOutButton.setOnAction(Methods::logOut);
    }
}
