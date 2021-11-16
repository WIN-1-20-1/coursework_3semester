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
    private Label workerSalaryLabel;


    @FXML
    void initialize() {
        LogOutButton.setOnAction(Methods::logOut);
        tasksHomeButton.setOnAction(event -> {
            Controller.loadStage(Controller.position);
        });
        WorkerSalaryText.setText("Gehalt ist " + Methods.getSalary(Controller.id) + "€");
    }
}
