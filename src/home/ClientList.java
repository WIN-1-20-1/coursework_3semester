package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ClientList {

    @FXML
    private Button HomeButton;

    @FXML
    private Button LogOutButton;

    @FXML
    private ListView<String> clientsLV;

    @FXML
    private ListView<String> clientApartmentsLV;

    @FXML
    private Label clientName;

    @FXML
    private Label clientPhone;

    @FXML
    private Label clientPlace;

    String aktuelleOption;

    @FXML
    void initialize() {
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        HomeButton.setOnAction(event -> Controller.loadStage(Controller.position, event));
        clientsLV.getItems().addAll(Methods.ShowAllClients());

        clientsLV.setOnMouseClicked(event -> {
            aktuelleOption = clientsLV.getSelectionModel().getSelectedItem();
            clientName.setText(aktuelleOption);
            clientPhone.setText(Methods.getClientPhone(aktuelleOption));
            clientPlace.setText(Methods.getClientPlace(aktuelleOption));

            clientApartmentsLV.getItems().clear();
            clientApartmentsLV.getItems().addAll(Methods.getClientApartments(aktuelleOption));
        });
    }
}
