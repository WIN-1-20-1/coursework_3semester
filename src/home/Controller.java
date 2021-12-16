package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.bson.types.ObjectId;
import static home.Methonds.Methods.auth;

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
}

