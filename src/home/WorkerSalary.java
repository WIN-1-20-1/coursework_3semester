package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WorkerSalary {

    @FXML
    private Button LogOutButton;

    @FXML
    private Label WorkerSalaryText;

    @FXML
    private Button tasksHomeButton;


    @FXML
    void initialize() {
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        tasksHomeButton.setOnAction(event -> {
            Methods.loadStage(Controller.position, event);
        });
        WorkerSalaryText.setText("Gehalt ist " + Methods.getSalary(Controller.id) + "€");
    }
}
