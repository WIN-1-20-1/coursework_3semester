package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    public static String position;

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
                    position = userPosition;
                    loadStage(userPosition, event);

                } else {
                    System.out.println("You entered wrong login or password");
                }
        });
    }

    public static void loadStage(String fxml, ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Controller.class.getResource("fxml/" + fxml + ".fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

