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
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        HomeButton.setOnAction(event -> Controller.loadStage(Controller.position, event));

        clientListView.getItems().addAll(Methods.ShowAllClients());
        apartmentListView.getItems().addAll(Methods.ShowFreeApartments());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

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
                    alert.setTitle("Апртаменты успешно арендованы!");
                    alert.setHeaderText("Спасибо, что выбрали нас");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                    apartmentListView.getItems().clear();
                    apartmentListView.getItems().addAll(Methods.ShowFreeApartments());
                } else {
                    alert.setTitle("Внимание!");
                    alert.setHeaderText("Не удалось арендовать апартоменты");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                }
            } else {
                alert.setTitle("Внимание!");
                alert.setHeaderText("Данные не совпадают!");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.print("");
                    }
                });
            }
        });

        Sell.setOnAction(event -> {
            if (Methods.BoolFoundApartments(apartmentOption)) {
                Document Apartment = Methods.FoundApartments(apartmentOption);
                Document Client = Methods.FoundClient(clientOption);
                if (Methods.BoolSellApartment(Apartment, Client)) {
                    Methods.SellApartment(Apartment, Client);
                    alert.setTitle("Апртаменты успешно арендованы!");
                    alert.setHeaderText("Спасибо, что выбрали нас");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                    apartmentListView.getItems().clear();
                    apartmentListView.getItems().addAll(Methods.ShowFreeApartments());
                } else {
                    alert.setTitle("Внимание!");
                    alert.setHeaderText("Не удалось купить апартоменты");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                }
            } else {
                alert.setTitle("Внимание!");
                alert.setHeaderText("Данные не совпадают!");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.print("");
                    }
                });
            }
        });
    }
}
