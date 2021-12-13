package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Promotion {

    @FXML
    private Button HomeButton;

    @FXML
    private Button LogOutButton;

    @FXML
    private TextField getMoney;

    @FXML
    private TextField getPlace;

    @FXML
    private TextField getProject;

    @FXML
    private Button spendButton;


    @FXML
    void initialize() {
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        HomeButton.setOnAction(event -> Controller.loadStage(Controller.position, event));
        spendButton.setOnAction(event -> Methods.createNewProject(getProject.getText(), getPlace.getText(), Integer.parseInt(getMoney.getText())));
    }

}
