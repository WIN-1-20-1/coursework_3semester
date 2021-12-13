package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ApartmentList {

    @FXML
    private Button HomeButton;

    @FXML
    private Button LogOutButton;

    @FXML
    private ListView<String> apartmentsLV;

    @FXML
    private Label apartmentAdress;

    @FXML
    private Label apartmentRentPrice;

    @FXML
    private Label apartmentSellPrice;

    @FXML
    private Label apartmentStatus;

    @FXML
    private Label apartmentOwner;

    String aktuelleOption;

    @FXML
    void initialize() {
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        HomeButton.setOnAction(event -> Controller.loadStage(Controller.position, event));
        apartmentsLV.getItems().addAll(Methods.ShowApartments());

        apartmentsLV.setOnMouseClicked(event -> {
            aktuelleOption = apartmentsLV.getSelectionModel().getSelectedItem();
            apartmentAdress.setText(aktuelleOption);
            apartmentRentPrice.setText(Methods.getApartmentRentPrise(aktuelleOption));
            apartmentSellPrice.setText(Methods.getApartmentSellPrise(aktuelleOption));
            apartmentStatus.setText(Methods.getApartmentStatus(aktuelleOption));
            apartmentOwner.setText(Methods.getApartmentOwner(aktuelleOption));
        });
    }
}
