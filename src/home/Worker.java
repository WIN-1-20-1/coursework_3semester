package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Worker  {

    @FXML
    private Label workerLabel;

    @FXML
    private ListView<String> WorkerListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Liste Aufgaben anzeigen", "Zeige mein Gehalt"};

    String aktuelleOption;

    @FXML
    void initialize(){
        workerLabel.setText( "Hallo, " + Controller.name);
        WorkerListView.getItems().addAll(option);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        WorkerListView.setOnMouseClicked(event -> {
            aktuelleOption = WorkerListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Liste Aufgaben anzeigen" -> Methods.loadStage("Tasks", event);
                case "Zeige mein Gehalt" -> Methods.loadStage("WorkerSalary", event);
                default -> {}
            }
        });
    }
}
