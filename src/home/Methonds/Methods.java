package home.Methonds;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class Methods {
    public static void logOut(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
