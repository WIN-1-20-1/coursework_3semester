package home.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.bson.Document;
import home.Database.Database;

import java.io.IOException;

public class Controller {
    public static String name;

    @FXML
    private Button authButton;

    @FXML
    private TextField SingUpLogin;

    @FXML
    private PasswordField SingUpPass;

    @FXML
    void initialize(){
        authButton.setOnAction(event -> {
            String login = SingUpLogin.getText().trim();
            String password = SingUpPass.getText().trim();
            Document founded = Database.users.find(new Document("login", login)).first();
                if (founded != null && password.equals(founded.getString("password"))) {
                    String userPosition = founded.getString("position");
                    name = founded.getString("name");
                    loadStage(userPosition);
                } else {
                    System.out.println("You entered wrong login or password");
                }
        });
    }

    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/" + fxml + ".fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

