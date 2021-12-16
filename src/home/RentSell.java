package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.bson.Document;

public class RentSell {

    @FXML
    private Button HomeButton;

    @FXML
    private Button LogOutButton;


    @FXML
    private ListView<String> clientListView;

    @FXML
    private Button Rent;

    @FXML
    private Button Sell;

    @FXML
    private Label clientNameLabel;


    @FXML
    private ListView<String> apartmentListView;

    @FXML
    private Label apartmentAddressLabel;

    @FXML
    private Label rentPrise;

    @FXML
    private Label sellPrise;

    String clientOption;
    String apartmentOption;

    @FXML
    void initialize() {
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        HomeButton.setOnAction(event -> Methods.loadStage(Controller.position, event));

        clientListView.getItems().addAll(Methods.ShowAllClients());
        apartmentListView.getItems().addAll(Methods.ShowFreeApartments());

        clientListView.setOnMouseClicked(event -> {
            clientOption = clientListView.getSelectionModel().getSelectedItem();
            clientNameLabel.setText(clientOption);
        });

        apartmentListView.setOnMouseClicked(event -> {
            apartmentOption = apartmentListView.getSelectionModel().getSelectedItem();
            apartmentAddressLabel.setText(apartmentOption);
            rentPrise.setText(Methods.getApartmentRentPrise(apartmentOption));
            sellPrise.setText(Methods.getApartmentSellPrise(apartmentOption));
        });

        Rent.setOnAction(event -> {
            if (Methods.BoolFoundApartments(apartmentOption)) {
                Document Apartment = Methods.FoundApartments(apartmentOption);
                Document Client = Methods.FoundClient(clientOption);
                if (Methods.BoolRentApartment(Apartment, Client)) {
                    Methods.RentApartment(Apartment, Client);
                    Methods.alert("Апатраменты успешно арендованы!","Спасибо, что выбрали нас");
                    apartmentListView.getItems().clear();
                    apartmentListView.getItems().addAll(Methods.ShowFreeApartments());
                } else {
                    Methods.alert("Внимание!","Не удалось арендовать апартаменты");
                }
            } else {
                Methods.alert("Внимание!", "Данные не совпадают");
            }
        });

        Sell.setOnAction(event -> {
            if (Methods.BoolFoundApartments(apartmentOption)) {
                Document Apartment = Methods.FoundApartments(apartmentOption);
                Document Client = Methods.FoundClient(clientOption);
                if (Methods.BoolSellApartment(Apartment, Client)) {
                    Methods.SellApartment(Apartment, Client);
                    Methods.alert("Апатраменты успешно арендованы!","Спасибо, что выбрали нас");
                    apartmentListView.getItems().clear();
                    apartmentListView.getItems().addAll(Methods.ShowFreeApartments());
                } else {
                    Methods.alert("Внимание!","Не удалось купить апартаменты");
                }
            } else {
                Methods.alert("Внимание!","Данные не совпадают");
            }
        });
    }
}
