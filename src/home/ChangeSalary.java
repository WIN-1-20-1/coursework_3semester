package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChangeSalary {

    @FXML
    private Button HomeButton;

    @FXML
    private Button LogOutButton;

    @FXML
    private ListView<String> changeListView;

    @FXML
    private TextField getNumber;

    @FXML
    private Button increase;

    @FXML
    private Button decrease;

    @FXML
    private Label workerNameLabel;

    String aktuelleOption;
    @FXML
    void initialize() {
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        HomeButton.setOnAction(event -> Methods.loadStage(Controller.position, event));
        changeListView.getItems().addAll(Methods.getWorkers());
        changeListView.setOnMouseClicked(event -> {
            aktuelleOption = changeListView.getSelectionModel().getSelectedItem();
            workerNameLabel.setText(aktuelleOption);
        });
        increase.setOnAction(event -> {
            Methods.increaseSalary(aktuelleOption, Integer.parseInt(getNumber.getText()));
            Methods.alert("Erfolg", aktuelleOption + "s Gehalt wurde um " + getNumber.getText() + " erhöht");
        });
        decrease.setOnAction(event -> {
            Methods.decreaseSalary(aktuelleOption, Integer.parseInt(getNumber.getText()));
            Methods.alert("Erfolg", aktuelleOption + "s Gehalt wurde um " + getNumber.getText() + " senkt");
        });
    }
}
