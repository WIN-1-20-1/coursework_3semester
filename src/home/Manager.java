package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Map;

public class Manager {

    @FXML
    private Label ManagerLabel;

    @FXML
    private ListView<String> ManagerListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Список сотрудников", "Список заданий", "Процент клиентов на регион", "Квартиры на продажу и на аренду", "Стоимость квартир на продажу и на аренду"};

    String aktuelleOption;

    @FXML
    void initialize(){
        ManagerLabel.setText( "Привет, " + Controller.name);
        ManagerListView.getItems().addAll(option);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        ManagerListView.setOnMouseClicked(event -> {
            aktuelleOption = ManagerListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Список сотрудников" -> Methods.loadStage("WorkerList", event);
                case "Список заданий" -> Methods.loadStage("Tasks", event);
                case "Процент клиентов на регион" -> Methods.loadStage("ClientsAreas", event);
                case "Квартиры на продажу и на аренду" -> {
                    Map<String, Integer> category = Methods.calculateByCategory();
                    Methods.alert("Квартиры на продажу и на аренду", "На аренду " + category.get("Rent") + "\nНа продажу " + category.get("Sell"));
                }
                case "Стоимость квартир на продажу и на аренду" -> {
                    Map<String, Integer> category = Methods.calculateTotalAmount();
                    Methods.alert("Стоимость квартир на продажу и на аренду", "На аренду " + category.get("Rent") + "€" + "\nНа продажу " + category.get("Sell") + "€");
                }
                default -> {}
            }
        });
    }
}
