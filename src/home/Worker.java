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

    String[] option = {"Список заданий", "Зарплата"};

    String aktuelleOption;

    @FXML
    void initialize(){
        workerLabel.setText( "Привет, " + Controller.name);
        WorkerListView.getItems().addAll(option);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        WorkerListView.setOnMouseClicked(event -> {
            aktuelleOption = WorkerListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Список заданий" -> Methods.loadStage("Tasks", event);
                case "Зарплата" -> Methods.loadStage("WorkerSalary", event);
                default -> {}
            }
        });
    }
}
