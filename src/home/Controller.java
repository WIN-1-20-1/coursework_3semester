package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bson.Document;
import home.Database.Database;
import org.bson.types.ObjectId;
import java.io.IOException;
import java.util.Objects;

public class Controller {
    public static String name;
    public static String position;
    public static ObjectId id;

    @FXML
    private Button authButton;

    @FXML
    private TextField SingUpLogin;

    @FXML
    private PasswordField SingUpPass;

    @FXML
    public void onEnter(ActionEvent event){
        auth(event, SingUpLogin.getText().trim(), SingUpPass.getText().trim());
    }



    @FXML
    void initialize(){
        authButton.setOnAction(event ->auth(event, SingUpLogin.getText().trim(), SingUpPass.getText().trim()));
    }

    public static void auth(ActionEvent event, String login , String password) {
        Document founded = Database.users.find(new Document("login", login)).first();
        if (founded != null && password.equals(founded.getString("password"))) {
            String userPosition = founded.getString("position");
            name = founded.getString("name");
            position = userPosition;
            id = founded.getObjectId("_id");
            loadStage(userPosition, event);

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fehlermeldung");
            alert.setHeaderText("Falsches Login oder Passwort");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.print("");
                }
            });
        }
    }

    public static void loadStage(String fxml, MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("fxml/" + fxml + ".fxml")));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadStage(String fxml, ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("fxml/" + fxml + ".fxml")));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

